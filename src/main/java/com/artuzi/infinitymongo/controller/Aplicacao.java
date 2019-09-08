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
import com.artuzi.infinitymongo.dto.ProdutoExternoDTO;
import com.artuzi.infinitymongo.entity.Diaria;
import com.artuzi.infinitymongo.entity.Movimento;
import com.artuzi.infinitymongo.service.DiariaService;
import com.artuzi.infinitymongo.service.MovimentoService;
import com.artuzi.infinitymongo.service.ProdutoExternoService;


@RestController
@RequestMapping("/mongo")
public class Aplicacao {

	Logger logger = LoggerFactory.getLogger(Aplicacao.class);	

	@Autowired
	private DiariaService diariaService;	
	
	@Autowired
	private MovimentoService movimentoService;
	
	@Autowired
	private ProdutoExternoService produtoExternoService;
	
	@RequestMapping(method = RequestMethod.POST, value="/insert")
	public ResponseEntity<ArrayList<Movimento>> insertMovimento(@RequestBody ArrayList<MovimentoDTO> movimentosDTO) {
		
		
		ArrayList<Movimento> movimentos = new ArrayList<Movimento>();
		
		Date diaria = new Date();

		ArrayList<ProdutoExternoDTO> produtosExternosDTO = produtoExternoService.findProdutoExternoAtivo(diaria);
		
		for (ProdutoExternoDTO produtoExternoDTO: produtosExternosDTO) {
		
			Long idDiaria = diariaService.geraNovaDiaria(diaria, produtoExternoDTO.getCodProduto(), produtoExternoDTO.getCodCanal(), produtoExternoDTO.getCodEmpresa());
	
			for (MovimentoDTO movimentoDTO: movimentosDTO) {
				Movimento mov = new Movimento();
				mov.setIdDiaria(idDiaria);
				mov.setDescricao(movimentoDTO.getDescricao());
				mov.setValor(movimentoDTO.getValor());
				mov.setStatus("PEN");
				movimentos.add(mov);
			}
			
			movimentoService.saveMovimentos(movimentos);
			
			logger.info("Insert processado. Inseridos " + movimentos.size());
		}
		
		return new ResponseEntity<>(movimentos,HttpStatus.OK);
	}
	
	@GetMapping("/find/{descricao}")	
	public ResponseEntity<ArrayList<Movimento>> buscaMovimento(@PathVariable String descricao) {
		
		ArrayList<Movimento> movimento = movimentoService.findMovimentoByDescricao(descricao);
		
		if (movimento.size() != 0) {
			logger.info("Encontrado movimento");
		} else {
			logger.error("Nao encontrado Movimento: " + descricao);
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(movimento,HttpStatus.OK);
	}
	

	@GetMapping("/findDiariasPendentes")	
	public ResponseEntity<ArrayList<Diaria>> findDiariasPendentes() {
	
		logger.info("Retornando diarias pendentes");
		ArrayList<Diaria> diarias = diariaService.findDiariasStatus("PEN");
		
		return new ResponseEntity<>(diarias,HttpStatus.OK);
	
	}

	@GetMapping("/findMovimentoDiaria/{idDiaria}")	
	public ResponseEntity<ArrayList<Movimento>> findMovimentoDiaria(@PathVariable Long idDiaria) {
	
		logger.info("Retornando movimentos da diaria");
		ArrayList<Movimento> movimentos = movimentoService.findMovimentoByIdDiaria(idDiaria);
		
		return new ResponseEntity<>(movimentos,HttpStatus.OK);
	}
}
