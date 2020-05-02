CREATE SEQUENCE public.usuario_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
    
/* ------------------------- */
    
CREATE TABLE public.tb_usuario (
    id bigint NOT NULL DEFAULT nextval('usuario_sequence'::regclass),
    nome character varying COLLATE pg_catalog."default" NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    idade bigint NOT NULL,
    iscasado boolean NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (id)
)