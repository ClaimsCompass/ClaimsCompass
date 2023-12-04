import React from 'react';
import Login from "./login/login";
// import Table from "./dashboard/Table";
import DashboardPage from "./dashboard/DashboardPage";
import SecurianLogo from './login/securianLogo.png'
import ClaimPage from './claim/Claim';
import {Routes, Route} from "react-router-dom";
import axios from "axios";

function App() {
    // const response = axios.post('http://localhost:8080/assign', {});
    return (
        <>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/login_page" element={<Login />} />
                <Route path="/dashboard" element={<DashboardPage />} />
                <Route path="/dashboard/:id" element={<ClaimPage />} />
            </Routes>
        </>
    );
}

export default App;