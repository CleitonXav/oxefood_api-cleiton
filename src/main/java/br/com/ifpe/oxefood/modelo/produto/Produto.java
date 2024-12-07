package br.com.ifpe.oxefood.modelo.produto;
//import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// JPA Serve para um proposito: Enyty Entidade manipulada pelo JPA
@Entity
@Table(name = "Produto")
@SQLRestriction("habilitado = true") // o True vai acrescentar numa classe "exclusão lógica" habilitando true ou false.

// lombok para outro proposito 
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 
public class Produto extends EntidadeAuditavel  {
  
    @Column
    private String titulo;
 
    @Column
    private String codigoDoProduto;
 
    @Column
    private String descricao;
 
    @Column
    private Double valorUnitario;
 
    @Column
    private Integer tempoDeEntregaMinimoEmMinutos;

    @Column
    private Integer tempoDeEntregaMaximoEmMinutos;
 
 }
 