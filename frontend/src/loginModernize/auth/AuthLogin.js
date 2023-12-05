import React, {useState} from 'react';
import {
    Box,
    Typography,
    FormGroup,
    FormControlLabel,
    Button,
    Stack,
    Checkbox
} from '@mui/material';
import {Link, useNavigate} from 'react-router-dom';

import CustomTextField from '../CustomTextField';
import axios from "axios";

const AuthLogin = ({ title, subtitle, subtext }) => {
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
                const response2 = await axios.post('http://localhost:8080/assign', {});
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

    return <>

        {title ? (
            <Typography fontWeight="700" variant="h2" mb={1}>
                {title}
            </Typography>
        ) : null}

        {subtext}

        <Stack>
            <Box>
                <Typography variant="subtitle1"
                    fontWeight={600} component="label" htmlFor='username' mb="5px">Username</Typography>
                <CustomTextField id="username" variant="outlined" fullWidth value={username}
                                 onChange={(e) => setUsername(e.target.value)}/>
            </Box>
            <Box mt="25px">
                <Typography variant="subtitle1"
                    fontWeight={600} component="label" htmlFor='password' mb="5px" >Password</Typography>
                <CustomTextField id="password" type="password" variant="outlined" fullWidth value={password}
                                 onChange={(e) => setPassword(e.target.value)}/>
            </Box>
            <Stack justifyContent="space-between" direction="row" alignItems="center" my={2}>
                <Typography
                    component={Link}
                    to="/"
                    fontWeight="500"
                    sx={{
                        textDecoration: 'none',
                        color: 'primary.main',
                    }}
                >
                    {message}
                </Typography>
            </Stack>
        </Stack>
        <Box>
            <Button
                onClick={handleLogin}
                color="primary"
                variant="contained"
                size="large"
                fullWidth
                component={Link}
                to="/"
                type="submit"
            >
                Sign In
            </Button>
        </Box>
        {subtitle}
    </>
};

export default AuthLogin;
