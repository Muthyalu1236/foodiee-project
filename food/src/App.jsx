import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./components/Login";
import Registration from "./components/Registration";
import Home from "./components/Home"
import Checkout from "./components/Checkout";
import EndPage from "./components/Checkout/EndPage";

const App = () => {
  return (

    //To add elements to the path
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/register" element={<Registration />} />
        <Route path="/home" element={<Home />} />
        <Route path="/checkout" element={<Checkout />} />
        <Route path="/thankyou" element={<EndPage />} />
      </Routes>
    </BrowserRouter>
  );
};

export default App;
