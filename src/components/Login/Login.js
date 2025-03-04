import React, { useState } from "react";
import api from "../../services/api"; 
import "../../variables.css";
import "./style.css";

const Login = ({ onLoginSuccess }) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const { data } = await api.post("/login", { email, password });
      localStorage.setItem("authToken", data.token);
      localStorage.setItem("maUser", data.maUser.toString());
      onLoginSuccess();
    } catch (error) {
      setError("Email hoặc mật khẩu không chính xác.");
    }
  };

  return (
    <div className="login-container">
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
            <button type="submit" className="login-button">Sign In</button>
          </form>
        </div>
    </div>
  );
};

export default Login;
