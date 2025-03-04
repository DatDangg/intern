import React, { useState, useEffect, lazy, Suspense } from "react";
import { Navigate, BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Header from "./components/Header/Header";
import Aside from "./components/Aside/Aside";
import "./App.css";

const Backlog = lazy(() => import("./components/Backlog/Backlog"));
const CoursesInTerm = lazy(() => import("./components/CoursesInTerm/CoursesInTerm"));
const Login = lazy(() => import("./components/Login/Login"));

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem("authToken"));
  const [isAsideVisible, setIsAsideVisible] = useState(window.innerWidth > 768);
  const [isSmallScreen, setIsSmallScreen] = useState(window.innerWidth <= 768);

  useEffect(() => {
    const handleResize = () => {
      setIsSmallScreen(window.innerWidth <= 768);
    };
    window.addEventListener("resize", handleResize);
    return () => window.removeEventListener("resize", handleResize);
  }, []);

  useEffect(() => {
    if (isSmallScreen) {
      setIsAsideVisible(false);
    } else {
      setIsAsideVisible(true);
    }
  }, [isSmallScreen]);

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
            {isSmallScreen && isAsideVisible && <div className="overlay" onClick={toggleAside}></div>}
            <Aside isVisible={isAsideVisible} toggleAside={toggleAside} />
            <main>
              <div className="main-content">
                <Suspense fallback={<div className="loading">Đang tải...</div>}>
                  <Routes>
                    <Route path="/" element={<Navigate to="/backlog" replace />} />
                    <Route path="/backlog" element={<Backlog />} />
                    <Route path="/courses-in-term" element={<CoursesInTerm />} />
                  </Routes>
                </Suspense>
              </div>
            </main>
          </>
        ) : (
          <Suspense fallback={<div className="loading">Đang tải trang đăng nhập...</div>}>
            <Login onLoginSuccess={() => setIsLoggedIn(true)} />
          </Suspense>
        )}
      </div>
    </Router>
  );
}

export default App;
