--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 11.3

-- Started on 2019-10-11 10:44:44

SET client_encoding = 'UTF8';

--
-- TOC entry 2846 (class 0 OID 47622)
-- Dependencies: 209
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (id, create_at, email, full_name) VALUES (1, '2018-01-31 00:00:00', 'simple@example.com', 'Simple Writer');
INSERT INTO public.users (id, create_at, email, full_name) VALUES (2, '2018-02-09 00:00:00', 'very.common@example.com', 'Common Angel');
INSERT INTO public.users (id, create_at, email, full_name) VALUES (3, '2018-03-31 00:00:00', 'disposable.style.email.with+symbol@example.com', 'Re-cycle Activist');
INSERT INTO public.users (id, create_at, email, full_name) VALUES (4, '2018-01-31 00:00:00', 'other.email-with-hyphen@example.com', 'Hyphen Hyan');
INSERT INTO public.users (id, create_at, email, full_name) VALUES (5, '2018-01-31 00:00:00', 'fully-qualified-domain@example.com', 'Quality Assurance');


--
-- TOC entry 2854 (class 0 OID 0)
-- Dependencies: 210
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', SELECT MAX(id) FROM users);


-- Completed on 2019-10-11 10:44:44

--
-- PostgreSQL database dump complete
--

