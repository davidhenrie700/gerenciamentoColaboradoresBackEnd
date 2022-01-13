package com.david.colaboradores.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.david.colaboradores.model.Colaborador;

@Repository
public interface ColaboradorRepositorio extends JpaRepository<Colaborador, Long>{
	
}
