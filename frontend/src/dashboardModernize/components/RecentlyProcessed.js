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
import {useLocation, useNavigate} from 'react-router-dom'; // Import useLocation

const RecentlyProcessed = () => {
  const location = useLocation();
  const { username } = location.state || {};
  const [processedClaims, setProcessedClaims] = useState([]);

  useEffect(() => {
    const fetchProcessedClaims = async () => {
      try {
        // Fetch data from your API
        let isProcessed = true;
        const response = await axios.post('http://localhost:8080/api/claims',
            null, {
              params: {username, isProcessed},
            });

        // Set processed claims in state
        setProcessedClaims(processedClaims);

      } catch (error) {
        console.error('Error fetching claims:', error);
      }
    };

    fetchProcessedClaims();
  }, [location.state]); // Include location.state in the dependency array

  return (
      <DashboardCard title="Recently Processed Claims">
        <Timeline>
          {processedClaims.map(claim => (
              <TimelineItem key={claim.id}>
                <TimelineOppositeContent>
                  {`${String(new Date().getHours()).padStart(2, '0')}:${String(new Date().getMinutes()).padStart(2, '0')}`}
                </TimelineOppositeContent>
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
