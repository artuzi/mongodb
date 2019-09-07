package com.artuzi.infinitymongo.controller;

import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.artuzi.infinitymongo.dao.DiariaRepository;
import com.artuzi.infinitymongo.dao.MovimentoRepository;
import com.artuzi.infinitymongo.dao.SequenceRepository;
import com.artuzi.infinitymongo.dto.MovimentoDTO;
import com.artuzi.infinitymongo.entity.Movimento;
import com.artuzi.infinitymongo.util.Diarias;


@RestController
@RequestMapping("/mongo")
public class Aplicacao {

	Logger logger = LoggerFactory.getLogger(Aplicacao.class);	

	@Autowired
	private MovimentoRepository ocorrenciasRepository;
	
	@Autowired
	private Diarias diariasService;	
	
	@RequestMapping(method = RequestMethod.POST, value="/insert")
	public ResponseEntity<ArrayList<Movimento>> insertMovimento(@RequestBody ArrayList<MovimentoDTO> movimentosDTO) {
		
		ArrayList<Movimento> movimentos = new ArrayList<Movimento>();
		
		Date diaria = new Date();
		Long id = diariasService.geraNovaDiaria(diaria);

		for (MovimentoDTO movimentoDTO: movimentosDTO) {
			Movimento mov = new Movimento();
			mov.setId(id);
			mov.setDescricao(movimentoDTO.getDescricao());
			mov.setValor(movimentoDTO.getValor());
			movimentos.add(mov);
		}
		
		ocorrenciasRepository.saveAll(movimentos);
		
		logger.info("Insert processado. Inseridos " + movimentos.size());
		
		return new ResponseEntity<>(movimentos,HttpStatus.OK);
	}
	
	@GetMapping("/find/{descricao}")	
	public ResponseEntity<ArrayList<Movimento>> buscaMovimento(@PathVariable String descricao) {
		
		ArrayList<Movimento> movimento = ocorrenciasRepository.findByDescricao(descricao);
		
		if (movimento.size() != 0) {
			logger.info("Encontrado movimento");
		} else {
			logger.error("Nao encontrado Movimento: " + descricao);
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(movimento,HttpStatus.OK);
	}
	
	
}
