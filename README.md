# controle-financeiro-jiva (back-end)
Controle Financeiro Jiva

# *************** Instruções ******************

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

-- Mock Teste DAO -- 

Para os testes do DAO, não é necessário "subir"/executar a aplicação no Tomcat

-- Mock Teste Controller -- 
1 - Para os testes do controller, executar a aplicação no Tomcat 8.5 

2 - Executar os testes com o JUnit

Caso não existir os códigos abaixo, inserir para realizar os tesdes do controller

insert into lancamentos (descricao,vencimento,valor,tipo)
values(1,'Teste mock','2018-05-01',100.99,'R');
	
insert into lancamentos (descricao,vencimento,valor,tipo)
values(2,'Teste mock','2018-05-02',50.99,'D');

insert into lancamentos (descricao,vencimento,valor,tipo)
values(3,'Teste mock','2018-05-02',770.10,'D');

-- Deploy

1 git clone https://github.com/thiagohernandes/controle-financeiro-jiva.git

2 publicar no Tomcat 8.5 utilizando o Eclipse

