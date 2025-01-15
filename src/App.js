import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Header from "./components/Header/Header";
import Aside from "./components/Aside/Aside";
import Backlog from "./components/Backlog/Backlog";
import CoursesInTerm from "./components/CoursesInTerm/CoursesInTerm";
import Login from "./components/Login/Login";

import "./App.css";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(
    !!localStorage.getItem("currentUser")
  );

  const handleLoginSuccess = () => {
    setIsLoggedIn(true);
  };

  const [isAsideVisible, setIsAsideVisible] = useState(true);
  const [isSmallScreen, setIsSmallScreen] = useState(false);

  useEffect(() => {
    const handleResize = () => {
      if (window.innerWidth <= 768) {
        setIsSmallScreen(true);
        setIsAsideVisible(false);
      } else {
        setIsSmallScreen(false);
        setIsAsideVisible(true);
      }
    };

    handleResize();
    window.addEventListener("resize", handleResize);
    return () => window.removeEventListener("resize", handleResize);
  }, []);

  const toggleAside = () => {
    if (isSmallScreen) {
      setIsAsideVisible(!isAsideVisible);
    }
  };

  return (
    <Router>
      <div className="app">
        {isLoggedIn ? (
          <>
            <Header onMenuClick={toggleAside} />
            {isSmallScreen && isAsideVisible && (
              <div className="overlay" onClick={toggleAside}></div>
            )}
            <Aside isVisible={isAsideVisible} toggleAside={toggleAside} />
            <main>
              <div className="main-content">
                <Routes>
                  <Route path="/backlog" element={<Backlog />} />
                  <Route path="/courses-in-term" element={<CoursesInTerm />} />
                </Routes>
              </div>
            </main>
          </>
        ) : (
          <Login onLoginSuccess={handleLoginSuccess} />
        )}
      </div>
    </Router>
  );
}

export default App;
