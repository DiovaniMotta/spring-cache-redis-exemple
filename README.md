# Projeto Spring Data com PostgreSQL 14, Spring Cache e Redis

Este projeto é uma API Spring Boot que utiliza **Spring Data** para interagir com um banco de dados PostgreSQL 14, além de implementar **Spring Cache** com **Redis** como provedor de cache. Ele também inclui instruções para instalação do Redis Insight no Windows para monitoramento e análise do Redis.

---

## **Funcionalidades**
- Gerenciamento de entidades com **Spring Data JPA**.
- Armazenamento em banco de dados relacional **PostgreSQL 14**.
- Cache de dados utilizando **Spring Cache** e **Redis**.
- Suporte a consultas paginadas e metadados em cache.

---

## **Tecnologias Utilizadas**
- **Java 11**
- **Spring Boot 2.x**
    - Spring Data JPA
    - Spring Cache
    - Spring Web
- **PostgreSQL 14**
- **Redis**
- **Redis Insight**

---

## **Pré-requisitos**

1. **Java 11 ou superior**
2. **Maven** (para construção do projeto)
3. **PostgreSQL 14** instalado e configurado
4. **Redis** instalado e em execução
5. **Redis Insight** (opcional para monitoramento do Redis)

---

## **Configuração do Ambiente**

### **1. Banco de Dados PostgreSQL**

- Crie o banco de dados necessário para o projeto:
  ```sql
  CREATE DATABASE nome_do_banco;
  ```
- Configure as credenciais no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name?currentSchema=schema_name
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### **2. Redis**

#### **Instalação no Windows**
1. Seguir as orientações para instalação em ambiente Windows na [documentação do Redis](https://redis.io/docs/latest/operate/oss_and_stack/install/install-redis/install-redis-on-windows/).
2. Após a instalação, inicie o servidor Redis:

```shell
  sudo service redis-server start
```

#### **Configuração do Redis no projeto**
Adicione as configurações no `application.properties`:

```properties
spring.redis.host=localhost
spring.redis.port=6379
spring.redis.password=
spring.redis.database=0
```

### **3. Redis Insight**

#### **Instalação do Redis Insight no Windows**
1. Baixe o instalador do Redis Insight a partir do [site oficial](https://redis.com/redis-enterprise/redis-insight/).
2. Execute o instalador e siga as instruções para completar a instalação.
3. Abra o Redis Insight e adicione uma nova conexão:
    - Host: `localhost`
    - Porta: `6379`
4. Conecte-se ao Redis e comece a monitorar suas operações de cache.

---

## **Execução do Projeto**

1. Clone o repositório:
   ```bash
   git clone https://github.com/DiovaniMotta/spring-cache-redis-exemple.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd spring-cache-redis-exemple
   ```

3. Compile e execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

4. A API estará disponível em: `http://localhost:8080`

---

## **Endpoints Disponíveis**

### **Exemplo de Endpoints**
1. **Listar Objetos Paginados:**
    - **GET** `/api/objects/elements/{page}`
2. **Listar Nomes Paginados:**
    - **GET** `/api/objects/names/{page}`
3. **Listar IDs e Nomes:**
    - **GET** `/api/objects/basic/{page}`

---

## **Monitoramento do Cache com Redis Insight**
1. Abra o Redis Insight e selecione a conexão configurada.
2. Acompanhe as chaves criadas para os caches, por exemplo:
    - `objects_S3_elements`
    - `objects_S3_names`
    - `objects_S3_id_names`
3. Verifique o tempo de vida (TTL) e os valores armazenados diretamente no painel.

---

## **Contribuição**
Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

1. Faça um fork do repositório.
2. Crie uma branch para suas alterações:
   ```bash
   git checkout -b minha-feature
   ```
3. Faça commit das suas alterações:
   ```bash
   git commit -m "Minha nova feature"
   ```
4. Envie suas alterações:
   ```bash
   git push origin minha-feature
   ```
5. Abra um pull request.

---

## **Licença**
Este projeto está sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.

