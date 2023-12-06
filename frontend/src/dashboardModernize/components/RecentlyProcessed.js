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

const RecentlyProcessed = () => {
  const [processedClaims, setProcessedClaims] = useState([]);

  useEffect(() => {
    const fetchClaims = async () => {
      try {
        // Fetch claims data from your API
        const response = await axios.get('http://localhost:8080/api/getClaimById?id=' + location.state.claimId.toString());

        // Filter claims where isProcessed is true
        const processed = response.data.filter(claim => claim.isProcessed);

        // Update state with filtered processed claims
        setProcessedClaims(processed);
      } catch (error) {
        // Log any errors
        console.error('Error fetching claims:', error);
      }
    };

    // Call the fetch function
    fetchClaims();
  }, [location.state.claimId]); // Add location.state.claimId to the dependency array

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
