import React from 'react';
import {Box, Button, Typography} from "@mui/material";
import axios from "axios";
import {useLocation, useNavigate} from "react-router-dom";

export const ActionButton= () => {
    let location = useLocation();
    const navigate = useNavigate();
    const redirectDashboard = async () => {
        const id = location.state.claimId;
        try {
            // POST'ing to db, indicates claim has been processed
            const updateClaimPost = 'https://desolate-atoll-42268-f37d5cfd51df.herokuapp.com/http://ec2-3-129-4-166.us-east-2.compute.amazonaws.com:8080/api/updateProcessedClaim'
            const response = await axios.post(updateClaimPost, { id });
        } catch (error) {
            // Log any errors
            console.error("Error fetching claims:", error);
        }
        navigate("/dashboard", { state: { username: location.state.username } });
    }
    return (
        <Box
            display={'flex'}
            alignItems="center"
            gap={2}
            sx={{ m: 3, p: 3, bgcolor: `${'transparent'}`, borderRadius: '8px' }}
        >
            <>
            <Button onClick={redirectDashboard} color="primary" target="_blank"  variant="contained" aria-label="logout" size="small" style={{backgroundColor: "#0C7B40"}}>
                Approve
            </Button>
            <Button onClick={redirectDashboard} color="primary" target="_blank" variant="contained"  size="small" style={{backgroundColor:"#0C7B40"}}>
                Forward
            </Button>
            </>
        </Box>
    );
};