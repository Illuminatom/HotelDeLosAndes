package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.parranderos.modelo.Sala;
import uniandes.edu.co.parranderos.modelo.ServicioBasico;
import uniandes.edu.co.parranderos.repositorio.SalaRepository;
import uniandes.edu.co.parranderos.repositorio.ServicioBasicoRepository;

import java.util.Collection;

@Controller
public class SalaController {

    @Autowired
    SalaRepository salaRepository;
    
    @Autowired
    ServicioBasicoRepository servicioBasicoRepository;

    @GetMapping("/servicios-basicos/salas")
    public String salas(Model model) {
        Collection<Sala> salas = salaRepository.darSalas();
        model.addAttribute("salas", salas);
        return "salas";
    }

    @GetMapping("/servicios-basicos/salas/new")
    public String salaForm(Model model) {
        model.addAttribute("servicioBasico", new ServicioBasico());
        model.addAttribute("sala", new Sala());
        return "salaNuevo";
    }

    @PostMapping("/servicios-basicos/salas/new/save")
    public String salaGuardar(@ModelAttribute Sala sala, @ModelAttribute ServicioBasico servicioBasico) {
        servicioBasicoRepository.insertarServicioBasico(servicioBasico.getId(), servicioBasico.getNombre(), servicioBasico.getCapacidad());
        salaRepository.insertar(servicioBasico.getId(), sala.getTipo(), sala.getCosto());
        return "redirect:/servicios-basicos/salas";
    }

    @GetMapping("/servicios-basicos/salas/{id}/edit")
    public String salaEditarForm(@PathVariable("id") int id, Model model) {
        ServicioBasico servicioBasico = servicioBasicoRepository.darServicioBasico(id);
        Sala sala = salaRepository.darSala(id);
        if (sala != null) {
            model.addAttribute("sala", sala);
            model.addAttribute("servicioBasico", servicioBasico);
            return "salaEditar";
        } else {
            return "redirect:/servicios-basicos/salas";
        }
    }

    @PostMapping("/servicios-basicos/salas/{id}/edit/save")
    public String salaEditarGuardar(@PathVariable("id") int id, @ModelAttribute ServicioBasico servicioBasico, @ModelAttribute Sala sala) {
        servicioBasicoRepository.actualizarServicioBasico(id, servicioBasico.getNombre(), servicioBasico.getCapacidad());
        salaRepository.actualizarSala(id, servicioBasico.getId(), sala.getTipo(), sala.getCosto());
        return "redirect:/servicios-basicos/salas";
    }

    @GetMapping("/servicios-basicos/salas/{id}/delete")
    public String salaBorrar(@PathVariable("id") int id) {
        salaRepository.eliminarSala(id);
        return "redirect:/servicios-basicos/salas";
    }
}
