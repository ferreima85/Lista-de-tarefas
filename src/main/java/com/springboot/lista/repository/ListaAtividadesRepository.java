package com.springboot.lista.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.lista.models.ListaAtividades;

public interface ListaAtividadesRepository extends JpaRepository<ListaAtividades, Long>{
	
	ListaAtividades findById(long id);
	
}
