import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Footer from "./components/Footer";
import Header from "./components/Header";
import Home from "./components/Home";
import Login from "./components/Login";
import List from "./routes/List";

const App = () => {
  return (
    <div>
      <Router>
        <Header />
        <div>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/list" elememt={<List />} />
            <Route path="/login" elememt={<Login />} />
          </Routes>
        </div>
        <Footer />
      </Router>
    </div>
  );
};

export default App;
