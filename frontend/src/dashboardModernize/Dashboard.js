import React from 'react';
import { Grid, Box } from '@mui/material';
import DashboardContainer from './DashboardContainer';

// components
import SalesOverview from './components/SalesOverview';
import YearlyBreakup from './components/YearlyBreakup';
import RecentTransactions from './components/RecentTransactions';
import ClaimsTable from './components/ClaimsTable';
import MonthlyEarnings from './components/MonthlyEarnings';


const Dashboard = () => {
  return (
    <DashboardContainer title="Your Claims" description="this is Dashboard">
      <Box>
        <Grid container spacing={3}>
          <Grid item xs={12} lg={8}>
            <ClaimsTable />
          </Grid>
          <Grid item xs={12} lg={4}>
            <Grid container spacing={3}>
              <Grid item xs={12}>
                <YearlyBreakup />
              </Grid>
              <Grid item xs={12}>
                <MonthlyEarnings />
              </Grid>
            </Grid>
          </Grid>
          <Grid item xs={12} lg={4}>
            <RecentTransactions />
          </Grid>
          <Grid item xs={12} lg={8}>
            <SalesOverview />
          </Grid>
        </Grid>
      </Box>
    </DashboardContainer>
  );
};

export default Dashboard;
