import React from 'react';
import Login from "./login/login";
import SecurianLogo from './login/securianLogo.png'

function App() {
  return (
      <div className="container">
          <div className="login-logo-box">
              <img src={SecurianLogo} alt="Securian Logo" />
          </div>
          <div className="login-box">
              <Login />
          </div>
      </div>
  );
}

export default App;