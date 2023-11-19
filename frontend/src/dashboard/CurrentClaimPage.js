import React from 'react';
import { useParams } from 'react-router-dom';

const CurrentClaimPage = () => {
    const { id } = useParams();

    // Fetch claim details based on ID or use the provided ID to display details

    return (
        <div>
            <h2>Details of Claim ID: {id}</h2>
            {/* Display claim details */}
        </div>
    );
};

export default CurrentClaimPage;
