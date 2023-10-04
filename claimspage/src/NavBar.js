import React from 'react';
import logoImage from './Images/Logo.png';
function Navbar() {
    return (
        <nav>
            <ul>
                <li className="left-content">
                    <img
                        src={logoImage}
                        alt="Securian Logo"
                        className="logo-image"
                    />
                </li>
                <li><a href="#" className="nav-link-home">Home</a></li>
                <li><a href="#" className="nav-link-exit">Exit</a></li>
            </ul>
        </nav>
    );
}

export default Navbar;