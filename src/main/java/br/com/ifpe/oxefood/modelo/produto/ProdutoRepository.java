package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
  
    //Exemplo de uma busca exata
    @Query(value = "SELECT p FROM Produto p WHERE p.codigo = :codigo")
    List<Produto> consultarPorCodigo(String codigo);
    
    // Duas formas diferente de ser feita a mesma coisa do @Query(value = "SELECT p FROM Produto p WHERE p.codigo = :codigo")
    List<Produto>findByCodigoOrderById(String codigo);
 
    //Exemplo de uma busca aproximada com ordenação: Percentual % é uma busca aproximada, não é igual
    // @Query(value = "SELECT p FROM Produto p WHERE p.titulo ilike %:titulo% ORDER BY p.titulo") 
    // List<Produto> consultarPorTitulo(String titulo);
    List<Produto> findByTituloContainingIgnoreCaseOrderByTituloAsc(String titulo); //ContainingIgnoreCase (diferencia a letra maiuscula de menuscula)
 
    //Exemplo de uma busca exata como um atributo de relacionamento
    @Query(value = "SELECT p FROM Produto p WHERE p.categoria.id = :idCategoria")
    List<Produto> consultarPorCategoria(Long idCategoria);
 
    //Exemplo de uma busca com mais de um atributo
    @Query(value = "SELECT p FROM Produto p WHERE p.titulo ilike %:titulo% AND p.categoria.id = :idCategoria")
    List<Produto> consultarPorTituloECategoria(String titulo, Long idCategoria);
 }
 
