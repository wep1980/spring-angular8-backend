package br.com.waldirep.springangular.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.waldirep.springangular.model.Usuario;
import br.com.waldirep.springangular.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class IndexController {
	
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/**
	 * Metodo de teste inicial
	 * @return
	 */
	/*@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity init(){
		return new ResponseEntity("Ola USUARIO REST Spring boot Teste", HttpStatus.OK);
	}*/
	
	
	/**
	 * Metodo que pega um parametro digitado na URL
	 * 
	 * URL com 1 parametro -> http://localhost:8080/usuario/?nome=Waldir%20escouto%20pereira
	 * URL com 2 parametros ou mais -> http://localhost:8080/usuario/?nome=Waldir%20escouto%20pereira&idade=40
	 * defaultValue = "Nome não informado" -> valor padrão caso o nome não seja informado
	 * required = false -> o parametro não e obrigatorio
	 * @param nome
	 * @return
	 */
	/*@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity initRecebendoParametro(@RequestParam (value = "nome", defaultValue = "Nome não informado") String nome, 
			@RequestParam(value = "idade") String idade){
		
		System.out.println("Parametro sendo recebido " + nome + "E sua idade é : " + idade);
		
		return new ResponseEntity("Ola USUARIO REST Spring boot seu nome é : " + nome + "e sua idade é : " + idade, HttpStatus.OK);
	}*/
	
	
	/**
	 * Metodo que busca um usuario por ID do banco de dados
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Usuario> init(@PathVariable(value = "id") Long id) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return new  ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	}
	
	
	
	/**
	 * Metodo que retorna uma lista de usuarios
	 * @return
	 */
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> listUsers(){
		
		List<Usuario> list = usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}
	
	
	
	/**
	 * Metodo que salva um usuario e os telefones
	 * @param usuario
	 * @return
	 */
	@PostMapping(value = "/")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
		
		for(int pos = 0; pos < usuario.getTelefones().size(); pos++) {
			usuario.getTelefones().get(pos).setUsuario(usuario);
		}
		
		Usuario user = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}
	
	
	/**
	 * Metodo que atualiza o usuario
	 * O metodo save do JPA salva ou atualiza, se vier um id ele atualiza, se não existir um id ele cria um usuario novo
	 * @param usuario
	 * @return
	 */
	@PutMapping(value = "/")
	public ResponseEntity<Usuario> atualizar (@RequestBody Usuario usuario){
		
		Usuario user = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}
	
	
	
	/**
	 * Metodo que deleta
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/{id}", produces = "application/text")
	public String delete(@PathVariable(value = "id") Long id) {
		
		 usuarioRepository.deleteById(id);
		
		return("OK");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
