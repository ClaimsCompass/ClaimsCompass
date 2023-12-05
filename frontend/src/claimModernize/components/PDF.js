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

export default PDF;

import React from 'react';
import { Document, Page } from 'react-pdf';
import ClaimCard from '../ClaimCard';
const PDFViewer = () => {
    const pdfURL = 'https://drive.google.com/file/d/1pygVq2aoKgHIIaGWtYjfAJkh7HCSXgfJ/preview';
    return (
        <ClaimCard>
            <Document file={pdfURL}>
                <Page pageNumber={1} />
            </Document>
        </ClaimCard>
    );
};
export default PDFViewer;