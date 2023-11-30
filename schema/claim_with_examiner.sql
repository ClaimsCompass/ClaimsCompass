--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2023-11-29 19:44:01 EST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 49299)
-- Name: claims; Type: TABLE; Schema: public; Owner: securian
--
DROP TABLE IF EXISTS public.claims;

CREATE TABLE public.claims (
    id integer NOT NULL,
    claim_type character varying(255) NOT NULL,
    claim_amt real NOT NULL,
    claim_details character varying(255),
    complexity_score integer,
    urgency_score integer,
    total_score integer,
    processed boolean,
    creation_date_time timestamp without time zone,
    examiner character varying,
    state character varying
);


ALTER TABLE public.claims OWNER TO securian;

--
-- TOC entry 3599 (class 0 OID 49299)
-- Dependencies: 217
-- Data for Name: claims; Type: TABLE DATA; Schema: public; Owner: securian
--

INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (1287392, 'disability', 100000, NULL, 8, 0, 0, true, '2023-11-17 08:00:00', 'janeDoe', NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (1423567, 'employment
', 7000, NULL, 5, 0, 0, false, '2023-11-17 15:00:00', 'janeDoe', NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (1523467, 'life
', 5000, NULL, 3, 0, 0, false, '2023-11-16 00:00:00', 'janeDoe', NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (1623457, 'life
', 5000, NULL, 2, 0, 0, true, '2023-11-17 08:00:00', 'janeDoe', NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (1927301, 'life', 3000, 'details from form', 2, 0, 0, false, '2023-11-10 00:00:00', 'janeDoe', NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (2635372, 'disability', 100000, NULL, 8, 0, 0, false, '2023-11-14 00:00:00', 'janeDoe', NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (2828010, 'disability', 100000, NULL, 8, 0, 0, false, '2023-11-17 08:00:00', 'janeDoe', NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (1324567, 'employment
', 7000, NULL, 5, 0, 0, true, '2023-11-17 15:00:00', 'janeDoe', NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (1237658, 'disability
', 200000, NULL, 8, 0, 100, false, '2023-11-16 00:00:00', 'janeDoe', NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (1234567, 'employment
', 7000, NULL, 5, 0, 0, false, '2023-11-17 15:00:00', 'janeDoe', NULL);


--
-- TOC entry 3455 (class 2606 OID 49305)
-- Name: claims claims_pkey; Type: CONSTRAINT; Schema: public; Owner: securian
--

ALTER TABLE ONLY public.claims
    ADD CONSTRAINT claims_pkey PRIMARY KEY (id);


-- Completed on 2023-11-29 19:44:01 EST

--
-- PostgreSQL database dump complete
--
