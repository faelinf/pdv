

## PDV

 - Descrição:
          
          Sistema de ERP web desenvolvido em Java com Spring Framework
 - Objetivo:
   
	      Esse sistema tem como principal objetivo obter o contato e a
	   interação direta com o cliente final. Para que o lojista consiga
	   realizar a operação correta de suas vendas, além de comercializar em
	   conformidade com a legislação.

## Funcionalidade contidas no sistema

 - Abaixo listamos as funcionalidades que o sistema terá, são elas:

    - Cadastro produtos/clientes/fornecedor
     - Controle de estoque
	- Gerenciar comandas
	- Realizar venda
	- Controle de fluxo de caixa
	- Controle de pagar e receber
	- Venda com cartões
	- Gerenciar permissões de usuários por grupos
	- Cadastrar novas formas de pagamentos
	- Relatórios

## Como instalar?

-  Para instalar o sistema, você deve seguir os seguintes passos:

> 1 - Criar o banco de dado “pdv” no mysql;

> 2 - Configurar o arquivo application.properties com os dados do seu usuário root do mysql;

> 3 - Rodar o projeto pelo Eclipse ou gerar o jar do mesmo e execultar.

## Como logar no sistema?

- Para efetuar o login no sistema, pode-se utilizar as seguintes
 credenciais:

   > *Usuário: “gerente” e a senha “123”.*

## Tecnologias utilizadas

- Java SDK 8
- Spring Framework 5
- Thymeleaf 3
- MySQL
- Hibernate
- FlyWay

## Tutorial para Construir/Buildar o sistema

- É necessário:

**Construir/Buildar a aplicação usando o maven:**

> mvn clean package

**Construir/Buildar a aplicação usando o maven sem usar os testes**

> mvn clean package -DskipTests

**Executar aplicação**

## Tutorial para Executar o sistema

**Abaixo são as formas para execução:**
- Usando o perfil de ‘dev’ com o banco de dados h2 (Um banco de dados em memória)

- Todos os testes são executados com esse perfil
	>     java -Dspring.profiles.active=dev -jar ./pdv-0.0.1-SNAPSHOT.war

- Usando o perfil de ‘mysql’ com o banco de dados MySQL é necessário
passar as variáveis de conexão que são:

	-     PDV_DB_HOST => Endereço do hosto do banco
	-     PDV_DB_DATABASE => Nome do database/schema
	-     PDV_DB_USER => usuário do banco
	-     PDV_DB_PASS => senha do banco
	
	
**Existem duas formas de configurar essas variáveis**

- 1 - Configurando como variáveis de ambiente do Sistema operacional

	-  Caso escolha essa opção, após configurar nas variáveis de ambiente usar o comando:
		 >  java -Dspring.profiles.active=mysql -jar ./pdv-0.0.1-SNAPSHOT.war
-  2 - Passar essas variáveis na inicialização da aplicação

	  - Caso escolha essa opção, após configurar nas variáveis de ambiente usar o comando:
		>java -Dspring.profiles.active=mysql -DPDV_DB_HOST= -		  DPDV_DB_DATABASE= -DPDV_DB_USER= -DPDV_DB_PASS= -jar ./pdv-0.0.1-SNAPSHOT.war

## Validação

- Para checar versão do java:

	>		 java -version

- Para checar versão do maven

	>		mvn -version

## Frontend

 -    No Frontend utilizaremos:
	  >Bootstrap v3.3.7;
      >jQuery v3.2.1;
 -   Para gerar relatórios utilizaremos:

      >jasperreports 6.5.1
