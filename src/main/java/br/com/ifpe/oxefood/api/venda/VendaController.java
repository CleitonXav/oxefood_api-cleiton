package br.com.ifpe.oxefood.api.venda;

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

import br.com.ifpe.oxefood.modelo.venda.Venda;
import br.com.ifpe.oxefood.modelo.venda.VendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/venda")
@CrossOrigin
@Tag(
    name = "API Venda",
    description = "API responsável pelos serviços de VENDA no sistema"
)

public class VendaController {

    @Operation(
        summary = "Serviço responsável por buscar informações da API Venda, como listar recursos ou obter detalhes específicos.",
        description = "será documentado como operações de leitura, exibindo os detalhes de cada endpoint associado a API de Venda, como os parâmetros necessários e as possíveis respostas."
    )
    @GetMapping
    public List<Venda> listarTodos() {
        return vendaService.listarTodos();
    }


    @Operation(
        summary = "Serviço é responsável por criar um endpoint na API que permite buscar ou consultar uma venda com base no seu identificador (id).",
        description = "No Swagger, esse endpoint será documentado como uma operação HTTP GET acessível no caminho /venda/{id} espera receber um parâmetro de caminho (id), que é o identificador único da venda a ser buscada."
    )    
    @GetMapping("/{id}")
    public Venda obterPorID(@PathVariable Long id) {
        return vendaService.obterPorID(id);
    }


    @Operation(
        summary = "Serviço é responsável por atualizar os dados de uma venda existente com base no seu identificador (id).",
        description = "No Swagger, ele será documentado como um endpoint que permite modificar informações de uma venda já cadastrada."
    )
    @PutMapping("/{id}")
    public ResponseEntity<Venda> update(@PathVariable("id") Long id, @RequestBody VendaRequest request) {

        vendaService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @Autowired
    private VendaService vendaService;


    @Operation(
        summary = "Serviço é responsável por definir um endpoint HTTP POST que permite criar uma nova venda.",
        description = "Ele será documentado como uma operação para cadastrar uma nova venda enviando os dados necessários no corpo da requisição."
    )
    @PostMapping
    public ResponseEntity<Venda> save(@RequestBody VendaRequest request) {

        Venda venda = vendaService.save(request.build());
        return new ResponseEntity<Venda>(venda, HttpStatus.CREATED);
    }



    @Operation(
        summary = "Serviço é responsável por expor um endpoint HTTP DELETE que permite a exclusão de uma venda com base no seu identificador (id).",
        description = "ele será documentado como uma operação que realiza a exclusão de um recurso específico (neste caso, a venda) na API."
    ) 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        vendaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
