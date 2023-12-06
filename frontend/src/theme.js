import { createTheme } from '@mui/material/styles';

const theme = createTheme({
    typography: {
        fontFamily: [
            'HurmeGeometricSans3-Regular',
            'Arial',
            'Helvetica',
            'sans-serif',
        ].join(','),
    },
});

export default theme;
