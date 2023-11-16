import React, { useState } from 'react';
import axios from 'axios';
import IncorrectCredentialsBox from "./incorrectCredentialsBox";

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');

    const handleLogin = async () => {
        try {
            const response = await axios.post('http://localhost:8080/login', {
                username,
                password,
            });
            setMessage(response.data)
            history.push("/dashboard");
        } catch (error) {
            console.error('Login failed:', error);
        }
    };

    return (
        <div>

            <h1>Login</h1>
            <br/>
            <div className="input-container">
                <label htmlFor="username">Username: </label>
                <input type="text" id="username" name="username" placeholder="Enter your username." value={username} onChange={(e) => setUsername(e.target.value)}/>
            </div>
            <br/>
            <div className="input-container">
                <label htmlFor="password">Password: </label>
                <input type="password" id="password" name="password" placeholder="Enter your password." value={password} onChange={(e) => setPassword(e.target.value)}/>
            </div>
            <br/>
            <button onClick={handleLogin}>Login</button>
            <br />
            <p> {message} </p>
        </div>
    );
};

export default Login;
