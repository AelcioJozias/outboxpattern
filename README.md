<h1 align="center">
  OUTBOX PATTERN
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=8257E5&labelColor=000000" alt="Desafio" />
</p>

Projeto proposto pela empresa onde eu trabalho, que traz como desafio trabalhar com microserviçoes
usando o pattern outbox para garantir a integridade e confiabilidade 
dos dados quando usamos sistemas distribuidos 

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Postgres](https://www.postgresql.org/)
- [RabbitMQ](https://www.rabbitmq.com/)
- [Sprig Scheduling Tasks](https://spring.io/guides/gs/scheduling-tasks)

## Práticas adotadas

- SOLID, CLEAN-CODE
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Geração automática do Swagger com a OpenAPI 3

## Como Executar

- Clonar repositório git
- Na pasta docker executar o comando docker-compose up -d, que vai levantar os containers necessários para a aplicação (postgres,rabitmq)
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## No Swagger
Abra o swagger como o indicado acima e execute a requisicao que já está documentada e com exemplo construido


```
