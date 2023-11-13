import React, { useState } from 'react';
import axios from 'axios';

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = async () => {
        try {
            const response = await axios.post('/login', {
                username,
                password,
            });
            console.log('Login successful:', response.data);
        } catch (error) {
            console.error('Login failed:', error.message);
        }
    };

    return (
        <div>
            <h1>Login</h1>
            <label>
                Username:
                <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />
            </label>
            <br />
            <label>
                Password:
                <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
            </label>
            <br />
            <button onClick={handleLogin}>Login</button>
        </div>
    );
};

export default Login;