package com.example.demo2.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo2.application.models.Profissao;
import com.example.demo2.application.service.ProfissaoService;

@Controller
public class AppController {
	
	@Autowired ProfissaoService service;
	
	 @RequestMapping("/")
	 public String lista(Model model)
	 {
	 model.addAttribute("profissoes", service.listAll());
	 return "profissao";
	 }
	 
	@GetMapping("/new")
	public String showNewProfissaoPage(Model model) {
	 Profissao profissao = new Profissao();
	 model.addAttribute("profissao", profissao);
	 return "new_profissao";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProfissao(@ModelAttribute("usuario") Profissao profissao) {
	 service.save(profissao);

	 return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProfissaoPage(@PathVariable(name = "id") int id) {
	 ModelAndView mav = new ModelAndView("edit_profissao");
	 Profissao profissao = service.get(id);
	 mav.addObject("profissao", profissao);

	 return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteProfissao(@PathVariable(name = "id") int id) {
	 service.delete(id);
	 return "redirect:/";
	}

	
}
