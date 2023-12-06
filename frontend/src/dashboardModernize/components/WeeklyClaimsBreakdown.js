import React from 'react';
import Chart from 'react-apexcharts';
import { useTheme } from '@mui/material/styles';
import { Grid, Stack, Typography, Avatar } from '@mui/material';
import {IconArrowDownRight, IconArrowUpLeft} from '@tabler/icons-react';

import DashboardCard from '../DashboardCard';

const WeeklyClaimsBreakdown = () => {
  // chart color
  const theme = useTheme();
  const primary = theme.palette.primary.main;
  const primarylight = 'green';
  const successlight = theme.palette.success.light;

  // chart
  const optionscolumnchart = {
    chart: {
      type: 'donut',
      fontFamily: "'Plus Jakarta Sans', sans-serif;",
      foreColor: 'green',
      toolbar: {
        show: false,
      },
      height: 155,
    },
    colors: ['#95C93D', '#0C7B40', '#0AA147'],
    plotOptions: {
      pie: {
        startAngle: 0,
        endAngle: 360,
        donut: {
          size: '75%',
          background: 'transparent',
        },
      },
    },
    tooltip: {
      theme: theme.palette.mode === 'dark' ? 'dark' : 'light',
      fillSeriesColor: false,
    },
    stroke: {
      show: false,
    },
    dataLabels: {
      enabled: false,
    },
    legend: {
      show: false,
    },
    responsive: [
      {
        breakpoint: 991,
        options: {
          chart: {
            width: 120,
          },
        },
      },
    ],
  };
  const seriescolumnchart = [38, 40, 25];

  return (
    <DashboardCard title="Weekly Claims Breakdown">
      <Grid container spacing={3}>
        {/* column */}
        <Grid item xs={7} sm={7}>
          <Typography variant="h3" fontWeight="700">
            $36,358
          </Typography>
          <Stack direction="row" spacing={1} mt={1} alignItems="center">
            <Avatar sx={{ bgcolor: '#B4EBCA', width: 27, height: 27 }}>
              <IconArrowUpLeft width={20} color="#109648" />
            </Avatar>
            <Typography variant="subtitle2" fontWeight="600">
              +9%
            </Typography>
            <Typography variant="subtitle2" color="textSecondary">
              from last week
            </Typography>
          </Stack>
          <Stack spacing={3} mt={5} direction="row">
            <Stack direction="row" spacing={1} alignItems="center">
              <Avatar
                sx={{ width: 9, height: 9, bgcolor: '#95C93D', svg: { display: 'none' } }}
              ></Avatar>
              <Typography variant="subtitle2" color="textSecondary">
                Life
              </Typography>
            </Stack>
            <Stack direction="row" spacing={1} alignItems="center">
              <Avatar
                sx={{ width: 9, height: 9, bgcolor: '#0C7B40', svg: { display: 'none' } }}
              ></Avatar>
              <Typography variant="subtitle2" color="textSecondary">
                Employment
              </Typography>
            </Stack>
            <Stack direction="row" spacing={1} alignItems="center">
              <Avatar
                  sx={{ width: 9, height: 9, bgcolor: '#0AA147', svg: { display: 'none' } }}
              ></Avatar>
              <Typography variant="subtitle2" color="textSecondary">
                Disability
              </Typography>
            </Stack>
          </Stack>
        </Grid>
        {/* column */}
        <Grid item xs={5} sm={5}>
          <Chart
            options={optionscolumnchart}
            series={seriescolumnchart}
            type="donut"
            height="150px"
          />
        </Grid>
      </Grid>
    </DashboardCard>
  );
};

export default WeeklyClaimsBreakdown;
