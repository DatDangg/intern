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
    setEmail(localStorage.getItem("rememberedEmail") || "");
    setPassword(localStorage.getItem("rememberedPassword") || "");
  }, []);

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const { data } = await axios.post("http://localhost:8888/login", { email, password });
      localStorage.setItem("authToken", data.token);
      localStorage.setItem("maUser", data.maUser.toString());
      onLoginSuccess();
    } catch {
      setError("Email hoặc mật khẩu không chính xác.");
    }
  };

  const handleForgotPassword = async (e) => {
    e.preventDefault();
    try {
      const { status } = await axios.post("http://localhost:3001/reset-password", { email: resetEmail });
      setResetMessage(status === 200 ? "Reset password link has been sent to your email." : "Failed to send reset link.");
    } catch {
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
            <input type="email" placeholder="Email" className="login-input-field" value={email} onChange={(e) => setEmail(e.target.value)} />
            <input type="password" placeholder="Password" className="login-input-field" value={password} onChange={(e) => setPassword(e.target.value)} />
            {error && <p className="error-message">{error}</p>}
            <button type="submit" className="login-button">Sign In</button>
          </form>
          <button className="forgot-password-button" onClick={() => setIsForgotPassword(true)}>Forgot Password</button>
        </div>
      ) : (
        <div className="forgot-password-box">
          <h2>Forgot Password</h2>
          <form onSubmit={handleForgotPassword}>
            <input type="email" placeholder="Enter your email" className="login-input-field" value={resetEmail} onChange={(e) => setResetEmail(e.target.value)} />
            <button type="submit" className="reset-button">Send Reset</button>
          </form>
          {resetMessage && <p className="reset-message">{resetMessage}</p>}
          <button className="back-to-login-button" onClick={() => setIsForgotPassword(false)}>Back to Login</button>
        </div>
      )}
    </div>
  );
};

export default Login;
