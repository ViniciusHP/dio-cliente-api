<h1 align="center">
  Clientes API com Padrões de Projeto
</h1>

<h4 align="center">Status: ✔ Concluído</h4>

---

<p align="center">
 <a href="#user-content-sobre-o-projeto">Sobre o projeto</a> |
 <a href="#user-content-adicionais">Adicionais</a> |
 <a href="#user-content-executando-o-projeto">Executando o projeto</a> |
 <a href="#user-content-tecnologias">Tecnologias</a>
</p>

---

## **Sobre o projeto**

API REST feita em Spring Boot para cadastro de clientes realizada durante o bootcamp [GFT Java & AWS Developer](https://digitalinnovation.one/bootcamps/gft-java-aws-developer?utm_source=https://digitalinnovation.one/bootcamps/gft-java-aws-developer%3Futm_source%3Dsm-organico-fb-ig-bc-java-serverless%2B-gft%26utm_medium%3Dorganic%26utm_campaign%3Dgft) com a [Digital Innovation One](https://digitalinnovation.one/) e o [Venilton FalvoJr](https://www.linkedin.com/in/falvojr/). [Link para o repositório original.](https://github.com/digitalinnovationone/lab-padroes-projeto-spring)

Neste projeto, foi explorado os padrões de projeto Singleton, Strategy/Repository e Facade, utilizando o Spring Framework. Também foi utilizada a API do ViaCEP para preencher os campos relacionados ao CEP.

## **Adicionais**

Nesta versão foi acrescentado:

- Bean Validation
- Evento para a inserção do header Location ao criar novo recurso
- Tratamento de exceção

## **Executando o projeto**

### Pré-requisitos

Antes de começar, é necessário você já tenha a ferramenta [Git](https://git-scm.com/) instalada.

### Instruções de execução do projeto
```bash
# Clone este repositório
$ git clone https://github.com/ViniciusHP/dio-cliente-api.git

# Acesse a pasta deste projeto por meio do terminal
$ cd dio-cliente-api

# Execute o projeto
$ ./mvnw spring-boot:run

# Para acessar a documentação da API, navegue para http://localhost:8080/swagger-ui.html
```

## **Tecnologias**

Este projeto foi construído com as seguintes ferramentas:

- **[Spring Boot](https://spring.io/projects/spring-boot)**
- **[Spring Cloud OpenFeign](https://spring.io/projects/spring-cloud-openfeign)**
- **[OpenAPI 3](https://springdoc.org/)**
- **[Lombok](https://projectlombok.org/)**