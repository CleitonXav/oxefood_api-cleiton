package br.com.ifpe.oxefood.api.entregador;

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

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.modelo.entregador.EntregadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/entregador")
@CrossOrigin
@Tag(
    name = "API EntregadorController",
    description = "API responsável pelos serviços do EntregadorController no sistema"
)

public class EntregadorController {

    @Autowired
    private EntregadorService entregadorService;


    @Operation(
        summary = "Serviço é responsável por definir um endpoint HTTP POST que permite criar um novo EntregadorController.",
        description = "Ele será documentado como uma operação para cadastrar um novo EntregadorController enviando os dados necessários no corpo da requisição."
    )
    @PostMapping
    public ResponseEntity<Entregador> save(@RequestBody EntregadorRequest request) {

        Entregador entregador = entregadorService.save(request.build());
        return new ResponseEntity<Entregador>(entregador, HttpStatus.CREATED);
    }


    @Operation(
        summary = "Serviço responsável por buscar informações da API EntregadorController, como listar recursos ou obter detalhes específicos .",
        description = "será documentado como operações de leitura, exibindo os detalhes de cada endpoint associado a API EntregadorController, como os parâmetros necessários e as possíveis respostas."
    ) 
    @GetMapping
    public List<Entregador> listarTodos() {
        return entregadorService.listarTodos();
    }


    @Operation(
        summary = "Serviço é responsável por criar um endpoint na API que permite buscar ou consultar um EntregadorController com base no seu identificador (id).",
        description = "No Swagger, esse endpoint será documentado como uma operação HTTP GET acessível no caminho /EntregadorController/{id} espera receber um parâmetro de caminho (id), que é o identificador único do EntregadorController a ser buscado."
    )
    @GetMapping("/{id}")
    public Entregador obterPorID(@PathVariable Long id) {
        return entregadorService.obterPorID(id);
    }


    @Operation(
        summary = "Serviço é responsável por atualizar os dados de um EntregadorController existente com base no seu identificador (id).", 
        description = "No Swagger, ele será documentado como um endpoint que permite modificar informações de um EntregadorController já cadastrado."
    )
    @PutMapping("/{id}")
    public ResponseEntity<Entregador> update(@PathVariable("id") Long id, @RequestBody EntregadorRequest request) {

        entregadorService.update(id, request.build());
        return ResponseEntity.ok().build();
    }


    @Operation(
        summary = "Serviço é responsável por expor um endpoint HTTP DELETE que permite a exclusão de um EntregadorController com base no seu identificador (id).", 
        description = "ele será documentado como uma operação que realiza a exclusão de um recurso específico (neste caso, o EntregadorController) na API."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        entregadorService.delete(id);
        return ResponseEntity.ok().build();
    }

}
