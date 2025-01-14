package br.com.ifpe.oxefood.api.funcionario;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.modelo.funcionario.Funcionario;
import br.com.ifpe.oxefood.modelo.funcionario.TipoFuncionario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioRequest {

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoFuncionario tipo;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String nome;

    private String cpf;

    private String rg;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String foneCelular;

    private String foneFixo;

    private Double salario;

    private String Rua;

    private String Numero;

    private String Bairro;

    private String Cidade;

    private String Cep;

    private String Uf;

    private String Complemento;

    public Usuario buildUsuario() {

        return Usuario.builder()
            .username(email)
            .password(password)
            .build();
    }

    public Funcionario build() {

        return Funcionario.builder()
                .tipo(tipo)
                .usuario(buildUsuario())
                .nome(nome)
                .cpf(cpf)
                .rg(rg)
                .dataNascimento(dataNascimento)
                .foneCelular(foneCelular)
                .foneFixo(foneFixo)
                .salario(salario)
                .Rua(Rua)
                .Numero(Numero)
                .Bairro(Bairro)
                .Cidade(Cidade)
                .Cep(Cep)
                .Uf(Uf)
                .Complemento(Complemento)
                .build();
    }

}
