package com.tkr.brewer.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tkr.brewer.model.Cerveja;
import com.tkr.brewer.model.Origem;
import com.tkr.brewer.model.Sabor;
import com.tkr.brewer.repository.Estilos;
import com.tkr.brewer.service.CadastroCervejaService;


@Controller
public class CervejasController {	
	
	@Autowired
	private Estilos estilos;
	
	@Autowired
	private CadastroCervejaService cadastroCervejaService;
	
	
	@RequestMapping("/cervejas/novo")
	public ModelAndView novo(Cerveja cerveja) {
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		return mv;
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar( @Valid Cerveja cerveja, BindingResult result, Model model , RedirectAttributes attributs) {
		if (result.hasErrors()) {
			
			return novo(cerveja); 
		}
		cadastroCervejaService.salvar(cerveja);
		attributs.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		
		return new ModelAndView("redirect:/cervejas/novo");
	}
	
}
