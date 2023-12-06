// import React from 'react';
// import Table from './Table'; // Import the Table component
// import './dashboard.css';
// import axios from "axios"; // Import your CSS file
// import {useState, useEffect} from 'react';
//
// const DashboardPage = () => {
//     const [claimsDetailsArray, setClaimsDetailsArray] = useState([]);
//     // const getClaims = async () => {
//     //     const response = await axios.get('http://localhost:8080/api/claims');
//     //     return response.data;
//     //     // setClaimsDetailsArray(response.data)
//     //     // for (let i = 0; i < response.data.length; i++) {
//     //     //     claimsDetailsArray.push(response.data[i]);
//     //     // }
//     //     // return claimsDetailsArray;
//     // };
//     // console.log(getClaims());
//     const fetchClaims = async () => {
//         try {
//             const response = await axios.get('http://localhost:8080/api/claims');
//             setClaimsDetailsArray(response.data);
//         } catch (error) {
//             console.error("Error fetching claims:", error);
//         }
//     };
//
//     fetchClaims();
//
//     return (
//         <div>
//             <h2>Claims Dashboard</h2>
//             <Table claimDetails={claimsDetailsArray}/>
//         </div>
//     );
// };
//
// export default DashboardPage;
import React, { useState, useEffect } from 'react';
import Table from './Table'; // Import the Table component
import './dashboard.css'; // Import your CSS file
import axios from "axios";
import {useLocation} from 'react-router-dom';
import {Button} from "react-bootstrap"; // Import axios for HTTP requests

const DashboardPage = () => {
    const [claimsDetailsArray, setClaimsDetailsArray] = useState([]); // Initialize state
    const location = useLocation();
    const { username } = location.state || {};
    // const [processedOrActive, setProcessedOrActive] = useState([]); // Initialize state

    useEffect(() => {
        // Define the function for fetching claims data
        const fetchClaims = async () => {
            try {
                // Fetch data from your API
                let isProcessed = false;
                // Local
                // const claimsPost = 'http://localhost:8080/api/claims'

                // EC2
                const claimsPost = 'http://3.129.4.166/api/claims'
                const response = await axios.post(claimsPost,
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

            // const claimsPost = 'http://localhost:8080/api/claims'
            const claimsPost = 'http://3.129.4.166/api/claims'
            const response = await axios.post(claimsPost,
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
        <div>
            <h2>Claims Dashboard</h2>
            { /* Pass the claims data to the Table component */ }
            <div className="claim-type-selector">
                <Button onClick={() => changeActiveProcessed(false)} className="btn btb-primary">Active</Button>
                <Button onClick={() => changeActiveProcessed(true)}>Processed</Button>
            </div>
            <Table claimDetails={claimsDetailsArray} />
        </div>
    );
};

export default DashboardPage;
