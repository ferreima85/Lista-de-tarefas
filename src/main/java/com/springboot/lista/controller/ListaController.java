package com.springboot.lista.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.lista.models.ListaAtividades;
import com.springboot.lista.repository.ListaAtividadesRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ListaController {

	@Autowired
	ListaAtividadesRepository listaAtividadesRepository; 
	
//	@GetMapping("/atividades")
//	public List<ListaAtividades> getAllAtividades(){
//		return listaAtividadesRepository.findAll();
//	}
	
	@GetMapping("/atividades/usuarios/{usuario}/id/{id}")
	public ListaAtividades selecionarAtividade(@PathVariable(value="id") long id){
		return listaAtividadesRepository.findById(id);
	}
	
	@GetMapping("/usuarios/{usuario}/atividades")
	public List<ListaAtividades> getAllListaAtividades(@PathVariable String usuario){
		return listaAtividadesRepository.findAll();
	}
	
	@PostMapping("/usuarios/{usuario}/adicionarAtividade")
	public ListaAtividades adicionarAtividade(@RequestBody ListaAtividades listaAtividades) {
		return listaAtividadesRepository.save(listaAtividades);
	}
	
	@PutMapping("/usuarios/{usuario}/atualizarAtividade/id/{id}")
	public ListaAtividades atualizarAtividade(@RequestBody ListaAtividades listaAtividades) {
		return listaAtividadesRepository.save(listaAtividades); 
	}
	
	@DeleteMapping("/deletarAtividade")
	public void deletarAtividade(@RequestBody ListaAtividades listaAtividades) {
		listaAtividadesRepository.delete(listaAtividades);
	}
	
	@DeleteMapping("/apagarAtividade/id/{id}")
	public void apagarAtividade(@PathVariable(value="id") long id) {
		listaAtividadesRepository.deleteById(id);
	}
}
