import React, {useEffect, useState} from 'react';
import axios from 'axios';
import SecurianLogo from './securianLogo.png';
import { useNavigate } from "react-router-dom";
import "./login.css"

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');
    const navigate = useNavigate();

    const handleLogin = async () => {
        try {
            // Local
            // const loginPost = 'http://localhost:8080/login';
            
            // EC2
            const loginPost = 'http://3.129.4.166:8080/login';
            const response = await axios.post(loginPost, {
                username,
                password,
            });
            if (response.status === 200) {
                setMessage(response.data);
                // Local
                // const assignPost = 'http://localhost:8080/assign';

                // EC2
                const assignPost = 'http://3.129.4.166:8080/assign';
                const response2 = await axios.post(assignPost, {});
                navigate('/dashboard', { state: { username } });
            } else {
                console.error('Login failed:', response.status, response.statusText);
                setMessage('Login failed. Please check your credentials.');
            }
        } catch (error) {
            // Handle network errors or other issues
            console.error('Login failed:', error);
            setMessage('Login failed. Please try again later.');
        }
    };
    // const assignClaims = async () => {
    //     try {
    //         const assignResponse = await axios.post('http://localhost:8080/assign', {
    //             // Include any necessary data for the assignment
    //         });
    //
    //         if (assignResponse.status === 200) {
    //             console.log('Claims assigned successfully.');
    //             // Optionally, you can perform any additional actions after claims are assigned.
    //         } else {
    //             console.error('Assignment failed:', assignResponse.status, assignResponse.statusText);
    //             // Handle assignment failure
    //         }
    //     } catch (error) {
    //         console.error('Assignment failed:', error);
    //         // Handle network errors or other issues during assignment
    //     }
    // };

    return (
        <div className="container">
            <div className="login-logo-box">
                <img src={SecurianLogo} alt="Securian Logo" />
            </div>
            <div className="login-box">
                <h1>Login</h1>
                <br />
                <div className="input-container">
                    <label htmlFor="username">Username: </label>
                    <input
                        type="text"
                        id="username"
                        name="username"
                        placeholder="Enter your username."
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                </div>
                <br />
                <div className="input-container">
                    <label htmlFor="password">Password: </label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        placeholder="Enter your password."
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </div>
                <br />
                <button onClick={handleLogin}>Login</button>
                <br />
                <p>{message}</p>
            </div>
        </div>
        // <div>
        //
        //     <h1>Login</h1>
        //     <br/>
        //     <div className="input-container">
        //         <label htmlFor="username">Username: </label>
        //         <input type="text" id="username" name="username" placeholder="Enter your username." value={username} onChange={(e) => setUsername(e.target.value)}/>
        //     </div>
        //     <br/>
        //     <div className="input-container">
        //         <label htmlFor="password">Password: </label>
        //         <input type="password" id="password" name="password" placeholder="Enter your password." value={password} onChange={(e) => setPassword(e.target.value)}/>
        //     </div>
        //     <br/>
        //     <button onClick={handleLogin}>Login</button>
        //     <br />
        //     <p> {message} </p>
        // </div>
    );
};

export default Login;
