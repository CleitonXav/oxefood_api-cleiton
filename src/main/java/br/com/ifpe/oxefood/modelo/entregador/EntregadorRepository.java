package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregadorRepository extends JpaRepository<Entregador, Long> {

    List<Entregador> listarTodos();

    Entregador obterPorID(Long id);
  
}
