# outboxpattern



Setting the database in docker 

- docker pull postgres
-  docker run -p 5432:5432 -v /dados/postgresql:/var/lib/postgresql/data -e POSTGRES_PASSWORD=1234 -d --restart always postgres
- docker ps, para ver se o container está rodando com sucesso