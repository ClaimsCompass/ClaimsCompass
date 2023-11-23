CREATE TABLE public.claims_examiner (
    username character varying NOT NULL,
    first_name character varying NOT NULL,
    password character varying NOT NULL,
    id bigint NOT NULL
);


ALTER TABLE public.claims_examiner OWNER TO securian;

--
-- TOC entry 3598 (class 0 OID 16685)
-- Dependencies: 216
-- Data for Name: claims_examiner; Type: TABLE DATA; Schema: public; Owner: securian
--

COPY public.claims_examiner (username, first_name, password, id) FROM stdin;
a	a	a	1
\.


--
-- TOC entry 3454 (class 2606 OID 16691)
-- Name: claims_examiner claims_examiner_pkey; Type: CONSTRAINT; Schema: public; Owner: securian
--

ALTER TABLE ONLY public.claims_examiner
    ADD CONSTRAINT claims_examiner_pkey PRIMARY KEY (username);
