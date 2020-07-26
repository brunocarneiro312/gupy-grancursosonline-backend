# Grancursos Online (POC)

Prova de conceito para a participação do processo seletivo do Grancursos Online.

### Problema
1 - Montar uma árvore de assuntos

 - Um assunto pode ter N assuntos como filhos. Um assunto filho pertencente a uma árvore não pode estar contida em outra. (OK)

2 - Criar uma entidade de Banca, Órgão e Questão (OK)

 - Uma questão possui um assunto, um órgão e uma banca vinculada. (OK)

3 - Criar uma página de programa de estudos onde o aluno irá selecionar um órgão e banca (OK)

 - Após criar o programa, deverá ser apresentado a árvore de assuntos para os filtros selecionados; 

 - Ao lado de cada assunto deverá ser apresentado a quantidade de questões. 





RN1: O assunto que não possuir pai, será o primeiro nó da árvore;

RN2: Criar mais de uma árvore de assuntos;

RN3: Preciso de muitas questões para poder gerar programas de estudos diversos.

## Atenção
#### Caso deseje, o sistema poderá ser acessado no ambiente da Amazon AWS
- Acesse o projeto hospedado em [http://poc-grancursos-online.s3-website-sa-east-1.amazonaws.com/#/](http://poc-grancursos-online.s3-website-sa-east-1.amazonaws.com/#/ "http://poc-grancursos-online.s3-website-sa-east-1.amazonaws.com/#/")

### Projeto

#### Tecnologias

- VueJS
- Bootstrap 4
- BootstrapVue
- Sass
- Popper.js
- NPM
- JQuery
- Java 8
- SpringBoot 2.x
- MySQL

### Configuração

#### Frontend
- Clone o projeto na sua máquina local `https://github.com/brunocarneiro312/gupy-grancursosonline-frontend.git`
- Importe para a IDE de sua preferência
- Execute o comando no terminal (mesmo diretório do arquivo package.json)
`npm install`
- Execute o comando
`npm run serve`
- Acesse a url `http://localhost:8080` (a porta não pode estar em uso)

#### Backend
- Clone o projeto na sua máquina local `https://github.com/brunocarneiro312/gupy-grancursosonline-backend.git`
- Importe para a IDE de sua escolha (Eclipse, IntelliJ, Netbeans...)
- Configure corretamente os parâmetros de conexão com a base, contida no arquivo `application.properties`
- Execute o comando `./mvnw spring-boot:run`
- A aplicação estará rodando na porta 5000 com o endereço `http://localhost:5000/grancursos`

#### Banco de dados
- Projeto poderá ser rodado com uma base de dados em memória (H2). Para isso, descomente a configuração do H2 no `application.properties` e comente a do MySQL
- É necessário a configuração de um banco de dados MySQL local para o armazenamento das informações de forma fixa.
- Certifique-se de que as configurações do banco de dados estão corretas no arquivo `application.properties` do projeto backend.

#### Após a execução dos passos acima
- Abra o navegador de sua preferência e navegue até `http://localhost:8080` para acessar a aplicação.

#### Screenshots
[![](https://i.ibb.co/z5678fv/evd1.png)](https://i.ibb.co/z5678fv/evd1.png)
[![](https://i.ibb.co/znxFGxM/evd2.png)](https://i.ibb.co/znxFGxM/evd2.png)
[![](https://i.ibb.co/qDgCdxL/evt3.png)](https://i.ibb.co/qDgCdxL/evt3.png)
[![](https://i.ibb.co/t3Nv8Jh/evd4.png)](https://i.ibb.co/t3Nv8Jh/evd4.png)
[![](https://ibb.co/QFqZqf7)](https://ibb.co/QFqZqf7)
