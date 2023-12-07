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
        const recentlyProcessed = 'https://desolate-atoll-42268-f37d5cfd51df.herokuapp.com/http://ec2-3-129-4-166.us-east-2.compute.amazonaws.com:8080/api/claims';
        const response = await axios.post(recentlyProcessed, {username, isProcessed});

        // Set processed claims in state
        setProcessedClaims(response.data);
        console.log(processedClaims);

      } catch (error) {
        console.error('Error fetching claims:', error);
      }
    };

    fetchProcessedClaims();
  }, [location.state]); // Include location.state in the dependency array

  return (
      <DashboardCard title="Recently Processed Claims">
        <Timeline>
          {processedClaims.map(claim => { // Shows when each approved claim was filed and its details
            console.log("Claim object:", claim); // Log the claim object
            return (
                <TimelineItem key={claim.id}>
                  <TimelineOppositeContent>
                    {`${String(claim[2])}`}
                  </TimelineOppositeContent>
                  <TimelineSeparator>
                    <TimelineDot />
                    <TimelineConnector />
                  </TimelineSeparator>
                  <TimelineContent> Approved Claim #{String(claim[0])} of type {claim[3]} of value ${claim[1]}.</TimelineContent>
                </TimelineItem>
            );
          })}
        </Timeline>
      </DashboardCard>
  );
};

export default RecentlyProcessed;
