package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.parranderos.modelo.Gimnasio;
import uniandes.edu.co.parranderos.repositorio.GimnasioRepository;

import java.util.Collection;

@Controller
public class GimnasioController {

    @Autowired
    GimnasioRepository gimnasioRepository;

    @GetMapping("/servicios-basicos/gimnasios")
    public String gimnasios(Model model) {
        Collection<Gimnasio> gimnasios = gimnasioRepository.darGimnasios();
        model.addAttribute("gimnasios", gimnasios);
        return "gimnasios";
    }

    @GetMapping("/servicios-basicos/gimnasios/new")
    public String gimnasioForm(Model model) {
        model.addAttribute("gimnasio", new Gimnasio());
        return "gimnasioNuevo";
    }

    @PostMapping("/servicios-basicos/gimnasios/new/save")
    public String gimnasioGuardar(@ModelAttribute Gimnasio gimnasio) {
        gimnasioRepository.insertarGimnasio(gimnasio.getPk().getId().getId(), gimnasio.getCosto());
        return "redirect:/servicios-basicos/gimnasios";
    }

    @GetMapping("/servicios-basicos/gimnasios/{id}/edit")
    public String gimnasioEditarForm(@PathVariable("id") int id, Model model) {
        Gimnasio gimnasio = gimnasioRepository.darGimnasio(id);
        if (gimnasio != null) {
            model.addAttribute("gimnasio", gimnasio);
            return "gimnasioEditar";
        } else {
            return "redirect:/servicios-basicos/gimnasios";
        }
    }

    @PostMapping("/servicios-basicos/gimnasios/{id}/edit/save")
    public String gimnasioEditarGuardar(@PathVariable("id") int id, @ModelAttribute Gimnasio gimnasio) {
        gimnasioRepository.actualizarGimnasio(id, gimnasio.getCosto());
        return "redirect:/servicios-basicos/gimnasios";
    }

    @GetMapping("/servicios-basicos/gimnasios/{id}/delete")
    public String gimnasioBorrar(@PathVariable("id") int id) {
        gimnasioRepository.eliminarGimnasio(id);
        return "redirect:/servicios-basicos/gimnasios";
    }
}
