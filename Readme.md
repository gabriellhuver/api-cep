
# CEP-API

   O objetivo do teste é criar uma aplicação API Rest em Java de consulta de CEP.

# Técnologias utilizadas
	- Java 11
	- Spring Boot
	- Hibernate
	- PostgreSQL

# Instalação e requisitos
## Requisitos
	
[Docker](https://www.docker.com/) 

## Docker
```shell
    $ docker-compose --up
```

## Rotas
### Cep - Obter um único CEP
	Tipo: GET
	Url: {contexto}/cep/{cep}
	Exemplo: http://localhost:8080/cep/01001000
Caso o CEP não exista, consultar o site http://viacep.com.br/ e realizar o cadastro do cep e da cidade.
#### Retorno
```json
{"cep": "01001-000",
"logradouro": "Praça da Sé",
"complemento": "lado ímpar",
"bairro": "Sé”,
"cidade":{
"ibge":"3550308",
"uf": "SP",
"localidade": "São Paulo"
}}
```
### Cep - Obter a lista de CEPs de uma cidade.
	Tipo: GET
	Url: {contexto}/ceps
	Parâmetros: ibge (obrigatório) e uf
	Exemplo: http://localhost:8080/ceps?ibge=3550308&uf=SP
	
#### Retorno
```json

```