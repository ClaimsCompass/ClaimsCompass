// Table.js
import React from 'react';
import '../resources/static/dashboard.css'; // Import your CSS file

const Table = ({ claimDetails }) => {
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
                <tr key={index}>
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
