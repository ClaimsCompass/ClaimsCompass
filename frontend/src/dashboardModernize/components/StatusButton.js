import React, {useState} from 'react';
import {Box, Button, Typography} from "@mui/material";
import axios from "axios";
import {useLocation, useNavigate} from "react-router-dom";

export const StatusButton= () => {
    let location = useLocation();
    const navigate = useNavigate();
    const [claimsDetailsArray, setClaimsDetailsArray] = useState([]);

    async function changeActiveProcessed(isProcessed) {
        try {
            const response = await axios.post('http://localhost:8080/api/claims',
                null, {
                    params: {username, isProcessed},
                });

            // Update state with the fetched data
            setClaimsDetailsArray(response.data);
        } catch (error) {
            // Log any errors
            console.error("Error fetching claims:", error);
        }
    }
    return (
        <Box
            display={'flex'}
            alignItems="center"
            gap={2}
            sx={{ m: 3, p: 3, bgcolor: `${'transparent'}`, borderRadius: '8px' }}
        >
            <>
                <Button onClick={redirectDashboard} color="primary" target="_blank"  variant="contained" aria-label="logout" size="small">
                    Approve
                </Button>
                <Button onClick={redirectDashboard} color="primary" target="_blank" variant="contained"  size="small">
                    Forward
                </Button>
            </>
        </Box>
    );
};