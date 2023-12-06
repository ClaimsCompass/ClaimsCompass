import React, { useEffect, useState } from 'react';
import DashboardCard from '../DashboardCard';
import {
  Timeline,
  TimelineItem,
  TimelineOppositeContent,
  TimelineSeparator,
  TimelineDot,
  TimelineConnector,
  TimelineContent,
} from '@mui/lab';
import axios from 'axios';
import { useLocation } from 'react-router-dom'; // Import useLocation

const RecentlyProcessed = () => {
  const location = useLocation();
  const [processedClaims, setProcessedClaims] = useState([]);

  useEffect(() => {
    const fetchClaims = async () => {
      try {
        if (location.state && location.state.claimId) { // Check if location.state and claimId exist
          const response = await axios.get('http://localhost:8080/api/getClaimById?id=' + location.state.claimId.toString());
          const processed = response.data.filter(claim => claim.isProcessed);
          setProcessedClaims(processed);
        } else {
          console.error('Claim ID not available in location.state');
        }
      } catch (error) {
        console.error('Error fetching claims:', error);
      }
    };

    fetchClaims();
  }, [location.state]); // Include location.state in the dependency array

  return (
      <DashboardCard title="Recently Processed Claims">
        <Timeline>
          {processedClaims.map(claim => (
              <TimelineItem key={claim.id}>
                <TimelineOppositeContent>{claim.dateProcessed}</TimelineOppositeContent>
                <TimelineSeparator>
                  <TimelineDot />
                  <TimelineConnector />
                </TimelineSeparator>
                <TimelineContent>{claim.claimDetails}</TimelineContent>
              </TimelineItem>
          ))}
        </Timeline>
      </DashboardCard>
  );
};

export default RecentlyProcessed;
