package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {
   
   private String nome;
   private String cpf;
   private String rg;
   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;
   private String foneCelular;
   private String foneFixo;
   private String qtdEntregasRealizadas;
   private String valorFrete;
   private String Rua;
   private Number Numero;
   private String Bairro;
   private String Cep;
   private String Cidade;
   private String Estado;
   private String Complemento;
   private Boolean ativo;

   public Entregador build() {

       return Entregador.builder()
           .nome(nome)           
           .cpf(cpf)
           .rg(rg)
           .dataNascimento(dataNascimento)
           .foneCelular(foneCelular)
           .foneFixo(foneFixo)           
           .qtdEntregasRealizadas(qtdEntregasRealizadas)
           .valorFrete(valorFrete)
           .Rua(Rua)
           .Numero(Numero)
           .Bairro(Bairro)
           .Cep(Cep)
           .Cidade(Cidade)
           .Estado(Estado)
           .Complemento(Complemento)
           .ativo(ativo)
           .build();
   }

}
