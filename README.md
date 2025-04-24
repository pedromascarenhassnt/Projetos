# 🏦 Projeto Banco Digital (Versão Simples)

Este é um projeto simples de um **banco digital**, desenvolvido como prática de conceitos de backend e integração com banco de dados, utilizando **JavaScript** com **Spring Boot** na IDE **Eclipse**.

O sistema permite o **cadastro e gerenciamento de clientes**, **gerenciamento de contas**, **verificação de saldo**, entre outras funcionalidades bancárias básicas.

---

## 🚀 Funcionalidades

- Cadastro de novos clientes  
- Consulta e edição de dados de clientes  
- Abertura e gerenciamento de contas  
- Verificação de saldo  
- Operações básicas de conta  

---

## 💻 Tecnologias utilizadas

- **JavaScript**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database** (banco de dados em memória)
- **Postman** (para testar os endpoints)
- **IDE Eclipse**

---

## ⚙️ Como executar o projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/banco-digital-simples.git
Importe o projeto na IDE Eclipse com suporte a projetos Spring Boot.

Execute o projeto através da classe principal:

java
Sempre exibir os detalhes

Copiar
BancoDigitalApplication.java
Acesse o console do banco de dados H2:

bash
Sempre exibir os detalhes

Copiar
http://localhost:8080/h2-console
JDBC URL padrão: jdbc:h2:mem:testdb

User: sa

Password: (em branco)

Testar os endpoints usando Postman ou outra ferramenta de API:

Exemplo de endpoint: GET http://localhost:8080/clientes

🔧 Melhorias futuras
Implementação de autenticação com Spring Security

Validações mais robustas nos formulários

Adição de operações bancárias como saque, depósito e extrato

Integração com frontend (React, Angular ou outro)

Salvamento de dados em banco de dados relacional (MySQL ou PostgreSQL)

👨‍💻 Autor
Desenvolvido por Pedro Mascarenhas 
