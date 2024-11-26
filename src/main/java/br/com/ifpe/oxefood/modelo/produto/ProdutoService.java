package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;
 
    @Transactional
    public Produto save(Produto produto) {
 
        produto.setHabilitado(Boolean.TRUE);
        return repository.save(produto);
    }
    public List<Produto> listarTodos() {
  
      return repository.findAll(); 
  }

  public Produto obterPorID(Long id) {

      return repository.findById(id).get();
  }
     @Transactional
   public void update(Long id, Produto produtoAlterado) {

      Produto produto = repository.findById(id).get();
      produto.setTitulo(produtoAlterado.getTitulo());
      produto.setCodigoDoProduto(produtoAlterado.getCodigoDoProduto());
      produto.setDescrição(produtoAlterado.getDescrição());
      produto.setValorUnitario(produtoAlterado.getValorUnitario());
      produto.setTempoDeEntregaMínimoEmMinutos(produtoAlterado.getTempoDeEntregaMínimoEmMinutos());
      produto.setTempoDeEntregaMáximoEmMinutos(produtoAlterado.getTempoDeEntregaMáximoEmMinutos());
	    
      repository.save(produto);
    }
    @Transactional
    public void delete(Long id) {
 
        Produto produto = repository.findById(id).get();
        produto.setHabilitado(Boolean.FALSE);
 
        repository.save(produto);
    }

 }