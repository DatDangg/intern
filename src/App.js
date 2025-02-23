import React, { useState, useEffect } from "react";
import { Navigate, BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Header from "./components/Header/Header";
import Aside from "./components/Aside/Aside";
import Backlog from "./components/Backlog/Backlog";
import CoursesInTerm from "./components/CoursesInTerm/CoursesInTerm";
import Login from "./components/Login/Login";
import Infor from "./components/Infor/Infor";
import "./App.css";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem("authToken"));
  const [isAsideVisible, setIsAsideVisible] = useState(true);
  const [isSmallScreen, setIsSmallScreen] = useState(window.innerWidth <= 768);

  useEffect(() => {
    const handleResize = () => setIsSmallScreen(window.innerWidth <= 768);
    window.addEventListener("resize", handleResize);
    return () => window.removeEventListener("resize", handleResize);
  }, []);

  const toggleAside = () => isSmallScreen && setIsAsideVisible(!isAsideVisible);

  return (
    <Router>
      <div className="app">
        {isLoggedIn ? (
          <>
            <Header onMenuClick={toggleAside} />
            {isSmallScreen && isAsideVisible && <div className="overlay" onClick={toggleAside}></div>}
            <Aside isVisible={isAsideVisible} toggleAside={toggleAside} />
            <main>
              <div className="main-content">
                <Routes>
                  <Route path="/" element={<Navigate to="/backlog" replace />} />
                  {/* <Route path="/infor" element={<Infor />} /> */}
                  <Route path="/backlog" element={<Backlog />} />
                  <Route path="/courses-in-term" element={<CoursesInTerm />} />
                </Routes>
              </div>
            </main>
          </>
        ) : (
          <Login onLoginSuccess={() => setIsLoggedIn(true)} />
        )}
      </div>
    </Router>
  );
}

export default App;
