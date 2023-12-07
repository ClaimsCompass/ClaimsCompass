import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import { BrowserRouter, HashRouter } from "react-router-dom";
import './App.css';

const root = ReactDOM.createRoot(document.getElementById('root'));
/*

      <BrowserRouter basename={"ClaimsCompass"}>
      </BrowserRouter>
 */
root.render(
  <React.StrictMode>
      <HashRouter>
          <App />
      </HashRouter>
  </React.StrictMode>
);


