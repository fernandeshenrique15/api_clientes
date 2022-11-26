package br.dev.duo.cidades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.duo.cidades.model.Cidade;
import br.dev.duo.cidades.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	CidadeRepository rep;
	
	public Cidade incluir(Cidade c) {
		return rep.save(c);
	}
	
	public List<Cidade> listarTodas(){
		return rep.findAll();
	}
	
	public Cidade alterar(Cidade c) {
		return rep.save(c);
	}
	
	public void excluir(Integer id) {
		Cidade cidadeExcluir = rep.findById(id).get();
		if(cidadeExcluir != null) {
			rep.delete(cidadeExcluir);
		}
	}
	
	public List<Cidade> listarPorUf(String uf){
		return rep.findByUf(uf);
	}
	
}
