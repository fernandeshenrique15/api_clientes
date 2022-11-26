package br.dev.duo.cidades.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.dev.duo.cidades.model.Cidade;
import br.dev.duo.cidades.model.Cliente;
import br.dev.duo.cidades.services.ClienteService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/cliente")
public class ClienteResource {
	
	@Autowired
	ClienteService service;
	
	@GetMapping
	@ApiOperation(value = "Lista todos clientes")
	public List<Cliente> listarTodos(){
		return service.listarTodos();
	}
	
	@PostMapping
	public Cliente cadastar(@RequestBody Cliente c) {
		return service.cadastrar(c);
	}
	
	@PutMapping
	public Cliente editar(@RequestBody Cliente c, @RequestParam Integer id) {
		c.setId(id);
		return service.cadastrar(c);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable("id") Integer id) {
		service.excluir(id);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Pesquisa por ID")
	public Cliente pesquisaPorId(@PathVariable("id") Integer id) {
		return service.pesquisarId(id);
	}
	
	@GetMapping("/cidade/{id}")
	@ApiOperation(value = "Consulta clientes de uma cidade")
	public List<Cliente> pesquisaPorCidade(@PathVariable("id") Integer id) {
		return service.listarPorCidade(id);
	}
}
