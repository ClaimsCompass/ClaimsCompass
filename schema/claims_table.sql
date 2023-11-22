-- CREATE SCHEMA IF NOT EXISTS public AUTHORIZATION securian;

CREATE TABLE claims (
    id integer NOT NULL,
    claim_type character varying,
    claim_amt real,
    claim_details character varying,
    complexity_score integer,
    urgency_score integer,
    total_score integer,
    processed boolean,
    creation_date_time timestamp without time zone
);


ALTER TABLE claims OWNER TO securian;

--
-- TOC entry 3598 (class 0 OID 16678)
-- Dependencies: 215
-- Data for Name: claims; Type: TABLE DATA; Schema: public; Owner: securian
--

COPY claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time) FROM stdin;
1	life	10000	should be lowest	1	0	\N	f	2023-11-19 18:00:00
2	disability	12000	num 5	5	0	\N	f	2023-11-19 18:00:00
3	life	95000	num 4	4	0	\N	f	2023-11-18 18:00:00
4	unemployment	40000	num 3	4	0	\N	f	2023-11-18 18:00:00
5	disability\n	320000	should be highest\n	8	0	\N	f	2023-11-17 18:00:00
6	unemployment	88000	num 2	1	0	\N	f	2023-11-17 18:00:00
\.

ALTER TABLE ONLY claims
    ADD CONSTRAINT claim_pkey PRIMARY KEY (id);
