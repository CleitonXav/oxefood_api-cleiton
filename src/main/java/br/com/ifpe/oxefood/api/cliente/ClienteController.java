package br.com.ifpe.oxefood.api.cliente;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.acesso.UsuarioService;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;
import br.com.ifpe.oxefood.modelo.cliente.EnderecoCliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin
@Tag(
    name = "API Cliente",
    description = "API responsável pelos servçios de cliente no sistema"
)

public class ClienteController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(
        summary = "Serviço responsável por buscar informações da API, como listar recursos ou obter detalhes específicos.",
        description = "será documentado como operações de leitura, exibindo os detalhes de cada endpoint associado, como os parâmetros necessários e as possíveis respostas."
    )
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }


    @Operation(
        summary = "Serviço é responsável por criar um endpoint na API que permite buscar ou consultar um cliente com base no seu identificador (id).",
        description = "No Swagger, esse endpoint será documentado como uma operação HTTP GET acessível no caminho /clientes/{id} espera receber um parâmetro de caminho (id), que é o identificador único do cliente a ser buscado."
    )
    @GetMapping("/{id}")
    public Cliente obterPorID(@PathVariable Long id) {
        return clienteService.obterPorID(id);
    }


    @Operation(
        summary = "Serviço é responsável por atualizar os dados de um cliente existente com base no seu identificador (id).",
        description = "No Swagger, ele será documentado como um endpoint que permite modificar informações de um cliente já cadastrado."
    )
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id,
     @RequestBody @Valid ClienteRequest clienteRequest, HttpServletRequest request) {

        clienteService.update(id, clienteRequest.build(), null);
        return ResponseEntity.ok().build();
     }      

    @Autowired
    private ClienteService clienteService;


    @Operation(
        summary = "Serviço é responsável por definir um endpoint HTTP POST que permite criar um novo cliente.",
        description = "Ele será documentado como uma operação para cadastrar um novo cliente enviando os dados necessários no corpo da requisição."
    ) 
    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteRequest clienteRequest, HttpServletRequest request) {
        
        Cliente cliente = clienteService.save(clienteRequest.build(),
        usuarioService.obterUsuarioLogado(request));
        return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
    }


    @Operation(
        summary = "Serviço é responsável por expor um endpoint HTTP DELETE que permite a exclusão de um cliente com base no seu identificador (id).",
        description = "ele será documentado como uma operação que realiza a exclusão de um recurso específico (neste caso, o cliente) na API."
    ) 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }


    @Operation(
        summary = "Serviço é responsável por adicionar um novo endereço para um cliente existente, utilizando o clienteId para associar o endereço ao cliente correto.",
        description = "ele será documentado como um endpoint que permite cadastrar um novo endereço para um cliente específico."
    ) 
    @PostMapping("/endereco/{clienteId}")
    public ResponseEntity<EnderecoCliente> adicionarEnderecoCliente(@PathVariable("clienteId") Long clienteId,
    @RequestBody @Valid EnderecoClienteRequest request) {

        EnderecoCliente endereco = clienteService.adicionarEnderecoCliente(clienteId, request.build());
        return new ResponseEntity<EnderecoCliente>(endereco, HttpStatus.CREATED);
    }


    @Operation(
        summary = "Serviço responsável por definir endpoints PUT que permitem atualizar informações relacionadas ao endereço de um cliente na API.",
        description = "Esses endpoints serão documentados como operações de atualização de dados de endereço."
    ) 
    @PutMapping("/endereco/{enderecoId}")
    public ResponseEntity<EnderecoCliente> atualizarEnderecoCliente(@PathVariable("enderecoId") Long enderecoId, @RequestBody EnderecoClienteRequest request) {

        EnderecoCliente endereco = clienteService.atualizarEnderecoCliente(enderecoId, request.build());
        return new ResponseEntity<EnderecoCliente>(endereco, HttpStatus.OK);
    }


    @Operation(
        summary = "Serviço é responsável por criar um endpoint que permite excluir um endereço identificado pelo {enderecoId}.",
        description = "No Swagger, ele será documentado como uma operação HTTP DELETE para o endpoint /endereco/{enderecoId}."
    )    
    @DeleteMapping("/endereco/{enderecoId}")
    public ResponseEntity<Void> removerEnderecoCliente(@PathVariable("enderecoId") Long enderecoId) {

        clienteService.removerEnderecoCliente(enderecoId);
        return ResponseEntity.noContent().build();
    }

}
