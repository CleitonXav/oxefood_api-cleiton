package br.com.ifpe.oxefood.api.categoriaproduto;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.categoriaproduto.CategoriaProduto;
import br.com.ifpe.oxefood.modelo.categoriaproduto.CategoriaProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/categoriaproduto")
@CrossOrigin
@Tag(
    name = "API CategoriaProdutoController",
    description = "API responsável pelos serviços da CategoriaProdutoController no sistema"
)

public class CategoriaProdutoController {

    @Autowired
    private CategoriaProdutoService categoriaProdutoService;


    @Operation(
        summary = "Serviço responsável por buscar informações da API CategoriaProdutoController, como listar recursos ou obter detalhes específicos .",
        description = "será documentado como operações de leitura, exibindo os detalhes de cada endpoint associado a API CategoriaProdutoController, como os parâmetros necessários e as possíveis respostas."
    )
    @GetMapping
    public List<CategoriaProduto> listarTodos() {
        return categoriaProdutoService.listarTodos();
    }


    @Operation(
        summary = "Serviço é responsável por criar um endpoint na API que permite buscar ou consultar um CategoriaProdutoController com base no seu identificador (id).",
        description = "No Swagger, esse endpoint será documentado como uma operação HTTP GET acessível no caminho /CategoriaProdutoController/{id} espera receber um parâmetro de caminho (id), que é o identificador único da CategoriaProdutoController a ser buscado."
    )
    @GetMapping("/{id}")
    public CategoriaProduto obterPorID(@PathVariable Long id) {
        return categoriaProdutoService.obterPorID(id);
    }


    @Operation(
        summary = "Serviço é responsável por atualizar os dados de uma CategoriaProdutoController existente com base no seu identificador (id).", 
        description = "No Swagger, ele será documentado como um endpoint que permite modificar informações de uma CategoriaProdutoController já cadastrado."
    )
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProduto> update(@PathVariable("id") Long id, @RequestBody CategoriaProdutoRequest request) {

        categoriaProdutoService.update(id, request.build());
        return ResponseEntity.ok().build();
    }


    @Operation(
        summary = "Serviço é responsável por definir um endpoint HTTP POST que permite criar uma nova CategoriaProdutoController.",
        description = "Ele será documentado como uma operação para cadastrar uma nova CategoriaProdutoController enviando os dados necessários no corpo da requisição."
    ) 
    @PostMapping
    public ResponseEntity<CategoriaProduto> save(@RequestBody CategoriaProdutoRequest request) {

        CategoriaProduto categoriaProdutoNovo = request.build();
        CategoriaProduto categoriaProduto = categoriaProdutoService.save(categoriaProdutoNovo);
        return new ResponseEntity<CategoriaProduto>(categoriaProduto, HttpStatus.CREATED);
    }


    @Operation(
        summary = "Serviço é responsável por expor um endpoint HTTP DELETE que permite a exclusão de uma CategoriaProdutoController com base no seu identificador (id).", 
        description = "ele será documentado como uma operação que realiza a exclusão de um recurso específico (neste caso, a CategoriaProdutoController) na API."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        categoriaProdutoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
