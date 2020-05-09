package com.example.demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo2.DemoModel;
import com.example.demo2.service.UsuarioService;


public class AppController {
	
	@Autowired UsuarioService service;
	
//	@RequestMapping(value="/")
//	public String form(){
//		return "usuario";
//	}
//	
	 @RequestMapping("/")
	 public String lista(Model model)
	 {
	 model.addAttribute("usuarios", service.listAll());
	 return "usuario";
	 }
	 
	@RequestMapping("/new_usuario")
	public String showNewUsuarioPage(Model model) {
	 DemoModel usuario = new DemoModel();
	 model.addAttribute("usuario", usuario);
	 return "new_usuario";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUsuario(@ModelAttribute("usuario") DemoModel usuario) {
	 service.save(usuario);

	 return "redirect:/caduser";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditUsuarioPage(@PathVariable(name = "id") int id) {
	 ModelAndView mav = new ModelAndView("edit_usuario");
	 DemoModel usuario = service.get(id);
	 mav.addObject("usuario", usuario);

	 return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteUsuario(@PathVariable(name = "id") int id) {
	 service.delete(id);
	 return "redirect:/caduser";
	}

	
}
