--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: client; Type: TABLE; Schema: public; Owner: Tessa; Tablespace: 
--

CREATE TABLE client (
    id integer NOT NULL,
    name character varying,
    stylist_id integer
);


ALTER TABLE client OWNER TO "Tessa";

--
-- Name: client_id_seq; Type: SEQUENCE; Schema: public; Owner: Tessa
--

CREATE SEQUENCE client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE client_id_seq OWNER TO "Tessa";

--
-- Name: client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Tessa
--

ALTER SEQUENCE client_id_seq OWNED BY client.id;


--
-- Name: stylist; Type: TABLE; Schema: public; Owner: Tessa; Tablespace: 
--

CREATE TABLE stylist (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE stylist OWNER TO "Tessa";

--
-- Name: stylist_id; Type: TABLE; Schema: public; Owner: Tessa; Tablespace: 
--

CREATE TABLE stylist_id (
    id integer NOT NULL
);


ALTER TABLE stylist_id OWNER TO "Tessa";

--
-- Name: stylist_id_id_seq; Type: SEQUENCE; Schema: public; Owner: Tessa
--

CREATE SEQUENCE stylist_id_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stylist_id_id_seq OWNER TO "Tessa";

--
-- Name: stylist_id_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Tessa
--

ALTER SEQUENCE stylist_id_id_seq OWNED BY stylist_id.id;


--
-- Name: stylist_id_seq; Type: SEQUENCE; Schema: public; Owner: Tessa
--

CREATE SEQUENCE stylist_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stylist_id_seq OWNER TO "Tessa";

--
-- Name: stylist_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Tessa
--

ALTER SEQUENCE stylist_id_seq OWNED BY stylist.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Tessa
--

ALTER TABLE ONLY client ALTER COLUMN id SET DEFAULT nextval('client_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Tessa
--

ALTER TABLE ONLY stylist ALTER COLUMN id SET DEFAULT nextval('stylist_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Tessa
--

ALTER TABLE ONLY stylist_id ALTER COLUMN id SET DEFAULT nextval('stylist_id_id_seq'::regclass);


--
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: Tessa
--

COPY client (id, name, stylist_id) FROM stdin;
1	teresa	1
5	Tessa	4
\.


--
-- Name: client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Tessa
--

SELECT pg_catalog.setval('client_id_seq', 5, true);


--
-- Data for Name: stylist; Type: TABLE DATA; Schema: public; Owner: Tessa
--

COPY stylist (id, name) FROM stdin;
1	marlon
2	teresa
3	elvis
4	pope francis
\.


--
-- Data for Name: stylist_id; Type: TABLE DATA; Schema: public; Owner: Tessa
--

COPY stylist_id (id) FROM stdin;
\.


--
-- Name: stylist_id_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Tessa
--

SELECT pg_catalog.setval('stylist_id_id_seq', 1, false);


--
-- Name: stylist_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Tessa
--

SELECT pg_catalog.setval('stylist_id_seq', 1, false);


--
-- Name: client_pkey; Type: CONSTRAINT; Schema: public; Owner: Tessa; Tablespace: 
--

ALTER TABLE ONLY client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


--
-- Name: stylist_id_pkey; Type: CONSTRAINT; Schema: public; Owner: Tessa; Tablespace: 
--

ALTER TABLE ONLY stylist_id
    ADD CONSTRAINT stylist_id_pkey PRIMARY KEY (id);


--
-- Name: stylist_pkey; Type: CONSTRAINT; Schema: public; Owner: Tessa; Tablespace: 
--

ALTER TABLE ONLY stylist
    ADD CONSTRAINT stylist_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: Tessa
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM "Tessa";
GRANT ALL ON SCHEMA public TO "Tessa";
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

