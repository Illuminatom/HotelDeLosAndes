package uniandes.edu.co.parranderos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uniandes.edu.co.parranderos.modelo.ServicioBasico;
import uniandes.edu.co.parranderos.repositorios.ServicioBasicoRepository;

@Controller
@RequestMapping("/servicios-basicos")
public class ServicioBasicoController {
    
    @Autowired
    private ServicioBasicoRepository servicioBasicoRepository;

    @GetMapping
    public String serviciosBasicos(Model model) {
        Collection<ServicioBasico> serviciosBasicos = servicioBasicoRepository.findAll();
        model.addAttribute("serviciosBasicos", serviciosBasicos);
        return "serviciosBasicos";
    }

    @GetMapping("/new")
    public String servicioBasicoForm(Model model) {
        model.addAttribute("servicioBasico", new ServicioBasico());
        return "servicioBasicoNuevo";
    }

    @PostMapping("/new/save")
    public String saveServicioBasico(ServicioBasico servicioBasico) {
        servicioBasicoRepository.save(servicioBasico);
        return "redirect:/servicios-basicos";
    }

    @GetMapping("/{id}/edit")
    public String servicioBasicoForm(@PathVariable("id") String id, Model model) {
        ServicioBasico servicioBasico = servicioBasicoRepository.findById(id);
        model.addAttribute("servicioBasico", servicioBasico);
        return "servicioBasicoEditar";
    }

    @PostMapping("/{id}/edit/save")
    public String updateServicioBasico(@PathVariable("id") String id, ServicioBasico servicioBasico) {
        servicioBasicoRepository.deleteById(id);
        servicioBasicoRepository.save(servicioBasico);
        return "redirect:/servicios-basicos";
    }

    @GetMapping("/{id}/delete")
    public String deleteServicioBasico(@PathVariable("id") String id) {
        servicioBasicoRepository.deleteById(id);
        return "redirect:/servicios-basicos";
    }
}
