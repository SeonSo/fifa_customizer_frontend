import React from "react";
import { Container, Image, Menu } from "semantic-ui-react";

import logo from "../assets/images/logo/launcher-icon.png";
import { useNavigate } from "react-router-dom";

const Header = () => {
  const navigate = useNavigate();
  return (
    <div>
      <Menu fixed="top" inverted>
        <Container>
          <Menu.Item as="a">
            <Image size="mini" src={logo} style={{ marginRight: "1.5em" }} />
            sofifa.copy
          </Menu.Item>
          <Menu.Item
            as="a"
            onClick={() => {
              navigate("/list");
            }}
          >
            players
          </Menu.Item>
          <Menu.Item as="a">teams</Menu.Item>
          <Menu.Item as="a">squads</Menu.Item>
          <Menu.Item
            as="a"
            onClick={() => {
              navigate("/login");
            }}
          >
            login
          </Menu.Item>
        </Container>
      </Menu>
    </div>
  );
};

export default Header;
