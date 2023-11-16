import React from 'react';
import Table from './Table'; // Import the Table component
import './dashboard.css';
import axios from "axios"; // Import your CSS file

const DashboardPage = () => {
    const claimsDetailsArray = [];
    const getClaims = async () => {
        const response = await axios.get('http://localhost:8080/api/claims');
        for (let i = 0; i < response.data.length; i++) {
            claimsDetailsArray.push(response.data[i]);
        }
        return claimsDetailsArray;
    };

    return (
        <div>
            <h2>Claims Dashboard</h2>
            <Table claimDetails={claimsDetailsArray}/>
        </div>
    );
};

export default DashboardPage;
