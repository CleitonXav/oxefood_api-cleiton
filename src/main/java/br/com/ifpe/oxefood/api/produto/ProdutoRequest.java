package br.com.ifpe.oxefood.api.produto;

//import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    private String titulo;

    private String codigoDoProduto;
 
    private String descrição;
 
    private Double valorUnitario;
 
    private Integer tempoDeEntregaMínimoEmMinutos;
 
    private Integer tempoDeEntregaMáximoEmMinutos;
 
   public Produto build() {

    return Produto.builder()
    .titulo(titulo)
    .codigoDoProduto(codigoDoProduto)
    .descrição(descrição)
    .valorUnitario(valorUnitario)
    .tempoDeEntregaMínimoEmMinutos(tempoDeEntregaMínimoEmMinutos)
    .tempoDeEntregaMáximoEmMinutos(tempoDeEntregaMáximoEmMinutos)
    .build();
   }
}
