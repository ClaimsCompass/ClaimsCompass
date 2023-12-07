--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2023-11-29 21:06:37 EST

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
-- TOC entry 215 (class 1259 OID 24587)
-- Name: claims_examiner; Type: TABLE; Schema: public; Owner: securian
--

CREATE TABLE public.claims_examiner (
    username character varying(255) NOT NULL,
    first_name character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    id bigint NOT NULL
);


ALTER TABLE public.claims_examiner OWNER TO securian;

--
-- TOC entry 216 (class 1259 OID 41107)
-- Name: claims_examiner_id_seq; Type: SEQUENCE; Schema: public; Owner: securian
--

CREATE SEQUENCE public.claims_examiner_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.claims_examiner_id_seq OWNER TO securian;

--
-- TOC entry 3607 (class 0 OID 0)
-- Dependencies: 216
-- Name: claims_examiner_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: securian
--

ALTER SEQUENCE public.claims_examiner_id_seq OWNED BY public.claims_examiner.id;


--
-- TOC entry 3454 (class 2604 OID 41108)
-- Name: claims_examiner id; Type: DEFAULT; Schema: public; Owner: securian
--

ALTER TABLE ONLY public.claims_examiner ALTER COLUMN id SET DEFAULT nextval('public.claims_examiner_id_seq'::regclass);


--
-- TOC entry 3600 (class 0 OID 24587)
-- Dependencies: 215
-- Data for Name: claims_examiner; Type: TABLE DATA; Schema: public; Owner: securian
--

INSERT INTO public.claims_examiner (username, first_name, password, id) VALUES ('janeDoe', 'Jane', 'Maison', 1);
INSERT INTO public.claims_examiner (username, first_name, password, id) VALUES ('bobDoe', 'Bob', 'Maison', 2);


--
-- TOC entry 3608 (class 0 OID 0)
-- Dependencies: 216
-- Name: claims_examiner_id_seq; Type: SEQUENCE SET; Schema: public; Owner: securian
--

SELECT pg_catalog.setval('public.claims_examiner_id_seq', 1, true);


--
-- TOC entry 3456 (class 2606 OID 24593)
-- Name: claims_examiner ClaimsExaminer_pkey; Type: CONSTRAINT; Schema: public; Owner: securian
--

ALTER TABLE ONLY public.claims_examiner
    ADD CONSTRAINT "ClaimsExaminer_pkey" PRIMARY KEY (username);


-- Completed on 2023-11-29 21:06:37 EST

--
-- PostgreSQL database dump complete
--

