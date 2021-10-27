package co.com.project.HolaThymeleaf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.com.project.HolaThymeleaf.domain.Persona;
import co.com.project.HolaThymeleaf.service.PersonaService;

@Controller()
public class ControllerInit {

    @Autowired
    private PersonaService personaService;
      
    @GetMapping("/")
    public String inicio(Model model){
        
        var personas = personaService.listarPersonas();
        model.addAttribute("personas", personas);
        var saldoTotal= 0D;
        for (var p : personas) {
            saldoTotal += p.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "modificar";
        }
            personaService.save(persona);
            return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model, BindingResult bindingResult){

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
        return "redirect:/";
    } 
}
