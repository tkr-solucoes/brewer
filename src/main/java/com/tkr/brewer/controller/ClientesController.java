package com.tkr.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;




import com.tkr.brewer.model.Cliente;


@Controller
public class ClientesController {
	
	@RequestMapping("/clientes/novo")
	public String novo(Model model) {
		model.addAttribute(new Cliente());
		return "cliente/CadastroCliente";
	}
	
	

}
