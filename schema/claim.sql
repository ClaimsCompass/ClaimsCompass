--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2023-12-06 19:23:46 EST

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

--
-- TOC entry 3596 (class 0 OID 73897)
-- Dependencies: 221
-- Data for Name: claims; Type: TABLE DATA; Schema: public; Owner: securian
--

INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (20000, 'Life', 18500, 'Life', 0, 0, 0, false, '2023-12-04 15:00:00', NULL, NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (22222, 'Disability', 100000, 'Disability CompletedDocuments:N AccurateDocuments:N', 0, 0, 0, false, '2023-12-04 15:00:00', NULL, NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (30000, 'Life', 16500, 'Disability', 0, 0, 0, false, '2023-12-04 15:00:00', NULL, NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (33333, 'Life', 80500, 'AccurateDocuments:N', 0, 0, 0, false, '2023-12-04 15:00:00', NULL, NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (40000, 'Life', 78500, 'Life', 0, 0, 0, false, '2023-12-04 15:00:00', NULL, NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (44444, 'Life', 80500, 'Life', 0, 0, 0, false, '2023-12-04 15:00:00', NULL, NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (55555, 'Unemployment', 100000, 'Unemployment CompletedDocuments:N', 0, 0, 0, false, '2023-12-04 15:00:00', NULL, NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (66666, 'Disability', 100000, 'Disability AccurateDocuments:N ', 0, 0, 0, false, '2023-12-04 15:00:00', NULL, NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (77777, 'Life', 90500, 'None', 0, 0, 0, false, '2023-12-04 15:00:00', NULL, NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (88888, 'Disability', 100000, 'Disability CompletedDocuments:N AccurateDocuments:N', 0, 0, 0, false, '2023-12-04 15:00:00', NULL, NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (99999, 'Unemployment', 100000, 'Disability CompletedDocuments:N AccurateDocuments:N', 0, 0, 0, false, '2023-12-04 15:00:00', NULL, NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (90000, 'Life', 14500, 'Life', 0, 0, 0, false, '2023-12-04 15:00:00', NULL, NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (80000, 'Life', 11500, 'Life', 0, 0, 0, false, '2023-12-04 15:00:00', NULL, NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (70000, 'Life', 90500, 'Life', 0, 0, 0, false, '2023-12-04 15:00:00', NULL, NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (60000, 'Unemployment', 68500, 'Unemployment CompletedDocuments:N', 0, 0, 0, false, '2023-12-04 15:00:00', NULL, NULL);
INSERT INTO public.claims (id, claim_type, claim_amt, claim_details, complexity_score, urgency_score, total_score, processed, creation_date_time, examiner, state) VALUES (50000, 'Disability', 78500, 'Disability', 0, 0, 0, false, '2023-12-04 15:00:00', NULL, NULL);


-- Completed on 2023-12-06 19:23:46 EST

--
-- PostgreSQL database dump complete
--

