import React, { useState, useEffect } from 'react';
import Table from './Table'; // Import the Table component
import './dashboard.css'; // Import your CSS file
import axios from "axios";
import {useLocation} from "react-router-dom";

const DashboardPage = () => {
    const [claimsDetailsArray, setClaimsDetailsArray] = useState([]); // Initialize state
    const location = useLocation();
    const { username } = location.state || {};

    useEffect(() => {
        // Define the function for fetching claims data
        const fetchClaims = async () => {
            try {
                // Fetch data from your API
                const response = await axios.post('http://localhost:8080/api/claims',
                    null, {
                        params: {username},
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

    return (
        <div>
            <h2>Claims Dashboard</h2>
            {/* Pass the claims data to the Table component */}
            <Table claimDetails={claimsDetailsArray} />
        </div>
    );
};

export default DashboardPage;