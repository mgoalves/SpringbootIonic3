package com.alves.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alves.exception.ObjectNotFoundException;
import com.alves.model.Categoria;
import com.alves.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	//Injections
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	//Buscar por ID
	public Categoria findById(Long id){
		
		Categoria categoria = categoriaRepository.findOne(id);
		
		if(categoria == null) {
			throw new ObjectNotFoundException("Objeto não encontrado. ID: " + id  
					+ ", Tipo: " + Categoria.class.getName());
		}
		
		return categoria;
	}


	//Salvar uma nova categoria
	public Categoria save(Categoria categoria) {
		
		categoria.setId(null);
		
		return categoriaRepository.save(categoria);
	}


	//Atualiza uma categoria
	public Categoria update(Long id, Categoria categoria) {
		
		findById(id);
		Categoria cat = categoriaRepository.save(categoria);
		
		return cat;
	}

}
