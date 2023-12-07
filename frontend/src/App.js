import React from 'react';
import {Routes, Route} from "react-router-dom";
import Dashboard from "./dashboardModernize/Dashboard";
import Claim from "./claimModernize/Claim";
import LoginPage from "./loginModernize/LoginPage";
import { ThemeProvider } from '@mui/material/styles';
import theme from './theme';


function App() {
    return (
        <ThemeProvider theme={theme}>
        <>
            <Routes>
                <Route path="/" element={<LoginPage />} />
                <Route path="/login_page" element={<LoginPage />} />
                <Route path="/dashboard" element={<Dashboard />} />
                <Route path="/dashboard/:id" element={<Claim/>} />
            </Routes>
        </>
        </ThemeProvider>
    );
}

export default App;