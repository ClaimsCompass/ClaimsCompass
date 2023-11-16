import React from 'react';
import Table from './Table'; // Import the Table component
import '../resources/static/dashboard.css'; // Import your CSS file

const DashboardPage = () => {
    const claimDetailsArray = [
        [10670975, 5439.00, '2023-11-01', 'Life', 'High', 'Low'],
        [10670900, 875.00, '2023-11-02', 'Employment', 'Low', 'Medium'],
        [10677374, 89785.00, '2023-11-04', 'Life', 'Low', 'High'],
        // Add more arrays of claim details as needed
    ];

    return (
        <div>
            <h2>Claims Dashboard</h2>
            <Table claimDetails={claimDetailsArray} />
        </div>
    );
};

export default DashboardPage;
