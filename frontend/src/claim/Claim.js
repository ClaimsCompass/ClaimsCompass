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
                const claimId = location.state.claimId.toString();
                const response = await axios.get(
                    'https://desolate-atoll-42268-f37d5cfd51df.herokuapp.com/http://3.129.4.166:8080/api/getClaimById',
                    {response}
                );
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
        const id = location.state.claimId;
        try {
            // POST'ing to db, indicates claim has been processed
            const response = await axios.post('http://localhost:8080/api/updateProcessedClaim',
                null, {
                    params: { id },
                });
        } catch (error) {
            // Log any errors
            console.error("Error fetching claims:", error);
        }
        navigate("/dashboard", { state: { username: location.state.username } });
    }

    /*
    <h2>Claim Amount: {claimData.claimAmt}</h2>
    <h2>Creation Date: {claimData.creationDateTime}</h2>
    <h2>Details of Claim ID: {claimData.claimType}</h2>
    */

    return (
        <div>
            <ClaimNavbar username={location.state.username}></ClaimNavbar>
            <div className="claim-info-container">
                <div className="detail-container">
                    <div className="detail-column">
                        <h2>Claim Amount: {claimData.claimAmt}</h2>
                    </div>
                    <div className="detail-column">
                        <h2>Creation Date: {claimData.creationDateTime}</h2>
                    </div>
                    <div className="detail-column">
                        <h2>Details of Claim ID: {claimData.claimType}</h2>
                    </div>
                </div>
                <iframe className="claim-pdf" allow="autoplay" src="https://drive.google.com/file/d/1pygVq2aoKgHIIaGWtYjfAJkh7HCSXgfJ/preview"></iframe>
            </div>
            {claimData['processed'] ? <div></div> :
                <div className="claim-type-selector">
                    <button onClick={redirectDashboard}>Process</button>
                    <button onClick={redirectDashboard}>Send</button>
                </div>};
        </div>
    );
};

export default ClaimPage;
