# [REST] Kotlin e Spring Boot:
v1 - Camada Web Basic Rest template
v1.0.1 - Camada banco em memória

---
## LOCALHOST
### Build aplicação docker
Variavel de ambiente local
- `SPRING_PROFILES_ACTIVE=local`

Build e up do docker
- `sudo docker build -t projeto-rest .`

- Execute o container a partir da imagem construída com o comando "docker run" e mapeie a porta 8080 do container para a porta 8080
- `docker run -p 8080:8080 projeto-rest`