package br.com.ifpe.oxefood.api.funcionario;

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

import br.com.ifpe.oxefood.modelo.acesso.Perfil;
import br.com.ifpe.oxefood.modelo.funcionario.Funcionario;
import br.com.ifpe.oxefood.modelo.funcionario.FuncionarioService;
import br.com.ifpe.oxefood.modelo.funcionario.TipoFuncionario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/funcionario")
@CrossOrigin
@Tag(
    name = "API FuncionarioController",
    description = "API responsável pelos serviços de FuncionarioController no sistema"
)
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;


    @Operation(
        summary = "Serviço é responsável por definir um endpoint HTTP POST que permite criar um novo FuncionarioController.",
        description = "Ele será documentado como uma operação para cadastrar um novo FuncionarioController enviando os dados necessários no corpo da requisição."
    )
    @PostMapping
    public ResponseEntity<Funcionario> save(@RequestBody @Valid FuncionarioRequest request) {

        Funcionario funcionarioNovo = request.build();

        if (funcionarioNovo.getTipo().equals(TipoFuncionario.ADMINISTRADOR)) {
            funcionarioNovo.getUsuario().getRoles().add(new Perfil(Perfil.ROLE_FUNCIONARIO_ADMIN));
        } else if (funcionarioNovo.getTipo().equals(TipoFuncionario.OPERADOR)) {
            funcionarioNovo.getUsuario().getRoles().add(new Perfil(Perfil.ROLE_FUNCIONARIO_USER));
        }

        Funcionario funcionario = funcionarioService.save(funcionarioNovo);
        return new ResponseEntity<Funcionario>(funcionario, HttpStatus.CREATED);
    }


    @Operation(
        summary = "Serviço responsável por buscar informações da API FuncionarioController, como listar recursos ou obter detalhes específicos .",
        description = "será documentado como operações de leitura, exibindo os detalhes de cada endpoint associado a API FuncionarioController, como os parâmetros necessários e as possíveis respostas."
    )
    @GetMapping
    public List<Funcionario> listarTodos() {

        return funcionarioService.listarTodos();
    }


    @Operation(
        summary = "Serviço é responsável por criar um endpoint na API que permite buscar ou consultar um FuncionarioController com base no seu identificador (id).",
        description = "No Swagger, esse endpoint será documentado como uma operação HTTP GET acessível no caminho /FuncionarioController/{id} espera receber um parâmetro de caminho (id), que é o identificador único do FuncionarioController a ser buscado."
    )
    @GetMapping("/{id}")
    public Funcionario obterPorID(@PathVariable Long id) {

        return funcionarioService.obterPorID(id);
    }


    @Operation(
        summary = "Serviço é responsável por atualizar os dados de um FuncionarioController existente com base no seu identificador (id).", 
        description = "No Swagger, ele será documentado como um endpoint que permite modificar informações de um FuncionarioController já cadastrado."
    )
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable("id") Long id, @RequestBody FuncionarioRequest request) {

        funcionarioService.update(id, request.build());
        return ResponseEntity.ok().build();
    }


    @Operation(
        summary = "Serviço é responsável por expor um endpoint HTTP DELETE que permite a exclusão de um FuncionarioController com base no seu identificador (id).", 
        description = "ele será documentado como uma operação que realiza a exclusão de um recurso específico (neste caso, o FuncionarioController) na API."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        funcionarioService.delete(id);
        return ResponseEntity.ok().build();
    }

}
