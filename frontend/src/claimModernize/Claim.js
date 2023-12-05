import Sidebar from "./components/Sidebar";
import {Box, Grid} from "@mui/material";
import DashboardContainer from "../dashboardModernize/DashboardContainer";
import PDF from "./components/PDF";
import PDFViewer from "./components/PDF";

const Claim = () => {
  return (
    <DashboardContainer title="Claim" description="this is claim page">
      <Box>
        <Grid container spacing={3}>
          <Grid item xs={12} lg={4}>
            <Sidebar />
          </Grid>
            <Grid item xs={12} lg={8}>
                <PDFViewer />
            </Grid>
        </Grid>
      </Box>
    </DashboardContainer>
  );
};

export default Claim;