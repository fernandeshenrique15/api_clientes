package br.dev.duo.cidades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.duo.cidades.model.Cidade;
import br.dev.duo.cidades.model.Cliente;
import br.dev.duo.cidades.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository rep;
	
	public List<Cliente> listarTodos(){
		return rep.findAll();
	}
	
	public List<Cliente> listarPorCidade(Integer cidade){
		return rep.findByCidadeId(cidade);
	}
	
	public Cliente cadastrar(Cliente c) {
		return rep.save(c);
	}
	
	public Cliente pesquisarId(Integer id) {
		return rep.findById(id).get();
	}
	
	public void excluir(Integer id) {
		rep.deleteById(id);
	}
}
