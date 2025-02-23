import React, { useState, useEffect } from "react";
import axios from "axios";
import "../../variables.css";
import "./style.css";

const Header = ({ onMenuClick }) => {
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const [currentUser, setCurrentUser] = useState(null);

  useEffect(() => {
    const fetchUserData = async () => {
      const token = localStorage.getItem("authToken");
      const maUser = localStorage.getItem("maUser");

      if (!maUser || !token) return;

      try {
        const { data } = await axios.get(`http://localhost:8888/admin/getId/${maUser}`, {
          headers: { Authorization: `Bearer ${token}` },
        });
        setCurrentUser(data);
      } catch {
        console.error("Error fetching user data");
      }
    };

    fetchUserData();
  }, []);

  const handleLogout = () => {
    localStorage.removeItem("authToken");
    localStorage.removeItem("maUser");
    window.location.href = "/login";
  };

  return (
    <header className="header">
      <button className="header-menu-button" onClick={onMenuClick}>☰</button>
      <div className="header-logo">
        <img src="/image/Logo.png" alt="Thang Long University" />
      </div>
      <div className="header-user">
        {currentUser ? (
          <>
            <div className="user-info">
              <span className="user-name">{currentUser.userProfileResponse.hoVaTen}</span>
              <span className="user-id">{currentUser.maUser}</span>
            </div>
            <div className="avatar-wrapper" onMouseEnter={() => setIsMenuOpen(true)} onMouseLeave={() => setIsMenuOpen(false)}>
              <img src="/image/avatar.png" alt="Avatar" className="user-avatar" />
              <div className="header-connect"></div>
              {isMenuOpen && (
                <div className="header-menu-dropdown">
                  <button className="header-logout-button" onClick={handleLogout}>Logout</button>
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
