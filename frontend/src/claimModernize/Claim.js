import Sidebar from "./components/Sidebar";
import {Box, Grid, Typography} from "@mui/material";
import PDFViewer from "./components/PDF";
import ClaimContainer from "./ClaimContainer";
import ClaimCard from "./ClaimCard";
import ClaimNavbar from "./components/ClaimNavbar";

const Claim = () => {
    return (
        <ClaimContainer title="Claim Page" description="this is claim page">
            <ClaimCard>
                <ClaimNavbar></ClaimNavbar>
                <Box sx={{marginTop: '100px'}}>
                    <Grid container spacing={3}>
                    <Grid item xs={12} lg={4}>
                     <Sidebar />
                    </Grid>
                     <Grid item xs={12} lg={8}>
                         <PDFViewer />
                     </Grid>
                    </Grid>
                </Box>
            </ClaimCard>
        </ClaimContainer>
    );
};

export default Claim;