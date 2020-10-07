package com.boot.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.boot.modelo.Persona;

@Controller
@RequestMapping("/proyecto")//ruta base   //  localhost:8090/proyecto/index
public class Controlador {

	
	// ejemplo con rutas
	@GetMapping({ "/", "/model", "/index" })// localhost:8090/index,  localhost:8090/model
	public String devolverIndex() {
		return "index";
	}

	// ejemplo con Model
	@GetMapping(value = "/home")// localhost:8090/home
	public String devolverModel(Model model) {
		String mensaje = "Hola Spring MVC 5";
		model.addAttribute("saludo", mensaje);
		return "index";
	}

	// ejemplo con ModelMap
	@GetMapping(value = "/modelMap") // localhost:8090/modelMap
	public String devolverModelMap(ModelMap modelMap) {
		String mensaje = "Hola Spring MVC 5 ModelMap";
		modelMap.addAttribute("saludo", mensaje);
		return "index";
	}

	// ejemplo con map
	@GetMapping(value = "/map") // localhost:8090/map
	public String devolverMap(Map<String, Object> map) {
		String mensaje = "Hola Spring MVC 5 Map<String, Object>";
		map.put("saludo", mensaje);
		return "index";
	}

	
	// ejemplo con modelAndView
		@GetMapping(value = "/modelAndView") // localhost:8090/modelAndView
		public ModelAndView devolverMap(ModelAndView modelAndView) {
			String mensaje = "Hola Spring MVC 5 Map<String, Object>";
			modelAndView.addObject("saludo", mensaje);
			modelAndView.setViewName("index");
			return modelAndView;
		}
		
		// ejemplo con Model  y llamando a un objeto
		@GetMapping(value = "/persona")// localhost:8090/proyecto/persona
		public String devolverPersona(Model model) {
			String mensaje = "Hola Spring MVC 5";
			List<Persona> lista=new ArrayList<>();
			Persona persona1=new Persona();
			persona1.setApellido("Ceron");
			persona1.setNombre("Luis");
			persona1.setCorreo("luis@gmail.com");
			
			Persona persona2=new Persona();
			persona2.setApellido("Ceron");
			persona2.setNombre("Juan");
			//persona2.setCorreo("Juan@gmail.com");
			lista.add(persona1);
			lista.add(persona2);
			model.addAttribute("listaPersona", lista);
			return "index";
		}
		
		
		
		// ejemplo con Model
		@GetMapping(value = "/parametros")// localhost:8090/proyecto/parametros?mensaje=hola&numero=3
		public String recibirParametro(@RequestParam() String mensaje,@RequestParam() int numero,
				Model model) {
			model.addAttribute("mensaje", "Mensaje recibido: "+mensaje +" parametro numero:"+  numero);
			return "parametros/parametro";
		}
		
		
}
