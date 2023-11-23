// Table.js
import React from 'react';
import './dashboard.css'; // Import your CSS file
import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";


const Table = ({ claimDetails }) => {
    const navigate = useNavigate();
    //navigate('login_page');

    function ResolveClaimView(index) {
        navigate(":" + index.toString(), { state: { claimId: index } });
    }
    return (
        <table>
            <thead>
            <tr>
                <th className="claim-id-header extra-padding">Claim ID</th>
                <th className="claim-amount">Amount</th>
                <th className="date-received">Date</th>
                <th className="claim-type">Type</th>
                <th className="urgency">Urgency</th>
                <th className="complexity">Complexity</th>
            </tr>
            </thead>
            <tbody>
            {claimDetails.map((claim, index) => (
                <tr key={index} onClick={() => ResolveClaimView(claim[0])}>
                    <td className="claim-id extra-padding">{claim[0]}</td>
                    <td>{claim[1]}</td>
                    <td>{claim[2]}</td>
                    <td>{claim[3]}</td>
                    <td><span className={`button-value ${claim[4].toLowerCase()}`}>{claim[4]}</span></td>
                    <td><span className={`button-value ${claim[5].toLowerCase()}`}>{claim[5]}</span></td>
                </tr>
            ))}
            </tbody>
        </table>
    );
};

export default Table;
