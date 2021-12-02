package br.org.generation.blogPessoal.blogPessoal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.org.generation.blogPessoal.blogPessoal.Model.Postagem;
import br.org.generation.blogPessoal.blogPessoal.repository.PostagemRepository;

@RestController  // indica para o Spring que essa classe será identificada como restController
@RequestMapping("/postagens")  // define o nosso endpoint, isto é, o URI pelo qual nossa classe será acessada e 
//devemos indicar um parâmetro no qual a requisição passa a consumir essa classe. 
@CrossOrigin("*") // essa sinal de *colocado em entre aspas duplas define que nossa classe pode ser acessada por qualquer origem

public class PostagemController {

	@Autowired
	private PostagemRepository repository; // lembre-se que isso aqui é uma interface portanto não conseguimos instanciar e
//então usamos injeção de dependência, deixando o trabalho de instanciar a intergace para o Spring através do @AutoWired

	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll(){
          return ResponseEntity.ok(repository.findAll());

	}
}
