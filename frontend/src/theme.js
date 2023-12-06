import { createTheme } from '@mui/material/styles';

const theme = createTheme({
    typography: {
        fontFamily: [
            'HurmeGeometricSans3-Regular', // Use the font-family name defined in @font-face
            'Arial',
            'Helvetica',
            'sans-serif',
        ].join(','),
    },
    overrides: {
        // Add any overrides or additional styles here if needed
    },
});

export default theme;
