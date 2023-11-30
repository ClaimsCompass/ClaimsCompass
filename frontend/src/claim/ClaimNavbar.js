import React, {useEffect, useState} from 'react';
import {useLocation, useNavigate} from 'react-router-dom';
import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import NavDropdown from 'react-bootstrap/NavDropdown';
import axios from 'axios';
// import '../dashboard/dashboard.css';

const ClaimNavbar = () => {
    // Fetch claim details based on ID or use the provided ID to display details
    let location = useLocation();
    const navigate = useNavigate();
    const [claimData, setClaimData] = useState([]); // Initialize state

    const redirectDashboard = async () => {
        navigate("/dashboard");
    }

    return (
        <Navbar className="bg-body-tertiary" height="500px">
            <Container>
                <Navbar.Brand href="#home">Navbar with text</Navbar.Brand>
                <Navbar.Toggle />
                <Navbar.Collapse className="justify-content-end">
                    <Navbar.Text>
                        Signed in as: <a href="#login">Mark Otto</a>
                    </Navbar.Text>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
};

export default ClaimNavbar;
