import React, { useState, useEffect } from "react";
import axios from "axios";
import "../../variables.css";
import "./style.css";

const Login = ({ onLoginSuccess }) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [isForgotPassword, setIsForgotPassword] = useState(false); 
  const [resetEmail, setResetEmail] = useState("");
  const [resetMessage, setResetMessage] = useState(""); 

  useEffect(() => {
    const rememberedEmail = localStorage.getItem("rememberedEmail");
    const rememberedPassword = localStorage.getItem("rememberedPassword");

    if (rememberedEmail && rememberedPassword) {
      setEmail(rememberedEmail);
      setPassword(rememberedPassword);
    }
  }, []);

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.get("http://localhost:3001/users");
      const user = response.data.find(
        (user) => user.email === email && user.password === password
      );

      if (user) {
        localStorage.setItem("currentUser", user.id);

        setError("");
        onLoginSuccess();
      } else {
        setError("Email hoặc mật khẩu không chính xác.");
      }
    } catch (error) {
      console.error("Error fetching users:", error);
      setError("Kết nối đến máy chủ thất bại. Vui lòng thử lại sau.");
    }
  };

  const handleForgotPassword = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post("http://localhost:3001/reset-password", {
        email: resetEmail,
      });
      if (response.status === 200) {
        setResetMessage("Reset password link has been sent to your email.");
      } else {
        setResetMessage("Failed to send reset link. Please try again.");
      }
    } catch (error) {
      console.error("Error resetting password:", error);
      setResetMessage("Error sending reset link. Please try again.");
    }
  };

  return (
    <div className="login-container">
      {!isForgotPassword ? (
        <div className="login-box">
          <div className="login-logo">
            <img src="./image/Logo.png" alt="Thang Long University" />
          </div>
          <h2>Sign in Your Account</h2>
          <form onSubmit={handleLogin}>
            <input
              type="email"
              placeholder="Email"
              className="login-input-field"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
            <input
              type="password"
              placeholder="Password"
              className="login-input-field"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
            {error && <p className="error-message">{error}</p>}
            <button type="submit" className="login-button">
              Sign In
            </button>
          </form>
          <button
            className="forgot-password-button"
            onClick={() => setIsForgotPassword(true)}
          >
            Forgot Password
          </button>
        </div>
      ) : (
        <div className="forgot-password-box">
          <h2>Forgot Password</h2>
          <form onSubmit={handleForgotPassword}>
            <input
              type="email"
              placeholder="Enter your email"
              className="login-input-field"
              value={resetEmail}
              onChange={(e) => setResetEmail(e.target.value)}
            />
            <button type="submit" className="reset-button">
              Send Reset
            </button>
          </form>
          {resetMessage && <p className="reset-message">{resetMessage}</p>}
          <button
            className="back-to-login-button"
            onClick={() => setIsForgotPassword(false)}
          >
            Back to Login
          </button>
        </div>
      )}
    </div>
  );
};

export default Login;
