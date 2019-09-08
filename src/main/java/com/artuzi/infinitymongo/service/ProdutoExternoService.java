package com.artuzi.infinitymongo.service;

import java.util.ArrayList;
import java.util.Date;

import com.artuzi.infinitymongo.dto.ProdutoExternoDTO;

public interface ProdutoExternoService {

	ArrayList<ProdutoExternoDTO> findProdutoExternoAtivo(Date diaria);
}
