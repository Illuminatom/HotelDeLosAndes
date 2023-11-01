package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.parranderos.modelo.Piscina;
import uniandes.edu.co.parranderos.modelo.ServicioBasico;
import uniandes.edu.co.parranderos.repositorio.PiscinaRepository;
import uniandes.edu.co.parranderos.repositorio.ServicioBasicoRepository;

import java.util.Collection;

@Controller
public class PiscinaController {

    @Autowired
    PiscinaRepository piscinaRepository;

    @Autowired
    ServicioBasicoRepository servicioBasicoRepository;

    @GetMapping("/servicios-basicos/piscinas")
    public String piscinas(Model model) {
        Collection<Piscina> piscinas = piscinaRepository.darPiscinas();
        model.addAttribute("piscinas", piscinas);
        return "piscinas";
    }

    @GetMapping("/servicios-basicos/piscinas/new")
    public String piscinaForm(Model model) {
        model.addAttribute("piscina", new Piscina());
        model.addAttribute("servicioBasico", new ServicioBasico());
        return "piscinaNueva";
    }

    @PostMapping("/servicios-basicos/piscinas/new/save")
    public String piscinaGuardar(@ModelAttribute Piscina piscina, @ModelAttribute ServicioBasico servicioBasico) {
        servicioBasicoRepository.insertarServicioBasico(servicioBasico.getId(), servicioBasico.getNombre(), servicioBasico.getCapacidad(), servicioBasico.getCosto(), servicioBasico.getHora_apertura(), servicioBasico.getHora_cierre());
        piscinaRepository.insertarPiscina(servicioBasico.getId(), piscina.getProfundidad());
        return "redirect:/servicios-basicos/piscinas";
    }

    @GetMapping("/servicios-basicos/piscinas/{id}/edit")
    public String piscinaEditarForm(@PathVariable("id") int id, Model model) {
        ServicioBasico servicioBasico = servicioBasicoRepository.darServicioBasico(id);
        Piscina piscina = piscinaRepository.darPiscina(id);
        if (piscina != null && servicioBasico !=null) {
            model.addAttribute("piscina", piscina);
            model.addAttribute("servicioBasico", servicioBasico);
            return "piscinaEditar";
        } else {
            return "redirect:/servicios-basicos/piscinas";
        }
    }

    @PostMapping("/servicios-basicos/piscinas/{id}/edit/save")
    public String piscinaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Piscina piscina, @ModelAttribute ServicioBasico servicioBasico) {
        servicioBasicoRepository.actualizarServicioBasico(id, servicioBasico.getNombre(), servicioBasico.getCapacidad(), servicioBasico.getCosto(), servicioBasico.getHora_apertura(), servicioBasico.getHora_cierre());
        piscinaRepository.actualizarPiscina(id, servicioBasico.getId(), piscina.getProfundidad());
        return "redirect:/servicios-basicos/piscinas";
    }

    @GetMapping("/servicios-basicos/piscinas/{id}/delete")
    public String piscinaBorrar(@PathVariable("id") int id) {
        piscinaRepository.eliminarPiscina(id);
        return "redirect:/servicios-basicos/piscinas";
    }
}
