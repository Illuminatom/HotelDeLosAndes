package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.parranderos.modelo.ServicioBasico;
import uniandes.edu.co.parranderos.repositorio.ServicioBasicoRepository;

import java.util.Collection;

@Controller
public class ServicioBasicoController {

    @Autowired
    ServicioBasicoRepository servicioBasicoRepository;

    @GetMapping("/servicios-basicos")
    public String serviciosBasicos(Model model) {
        Collection<ServicioBasico> serviciosBasicos = servicioBasicoRepository.darServiciosBasicos();
        model.addAttribute("serviciosBasicos", serviciosBasicos);
        return "serviciosBasicos";
    }

    @GetMapping("/servicios-basicos/new")
    public String servicioBasicoForm(Model model) {
        model.addAttribute("crear", true);
        model.addAttribute("servicioBasico", new ServicioBasico());
        return "servicioBasicoNuevo";
    }

    @PostMapping("/servicios-basicos/new/save")
    public String servicioBasicoGuardar(@ModelAttribute ServicioBasico servicioBasico) {
        servicioBasicoRepository.insertarServicioBasico(servicioBasico.getId(), servicioBasico.getNombre(), servicioBasico.getCapacidad());
        return "redirect:/servicios-basicos";
    }

    @GetMapping("/servicios-basicos/{id}/edit")
    public String servicioBasicoEditarForm(@PathVariable("id") int id, Model model) {
        ServicioBasico servicioBasico = servicioBasicoRepository.darServicioBasico(id);
        if (servicioBasico != null) {
            model.addAttribute("servicioBasico", servicioBasico);
            return "servicioBasicoEditar";
        } else {
            return "redirect:/servicios-basicos";
        }
    }

    @PostMapping("/servicios-basicos/{id}/edit/save")
    public String servicioBasicoEditarGuardar(@PathVariable("id") int id, @ModelAttribute ServicioBasico servicioBasico) {
        servicioBasicoRepository.actualizarServicioBasico(id, servicioBasico.getNombre(), servicioBasico.getCapacidad());
        return "redirect:/servicios-basicos";
    }

    @GetMapping("/servicios-basicos/{id}/delete")
    public String servicioBasicoBorrar(@PathVariable("id") int id) {
        servicioBasicoRepository.eliminarServicioBasico(id);
        return "redirect:/servicios-basicos";
    }
}
