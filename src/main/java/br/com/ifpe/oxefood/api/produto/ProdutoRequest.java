package br.com.ifpe.oxefood.api.produto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

   private String Titulo;

   //@JsonFormat(pattern = "dd/MM/yyyy")
   private String CodigoDoProduto;

   private String Descrição;

   private Double ValorUnitario;

   private Integer tempoDeEntregaMínimoEmMinutos;

   private Integer tempoDeEntregaMáximoEmMinutos;

   public Produto build() {

       return Produto.builder()
       
           .Titulo(Titulo)
           .CodigoDoProduto(CodigoDoProduto)
           .Descrição(Descrição)
           .ValorUnitario(ValorUnitario)
           .tempoDeEntregaMínimoEmMinutos;
           .tempoDeEntregaMáximoEmMinutos;
           .build();
   }

}
