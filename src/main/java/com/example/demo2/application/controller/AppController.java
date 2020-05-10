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

import com.example.demo2.application.models.Usuario;
import com.example.demo2.application.service.UsuarioService;

@Controller
public class AppController {
	
	@Autowired UsuarioService service;
	
	 @RequestMapping("/caduser")
	 public String lista(Model model)
	 {
	 model.addAttribute("usuarios", service.listAll());
	 return "usuario";
	 }
	 
	 @RequestMapping("/")
	 public String lista()
	 {
	
	 return "Ola mundo";
	 }
	 
	 @RequestMapping("/welcome")
		public String welcomepage() {
			return "Welcome to Yawin Tutor";
		}
	 
	@GetMapping("/new")
	public String showNewUsuarioPage(Model model) {
	 Usuario usuario = new Usuario();
	 model.addAttribute("usuario", usuario);
	 return "new_usuario";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUsuario(@ModelAttribute("usuario") Usuario usuario) {
	 service.save(usuario);

	 return "redirect:/caduser";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditUsuarioPage(@PathVariable(name = "id") int id) {
	 ModelAndView mav = new ModelAndView("edit_usuario");
	 Usuario usuario = service.get(id);
	 mav.addObject("usuario", usuario);

	 return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteUsuario(@PathVariable(name = "id") int id) {
	 service.delete(id);
	 return "redirect:/caduser";
	}

	
}
