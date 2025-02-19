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
O que significa essa @MappedSuperclass na EntidadeAuditavel

A anotação@MappedSuperclass não Jsuperclasse mapeada ,não é uma entidade em si .

Quando uma classe é anotada com @MappedSuperclass:

Ela não será mapeada como uma tabela no banco de dados.
Outras classes que a estendem herdarão seus atributos e mapeamentos ,
Isso permite reutilizar atributos comuns entre

_________________________________________________________________________________________
Av._________________________________________________________________________________________
```
01) Considerando as duas classes abaixo, responda:

public class Cliente {
   
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    @Column(nullable = false, length = 100)
    private String nome;
    
    @Column
    private LocalDate dataNascimento;

    @Column(unique = true)
    private String cpf;

    @Column
    private String fone;

    @Column
    private String foneAlternativo;
  
}
_________________________________________________________________________________________
````````
	public class ClienteRequest {

    @NotNull(message = "O Nome é de preenchimento obrigatório")
    @NotBlank(message = "O Nome é de preenchimento obrigatório")
    private String nome;

    @NotBlank(message = "O e-mail é de preenchimento obrigatório")
    @Email
    private String email;

    @NotBlank(message = "A senha é de preenchimento obrigatório")
    private String password;
    
    @NotNull(message = "O CPF é de preenchimento obrigatório")
    @NotBlank(message = "O CPF é de preenchimento obrigatório")
    @CPF
    private String cpf;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String fone;

    privamessagenste String foneAlternativo;

}
 _________________________________________________________________________________________
````````
a) Como pode ser observado, as duas classes possuem anotações de validação colocadas em determinados atributos da classe. Qual a diferença entre colocar essas validações na classe Cliente e colocar na classe ClienteRequest ?  (0,5 ponto)

Resposta:

  Validação na classeClienteRequest : protegida, validar os dados na camada de entrada (ClienteRequest)
•	As notas de validação ( @NotNull, `@Not@NotBlank, `@CPF, isso impede que informações inválidas cheguem ao backend e causem falhas mais à frente, proporcional
•	Essas validações são aplicadas pelo Bean Validation(JSR @Valid nenhum ponto final faz.

Validação na classe Cliente: Garanti a camada de persistência e promove regras de consistência na entidade ( Cliente)
•	Uma classe Cliente representa as anotações nesta classe (como @Column (nullable = false)) garantem diferentemente de ClienteRequest,
•	Caso os dados já tenham passado pela ClienteRequest, como valido.


  _________________________________________________________________________________________
````````
b) Explique o que significa cada validação colocada nas classes acima. (0,5 ponto)

Resposta:

Na Classe: Cliente
o	@ManyToOne
o	Indica um relacionamento de “muitos para um” com a entidade Usuario. Ou seja, vários clientes podem estar associados a um único usuário.
	
o	@JoinColumn(nullable = false)
o	Define que uma chave estrangeira (coluna que representa o relacionamento) com Usuario não pode ser nula, garantindo que todo cliente esteja comprometido com um usuário.
	
o	@Column(nullable = false, length = 100)
o	nullable = false: O campo nome “não pode ser nulo” no banco de dados.
o	length = 100: Limita o tamanho máximo do nome a 100 caracteres.
	
o	@Column(unique = true)
o	Indica que o campo CPF deve ter valores únicos no banco de dados, ou seja, não pode haver dois clientes com o mesmo CPF.


Na classe ClienteRequesté usada para receber dados de entrada na API e inclui diversas validações para garantir a integridade dos dados.

1.	@NotNull(message = "...")
	Indica que o campo não pode ser null.
	Exemplo: nome e cpf são obrigatórios e não podem estar ausentes na requisição.

2.	@NotBlank(message = "...")
	Garante que o campo não seja null, nem uma string vazia ( "") ou contendo apenas espaços em branco.
	Exemplo: nome, email, password e cpf precisa ter conteúdo válido.

3.	@Email
	Verifica se o formato do e-mail está correto.
	Exemplo: "exemplo@dominio.com"será válido, mas "exemplo@com"não será.
4.	@CPF
	Valida se o CPF informado é válido segundo a estrutura e o algoritmo de verificação de CPF.
5.	@JsonFormat(pattern = "dd/MM/yyyy")
	Defina o formato de entrada e saída da data de nascimento como dia/mês/ano (dd/MM/yyyy).
	Isso ajuda na conversão automática ao serializar e desserializar objetos JSON.

Em resumo, essas anotações ajudam a garantir que os dados informados pelos usuários sejam válidos antes de serem processados ou armazenados no banco de dados.

_________________________________________________________________________________________
````````

c) Qual seria a validação que precisaríamos acrescentar ao campo foneAlternativo para validar o tamanho máximo do campo para não permitir mais que 30 caracteres?  

Resposta:

@Size(max = 30, message = "O telefone alternativo deve ter no máximo 30 caracteres") private String foneAlternativo;

•	A anotação @Size(max = 30)garante que o foneAlternativo tenha no máximo 30 caracteres
•	Uma mensagem "O telefone alternativo deve ter no máximo 30 caracteres" será exibido para o usuário.
Isso garante que o campo seja devidamente validado conforme a regra de negócio.

_________________________________________________________________________________________
````````


02) Considerando os conceitos aprendidos na aula “C18 - Back-end - Relacionando Entidades”, implemente um relacionamento de “um para muitos” bidirecional entre as classes Empresa e Cliente de forma que:
?	um cliente tenha uma empresa;
?	uma empresa tenha uma lista de clientes

Faça a alteração no código das classes abaixo  

public class Cliente extends EntidadeAuditavel {



    @Column(nullable = false, length = 100)
    private String nome;
    
    @Column
    private LocalDate dataNascimento;

    @Column(unique = true)
    private String cpf;

    @Column
    private String fone;

    @Column
    private String foneAlternativo;

@OneToMany(mappedBy = "cliente", orphanRemoval = true, fetch = FetchType.EAGER)
private List<EnderecoCliente> enderecos;
    
}
 _________________________________________________________________________________________
````````
	public class Empresa extends EntidadeAuditavel {

@JsonIgnonore
@ManyToOne
private Cliente cliente;

   
    @Column
    private String site;

    @Column
    private String cnpj;

    @Column
    private String inscricaoEstadual;

    @Column
    private String nomeEmpresarial;

    @Column
    private String nomeFantasia;

    @Column
    private String fone;

    @Column
    private String foneAlternativo;

}
_________________________________________________________________________________________
````````
//Relacionamento um para muitos com Empresa 

@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
private List<Empresa> empresas;
 
//Getters e Setters
 public List<Empresa> getEmpresas() {
   return empresas;
 } 
 public void setEmpresas(List<Empresa> empresas) {   
   this.empresas = empresas; 
 } 

}

_________________________________________________________________________________________
````````
	// Getters e Setters
 public Cliente getCliente() {
     return cliente; 
  } 
  public void setCliente(Cliente cliente) {      
     this.cliente = cliente; 
  } 
} 
_________________________________________________________________________________________
````````

**@OneToMany(mappedBy = "cliente")emCliente
•	O atributo mappedBy = "cliente"referênciaclienten /
	DEmpresa
•	cascade = CascadeType.ALL:persist,
	`mergeeremovevocê
•	orphanRemoval = true:	
  _________________________________________________________________________________________
````````
	@ManyToOneemEmpresa
•	Indica
•	@JoinColumn(name = "cliente_id",
	nullable = false):
**@JsonIgnorena aulaEmpresa
•	Isso garante um relacionamento bidirecional correto e eficiente

 _________________________________________________________________________________________
````````
Aqui está a recomendação correta do relacionamento **"um para muitos" bidirecional** entre as classes `Empresa` e `Cliente`: 
- **Cada Cliente pertence a uma Empresa (@ManyToOne`)**

- **Uma Empresa pode ter vários Clientes (`@OneToMany`)** -

- # Correções e configurações:
1. **Na classe `Cliente`**: - Adicionamos um campo `empresa` com `@ManyToOne` para associar um cliente uma empresa. 
- Definimos `@JoinColumn(name = "empresa_id", nullable = false)` para garantir que um cliente sempre tenha uma empresa. 

_________________________________________________________________________________________
````````

03) Considerando o método abaixo, modifique o código para permitir:

?	Acesso público ao endpoint no Controller que consulta uma empresa por ID. (0,5 ponto)

   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

       http
               .httpBasic().disable().csrf().disable().cors().and().sessionManagement()
               .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling() .cliente() .id()
               .authenticationEntryPoint(authenticationEntryPoint).and().authorizeRequests()

               .antMatchers(AUTH_WHITELIST).permitAll()

               .anyRequest()
               .hasAnyAuthority(Usuario.ROLE_CLIENTE, Usuario.ROLE_EMPRESA, Usuario.ROLE_CLIENTE)
               .and().addFilterBefore(
                       new JwtTokenAuthenticationFilter(jwtTokenProvider),
                       UsernamePasswordAuthenticationFilter.class);

       return http.build();
   }


Resposta:

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .httpBasic().disable()
        .csrf().disable()
        .cors().and()
        .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .exceptionHandling()
            .authenticationEntryPoint(authenticationEntryPoint).and()
        .authorizeRequests()
            // Permitir acesso público ao endpoint /empresa/{id}
            .antMatchers(HttpMethod.GET, "/empresa/{id}").permitAll()

            // Definir outras permissões para os demais endpoints
            .antMatchers(AUTH_WHITELIST).permitAll()

            // Para o restante dos endpoints, requer autenticação
            .anyRequest()
            .hasAnyAuthority(Usuario.ROLE_CLIENTE, Usuario.ROLE_EMPRESA, Usuario.ROLE_CLIENTE).and()
        
        .addFilterBefore(
            new JwtTokenAuthenticationFilter(jwtTokenProvider),
            UsernamePasswordAuthenticationFilter.class);

    return http.build();
}
 _________________________________________________________________________________________
````````
@GetMapping("/empresa/{id}")
public ResponseEntity<Empresa> consultarEmpresa(@PathVariable Long id) {
 // Lógica para consultar a empresa por ID
 return ResponseEntity.ok
(empresaService.consultarEmpresaPorId(id)); }

_________________________________________________________________________________________
````````

04) No contexto da aula de Controle de Acesso, qual a diferença entre autenticação, autorização e auditoria? 

Resposta:

1.A autenticação é o processo de verificar a identidade de um usuário ou sistema. O objetivo é garantir que a pessoa ou sistema que está tentando acessar um recurso seja realmente quem diz ser.
Ex.: O processo de login onde o usuário fornece um nome de usuário e uma senha. O sistema verifica se as credenciais fornecidas coincidem com aquelas armazenadas no banco de dados.

2.A autorização acontece após a autenticação e define quais recursos o usuário autenticado pode acessar e quais ações pode realizar no sistema. Ou seja, é o processo de conceder ou restringir acesso com base nas permissões do usuário. Ex.: O sistema pode permitir que um administrador acesse configurações do sistema, mas não permitir que um usuário comum execute tais ações.

3. A auditoria envolve a coleta e análise de registros (logs) de eventos, transações e acessos realizados no sistema. O objetivo é monitorar e registrar as atividades dos usuários e sistemas para garantir que o controle de acesso seja realizado de forma adequada, e para detectar e investigar qualquer comportamento suspeito ou anormal. Ex.: Registrar quando e onde um usuário acessou determinado recurso, qual ação foi realizada e o que foi modificado no sistema.

Resumo:

Conceito		Descrição										Objetivo
Autenticação	Verificar a identidade do usuário ou sistema.	Garantir que a pessoa ou 
																sistema seja quem diz ser.
Autorização	    Definir o que o usuário autenticado pode ou
				não acessar.									Controlar o acesso a 	
																recursos com base nas permissões.
Auditoria		Registrar e monitorar as atividades do sistema
				e dos usuários.									Fornecer registros para 
																investigação e conformidade.

_________________________________________________________________________________________
````````
 
05) Durante a implementação do projeto trabalhado ao longo da disciplina nós criamos um arquivo .env e o colocamos na raiz do projeto. Responda:

a) Para que serve este arquivo? Qual a vantagem/importância dele? (0,5 ponto)

Resposta:

1. Para que serve o arquivo .env?
O arquivo .env contém variáveis de ambiente que podem ser carregadas na aplicação no momento da execução. Ele permite que a aplicação seja configurada dinamicamente, sem a necessidade de modificar o código-fonte diretamente, de modo que a mesma base de código possa ser executada em diferentes ambientes (desenvolvimento, produção, teste, etc.) com diferentes configurações.

2. Vantagens do arquivo .env:
Segurança e Separação de Configurações Sensíveis , como credenciais de banco de dados, chaves de API ou segredos de autenticação.

Facilidade de Configuração entre Ambientes: com o .env fica fácil configurar variáveis para diferentes ambientes sem ter que alterar o código-fonte.

Manutenção e Escalabilidade:
Manter as configurações fora do código-fonte melhora a manutenção da aplicação, especialmente à medida que ela cresce. Quando você precisa atualizar uma configuração, você pode simplesmente alterar o valor da variável no arquivo .env sem alterar o código.

Facilidade de Desenvolvimento Local:
Durante o desenvolvimento, o arquivo .env permite que os desenvolvedores definam rapidamente variáveis de ambiente sem a necessidade de configurar variáveis diretamente no sistema operacional ou containers. Isso torna a configuração de ambientes de desenvolvimento mais ágil.

3. Importância do arquivo .env:
Redução do Risco de Erros: Ao centralizar as configurações em um único lugar (o arquivo .env), fica mais fácil modificar essas configurações de forma consistente, sem precisar procurar por múltiplos locais no código.

Facilidade de Deploy e Automação:
Como o arquivo .env permite que você defina configurações específicas para o ambiente de execução, ele facilita o deploy automatizado e a configuração do ambiente.

Padrão de Boa Prática no Desenvolvimento de Software:
O uso de arquivos .env é considerado uma boa prática em projetos modernos. Ele segue o princípio de "externalizar configurações", o que significa que as configurações não estão codificadas diretamente no aplicativo, tornando-o mais flexível e seguro.

_________________________________________________________________________________________
````````

b) No arquivo onde definimos as configurações do projeto, escreva abaixo a linha em que informamos ao spring que o projeto poderá utilizar (ou não) um arquivo .env  (0,5 ponto)

Resposta:

No application.properties

spring.config.import=optional:file:.env[.properties]

 _________________________________________________________________________________________
````````

06) Observando o código abaixo, responda: 

“caso ocorra um erro e seja levantado alguma exceção na linha 9, os objetos inseridos nas linhas 4 e 7 serão gravados no banco de dados, pois os comandos são executados antes da linha 9.”

A afirmação acima é verdadeira? Justifique sua resposta. (1,0 ponto)

1	@Transactional
2 public Cliente save(Cliente cliente) {
3
4    usuarioService.save(cliente.getUsuario());
5	
6    super.preencherCamposAuditoria(cliente);
7    Cliente clienteSalvo = repository.save(cliente);
8	
9    emailService.enviarEmailConfirmacaoCadastroCliente(clienteSalvo);
10	
11   return clienteSalvo;
12 }

Resposta:

A afirmação não é verdadeira. 
O código fornecido está usando a anotação @Transactional, que indica que os métodos executados dentro de uma transação serão tratados de forma atômica. Ou seja, se ocorrer um erro em qualquer ponto do método, todas as operações realizadas antes da falha serão desfeitas (rollback).
No seu código:
•	Na linha 4, o método usuarioService.save(cliente.getUsuario()) é chamado.
•	Na linha 7, o método repository.save(cliente) é chamado para salvar o cliente no banco de dados.
•	Na linha 9, o método emailService.enviarEmailConfirmacaoCadastroCliente(clienteSalvo) é chamado.
Se ocorrer um erro na linha 9, o método @Transactional garante que o rollback ocorrerá e todos os dados inseridos nas linhas anteriores, como o que foi salvo no banco de dados (linha 7), serão desfeitos.
Portanto, o banco de dados não será alterado se ocorrer um erro na linha 9, pois a transação será revertida, desfazendo os registros feitos até o momento, incluindo a gravação do cliente.
 
_________________________________________________________________________________________
````````

07) Observando o código abaixo, responda: 

“Após criada esta interface (ClienteRepository), já é possível ter acesso a métodos para consultar um cliente por id, consultar todos os clientes, incluir, alterar e remover um cliente no banco de dados.”

A afirmação acima é verdadeira? Justifique sua resposta. (1,0 ponto)

package br.com.ifpe.oxefood.modelo.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClienteRepository extends JpaRepository<Cliente, Long>,JpaSpecificationExecutor<Cliente> {
     
}

Resposta:

A afirmação é verdadeira,
Quando você define uma interface ClienteRepository que estende JpaRepository<Cliente, Long> e JpaSpecificationExecutor<Cliente>, você automaticamente ganha uma série de métodos prontos e implementados pelo Spring Data JPA para realizar operações padrão de acesso a dados no banco de dados.

Sim, com a interface ClienteRepository herdando JpaRepository, você já tem acesso a métodos para:
	Consultar um cliente por id (com findById()).
	Consultar todos os clientes (com findAll()).
	Incluir/alterar um cliente (com save()).
	Remover um cliente (com deleteById() ou delete()).
Portanto, a afirmação está correta: com a criação da interface ClienteRepository, já é possível realizar operações padrão de acesso a dados como consultar, incluir, alterar e remover clientes no banco de dados.

 _________________________________________________________________________________________
````````

08) Considerando a classe abaixo:

public class CategoriaProduto extends EntidadeAuditavel {

    @NotNull
    @Column(nullable = false, length = 100)
    private String descricao;

}

a) O código abaixo funciona? Se não funcionar, explique o porquê. 

	public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {

    List<CategoriaProduto> findByChaveEmpresaOrderByNome(String chaveEmpresa);

}

Resposta:

O código não funciona como esperado, e a razão está no fato de que o método findByChaveEmpresaOrderByNome não corresponde corretamente ao modelo da classe CategoriaProduto.

Erro no nome dos atributos: O método findByChaveEmpresaOrderByNome está tentando buscar um atributo chamado chaveEmpresa e ordená-lo por nome. No entanto, de acordo com a classe CategoriaProduto fornecida, não existem atributos chamados chaveEmpresa ou nome.  
_________________________________________________________________________________________
````````

b) O código abaixo funciona? Se não funcionar, explique o porquê. 

	public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {

    List<CategoriaProduto> findByChaveEmpresaOrderByDescricao();

}

Resposta:

O código não funciona corretamente. A razão está relacionada ao fato de que o método findByChaveEmpresaOrderByDescricao está tentando acessar um atributo chamado chaveEmpresa, mas esse atributo não existe na classe CategoriaProduto conforme a definição fornecida.

Falta do atributo chaveEmpresa na classe CategoriaProduto: O método findByChaveEmpresaOrderByDescricao está tentando realizar uma consulta baseada em um campo chamado chaveEmpresa, mas a classe CategoriaProduto fornecida só possui o atributo descricao, sem qualquer menção a chaveEmpresa.

 _________________________________________________________________________________________
````````

09) Na aula de controle de acesso do projeto do front-end, implementamos um componente para restringir o acesso não autenticado às telas do sistema, posteriormente esse componente foi adicionado em cada definição <Route> no arquivo Rotas.js. Qual foi o componente criado e como ele foi utilizado no arquivo Rotas.js ? (

Resposta:

No Exemplo abaixo foi ajustado o arquivo Rotas.jsx para que o path “/” direcione o usuário para a tela de Login e o path “/home” direcione o usuário para tela de Home:

import Home from './views/home/Home';
import FormLogin from './views/login/FormLogin';

....    
        <Routes>
                <Route path="/" element={ <FormLogin/> } />
                <Route path="/home" element={ <Home/> } />
															  
_________________________________________________________________________________________
````````

10) O que é uma API WEB considerada RESTful?

Resposta:

R= Uma API Web RESTful é uma interface de comunicação entre sistemas baseada nos princípios do REST (Representational State Transfer). Ela permite a troca de dados entre clientes (frontend, mobile, outras APIs, etc.) e servidores usando requisições HTTP.
1? Baseada em Recursos:
Os dados são representados como recursos, identificados por URLs.
Exemplo: /clientes/1 representa o cliente com ID 1.

2?. Usa os Métodos HTTP de Forma Semântica:
GET ? Buscar um recurso (ex: GET /clientes/1)
POST ? Criar um novo recurso (ex: POST /clientes)
PUT ? Atualizar um recurso existente (ex: PUT /clientes/1)
DELETE ? Remover um recurso (ex: DELETE /clientes/1)

3? Comunicação via JSON ou XML:
JSON é o formato mais comum para troca de dados.
json

{
"id": 1,
"nome": "João Silva",
"email": "joao@email.com"
}

4 Stateless (Sem Estado):
Cada requisição é independente, ou seja, o servidor não armazena o estado do cliente.
Isso melhora a escalabilidade e torna a API mais eficiente.

5? Uso de Códigos de Status HTTP:
200 OK ? Requisição bem-sucedida
201 Created ? Recurso criado com sucesso
400 Bad Request ? Erro na requisição do cliente
404 Not Found ? Recurso não encontrado
500 Internal Server Error ? Erro no servidor
