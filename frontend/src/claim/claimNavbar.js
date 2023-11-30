// export default ClaimNavbar;
import whiteLogo from "./whiteLogo.png"
import "./claim.css"
import user from "./user.png"
import React from 'react';

const Navbar = () => {
    return (
        <div className="navbar">
            <div className="logo">
                <img src={whiteLogo} alt="Securian White Logo" />
            </div>

            <div className="right-section">
                <ul className="nav-links">
                    <li><a href="/">Home</a></li>
                    <li><a href="/dashboard">Dashboard</a></li>
                </ul>

                <div className="user-info">
                    <img src={user} alt="User" className="user-image" />
                    {/*TODO: Add the username's name with styling*/}
                </div>
            </div>
        </div>
    );
};

export default Navbar;