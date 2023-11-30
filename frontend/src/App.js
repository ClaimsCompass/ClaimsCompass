import React from 'react';
import Login from "./login/login";
// import Table from "./dashboard/Table";
import DashboardPage from "./dashboard/DashboardPage";
import SecurianLogo from './login/securianLogo.png'
import {Routes, Route} from "react-router-dom";

function App() {
    return (
        <>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/login_page" element={<Login />} />
                <Route path="/dashboard" element={<DashboardPage />} />
            </Routes>
        </>
    );
}

export default App;