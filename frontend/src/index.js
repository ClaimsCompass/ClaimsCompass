import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import { BrowserRouter, HashRouter } from "react-router-dom";
import './App.css';

const root = ReactDOM.createRoot(document.getElementById('root'));
/*
      <HashRouter>
      </HashRouter>
      <BrowserRouter basename={"ClaimsCompass"}>
      </BrowserRouter>
 */
root.render(
  <React.StrictMode>
      <BrowserRouter basename={"ClaimsCompass"}>
          <App />
      </BrowserRouter>
  </React.StrictMode>
);


