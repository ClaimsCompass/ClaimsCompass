import React from 'react';
import {Routes, Route} from "react-router-dom";
import axios from "axios";
import Dashboard from "./dashboardModernize/Dashboard";
import Claim from "./claimModernize/Claim";
import LoginPage from "./loginModernize/LoginPage";
import { ThemeProvider } from '@mui/material/styles';
import theme from './theme';


function App() {
    // const response = axios.post('http://localhost:8080/assign', {});
    return (
        <ThemeProvider theme={theme}>
        <>
            <Routes>
                <Route path="/" element={<LoginPage />} />
                <Route path="/login_page" element={<LoginPage />} />
                {/*<Route path="/dashboard" element={<DashboardPage />} />*/}
                <Route path="/dashboard" element={<Dashboard />} />
                <Route path="/dashboard/:id" element={<Claim/>} />
            </Routes>
        </>
        </ThemeProvider>
    );
}

export default App;