package br.dev.duo.cidades.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.dev.duo.cidades.model.Cliente;

public interface ClienteRepository extends JpaRepositoryImplementation<Cliente, Integer>{
	public List<Cliente> findByCidadeId(Integer cidade);
}
