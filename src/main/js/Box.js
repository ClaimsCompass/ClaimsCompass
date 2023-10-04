import React, { useState } from 'react';
import axios from 'axios';
function Box() {

    const [message, setMessage] = useState('');
    const newEmployeeName = "Maryam";
    const newEmployeeLastName = "Taj"

    const handleButtonClick = async () => {
        try {
            const response = await axios.post('/employees', {
                firstName: newEmployeeName,
                lastName: newEmployeeLastName
            });
            setMessage(response.data);
        } catch (error) {
            console.error('Error:', error);
        }
    };

    return (
        <div className="container">
            <div className="empty-box"></div>
            <div className="button-and-form-container">
                <button className="custom-button" onClick={handleButtonClick}>
                    Process
                </button>
                <div className="form-box">
                    <div className="category-indicator">Express</div>
                    <form>
                        <div className="form-group">
                            <label>First Name:</label>
                            <span>John</span>
                        </div>
                        <div className="form-group">
                            <label>Last Name:</label>
                            <span>Doe</span>
                        </div>
                        <div className="form-group">
                            <label>Amount:</label>
                            <span>$100</span>
                        </div>
                        <div className="form-group">
                            <label>Date received:</label>
                            <span>2023-10-10</span>
                        </div>
                        <div className="form-group">
                            <label>Phone Number:</label>
                            <span>(123) 456-7890</span>
                        </div>
                        <div className="form-group">
                            <label>Email:</label>
                            <span>john.doe@example.com</span>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        );
    }

export default Box;