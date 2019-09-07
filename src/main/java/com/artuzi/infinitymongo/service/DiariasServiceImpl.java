package com.artuzi.infinitymongo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artuzi.infinitymongo.dao.DiariaRepository;
import com.artuzi.infinitymongo.entity.Diaria;


@Service
public class DiariasServiceImpl implements DiariasService {
	
	Logger logger = LoggerFactory.getLogger(DiariasServiceImpl.class);	
	
	@Autowired
	private SequenceService sequenceUtilService;
	
	@Autowired
	private DiariaRepository diariaRepository;
	
	@Override
	public Long geraNovaDiaria(Date diaria) {

		//nome da sequence que controla o sequencial de diarias, incluir no DTO pra agrupar movimentos
		Long id = sequenceUtilService.findNext("diariaSequence");
		
		if (diaria == null) {
			
			Date date = new Date(System.currentTimeMillis());

			logger.info("Nao foi informada data, atribuindo data padrao");

			diaria = date;
		}

		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		logger.info("Proxima sequence: " + id.toString() + " para " + formatter.format(diaria));

		Diaria dia = new Diaria();
		
		dia.setId(id);
		dia.setDiaria(diaria);
		dia.setStatus("PEN");    //Status inicial: pendente

		diariaRepository.save(dia);

		logger.info("Diaria registrada");
		
		return id;
	}

	@Override
	public ArrayList<Diaria> findDiariasStatus(String status) {

		return diariaRepository.findByStatus(status);
	}

}
