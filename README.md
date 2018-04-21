# controle-financeiro-jiva (back-end)
Controle Financeiro Jiva
#Instruções

-- Instruções de Banco de Dados --

-- 1 - Registrar uma conexão no PostgreSQL (versão 10)  com o nome do banco: "jiva-financeiro-db"
-- 2 - Executar o script abaixo da entidade/tabela que armazenará os dados do financeiro (despesas/receitas)

CREATE TABLE public.lancamentos (
	id serial NOT NULL,
	descricao varchar(200) NOT NULL,
	vencimento date NOT NULL,
	valor numeric(10,2) NOT NULL,
	tipo varchar(1) NOT NULL,
	CONSTRAINT lancamentos_pk PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;

