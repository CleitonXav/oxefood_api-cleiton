# oxefood_api-cleiton

Dados no Back-Entregador_Categoria_Cliente_End.Cliente_Produto e etc.

entregador

 {
        "nome": "Cleiton Xavier",
        "cpf": "786.974.760-20",
        "rg": "1212123",
        "dataNascimento": "12/02/1986",
        "foneCelular": "(11) 11111.111_",
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
    "username": "cleitonxav25@gmail",
    "password": "123456",
    "nome": "Cleiton Xavier",
    "dataNascimento": "17/01/1982",
    "cpf": "247.666.260-79",
    "foneCelular": "(81) 11111.111",
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

_______________________________________________________________________________________________________________________________________________________________________
Anotacao spring validation

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

Anotações mais comuns do Spring Validation: No back-end: Entrada das Requisições - C20

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
_______________________________________________________________________________________________________________________________________________________________________
Anotação @Column em JPA

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