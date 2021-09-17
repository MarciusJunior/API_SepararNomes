package com.nomesapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nomesapi.model.NomeSeparado;
import com.nomesapi.service.NomesService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/nomecompleto")
public class NomesController {
	
	private NomesService nomesService;
	
	@GetMapping(value = "/nomes")
	public NomeSeparado nomeCompletoSeparado(@RequestParam String nome) {
				return nomesService.separarNome(nome);
		
	}

}
