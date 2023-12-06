import React, { useState, useEffect } from 'react';
import {
    Typography, Box,
    Table,
    TableBody,
    TableCell,
    TableHead,
    TableRow, Chip
} from '@mui/material';
import DashboardCard from '../DashboardCard';
import {useLocation, useNavigate} from "react-router-dom";
import axios from "axios";

const ClaimsTable = () => {
    const [claimsDetailsArray, setClaimsDetailsArray] = useState([]); // Initialize state
    const location = useLocation();
    const { username } = location.state || {};
    const navigate = useNavigate();
    // const [processedOrActive, setProcessedOrActive] = useState([]); // Initialize state

    function ResolveClaimView(index) {
        navigate(":" + index.toString(), { state: { claimId: index, username: location.state.username} });
    }

    useEffect(() => {
        // Define the function for fetching claims data
        const fetchClaims = async () => {
            try {
                // Fetch data from your API
                let isProcessed = false;
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
        };

        // Call the fetch function
        fetchClaims();
    }, []); // The empty dependency array ensures this effect runs once on component mount

    async function changeActiveProcessed(isProcessed) {
        // setProcessedOrActive(changeProcessedOrActive);
        try {
            // Fetch all claims data from the API
            //let apiURL = 'http://localhost:8080/api/activeClaims'
            //if (!isActive) {
            //    apiURL = 'http://localhost:8080/api/processedClaims'
            //}
            //const response = await axios.get(apiURL);
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

    const getPriorityColor = (priority) => {
        switch (priority) {
            case "High":
                return '#FA896B';
            case "Medium":
                return '#FFEF9F';
            case "Low":
                return '#95C93D';
            default:
                return "gray"; // Default color or any other color you prefer
        }
    };

    return (
        <DashboardCard title="Your Current Claims">
            <Box sx={{ overflow: 'auto', width: { xs: '280px', sm: 'auto' } }}>
                <Table
                    aria-label="simple table"
                    sx={{
                        whiteSpace: "nowrap",
                        mt: 2
                    }}
                >
                    <TableHead>
                        <TableRow>
                            <TableCell>
                                <Typography variant="subtitle2" fontWeight={600}>
                                    Claim ID
                                </Typography>
                            </TableCell>
                            <TableCell>
                                <Typography variant="subtitle2" fontWeight={600}>
                                    Amount
                                </Typography>
                            </TableCell>
                            <TableCell>
                                <Typography variant="subtitle2" fontWeight={600}>
                                    Date
                                </Typography>
                            </TableCell>
                            <TableCell>
                                <Typography variant="subtitle2" fontWeight={600}>
                                    Type
                                </Typography>
                            </TableCell>
                            <TableCell>
                                <Typography variant="subtitle2" fontWeight={600}>
                                    Urgency
                                </Typography>
                            </TableCell>
                            <TableCell>
                                <Typography variant="subtitle2" fontWeight={600}>
                                    Complexity
                                </Typography>
                            </TableCell>

                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {claimsDetailsArray.map((claim, index) => (
                            <TableRow key={index} onClick={() => ResolveClaimView(claim[0])}>
                                <TableCell>
                                    <Typography
                                        variant="subtitle2"
                                        sx={{
                                            fontSize: "15px",
                                            fontWeight: "600",
                                        }}
                                    >
                                        {claim[0]}
                                    </Typography>
                                </TableCell>
                                <TableCell>{claim[1]}</TableCell>
                                <TableCell>{claim[2]}</TableCell>
                                <TableCell>{claim[3]}</TableCell>
                                <TableCell>
                                    <Chip
                                        sx={{
                                            px: "4px",
                                            backgroundColor: getPriorityColor(claim[4]),
                                            color: "#fff",
                                        }}
                                        size="small"
                                        label={claim[4]}
                                    ></Chip>
                                </TableCell>
                                <TableCell>
                                    <Chip
                                        sx={{
                                            px: "4px",
                                            backgroundColor: getPriorityColor(claim[5]),
                                            color: "#fff",
                                        }}
                                        size="small"
                                        label={claim[5]}
                                    ></Chip>
                                </TableCell>

                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </Box>
        </DashboardCard>
    );
};

export default ClaimsTable;
