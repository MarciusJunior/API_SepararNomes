package com.nomesapi.service;

import org.springframework.stereotype.Service;

import com.nomesapi.model.Nomes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.nomesapi.model.NomeSeparado;

@Service
public class NomesService {
	
	public NomeSeparado separarNome(String nome) {
		
		Nomes nomes = new Nomes();
		NomeSeparado nomeFinal = new NomeSeparado();

		nomes.setNomeInteiro(nome);		
		
		String[] PrimeiroNomeSeparado = nomes.getNomeInteiro().split("_");
		List<String> nomeSeparado = Arrays.asList(PrimeiroNomeSeparado);
		List<String> ultimoNomeSeparado = nomeSeparado.subList(1, nomeSeparado.size()-1);
		nomes.setPrimeiroNome(nomeSeparado.get(0));
		nomes.setUltimoNome(nomeSeparado.get(nomeSeparado.size()-1));
		nomeFinal.setPrimeiroNomeReturn(nomes.getPrimeiroNome());
		nomeFinal.setSobrenomeReturn(nomes.getUltimoNome());
		
		if(containsPenultimo(ultimoNomeSeparado)) {
	
			ultimoNomeSeparado = ultimoNomeSeparado.subList(0, ultimoNomeSeparado.size()-1);
			
		}
		
		for(int i = 0; i < ultimoNomeSeparado.size(); i++) {
			
			nomeFinal.setNomeDoMeio( nomeFinal.getNomeDoMeio() + " " + ultimoNomeSeparado.get(i));
			
		}
		
		nomeFinal.setNomeInteiro(nomeSeparado.stream().collect(Collectors.joining(" ")));

		return nomeFinal;
		
	}
	
	boolean containsPenultimo(List ultimoNomeSeparado){
		
			List<String> osD = new ArrayList<>();
			osD.add("de");
			osD.add("da");
			osD.add("das");
			osD.add("do");
			osD.add("dos");
			

	      if(osD.contains(ultimoNomeSeparado.get(ultimoNomeSeparado.size()-1))) {
	    	  return true;
	      } else {
	    	  return false;
	      }	      
	}

}
