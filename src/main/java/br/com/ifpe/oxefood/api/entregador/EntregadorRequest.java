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

   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;

   private String cpf;

   private String rg;

   private String foneCelular;

   private String foneFixo;

   private Integer qtdEntregasRealizadas;

   private Double valorPorFrete;

   private String rua;

   private String numero;

   private String bairro;

   private String cidade;

   private String CEP;

   private String UF;

   private String complemento;

   private String ativo;

   

   public Entregador build() {

       return Entregador.builder()
           .nome(nome)
           .cpf(cpf)
           .rg(rg)
           .dataNascimento(dataNascimento)
           .foneCelular(foneCelular)
           .foneFixo(foneFixo)
           .qtdEntregasRealizadas(qtdEntregasRealizadas)
           .valorPorFrete(valorPorFrete)
           .rua(rua)
           .numero(numero)
           .bairro(bairro)
           .cidade(cidade)
           .cep(CEP)
           .uf(UF)
           .complemento(complemento)
           .ativo(ativo)
           .build();
   }

}
