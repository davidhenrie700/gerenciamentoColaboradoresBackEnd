package com.david.colaboradores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.colaboradores.model.Colaborador;
import com.david.colaboradores.repositorio.ColaboradorRepositorio;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

	@Autowired
	private ColaboradorRepositorio colaboradorRepositorio;
	
	@GetMapping
	@CrossOrigin
	public List<Colaborador> Listar() {
		return colaboradorRepositorio.findAll();
	}

	@GetMapping(path = {"/{id}"})
	@CrossOrigin
	public Colaborador listarPorId(@PathVariable Long id) {
		return (colaboradorRepositorio.getById(id));
	}
	
	@PostMapping
	@CrossOrigin
	public Colaborador cadastrar(@RequestBody Colaborador colaborador) {
		return colaboradorRepositorio.save(colaborador);
	}
	
	@PutMapping
	@CrossOrigin
	public Colaborador alterar(@RequestBody Colaborador colaborador) {
		return colaboradorRepositorio.save(colaborador);
	}
	
	@DeleteMapping(path = {"/{id}"})
	@CrossOrigin
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		System.out.println("aqui ");
		return colaboradorRepositorio.findById(id)
				.map(record -> {
					colaboradorRepositorio.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
}
