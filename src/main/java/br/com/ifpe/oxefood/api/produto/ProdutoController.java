package br.com.ifpe.oxefood.api.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.categoriaproduto.CategoriaProdutoService;
import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.produto.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin
@Tag(
    name = "API Produto",
    description = "API responsável pelos serviços de PRODUTO no sistema"
)

public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    
    @Operation(
        summary = "Serviço é responsável por definir um endpoint HTTP POST que permite criar um novo Produto.",
        description = "Ele será documentado como uma operação para cadastrar um novo Produto enviando os dados necessários no corpo da requisição."
    )
    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody @Valid ProdutoRequest request) {

        Produto produtoNovo = request.build();
        produtoNovo.setCategoria(categoriaProdutoService.obterPorID(request.getIdCategoria()));
        Produto produto = produtoService.save(produtoNovo);

        return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
    }

    @Autowired
    private CategoriaProdutoService categoriaProdutoService;


    @Operation(
        summary = "Serviço responsável por buscar informações da API Produto, como listar recursos ou obter detalhes específicos .",
        description = "será documentado como operações de leitura, exibindo os detalhes de cada endpoint associado a API Produto, como os parâmetros necessários e as possíveis respostas."
    )
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @Operation(
        summary = "Serviço é responsável por criar um endpoint na API que permite buscar ou consultar um Produto com base no seu identificador (id).",
        description = "No Swagger, esse endpoint será documentado como uma operação HTTP GET acessível no caminho /produto/{id} espera receber um parâmetro de caminho (id), que é o identificador único do produto a ser buscado."
    )
    @GetMapping("/{id}")
    public Produto obterPorID(@PathVariable Long id) {
        return produtoService.obterPorID(id);
    }


    @Operation(
        summary = "Serviço é responsável por atualizar os dados de um Produto existente com base no seu identificador (id).", 
        description = "No Swagger, ele será documentado como um endpoint que permite modificar informações de um produto já cadastrado."
    )
    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") Long id, @RequestBody ProdutoRequest request) {

        Produto produto = request.build();
        produto.setCategoria(categoriaProdutoService.obterPorID(request.getIdCategoria()));
        produtoService.update(id, produto);

        return ResponseEntity.ok().build();
    }


    @Operation(
        summary = "Serviço é responsável por expor um endpoint HTTP DELETE que permite a exclusão de um Produto com base no seu identificador (id).", 
        description = "ele será documentado como uma operação que realiza a exclusão de um recurso específico (neste caso, o produto) na API."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }

    
    @Operation(
        summary = "Serviço é responsável por definir um endpoint HTTP POST que permite filtrar produtos com base em critérios enviados no corpo da requisição.", 
        description = "No Swagger, ele será documentado como um endpoint para buscar Produtos usando filtros personalizados."
    )
    @PostMapping("/filtrar")
    public List<Produto> filtrar(
            @RequestParam(value = "codigo", required = false) String codigo,
            @RequestParam(value = "titulo", required = false) String titulo,
            @RequestParam(value = "idCategoria", required = false) Long idCategoria) {

        return produtoService.filtrar(codigo, titulo, idCategoria);
    }

}
