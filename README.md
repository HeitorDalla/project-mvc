# 📌 Ecommerce

Este projeto segue o padrão arquitetural **MVC (Model–View–Controller)** com foco em organização, modularidade e camadas bem definidas.  
O domínio envolve entidades como Usuário, Produto, Pedido e Carrinho, com persistência simples via DAO.

---

## 📂 Estrutura Completa do Projeto

```
project-mvc/
├── src/
│   └── main/
│       ├── java/
│       │   └── br/edu/unicesumar/
│       │       ├── dao/
│       │       │   ├── CarrinhoDAO.java
│       │       │   ├── CategoriaDAO.java
│       │       │   ├── DAO.java
│       │       │   ├── EnderecoDAO.java
│       │       │   ├── ItemCarrinhoDAO.java
│       │       │   ├── ItemPedidoDAO.java
│       │       │   ├── PedidoDAO.java
│       │       │   ├── ProdutoDAO.java
│       │       │   └── UsuarioDAO.java
│       │       │
│       │       ├── enumerate/
│       │       │   └── StatusPedido.java
│       │       │
│       │       └── model/
│       │           ├── Carrinho.java
│       │           ├── Categoria.java
│       │           ├── Endereco.java
│       │           ├── ItemCarrinho.java
│       │           ├── ItemPedido.java
│       │           ├── Pedido.java
│       │           ├── Produto.java
│       │           ├── Usuario.java
│       │           ├── FXMLController.java
│       │           └── MainApp.java
│       │
│       └── resources/
│           ├── fxml/
│           ├── META-INF/
│           └── styles/
│
└── target/
    ├── classes
    ├── modules
    └── test-classes
```

---

## 🧱 Arquitetura

| Camada | Pacote | Responsabilidade |
|--------|--------|-----------------|
| **Model** | `model` | Entidades e regras de domínio |
| **DAO** | `dao` | Persistência e CRUD |
| **Enum** | `enumerate` | Constantes e estados fixos |
| **Controller** | `FXMLController` | Comunicação View ↔ Model |
| **View** | `resources/fxml` | Interface visual JavaFX |

---

## ✅ Tecnologias Utilizadas

- Java 17+
- JavaFX
- Padrão MVC
- Padrão DAO
- Maven
- VS Code / IntelliJ / Eclipse

---

## ▶️ Como Executar

### 1️⃣ Compilar

```bash
mvn clean install
```

### 2️⃣ Executar a aplicação

```bash
mvn javafx:run
```

Ou iniciar manualmente a classe:

```
MainApp.java
```

---

## ✨ Funcionalidades Previstas

✔ Cadastro de produtos  
✔ Gerenciamento de usuários  
✔ Carrinho de compras  
✔ Pedidos com status através de Enum  

---

## 📌 Melhorias Futuras

- Criar pacote próprio para **controllers**
- Adicionar banco de dados real (JPA ou JDBC)
- Criar testes unitários com JUnit
- Gerar documentação com JavaDoc
- Designs e navegação aprimorados em FXML

---

## 👤 Autor

Desenvolvido por **Heitor**, para estudos avançados de Java, MVC e automação de persistência.

---

📌 *Este README pode ser expandido com imagens do sistema, fluxogramas e diagramas UML. Basta solicitar!* ✨
