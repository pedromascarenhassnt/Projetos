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
   git clone https://github.com/pedromascarenhassnt/banco-digital-simples.git
Importe o projeto na IDE Eclipse com suporte a projetos Spring Boot.

Execute o projeto através da classe principal:

java
Copiar
Editar
BancoDigitalApplication.java
Acesse o console do banco de dados H2:

bash
Copiar
Editar
http://localhost:8080/h2-console
JDBC URL padrão: jdbc:h2:mem:testdb

User: sa

Password: (em branco)

Testar os endpoints usando Postman ou outra ferramenta de API:

Exemplo de endpoint: GET http://localhost:8080/h2-console

🔧 Coisas que ainda vão ser implementadas
Implementação de cartão e Seguro

Validações mais robustas nos formulários

Integração com frontend


👨‍💻 Criado por
Desenvolvido por Pedro Mascarenhas
