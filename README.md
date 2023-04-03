# [REST] Kotlin e Spring Boot:
v1 - Camada Web Basic Rest template
v1.0.1 - Camada banco em memória

---
## LOCALHOST
Variavel de ambiente local
- `SPRING_PROFILES_ACTIVE=local`

### Execução local
- **Subir container docker**
- - `docker-compose up -d`

### Conexão postgres
- **Port:** 5450
- **User:** postgres
- **Pass:** postgres

### Build aplicação docker

Build e up do docker
- `sudo docker build -t projeto-rest .`

- Execute o container a partir da imagem construída com o comando "docker run" e mapeie a porta 8080 do container para a porta 8080
- `docker run -p 8080:8080 projeto-rest`

- Limpar a base de tudo
- - `docker system prune --volumes -f`
- limpar so seu volume
- - `docker volume ls`
- - `docker volume rm id_volume`