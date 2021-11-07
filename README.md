# Pessoa API

### API Rest para cadastrar e consultar Pessoas.

#### Tecnologias Utilizadas
- Spring Boot
- Spring Data JPA
- Swagger
- H2 Database
- Maven
- Java 11
- MySQL
- Mockit
- JUnit

## Instalação

- 1: Clone o repositório na sua máquina
- 2: Para rodar os testes funcionais execute o comando: mvn clean install
- 3: Para subir a aplicação execute o comando: mvn spring-boot:run
- 4: Acesse o swagger pela URL: http://localhost:8080/pessoa/api/swagger-ui.html#/


## EndPoints

- 1 - Salvar uma nova pessoa: v1/pessoa/salvar
```
{
  "cpf": "string",
  "dataNascimento": "string",
  "nomeCompleto": "string",
  "telefones": [
    {
      "id": 0,
      "numero": "string",
      "tipoTelefone": "Residencial"
    }
  ]
}
```
- 2 - v1/pessoa/consultar/{id}
- 3 - v1/pessoa/consultar

