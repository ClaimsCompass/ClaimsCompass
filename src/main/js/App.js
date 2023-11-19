import React from 'react';
import Navbar from './NavBar';
import Box from './Box';
// import '../resources/static/App.css';
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

//import React, { useState, useEffect } from 'react';
//import axios from 'axios';
//
//function App() {
//    const [data, setData] = useState('');
//
//    useEffect(() => {
//        axios.get('/employees')
//            .then(response => {
//                setData(response.data);
//            })
//            .catch(error => {
//                console.error('Error fetching data:', error);
//            });
//    }, []);
//
//    return (
//        <div>
//            <p>Data from Spring Boot:</p>
//            <p>{data}</p>
//        </div>
//    );
//}
//
//export default App;
