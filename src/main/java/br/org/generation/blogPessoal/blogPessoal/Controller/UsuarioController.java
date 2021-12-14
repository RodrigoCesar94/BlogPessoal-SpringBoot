package br.org.generation.blogPessoal.blogPessoal.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.blogPessoal.blogPessoal.Model.UserLogin;
import br.org.generation.blogPessoal.blogPessoal.Model.Usuario;
import br.org.generation.blogPessoal.blogPessoal.repository.UsuarioRepository;
import br.org.generation.blogPessoal.blogPessoal.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/all")
    public ResponseEntity <List<Usuario>> getAll(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @PostMapping("/logar")
    public ResponseEntity<UserLogin> login(@RequestBody Optional<UserLogin> user) {
        return usuarioService.autenticarUsuario(user)
            .map(resposta -> ResponseEntity.ok(resposta))
            .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> postUsuario(@Valid @RequestBody Usuario usuario) {

        return usuarioService.cadastrarUsuario(usuario)
            .map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
            .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
}
    @PutMapping("/atualizar")
    public ResponseEntity<Usuario> putUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(usuario)
            .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
