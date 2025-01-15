import React, { useState, useEffect } from "react";
import axios from "axios";
import "../../variables.css";
import "./style.css";

const Header = ({ onMenuClick }) => {
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const [currentUser, setCurrentUser] = useState(null);

  useEffect(() => {
    const fetchCurrentUser = async () => {
      const userId = localStorage.getItem("currentUser");
      if (userId) {
        try {
          const response = await axios.get("http://localhost:3001/users");
          const user = response.data.find((user) => user.id === userId);
          setCurrentUser(user);
        } catch (error) {
          console.error("Error fetching user data:", error);
        }
      }
    };

    fetchCurrentUser();
  }, []);

  const handleLogout = () => {
    localStorage.removeItem("currentUser");
    window.location.href = "/login";
  };

  return (
    <header className="header">
      <button className="header-menu-button" onClick={onMenuClick}>
        ☰
      </button>
      <div className="header-logo">
        <img src="/image/Logo.png" alt="Thăng Long University" />
      </div>
      <div className="header-user">
        {currentUser ? (
          <>
            <div className="user-info">
              <span className="user-name">{currentUser.name}</span>
              <span className="user-id">{currentUser.id}</span>
            </div>
            <div
              className="avatar-wrapper"
              onMouseEnter={() => setIsMenuOpen(true)}
              onMouseLeave={() => setIsMenuOpen(false)}
            >
              <img
                src="/image/avatar.png"
                alt="Avatar"
                className="user-avatar"
              />
              <div className="header-connect"></div>
              {isMenuOpen && (
                <div className="header-menu-dropdown">
                  <button className="header-logout-button" onClick={handleLogout}>
                    Logout
                  </button>
                </div>
              )}
            </div>
          </>
        ) : (
          <span>Loading...</span>
        )}
      </div>
    </header>
  );
};

export default Header;
