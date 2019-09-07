package com.artuzi.infinitymongo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artuzi.infinitymongo.dao.SequenceRepository;
import com.artuzi.infinitymongo.entity.Sequence;

@Service
public class SequenceServiceImpl implements SequenceService {
	
	Logger logger = LoggerFactory.getLogger(SequenceServiceImpl.class);	
	
	@Autowired
	private SequenceRepository sequenceRepository;
	
	@Override
	public Long findNext(String name) {

		Long retorno = null;
		
		Sequence sequence = sequenceRepository.findByName(name);
		
		if (sequence == null) {
			Sequence seq = new Sequence();
			seq.setName(name);
			seq.setValue(1L);
			sequenceRepository.save(seq);
			
			retorno = seq.getValue();
			
		} else {
			
			sequence.setValue(sequence.getValue()+1L);
			sequenceRepository.save(sequence);
			
			retorno = sequence.getValue();
		}
		
		logger.info("Retornando valor " + retorno.toString() + " para sequence " + name);
		
		return retorno;
	}

}
