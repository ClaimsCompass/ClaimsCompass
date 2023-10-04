import React from 'react';
import Navbar from './NavBar';
import Box from './Box';
import './App.css';
function App() {
    return (
        <div className="App">
            <Navbar />
            <div className="content">
                <Box />
            </div>
        </div>
    );
}

export default App;
