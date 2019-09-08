package com.artuzi.infinitymongo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.artuzi.infinitymongo.dto.ProdutoExternoDTO;

@Service
public class ProdutoExternoServiceImp implements ProdutoExternoService {

	Logger logger = LoggerFactory.getLogger(ProdutoExternoServiceImp.class);	
	
	String URL_MICROSERVICO = "http://localhost:8090";
	
	@Override
	public ArrayList<ProdutoExternoDTO> findProdutoExternoAtivo(Date diaria) {
		
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");

		String metodo = "/produtoExterno/findProdutoAtivo/";
		String url = URL_MICROSERVICO + metodo + formatter.format(diaria);
		
		logger.info("Acionando servico " + url);
		
		RestTemplate restTemplate = new RestTemplate();		
		
		ResponseEntity<ArrayList<ProdutoExternoDTO>> response = restTemplate.exchange(
				  url,
				  HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<ArrayList<ProdutoExternoDTO>>(){});
		
		return response.getBody();
	}

}
