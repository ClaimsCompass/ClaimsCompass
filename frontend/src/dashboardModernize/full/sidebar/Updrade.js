import React from 'react';
import { Box, Typography, Button } from '@mui/material';

export const Upgrade = () => {
    return (
        <Box
            display={'flex'}
            alignItems="center"
            gap={2}
            sx={{ m: 3, p: 3, bgcolor: `${'primary.light'}`, borderRadius: '8px' }}
        >
            <>
                <Box>
                    <Typography variant="h6" mb={1}>Unlimited Access</Typography>
                    <Button color="primary" target="_blank" href="https://adminmart.com/product/modernize-react-mui-dashboard-template/" variant="contained" aria-label="logout" size="small">
                        Upgrade
                    </Button>
                </Box>
            </>
        </Box>
    );
};
