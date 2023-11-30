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
            const response = await axios.post('http://localhost:8080/login', {
                username,
                password,
            });
            if (response.status === 200) {
                setMessage(response.data);
                navigate('/dashboard');
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
