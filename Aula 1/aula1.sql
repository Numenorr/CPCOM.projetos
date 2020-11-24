--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-10-22 20:56:38

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
-- TOC entry 203 (class 1259 OID 25878)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    idcliente integer NOT NULL,
    nome character varying,
    email character varying,
    telefone character varying,
    "dtaAniversario" date
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 25876)
-- Name: cliente_idcliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_idcliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_idcliente_seq OWNER TO postgres;

--
-- TOC entry 2857 (class 0 OID 0)
-- Dependencies: 202
-- Name: cliente_idcliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cliente_idcliente_seq OWNED BY public.cliente.idcliente;


--
-- TOC entry 211 (class 1259 OID 25932)
-- Name: itens_venda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.itens_venda (
    idvenda integer NOT NULL,
    idlivro integer NOT NULL,
    quantidade integer
);


ALTER TABLE public.itens_venda OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 25930)
-- Name: itens_venda_idlivro_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.itens_venda_idlivro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.itens_venda_idlivro_seq OWNER TO postgres;

--
-- TOC entry 2858 (class 0 OID 0)
-- Dependencies: 210
-- Name: itens_venda_idlivro_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.itens_venda_idlivro_seq OWNED BY public.itens_venda.idlivro;


--
-- TOC entry 209 (class 1259 OID 25928)
-- Name: itens_venda_idvenda_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.itens_venda_idvenda_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.itens_venda_idvenda_seq OWNER TO postgres;

--
-- TOC entry 2859 (class 0 OID 0)
-- Dependencies: 209
-- Name: itens_venda_idvenda_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.itens_venda_idvenda_seq OWNED BY public.itens_venda.idvenda;


--
-- TOC entry 208 (class 1259 OID 25905)
-- Name: livro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.livro (
    idlivro integer NOT NULL,
    nomelivro character varying,
    autor character varying,
    "precoUnitario" double precision
);


ALTER TABLE public.livro OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 25903)
-- Name: livro_idlivro_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.livro_idlivro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.livro_idlivro_seq OWNER TO postgres;

--
-- TOC entry 2860 (class 0 OID 0)
-- Dependencies: 207
-- Name: livro_idlivro_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.livro_idlivro_seq OWNED BY public.livro.idlivro;


--
-- TOC entry 206 (class 1259 OID 25891)
-- Name: venda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.venda (
    idvenda integer NOT NULL,
    data date,
    valor double precision,
    idcliente integer NOT NULL
);


ALTER TABLE public.venda OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 25889)
-- Name: venda_idcliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.venda_idcliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.venda_idcliente_seq OWNER TO postgres;

--
-- TOC entry 2861 (class 0 OID 0)
-- Dependencies: 205
-- Name: venda_idcliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.venda_idcliente_seq OWNED BY public.venda.idcliente;


--
-- TOC entry 204 (class 1259 OID 25887)
-- Name: venda_idvenda_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.venda_idvenda_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.venda_idvenda_seq OWNER TO postgres;

--
-- TOC entry 2862 (class 0 OID 0)
-- Dependencies: 204
-- Name: venda_idvenda_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.venda_idvenda_seq OWNED BY public.venda.idvenda;


--
-- TOC entry 2711 (class 2604 OID 25881)
-- Name: cliente idcliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente ALTER COLUMN idcliente SET DEFAULT nextval('public.cliente_idcliente_seq'::regclass);


--
-- TOC entry 2715 (class 2604 OID 25935)
-- Name: itens_venda idvenda; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itens_venda ALTER COLUMN idvenda SET DEFAULT nextval('public.itens_venda_idvenda_seq'::regclass);


--
-- TOC entry 2716 (class 2604 OID 25936)
-- Name: itens_venda idlivro; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itens_venda ALTER COLUMN idlivro SET DEFAULT nextval('public.itens_venda_idlivro_seq'::regclass);


--
-- TOC entry 2714 (class 2604 OID 25908)
-- Name: livro idlivro; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro ALTER COLUMN idlivro SET DEFAULT nextval('public.livro_idlivro_seq'::regclass);


--
-- TOC entry 2712 (class 2604 OID 25894)
-- Name: venda idvenda; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda ALTER COLUMN idvenda SET DEFAULT nextval('public.venda_idvenda_seq'::regclass);


--
-- TOC entry 2713 (class 2604 OID 25895)
-- Name: venda idcliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda ALTER COLUMN idcliente SET DEFAULT nextval('public.venda_idcliente_seq'::regclass);


--
-- TOC entry 2718 (class 2606 OID 25886)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (idcliente);


--
-- TOC entry 2722 (class 2606 OID 25913)
-- Name: livro livro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro
    ADD CONSTRAINT livro_pkey PRIMARY KEY (idlivro);


--
-- TOC entry 2720 (class 2606 OID 25897)
-- Name: venda venda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_pkey PRIMARY KEY (idvenda);


--
-- TOC entry 2723 (class 2606 OID 25898)
-- Name: venda idcliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT idcliente FOREIGN KEY (idcliente) REFERENCES public.cliente(idcliente);


--
-- TOC entry 2725 (class 2606 OID 25942)
-- Name: itens_venda idlivro; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itens_venda
    ADD CONSTRAINT idlivro FOREIGN KEY (idlivro) REFERENCES public.livro(idlivro);


--
-- TOC entry 2724 (class 2606 OID 25937)
-- Name: itens_venda idvenda; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itens_venda
    ADD CONSTRAINT idvenda FOREIGN KEY (idvenda) REFERENCES public.venda(idvenda);


-- Completed on 2020-10-22 20:56:38

--
-- PostgreSQL database dump complete
--

