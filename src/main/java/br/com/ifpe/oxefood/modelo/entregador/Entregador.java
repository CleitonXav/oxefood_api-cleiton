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

@Entity
@Table(name = "Entregador")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entregador extends EntidadeAuditavel  {
  
   @Column
   private String nome;

   @Column
   private LocalDate dataNascimento;

   @Column
   private String cpf;

   @Column
   private String foneCelular;

   @Column
   private String foneFixo;

   @Column
   private String rg;

   @Column
   private String qtdEntregasRealizadas;

   @Column
   private String valorFrete;

   @Column
   private String Rua;

   @Column
   private Number Numero;

   @Column
   private String Bairro;

   @Column
   private String Cep;

   @Column
   private String Cidade;

   @Column
   private String Estado;

   @Column
   private String Complemento;

   @Column
   private Boolean ativo;
}
