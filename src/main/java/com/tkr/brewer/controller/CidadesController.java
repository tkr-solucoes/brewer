package com.tkr.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tkr.brewer.model.Cidade;


@Controller
public class CidadesController {
	
	@RequestMapping("/cidades/novo")
	public String novo(Model model) {
		model.addAttribute(new Cidade());
		return "cidade/CadastroCidade";
	}
	

}
