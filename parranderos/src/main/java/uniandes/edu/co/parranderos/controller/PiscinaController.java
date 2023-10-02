package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.parranderos.modelo.Piscina;
import uniandes.edu.co.parranderos.repositorio.PiscinaRepository;

import java.util.Collection;

@Controller
public class PiscinaController {

    @Autowired
    PiscinaRepository piscinaRepository;

    @GetMapping("/servicios-basicos/piscinas")
    public String piscinas(Model model) {
        Collection<Piscina> piscinas = piscinaRepository.darPiscinas();
        model.addAttribute("piscinas", piscinas);
        return "piscinas";
    }

    @GetMapping("/servicios-basicos/piscinas/new")
    public String piscinaForm(Model model) {
        model.addAttribute("piscina", new Piscina());
        return "piscinaNuevo";
    }

    @PostMapping("/servicios-basicos/piscinas/new/save")
    public String piscinaGuardar(@ModelAttribute Piscina piscina) {
        piscinaRepository.insertarPiscina(piscina.getPk().getId().getId(), piscina.getProfundidad(), piscina.getCosto());
        return "redirect:/servicios-basicos/piscinas";
    }

    @GetMapping("/servicios-basicos/piscinas/{id}/edit")
    public String piscinaEditarForm(@PathVariable("id") int id, Model model) {
        Piscina piscina = piscinaRepository.darPiscina(id);
        if (piscina != null) {
            model.addAttribute("piscina", piscina);
            return "piscinaEditar";
        } else {
            return "redirect:/servicios-basicos/piscinas";
        }
    }

    @PostMapping("/servicios-basicos/piscinas/{id}/edit/save")
    public String piscinaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Piscina piscina) {
        piscinaRepository.actualizarPiscina(id, piscina.getPk().getId().getId(), piscina.getProfundidad(), piscina.getCosto());
        return "redirect:/servicios-basicos/piscinas";
    }

    @GetMapping("/servicios-basicos/piscinas/{id}/delete")
    public String piscinaBorrar(@PathVariable("id") int id) {
        piscinaRepository.eliminarPiscina(id);
        return "redirect:/servicios-basicos/piscinas";
    }
}
