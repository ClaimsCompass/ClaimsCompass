import React from 'react';
import { Grid, Box } from '@mui/material';
import DashboardContainer from './DashboardContainer';

// components
import MonthlyClaimsOverview from './components/MonthlyClaimsOverview';
import WeeklyClaimsBreakdown from './components/WeeklyClaimsBreakdown';
import RecentlyProcessed from './components/RecentlyProcessed';
import ClaimsTable from './components/ClaimsTable';
import YearlyClaimsStats from './components/YearlyClaimsStats';
import DashboardNavbar from "./components/DashboardNavbar";


const Dashboard = () => {
  return (
    <DashboardContainer title="Your Claims" description="this is Dashboard">
      <DashboardNavbar></DashboardNavbar>
      <Box sx={{marginTop: '100px'}}>
        <Grid container spacing={3}>
          <Grid item xs={12} lg={8}>
            <ClaimsTable />
          </Grid>
          <Grid item xs={12} lg={4}>
            <Grid container spacing={3}>
              <Grid item xs={12}>
                <WeeklyClaimsBreakdown />
              </Grid>
              <Grid item xs={12}>
                <YearlyClaimsStats />
              </Grid>
            </Grid>
          </Grid>
          <Grid item xs={12} lg={4}>
            <RecentlyProcessed />
          </Grid>
          <Grid item xs={12} lg={8}>
            <MonthlyClaimsOverview />
          </Grid>
        </Grid>
      </Box>
    </DashboardContainer>
  );
};

export default Dashboard;
