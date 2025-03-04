import React, { useState, useEffect } from "react";
import api from "../../services/api";
import "../../variables.css";
import "./style.css";

const Header = ({ onMenuClick }) => {
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const [isLogoutPopupOpen, setIsLogoutPopupOpen] = useState(false);
  const [currentUser, setCurrentUser] = useState(null);

  useEffect(() => {
    const fetchUserData = async () => {
      const token = localStorage.getItem("authToken");
      const maUser = localStorage.getItem("maUser");

      if (!maUser || !token) return;

      try {
        const { data } = await api.get(`/admin/getId/${maUser}`, {
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

  const toggleMenu = () => {
    setIsMenuOpen(prev => !prev);
  };

  const openLogoutPopup = () => {
    setIsLogoutPopupOpen(true);
  };

  const closeLogoutPopup = () => {
    setIsLogoutPopupOpen(false);
  };

  useEffect(() => {
    const handleClickOutside = (event) => {
      if (!event.target.closest(".avatar-wrapper")) {
        setIsMenuOpen(false);
      }
    };

    document.addEventListener("click", handleClickOutside);
    return () => document.removeEventListener("click", handleClickOutside);
  }, []);

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
            <div className="avatar-wrapper" onClick={toggleMenu}>
              <img src="/image/avatar.png" alt="Avatar" className="user-avatar" />
              <div className="header-connect"></div>
              {isMenuOpen && (
                <div className="header-menu-dropdown">
                  <button className="header-logout-button" onClick={openLogoutPopup}>Logout</button>
                </div>
              )}
            </div>
          </>
        ) : (
          <span>Loading...</span>
        )}
      </div>

      {isLogoutPopupOpen && (
        <div className="logout-popup">
          <div className="logout-popup-content">
            <h3>Xác nhận đăng xuất</h3>
            <p>Bạn có chắc chắn muốn đăng xuất không?</p>
            <div className="logout-popup-buttons">
              <button className="cancel-button" onClick={closeLogoutPopup}>Hủy</button>
              <button className="confirm-button" onClick={handleLogout}>Đăng xuất</button>
            </div>
          </div>
        </div>
      )}
    </header>
  );
};

export default Header;
