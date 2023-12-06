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
        <ClaimCard title="Recent Transactions">
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
                        <TimelineOppositeContent>Claim Date: </TimelineOppositeContent>
                        <TimelineSeparator>
                            <TimelineDot color="primary" variant="outlined" />
                            <TimelineConnector />
                        </TimelineSeparator>
                        <TimelineContent>{claimData.creationDateTime} </TimelineContent>
                    </TimelineItem>
                    <TimelineItem>
                        <TimelineOppositeContent>Claim Amount:</TimelineOppositeContent>
                        <TimelineSeparator>
                            <TimelineDot color="secondary" variant="outlined" />
                            <TimelineConnector />
                        </TimelineSeparator>
                        <TimelineContent>
                            <Typography fontWeight="600">{claimData.claimAmt}</Typography>{' '}
                            <Link href="/" underline="none">
                                #ML-3467
                            </Link>
                        </TimelineContent>
                    </TimelineItem>
                    <TimelineItem>
                        <TimelineOppositeContent>Claim Type:</TimelineOppositeContent>
                        <TimelineSeparator>
                            <TimelineDot color="success" variant="outlined" />
                            <TimelineConnector />
                        </TimelineSeparator>
                        <TimelineContent>{claimData.claimType}</TimelineContent>
                    </TimelineItem>
                    <TimelineItem>
                        <TimelineOppositeContent>09:30 am</TimelineOppositeContent>
                        <TimelineSeparator>
                            <TimelineDot color="warning" variant="outlined" />
                            <TimelineConnector />
                        </TimelineSeparator>
                        <TimelineContent>
                            <Typography fontWeight="600">New sale recorded</Typography>{' '}
                            <Link href="/" underline="none">
                                #ML-3467
                            </Link>
                        </TimelineContent>
                    </TimelineItem>
                    <TimelineItem>
                        <TimelineOppositeContent>09:30 am</TimelineOppositeContent>
                        <TimelineSeparator>
                            <TimelineDot color="error" variant="outlined" />
                            <TimelineConnector />
                        </TimelineSeparator>
                        <TimelineContent>
                            <Typography fontWeight="600">New arrival recorded</Typography>
                        </TimelineContent>
                    </TimelineItem>
                    <TimelineItem>
                        <TimelineOppositeContent>12:00 am</TimelineOppositeContent>
                        <TimelineSeparator>
                            <TimelineDot color="success" variant="outlined" />
                        </TimelineSeparator>
                        <TimelineContent>Payment Received</TimelineContent>
                    </TimelineItem>
                </Timeline>
            </>
            <ActionButton></ActionButton>
        </ClaimCard>
    );
};

export default Sidebar;
