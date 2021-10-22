package co.com.project.HolaThymeleaf.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.project.HolaThymeleaf.domain.Persona;
import co.com.project.HolaThymeleaf.service.PersonaService;

@Controller
@RequestMapping("/")
public class ControllerInit {

    @Autowired
    private PersonaService personaService;
      
    @GetMapping("/inicio")
    public String inicio(Model model){
        
        var personas = personaService.listarPersonas();
        model.addAttribute("personas", personas);
        
        return "index";
    }

    @GetMapping("/inicio/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "modificar";
        }
            personaService.save(persona);
            return "redirect:/inicio";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(@Valid Persona persona, Model model, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "No se puede guardar";
        }
            persona = personaService.findPerson(persona);
            model.addAttribute("persona", persona);
            return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.delete(persona);
        return "redirect:/inicio";
    } 
}
