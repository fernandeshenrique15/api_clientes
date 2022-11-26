package br.dev.duo.cidades.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.duo.cidades.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	public List<Cidade> findByUf(String uf);
}
