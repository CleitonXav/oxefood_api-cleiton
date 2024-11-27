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
 
    private String descricao;
 
    private Double valorUnitario;
 
    private Integer tempoDeEntregaMinimoEmMinutos;
 
    private Integer tempoDeEntregaMaximoEmMinutos;
 
   public Produto build() {

    return Produto.builder()
    .titulo(titulo)
    .codigoDoProduto(codigoDoProduto)
    .descricao(descricao)
    .valorUnitario(valorUnitario)
    .tempoDeEntregaMinimoEmMinutos(tempoDeEntregaMinimoEmMinutos)
    .tempoDeEntregaMaximoEmMinutos(tempoDeEntregaMaximoEmMinutos)
    .build();
   }
}
