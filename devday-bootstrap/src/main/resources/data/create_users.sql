--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 11.3

-- Started on 2019-10-11 10:44:44

SET client_encoding = 'UTF8';

CREATE EXTENSION IF NOT EXISTS pgcrypto WITH SCHEMA public;

--
-- TOC entry 2846 (class 0 OID 47622)
-- Dependencies: 209
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (id, create_at, email, full_name, password, username) 
VALUES (1, '2018-01-31 00:00:00', 'simple@example.com', 'Simple Writer'
,encode(digest('simple', 'md5'), 'hex'),'simple');
INSERT INTO public.users (id, create_at, email, full_name, password, username) 
VALUES (2, '2018-02-09 00:00:00', 'very.common@example.com', 'Common Angel'
,encode(digest('simple', 'md5'), 'hex'),'angel');
INSERT INTO public.users (id, create_at, email, full_name, password, username) 
VALUES (3, '2018-03-31 00:00:00', 'disposable.style.email.with+symbol@example.com', 'Re-cycle Activist'
,encode(digest('simple', 'md5'), 'hex'),'activist');
INSERT INTO public.users (id, create_at, email, full_name, password, username) 
VALUES (4, '2018-01-31 00:00:00', 'other.email-with-hyphen@example.com', 'Hyphen Hyan'
,encode(digest('simple', 'md5'), 'hex'),'hyan');
INSERT INTO public.users (id, create_at, email, full_name, password, username) 
VALUES (5, '2018-01-31 00:00:00', 'fully-qualified-domain@example.com', 'Quality Assurance'
,encode(digest('simple', 'md5'), 'hex'),'qa');
--
-- TOC entry 2854 (class 0 OID 0)
-- Dependencies: 210
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', (SELECT MAX(id) FROM users));


-- Completed on 2019-10-11 10:44:44

--
-- PostgreSQL database dump complete
--

