import React from "react";
import { NavLink } from "react-router-dom";
import "../../variables.css";
import "./style.css";

const Aside = ({ isVisible, toggleAside }) => {
  return (
    <aside className={`aside ${isVisible ? "visible" : ""}`}>
      <nav>
        <ul className="aside-menu">
          <li>
            <NavLink 
              to="/backlog" 
              className="aside-menu__item" 
              onClick={toggleAside}
            >
              <img src="/image/image2.png" alt="Môn tồn đọng" />
              Môn tồn đọng
            </NavLink>
          </li>
          <li>
            <NavLink 
              to="/courses-in-term" 
              className="aside-menu__item" 
              onClick={toggleAside}
            >
              <img src="/image/image4.png" alt="Môn trong kỳ" />
              Môn trong kỳ
            </NavLink>
          </li>
        </ul>
      </nav>
    </aside>
  );
};

export default Aside;