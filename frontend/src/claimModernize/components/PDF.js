// import React from 'react';
// import ClaimCard from '../ClaimCard';
//
// const PDF = () => {
//     return (
//         <ClaimCard title="Recent Transactions">
//             <embed allow="autoplay" src="https://drive.google.com/file/d/1pygVq2aoKgHIIaGWtYjfAJkh7HCSXgfJ/preview"></embed>
//         </ClaimCard>
//     );
// };

import React from 'react';
import { Box, Typography } from '@mui/material';

const PDFViewer = () => {
    return (
        <Box>
            <div style={{height:"100vh"}}>
                <iframe
                    title="PDF Viewer"
                    className="pdf-iframe"
                    src="https://drive.google.com/file/d/1pygVq2aoKgHIIaGWtYjfAJkh7HCSXgfJ/preview"
                    width="90%"
                    height="790vh"
                    allowFullScreen
                />
            </div>
        </Box>
    );
};

export default PDFViewer;