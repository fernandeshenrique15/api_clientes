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
import br.dev.duo.cidades.services.CidadeService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/cidade")
public class CidadeResource {
	
	@Autowired
	CidadeService service;
	 
	@PostMapping
	@ApiOperation(value = "Cadastra uma cidade")
	public Cidade inserirCidade(@RequestBody Cidade c) {
		return service.incluir(c);	
	}
	
	@GetMapping
	@ApiOperation(value = "Lista todas cidades")
	public List<Cidade> listarTodas(){
		return service.listarTodas();
	}
	
	@GetMapping("/buscauf/{uf}")
	@ApiOperation(value = "Pesquisa cidades por UF")
	public List<Cidade> listarPorUf(@PathVariable("uf") String uf){
		return service.listarPorUf(uf);
	}
	
	@PutMapping
	@ApiOperation(value = "Altera uma cidade")
	public Cidade alterar(@RequestBody Cidade c, @RequestParam("id") Integer id) {
		c.setId(id);
		return service.alterar(c);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta uma cidade")
	public void excluir(@PathVariable("id") int id) {
		service.excluir(id);
	}
}
