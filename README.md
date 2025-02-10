# oxefood_api-cleiton

Extensões app para o VSCode:

# Material Icon Theme
# Prettier - Code formatter
# ESLint
# Dotenv Official +Vault
# Open In Default Browser

_________________________________________________________________________________________
````````

# Dados no Back-Entregador_Categoria_Cliente_End.Cliente_Produto e etc.

entregador

{
"nome": "Cleiton Xavier",
"cpf": "786.974.760-20",
"rg": "1212123",
"dataNascimento": "12/02/1986",
"foneCelular": "(11) 11111.111\_",
"foneFixo": "(11) 1111.1111",
"qtdEntregasRealizadas": 10,
"valorFrete": 10.0,
"Rua": "osvaldo crux",
"Numero": "56",
"Bairro": "tamandare",
"Cidade": "Moreno",
"Cep": "54800-000",
"Uf": null,
"Complemento": "dddd",
"ativo": true
}

cliente

{
    "email": "cleitonxav25@gmail.com",
    "password": "123456",
    "nome": "Cleiton Xavier",
    "dataNascimento": "17/01/1986",
    "cpf": "625.343.930-81",
    "foneCelular": "(81) 98888.8888",
    "foneFixo": "(81) 1111.1111"
}

Endereço Cliente

{
"rua": "Rua x",
"numero": "25",
"bairro": "xyz",
"cep": "53.123.123",
"cidade": "z",
"estado": "zyz",
"complemento": "xy 21"
}

Produto

{
"codigo": "ABC123",
"titulo": "Produto ABC",
"descricao": "Este é um produto de exemplo",
"valorUnitario": 59.99,
"tempoEntregaMinimo": 3,
"tempoEntregaMaximo": 7
}

Categoria

{
"idCategoria": 3,
"codigo": "Sdf548",
"titulo": "Coxinha",
"descricao": "Coxinhas",
"valorUnitario": 5,
"tempoEntregaMinimo": 3,
"tempoEntregaMaximo": 7
}

Funcionario

{
"tipo": "Administrador",
"email": "funcionario@gmail.com",
"password": "123456",
"nome": "Cleiton"
}

_________________________________________________________________________________________
````````

# FAZENDO O DEPLOY DO PROJETO BACK-END NO SERVIDOR

Pré-requisitos para o ambiente:
Instalar o JDK 17
Instalar o Git
Instalar o Docker / Docker-compose

Para rodar o projeto siga os passos abaixo  e execute os comandos:
1) Baixe o projeto do repositório git, exemplo:
    git clone https://github.com/robertoalencar/oxefood-api.git

2) Entre na pasta do projeto e execute o comando abaixo para levantar o banco de dados:
    docker-compose up -d

3) Ainda na pasta do projeto, execute o comando abaixo para rodar o projeto:
    ./mvnw spring-boot:run
_______________________________________________________________________________________________________
```

# FAZENDO O DEPLOY DO PROJETO FRONT-END NO SERVIDOR

Pré-requisitos para o ambiente:
Instalar o NodeJS
Instalar o Git

Para rodar o projeto siga os passos abaixo e execute os comandos:

1. Baixe o projeto do repositório git, exemplo:
   git clone https://github.com/robertoalencar/oxefood-web.git

2. Entre na pasta do projeto e execute o comando abaixo para rodar o projeto:
   npm start

_________________________________________________________________________________________
````````

# ATERAÇÃO DO .ENV NO DOCKER-COMPOSE

version: "3"
services:
  db:
     image: postgres:9.6
     restart: always
     environment:
       POSTGRES_PASSWORD: ${PASS_DB}
       POSTGRES_DB: ${NAME_DB}

     ports:
      -${PORT_DB}:5432
     volumes:
       - ./postgres-data:/bitnami/postgresql/data

________________________________________________________________
```

ATERAÇÃO DO .ENV APPLICATION.PROPERTIES

# Datasource ( levantando a aplicação sem container )

spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://${HOST_DB}:${PORT_DB}/${NAME_DB}
spring.datasource.username=postgres
spring.datasource.password=${PASS_DB}

# Dados para envios de email

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=${EMAIL_USER}
spring.mail.password=${EMAIL_PASSWORD}
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

security.jwt.secret-key=3cfa76ef14937c1c0ea519f8fc057a80fcd04a7420f8e8bcd0a7567c272e007b
# 1h in millisecond
security.jwt.expiration-time=3600000

springdoc.api-docs.path=/api-docs

---

```
ATERAÇÃO DO .ENV NO GITIGNORE

### VS Code ###
.vscode/
.env

_________________________________________________________________________________________
````````

# ANOTACAO SPRING VALIDATION

Claro! Aqui está uma lista abrangente das anotações de validação padrão disponíveis na Bean Validation (JSR-380), que são usadas frequentemente em projetos Spring:

### **Anotações de Validação**

1. **@AssertFalse**

   - Garante que o valor seja `false`.

   ```java
   @AssertFalse(message = "O valor deve ser falso")
   private boolean flag;
   ```

2. **@AssertTrue**

   - Garante que o valor seja `true`.

   ```java
   @AssertTrue(message = "O valor deve ser verdadeiro")
   private boolean ativo;
   ```

3. **@DecimalMax**

   - Define o valor máximo permitido para números decimais.

   ```java
   @DecimalMax(value = "100.00", message = "O valor deve ser no máximo 100.00")
   private BigDecimal valor;
   ```

4. **@DecimalMin**

   - Define o valor mínimo permitido para números decimais.

   ```java
   @DecimalMin(value = "1.00", message = "O valor deve ser no mínimo 1.00")
   private BigDecimal valor;
   ```

5. **@Digits**

   - Define o número máximo de dígitos e casas decimais.

   ```java
   @Digits(integer = 5, fraction = 2, message = "O valor deve ter no máximo 5 dígitos e 2 casas decimais")
   private BigDecimal valor;
   ```

6. **@Email**

   - Valida se o valor é um endereço de e-mail válido.

   ```java
   @Email(message = "O endereço de e-mail deve ser válido")
   private String email;
   ```

7. **@Future**

   - Valida se a data é no futuro.

   ```java
   @Future(message = "A data deve estar no futuro")
   private LocalDate dataDeViagem;
   ```

8. **@FutureOrPresent**

   - Valida se a data é no futuro ou no presente.

   ```java
   @FutureOrPresent(message = "A data deve ser no futuro ou no presente")
   private LocalDate data;
   ```

9. **@Max**

   - Define o valor máximo permitido para números.

   ```java
   @Max(value = 100, message = "O valor deve ser no máximo 100")
   private int idade;
   ```

10. **@Min**

    - Define o valor mínimo permitido para números.

    ```java
    @Min(value = 1, message = "O valor deve ser no mínimo 1")
    private int idade;
    ```

11. **@NotBlank**

    - Garante que a string não seja nula e não seja composta apenas por espaços em branco.

    ```java
    @NotBlank(message = "O campo não pode estar em branco")
    private String descricao;
    ```

12. **@NotEmpty**

    - Garante que a string não seja nula e não esteja vazia.

    ```java
    @NotEmpty(message = "O campo não pode estar vazio")
    private String nome;
    ```

13. **@NotNull**

    - Garante que o valor não seja `null`.

    ```java
    @NotNull(message = "O campo não pode ser nulo")
    private String nome;
    ```

14. **@Null**

    - Garante que o valor seja `null`.

    ```java
    @Null(message = "O campo deve ser nulo")
    private String nome;
    ```

15. **@Past**

    - Valida se a data é no passado.

    ```java
    @Past(message = "A data deve estar no passado")
    private LocalDate dataDeNascimento;
    ```

16. **@PastOrPresent**

    - Valida se a data é no passado ou no presente.

    ```java
    @PastOrPresent(message = "A data deve ser no passado ou no presente")
    private LocalDate data;
    ```

17. **@Pattern**

    - Valida a string com base em uma expressão regular.

    ```java
    @Pattern(regexp = "^81", message = "O valor deve começar com '81'")
    private String codigo;
    ```

18. **@Size**

    - Define o tamanho mínimo e máximo para strings e coleções.

    ```java
    @Size(min = 2, max = 50, message = "O tamanho deve estar entre 2 e 50 caracteres")
    private String nome;
    ```

19. **@Positive**

    - Garante que o número seja positivo.

    ```java
    @Positive(message = "O valor deve ser positivo")
    private int quantidade;
    ```

20. **@PositiveOrZero**

    - Garante que o número seja positivo ou zero.

    ```java
    @PositiveOrZero(message = "O valor deve ser positivo ou zero")
    private int quantidade;
    ```

21. **@Negative**

    - Garante que o número seja negativo.

    ```java
    @Negative(message = "O valor deve ser negativo")
    private int quantidade;
    ```

22. **@NegativeOrZero**

    - Garante que o número seja negativo ou zero.

    ```java
    @NegativeOrZero(message = "O valor deve ser negativo ou zero")
    private int quantidade;
    ```

23. **@Valid**

    - Valida objetos aninhados.

    ```java
    @Valid
    private Endereco endereco;
    ```

24. **@CreditCardNumber**
    - Valida se o valor é um número de cartão de crédito válido.
    ```java
    @CreditCardNumber(message = "O número do cartão de crédito deve ser válido")
    private String numeroCartao;
    ```

_________________________________________________________________________________________
````````
# Anotações mais comuns do Spring Validation: No back-end: Entrada das Requisições - C20

@NotNull -> Válida se o campo está nulo.

@NotEmpty -> Válida se o campo está vazio.

@NotBlank -> Válida se o campo está nulo ou vazio.

@Past -> Válida se a data é hoje ou qualquer dia antes de hoje.

@Future -> Válida se a data é hoje ou qualquer dia depois de hoje.

@Length -> Válida o tamanho mínimo e máximo de um campo.

@Max -> Válida o tamanho máximo de um campo.

@Min -> Valida o tamanho mínimo de um campo.

@Email -> Verifica se o campo possui as características de um endereço de e-mail.

Há várias anotações que vieram para poder facilitar a nossa vida, como, por exemplo, @Cpf.
@Cpf -> Verifica se o campo possui as características de um CPF valido.

### Observações

- As mensagens de erro personalizadas (`message`) são opcionalmente usadas para fornecer feedback mais claro ao usuário.
- Para usar essas anotações, você deve ter a dependência Bean Validation (javax.validation ou jakarta.validation) em seu projeto.

Essas anotações ajudam a garantir que os dados sejam consistentes e válidos antes de serem processados ou armazenados em um banco de dados.

_________________________________________________________________________________________
````````

# ANOTAÇÃO @COLUMN EM JPA

Claro! A anotação `@Column` em JPA é bastante versátil e pode ser configurada com diferentes atributos para atender às necessidades específicas de seu modelo de dados. Aqui está uma lista com os atributos mais usados da anotação `@Column` e suas descrições:

1. **`nullable`**:
   - **Descrição**: Define se a coluna pode aceitar valores nulos.
   - **Exemplo**: `@Column(nullable = false)` (A coluna não pode ter valores nulos.)


2. **`length`**:
   - **Descrição**: Define o comprimento máximo da coluna, aplicável principalmente a tipos de dados `String`.
   - **Exemplo**: `@Column(length = 255)` (A coluna pode ter até 255 caracteres.)


3. **`precision`**:
   - **Descrição**: Define a precisão total para tipos de dados numéricos, como `BigDecimal`. Representa o número total de dígitos.
   - **Exemplo**: `@Column(precision = 10)` (Define a precisão total para a coluna.)


4. **`scale`**:
   - **Descrição**: Define a escala para tipos de dados numéricos, como `BigDecimal`. Representa o número de dígitos à direita do ponto decimal.
   - **Exemplo**: `@Column(precision = 10, scale = 2)` (Define a precisão total e o número de dígitos após o ponto decimal.)


5. **`unique`**:
   - **Descrição**: Define se os valores na coluna devem ser únicos. Cria uma restrição de unicidade na coluna.
   - **Exemplo**: `@Column(unique = true)` (A coluna deve ter valores únicos.)


6. **`insertable`**:
   - **Descrição**: Define se a coluna deve ser incluída nas instruções de inserção geradas automaticamente.
   - **Exemplo**: `@Column(insertable = false)` (A coluna não será incluída nas instruções de inserção.)


7. **`updatable`**:
   - **Descrição**: Define se a coluna pode ser atualizada.
   - **Exemplo**: `@Column(updatable = false)` (A coluna não pode ser atualizada após a inserção.)


8. **`name`**:
   - **Descrição**: Define o nome da coluna no banco de dados.
   - **Exemplo**: `@Column(name = "nome_cliente")` (A coluna será chamada `nome_cliente` no banco de dados.)


9. **`columnDefinition`**:
   - **Descrição**: Define uma definição SQL personalizada para a coluna. Pode ser usado para especificar o tipo de dados exato ou outras características.
   - **Exemplo**: `@Column(columnDefinition = "TEXT")` (A coluna será do tipo `TEXT` no banco de dados.)


10. **`table`**:
    - **Descrição**: Define a tabela que a coluna pertence, usado em contextos específicos, como em mapeamentos complexos.
    - **Exemplo**: `@Column(table = "outra_tabela")` (A coluna é associada a uma tabela específica, quando necessário.)


Aqui está como você poderia usar esses atributos em uma classe de entidade:

```java
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class ExemploEntidade {

    @Id
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String nome;

    @Column(precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(insertable = false, updatable = false)
    private String status;

    @Column(name = "data_criacao", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataCriacao;


    @Column(nullable = false, length = 11, unique = true)
    private String cpf; // CPF é geralmente armazenado como uma string com 11 caracteres

    @Column(nullable = true, length = 15)
    private String telefone; // Telefone pode variar em formato, então 15 é um tamanho razoável


    // Getters e setters
    // ...
}
```

Neste exemplo, cada atributo da anotação `@Column` é utilizado para definir características específicas das colunas da tabela no banco de dados.

_________________________________________________________________________________________
````````

PERGUNTAS TÍPICAS C/RESPOSTAS

No contexto de Controle de Acesso, qual a diferença entre autenticação, autorização e auditoria?

R = 1. Autenticação (Quem é você?) A autenticação é o processo de verificar a identidade do usuário. O sistema precisa confirmar que a pessoa que está tentando acessar é realmente quem diz ser.

2. Autorização (O que você pode fazer?)
   A autorização ocorre depois da autenticação e define os privilégios de acesso do usuário. Mesmo que um usuário seja autenticado, ele pode não ter permissão para acessar determinados recursos.

\*Exemplos de autorização:
Um administrador pode acessar e modificar dados, enquanto um usuário comum só pode visualizar.

3. Auditoria (O que foi feito?)
   A auditoria registra e monitora todas as ações realizadas no sistema para garantir segurança e conformidade. Isso ajuda a rastrear quem fez o quê e quando.

- Exemplos de auditoria:
  Registro de tentativas de login (bem-sucedidas ou falhas).
  Histórico de alterações de dados sensíveis (exemplo: alteração de senha, mudanças em permissões de usuários).
  Conceito Pergunta O que faz?
  Autenticação Quem é você? Verifica a identidade do usuário.
  Autorização O que você pode fazer? Define permissões de acesso.
  Auditoria O que foi feito? Registra ações para análise e segurança.

_________________________________________________________________________________________
````````
PARA QUE SERVE ESTE ARQUIVO.ENV? QUAL A VANTAGEM/IMPORTÂNCIA DELE?

R=a) .env é usado para armazenar variáveis de ambiente de forma segura e organizada. Ele é comumente utilizado em aplicações para configurar credenciais sensíveis, URLs de serviços, chaves de API e outras configurações que podem variar entre diferentes ambientes (desenvolvimento, teste, produção).

* Principais Usos do .env
1️ Configurar informações sensíveis (ex: senhas, chaves de API, tokens).
2️ Separar configurações do código-fonte, tornando o projeto mais seguro e flexível.
3️ Facilitar a portabilidade da aplicação entre diferentes ambientes (local, homologação, produção).
_________________________________________________________________________________________
````````
b) No arquivo (application.properties) onde foi definido as configurações do projeto, escreva abaixo a linha em que informamos ao spring que o projeto poderá utilizar (ou não) um arquivo .env:
R=  spring.datasource.url=jdbc:postgresql://localhost:5434/oxefood
    spring.datasource.username=postgres
    spring.datasource.password=oxefood

# Datasource ( levantando a aplicação sem container )
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://${HOST_DB}:${PORT_DB}/${NAME_DB}
spring.datasource.username=postgres
spring.datasource.password=${PASS_DB}
_________________________________________________________________________________________
````````
caso ocorra um erro e seja levantado alguma exceção na linha 9, os objetos inseridos nas linhas 4 e 7 serão gravados no banco de dados, pois os comandos são executados antes da linha 9.”
A AFIRMAÇÃO ACIMA É VERDADEIRA? JUSTIFIQUE SUA RESPOSTA.

R = A afirmação está incorreta!
pois a anotação @Transactional na linha 1 garante que todos os comandos dentro do método fazem parte de uma única transação.
Se ocorrer um erro na linha 9 (emailService.enviarEmailConfirmacaoCadastroCliente(clienteSalvo);), a transação será abortada e todas as operações anteriores serão revertidas (rollback), impedindo que os objetos das linhas 4 e 7 sejam gravados no banco de dados.

1 @Transactional
2 public Cliente save(Cliente cliente) {
3
4 usuarioService.save(cliente.getUsuario());
5
6 super.preencherCamposAuditoria(cliente);
7 Cliente clienteSalvo = repository.save(cliente);
8
9 emailService.enviarEmailConfirmacaoCadastroCliente(clienteSalvo);
10
11 return clienteSalvo;
12 }
_________________________________________________________________________________________
```
"Após criada esta interface (ClienteRepository), já é possível ter acesso a métodos para consultar um cliente por id, consultar todos os clientes, incluir, alterar e remover um cliente no banco de dados.”

A AFIRMAÇÃO ACIMA É VERDADEIRA? JUSTIFIQUE SUA RESPOSTA.

R= A afirmação está correta!
Ao estender JpaRepository<Cliente, Long>, a interface ClienteRepository herda automaticamente vários métodos para manipulação de dados no banco, sem necessidade de implementação manual.
# Sim, ao criar ClienteRepository, já temos acesso aos métodos padrão para manipular clientes no banco.
  JpaRepository<Cliente, Long> → Fornece métodos básicos de CRUD (Create, Read, Update, Delete).

1 package br.com.ifpe.oxefood.modelo.cliente;
2
3 import org.springframework.data.jpa.repository.JpaRepository;
4 import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
5
6 public interface ClienteRepository extends JpaRepository<Cliente, Long>,JpaSpecificationExecutor<Cliente> {
7
8
9 }
_________________________________________________________________________________________
```

8.  Considerando a classe abaixo:

1 public class CategoriaProduto extends EntidadeAuditavel {
2
3 @NotNull
4 @Column(nullable = false, length = 100)
5 private String descricao;
6
7 }
a) O código abaixo funciona? Se não funcionar, explique o porquê.

1 public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {
2
3 List<CategoriaProduto> findByChaveEmpresaOrderByNome(String chaveEmpresa);
4
5 }
R= O código não funciona e resultará em erro.
Motivo do erro
Na interface CategoriaProdutoRepository, há um método customizado:
° findByChaveEmpresa → Está tentando buscar por um atributo chaveEmpresa, mas ele não existe na classe CategoriaProduto.
° OrderByNome → Está tentando ordenar pelo campo nome, que também não existe.

b) O código abaixo funciona? Se não funcionar, explique o porquê.

1 public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {
2
3 List<CategoriaProduto> findByChaveEmpresaOrderByDescricao();
4
5 }
R= O código não funciona!
O erro está no método findByChaveEmpresaOrderByDescricao() da interface CategoriaProdutoRepository, pois não existe um atributo chamado chaveEmpresa na classe CategoriaProduto. Então o Spring lançará um erro de "Property 'chaveEmpresa' not found" ao tentar iniciar a aplicação.
_________________________________________________________________________________________
`````
09) Na aula de controle de acesso do projeto do front-end, implementamos um componente para restringir o acesso não autenticado às telas do sistema, posteriormente esse componente foi adicionado em cada definição <Route> no arquivo Rotas.js. Qual foi o componente criado e como ele foi utilizado no arquivo Rotas.js ?

R= No Exemplo abaixo foi ajustado o arquivo Rotas.jsx para que o path “/” direcione o usuário para a tela de Login e o path “/home” direcione o usuário para tela de Home:

import Home from './views/home/Home';
import FormLogin from './views/login/FormLogin';
...
<Routes>
        <Route path="/" element={ <FormLogin/> } />
        <Route path="/home" element={ <Home/> } />
_________________________________________________________________________________________
```

10. O que é uma API WEB considerada RESTful?

R= Uma API Web RESTful é uma interface de comunicação entre sistemas baseada nos princípios do REST (Representational State Transfer). Ela permite a troca de dados entre clientes (frontend, mobile, outras APIs, etc.) e servidores usando requisições HTTP.

1️⃣ Baseada em Recursos:
Os dados são representados como recursos, identificados por URLs.
Exemplo: /clientes/1 representa o cliente com ID 1.

2️⃣ Usa os Métodos HTTP de Forma Semântica:
GET → Buscar um recurso (ex: GET /clientes/1)
POST → Criar um novo recurso (ex: POST /clientes)
PUT → Atualizar um recurso existente (ex: PUT /clientes/1)
DELETE → Remover um recurso (ex: DELETE /clientes/1)

3️⃣ Comunicação via JSON ou XML:
JSON é o formato mais comum para troca de dados.
json
Copiar
Editar
{
"id": 1,
"nome": "João Silva",
"email": "joao@email.com"
}

4️⃣ Stateless (Sem Estado):
Cada requisição é independente, ou seja, o servidor não armazena o estado do cliente.
Isso melhora a escalabilidade e torna a API mais eficiente.

5️⃣ Uso de Códigos de Status HTTP:
200 OK → Requisição bem-sucedida
201 Created → Recurso criado com sucesso
400 Bad Request → Erro na requisição do cliente
404 Not Found → Recurso não encontrado
500 Internal Server Error → Erro no servidor

_________________________________________________________________________________________
```
** http://localhost:8081/swagger-ui/index.html **


PASTA ACESSO: # API AuthenticationController

@Tag(
    name = "API AuthenticationController",
    description = "API responsável pelos serviços da AuthenticationController no sistema"
)
@Operation(
        summary = "Serviço é responsável por definir um endpoint HTTP POST que permite criar uma nova AuthenticationController.",
        description = "Ele será documentado como uma operação para cadastrar uma nova AuthenticationController enviando os dados necessários no corpo da requisição."
    ) 

________
```
# API FuncionarioController
API responsável pelos serviços de FuncionarioController no sistema


GET
/api/funcionario/{id}
Serviço é responsável por criar um endpoint na API que permite buscar ou consultar um FuncionarioController com base no seu identificador (id).

PUT
/api/funcionario/{id}
Serviço é responsável por atualizar os dados de um FuncionarioController existente com base no seu identificador (id).

DELETE
/api/funcionario/{id}
Serviço é responsável por expor um endpoint HTTP DELETE que permite a exclusão de um FuncionarioController com base no seu identificador (id).

GET
/api/funcionario
Serviço responsável por buscar informações da API FuncionarioController, como listar recursos ou obter detalhes específicos .

POST
/api/funcionario
Serviço é responsável por definir um endpoint HTTP POST que permite criar um novo FuncionarioController.

________
```

# API Venda
API responsável pelos serviços de VENDA no sistema


GET
/api/venda/{id}
Serviço é responsável por criar um endpoint na API que permite buscar ou consultar uma venda com base no seu identificador (id).

PUT
/api/venda/{id}
Serviço é responsável por atualizar os dados de uma venda existente com base no seu identificador (id).

DELETE
/api/venda/{id}
Serviço é responsável por expor um endpoint HTTP DELETE que permite a exclusão de uma venda com base no seu identificador (id).

GET
/api/venda
Serviço responsável por buscar informações da API Venda, como listar recursos ou obter detalhes específicos.

POST
/api/venda
Serviço é responsável por definir um endpoint HTTP POST que permite criar uma nova venda.

________
```

# API CategoriaProdutoController
API responsável pelos serviços da CategoriaProdutoController no sistema

GET
/api/categoriaproduto/{id}
Serviço é responsável por criar um endpoint na API que permite buscar ou consultar um CategoriaProdutoController com base no seu identificador (id).

PUT
/api/categoriaproduto/{id}
Serviço é responsável por atualizar os dados de uma CategoriaProdutoController existente com base no seu identificador (id).

DELETE
/api/categoriaproduto/{id}
Serviço é responsável por expor um endpoint HTTP DELETE que permite a exclusão de uma CategoriaProdutoController com base no seu identificador (id).

GET
/api/categoriaproduto
Serviço responsável por buscar informações da API CategoriaProdutoController, como listar recursos ou obter detalhes específicos .

POST
/api/categoriaproduto
Serviço é responsável por definir um endpoint HTTP POST que permite criar uma nova CategoriaProdutoController.

________
```
# API Cliente
API responsável pelos servçios de cliente no sistema


GET
/api/cliente/{id}
Serviço é responsável por criar um endpoint na API que permite buscar ou consultar um cliente com base no seu identificador (id).

PUT
/api/cliente/{id}
Serviço é responsável por atualizar os dados de um cliente existente com base no seu identificador (id).

DELETE
/api/cliente/{id}
Serviço é responsável por expor um endpoint HTTP DELETE que permite a exclusão de um cliente com base no seu identificador (id).

PUT
/api/cliente/endereco/{enderecoId}
Serviço responsável por definir endpoints PUT que permitem atualizar informações relacionadas ao endereço de um cliente na API.

DELETE
/api/cliente/endereco/{enderecoId}
Serviço é responsável por criar um endpoint que permite excluir um endereço identificado pelo {enderecoId}.

GET
/api/cliente
Serviço responsável por buscar informações da API, como listar recursos ou obter detalhes específicos.

POST
/api/cliente
Serviço é responsável por definir um endpoint HTTP POST que permite criar um novo cliente.

POST
/api/cliente/endereco/{clienteId}
Serviço é responsável por adicionar um novo endereço para um cliente existente, utilizando o clienteId para associar o endereço ao cliente correto.

________
```
# API EntregadorController
API responsável pelos serviços do EntregadorController no sistema


GET
/api/entregador/{id}
Serviço é responsável por criar um endpoint na API que permite buscar ou consultar um EntregadorController com base no seu identificador (id).

PUT
/api/entregador/{id}
Serviço é responsável por atualizar os dados de um EntregadorController existente com base no seu identificador (id).

DELETE
/api/entregador/{id}
Serviço é responsável por expor um endpoint HTTP DELETE que permite a exclusão de um EntregadorController com base no seu identificador (id).

GET
/api/entregador
Serviço responsável por buscar informações da API EntregadorController, como listar recursos ou obter detalhes específicos .

POST
/api/entregador
Serviço é responsável por definir um endpoint HTTP POST que permite criar um novo EntregadorController.

________
```
# API Produto
API responsável pelos serviços de PRODUTO no sistema


GET
/api/produto/{id}
Serviço é responsável por criar um endpoint na API que permite buscar ou consultar um Produto com base no seu identificador (id).

PUT
/api/produto/{id}
Serviço é responsável por atualizar os dados de um Produto existente com base no seu identificador (id).

DELETE
/api/produto/{id}
Serviço é responsável por expor um endpoint HTTP DELETE que permite a exclusão de um Produto com base no seu identificador (id).

GET
/api/produto
Serviço responsável por buscar informações da API Produto, como listar recursos ou obter detalhes específicos .

POST
/api/produto
Serviço é responsável por definir um endpoint HTTP POST que permite criar um novo Produto.

POST
/api/produto/filtrar
Serviço é responsável por definir um endpoint HTTP POST que permite filtrar produtos com base em critérios enviados no corpo da requisição.

_________________________________________________________________________________________
```
# EntidadeNegocio

@JsonIgnore
    @Version
    private Long versao; //serve para indicar quantas alterações foram feitas naquele registro

_________________________________________________________________________________________
```
# SecurityConfiguration

    // Cai em prova => securityFilterChain ( <= É nessa funcão que será liberada todas as rotas públicas da minha aplicação!)
    // quando se acrescenta o SpringSecurity na aplicação todas as rotas por padrão são fechadas!
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(c -> c.disable())
            .authorizeHttpRequests(authorize -> authorize)
    }


// Para liberar as rotas publicas do meu projeto! 
// Para cada linha abaixo é uma rota que estarei liberando do Tipo (GET|POST|PUT|DELETE)

                .requestMatchers(HttpMethod.GET, "/api/produto").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/produto/*").permitAll() // Se a rota recebe um parâmetro, utilizasse " * " no lugar do ("/{id}") do Produto Controler
                .requestMatchers(HttpMethod.DELETE, "/api/cliente/*").permitAll() // * quando recebe o ("/{id}") do Cliente Controler

                .requestMatchers(HttpMethod.POST, "/api/cliente").permitAll() //permitAll() Cadastra um cliente sem estar logado!
                .requestMatchers(HttpMethod.POST, "/api/funcionario").permitAll() //permitAll() Cadastra um funcionario sem estar logado!
            
_________________________________________________________________________________________
```
5) Inicialize um repositório git no diretório do projeto criado, vincule ao repositório remoto e dê um push para o servidor remoto.

Comandos a serem executados dentro do diretório do projeto:
git init
git remote add origin https://github.com/robertoalencar/oxefood-web.git
git branch -M main
git add .
git commit -m “primeiro commit”
git push -u origin main

_________________________________________________________________________________________
```
