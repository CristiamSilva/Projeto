package br.com.zup.controleVeiculos.usuarios;

import br.com.zup.controleVeiculos.Exceptions.Excessoes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
//1
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    //2
    @PostMapping                                                                //3
    public ResponseEntity<?> cadastraUsuario(@RequestBody @Valid UsuarioRequest request){

        String cpf = request.getCpf();
        boolean existsByCpf = repository.existsByCpf(cpf);
        String email = request.getEmail();
        boolean existsByEmail = repository.existsByEmail(email);
        if(existsByCpf || existsByEmail){
            throw new Excessoes("");
        } //4
        Usuario usuario = request.toUsuario();
        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
