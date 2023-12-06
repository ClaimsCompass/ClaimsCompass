import React from 'react';
import { AppBar, Toolbar, Typography, Box } from '@mui/material';

const ClaimNavbar = () => {
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

export default ClaimNavbar;