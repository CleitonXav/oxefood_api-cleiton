package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;
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
@Table(name = "Entregador")
@SQLRestriction("habilitado = true") // o True vai acrescentar numa classe "exclusão lógica" habilitando true ou false.

// lombok para outro proposito 
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 
public class Entregador extends EntidadeAuditavel  {
  
    @Column
    private String nome;

    @Column
    private String cpf;

    @Column
    private String rg;

    @Column
    private LocalDate dataNascimento;
  
    @Column
    private String foneCelular;
 
    @Column
    private String foneFixo;

    @Column
    private Integer qtdEntregasRealizadas;

    @Column
    private Double valorPorFrete;

    @Column
    private String rua;

    @Column
    private String numero;

    @Column
    private String bairro;

    @Column
    private String cidade;

    @Column
    private String cep;

    @Column
    private String uf;

    @Column
    private String complemento;

    @Column
    private Boolean ativo;
 
 }
 