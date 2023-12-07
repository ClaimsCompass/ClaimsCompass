--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2023-12-06 22:38:23 EST

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
-- TOC entry 3597 (class 0 OID 24587)
-- Dependencies: 215
-- Data for Name: claims_examiner; Type: TABLE DATA; Schema: public; Owner: securian
--

INSERT INTO public.claims_examiner (username, first_name, password, id) VALUES ('andrewXie', 'Andrew', 'Maison', 2);
INSERT INTO public.claims_examiner (username, first_name, password, id) VALUES ('maryamTaj', 'Maryam', 'Maison', 1);


--
-- TOC entry 3605 (class 0 OID 0)
-- Dependencies: 216
-- Name: claims_examiner_id_seq; Type: SEQUENCE SET; Schema: public; Owner: securian
--

SELECT pg_catalog.setval('public.claims_examiner_id_seq', 1, true);


-- Completed on 2023-12-06 22:38:23 EST

--
-- PostgreSQL database dump complete
--

