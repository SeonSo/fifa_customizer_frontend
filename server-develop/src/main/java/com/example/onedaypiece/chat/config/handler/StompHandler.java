package com.example.onedaypiece.chat.config.handler;

import com.example.onedaypiece.chat.repository.RedisRepository;
import com.example.onedaypiece.chat.service.ChatMessageService;
import com.example.onedaypiece.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class StompHandler implements ChannelInterceptor {

    private final TokenProvider tokenProvider;
    private final ChatMessageService chatMessageService;
    private final RedisRepository redisRepository;

    // websocket을 통해 들어온 요청이 처리 되기전 실행된다.
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);

        // websocket 연결요청
        if (StompCommand.CONNECT == accessor.getCommand()) {
            String jwtToken = accessor.getFirstNativeHeader("token");
            tokenProvider.validateToken(jwtToken);

            log.info("CONNECT {}", jwtToken);
            // 채팅룸 구독요청
        } else if (StompCommand.SUBSCRIBE == accessor.getCommand()) {
            // header정보에서 구독 destination정보를 얻고, roomId를 추출한다.
            // roomId를 URL로 전송해주고 있어 추출 필요
            String roomId = chatMessageService.getRoomId(message.getHeaders().get("simpDestination"));

            // 채팅방에 들어온 클라이언트 sessionId를 roomId와 맵핑해 놓는다.(나중에 특정 세션이 어떤 채팅방에 들어가 있는지 알기 위함)
            String sessionId = String.valueOf(message.getHeaders().get("simpSessionId"));
            redisRepository.setMemberEnterInfo(sessionId, roomId);

            log.info("CONNECTED 채팅방　ｊｏｉｎ　{}, {}", sessionId, roomId);
            // Websocket 연결 종료
        } else if (StompCommand.DISCONNECT == accessor.getCommand()) {

            // 연결이 종료된 클라이언트 sesssionId로 채팅방 id를 얻는다.
            String sessionId = String.valueOf(message.getHeaders().get("simpSessionId"));
            String roomId = redisRepository.getMemberEnterRoomId(sessionId);

            // 퇴장한 클라이언트의 roomId 맵핑 정보를 삭제한다.
            redisRepository.removeMemberEnterInfo(sessionId);
            log.info("DISCONNECTED {}, {}", sessionId, roomId);
        }
        return message;
    }
}
