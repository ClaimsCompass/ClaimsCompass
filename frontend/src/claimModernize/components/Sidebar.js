import React, {useEffect, useState} from 'react';
import ClaimCard from '../ClaimCard';
import {
    Timeline,
    TimelineItem,
    TimelineOppositeContent,
    TimelineSeparator,
    TimelineDot,
    TimelineConnector,
    TimelineContent,
    timelineOppositeContentClasses,
} from '@mui/lab';
import {Link, Typography} from '@mui/material';
import {ActionButton} from "./Button";
import axios from "axios";
import {useLocation} from "react-router-dom";

const Sidebar = () => {
    let location = useLocation();
    const [claimData, setClaimData] = useState([]); // Initialize state

    useEffect(() => {
        // Define the function for fetching claims data
        const fetchClaim = async () => {
            try {
                // Fetch data from your API
                const response = await axios.get('http://localhost:8080/api/getClaimById?id=' + location.state.claimId.toString());
                // Update state with the fetched data
                setClaimData(response.data);
            } catch (error) {
                // Log any errors
                console.error("Error fetching claims:", error);
            }
        };

        // Call the fetch function
        fetchClaim();
    }, []); // The empty dependency array ensures this effect runs once on component mount
    return (
        <ClaimCard title="Claim Details">
            <>
                <Timeline
                    className="theme-timeline"
                    nonce={undefined}
                    onResize={undefined}
                    onResizeCapture={undefined}
                    sx={{
                        p: 0,
                        mb: '-40px',
                        '& .MuiTimelineConnector-root': {
                            width: '1px',
                            backgroundColor: '#efefef'
                        },
                        [`& .${timelineOppositeContentClasses.root}`]: {
                            flex: 0.5,
                            paddingLeft: 0,
                        },
                    }}
                >
                    <TimelineItem>
                        <TimelineOppositeContent>Date Filed:</TimelineOppositeContent>
                        <TimelineContent>{claimData.creationDateTime} </TimelineContent>
                    </TimelineItem>
                    <TimelineItem>
                        <TimelineOppositeContent>Amount:</TimelineOppositeContent>
                        <TimelineContent>
                            <Typography>{claimData.claimAmt}</Typography>{' '}
                        </TimelineContent>
                    </TimelineItem>
                    <TimelineItem>
                        <TimelineOppositeContent>Category:</TimelineOppositeContent>
                        <TimelineContent>{claimData.claimType}</TimelineContent>
                    </TimelineItem>
                </Timeline>
            </>
            <ActionButton></ActionButton>
        </ClaimCard>
    );
};

export default Sidebar;
