import React, {useEffect, useState} from 'react';
import {useLocation, useNavigate} from 'react-router-dom';
import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import NavDropdown from 'react-bootstrap/NavDropdown';
import axios from 'axios';
import ClaimNavbar from "./claimNavbar";
// import '../dashboard/dashboard.css';

const ClaimPage = () => {
    // Fetch claim details based on ID or use the provided ID to display details
    let location = useLocation();
    const navigate = useNavigate();
    const [claimData, setClaimData] = useState([]); // Initialize state

    useEffect(() => {
        // Define the function for fetching claims data
        const fetchClaim = async () => {
            try {
                // Fetch data from your API
                const response = await axios.get('http://localhost:8080/api/getClaimById?id=' + location.state.claimId.toString());
                // Update state with the fetched data
                setClaimData(response.data);
            } catch (error) {
                // Log any errors
                console.error("Error fetching claims:", error);
            }
        };

        // Call the fetch function
        fetchClaim();
    }, []); // The empty dependency array ensures this effect runs once on component mount

    const redirectDashboard = async () => {
        try {
            // POST'ing to db, indicates claim has been processed
            const response = await axios.post('http://localhost:8080/api/updateProcessedClaim?id='
                + location.state.claimId.toString());
        } catch (error) {
            // Log any errors
            console.error("Error fetching claims:", error);
        }
        navigate("/dashboard");
    }

    return (
        <div>
            <ClaimNavbar></ClaimNavbar>
            <h2>Claim Amount: {claimData.claimAmt}</h2>
            <h2>Creation Date: {claimData.creationDateTime}</h2>
            <h2>Details of Claim ID: {claimData.claimType}</h2>
            <button onClick={redirectDashboard}>Process</button>
            <button onClick={redirectDashboard}>Send</button>
            <iframe src="https://drive.google.com/file/d/1pygVq2aoKgHIIaGWtYjfAJkh7HCSXgfJ/preview" width="640" height="480" allow="autoplay"></iframe>
        </div>
    );
};

export default ClaimPage;