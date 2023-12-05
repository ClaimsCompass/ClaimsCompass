import React from 'react';
// import Login from "./login/login";
// import Table from "./dashboard/Table";
import DashboardPage from "./dashboard/DashboardPage";
import SecurianLogo from './login/securianLogo.png'
import ClaimPage from './claim/Claim';
import {Routes, Route} from "react-router-dom";
import axios from "axios";
import Dashboard from "./dashboardModernize/Dashboard";
import Claim from "./claimModernize/Claim";
import LoginPage from "./loginModernize/LoginPage";


function App() {
    // const response = axios.post('http://localhost:8080/assign', {});
    return (
        <>
            <Routes>
                <Route path="/" element={<LoginPage />} />
                <Route path="/login_page" element={<LoginPage />} />
                {/*<Route path="/dashboard" element={<DashboardPage />} />*/}
                <Route path="/dashboard" element={<Dashboard />} />
                <Route path="/dashboard/:id" element={<Claim/>} />
            </Routes>
        </>
    );
}

export default App;