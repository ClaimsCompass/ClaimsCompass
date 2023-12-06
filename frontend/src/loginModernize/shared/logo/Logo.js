import React from 'react';
import { Link } from 'react-router-dom';
import Securian from './img.png';

const linkStyle = {
  height: '70px',
  width: '180px',
  overflow: 'hidden',
  display: 'block',
  textDecoration: 'none', // Optional: To remove default link underline
};

const logoStyle = {
  height: '40px',
  width: 'auto',
};

const Logo = () => {
  return (
      <Link to="/" style={linkStyle}>
        <img src={Securian} alt="Logo" style={logoStyle} />
      </Link>
  );
};

export default Logo;
