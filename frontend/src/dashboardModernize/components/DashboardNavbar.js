import React from 'react';
import { AppBar, Toolbar, Typography, Box } from '@mui/material';
import {ThemeProvider} from "@mui/material/styles";

const DashboardNavbar = () => {
    return (
            <AppBar color={"success"} position="fixed">
                <Toolbar>
                    <Typography variant="h6">
                        ClaimsCompass
                    </Typography>
                    <Box sx={{ flexGrow: 1}} />
                </Toolbar>
            </AppBar>
    );
};

export default DashboardNavbar;