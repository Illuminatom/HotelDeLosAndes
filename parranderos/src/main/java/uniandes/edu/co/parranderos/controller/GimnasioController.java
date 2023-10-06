package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.parranderos.modelo.Gimnasio;
import uniandes.edu.co.parranderos.modelo.ServicioBasico;
import uniandes.edu.co.parranderos.repositorio.GimnasioRepository;
import uniandes.edu.co.parranderos.repositorio.ServicioBasicoRepository;

import java.util.Collection;

@Controller
public class GimnasioController {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    @Autowired
    private ServicioBasicoRepository servicioBasicoRepository;

    @GetMapping("/servicios-basicos/gimnasios")
    public String gimnasios(Model model) {
        Collection<Gimnasio> gimnasios = gimnasioRepository.darGimnasios();
        model.addAttribute("gimnasios", gimnasios);
        return "gimnasios";
    }

    @GetMapping("/servicios-basicos/gimnasios/new")
    public String gimnasioForm(Model model) {
        model.addAttribute("servicioBasico", new ServicioBasico());
        model.addAttribute("gimnasio", new Gimnasio());
        return "gimnasioNuevo";
    }

    @PostMapping("/servicios-basicos/gimnasios/new/save")
    public String gimnasioGuardar(@ModelAttribute Gimnasio gimnasio, @ModelAttribute ServicioBasico servicioBasico) {
        servicioBasicoRepository.insertarServicioBasico(servicioBasico.getId(), servicioBasico.getNombre(), servicioBasico.getCapacidad());
        gimnasioRepository.insertarGimnasio(servicioBasico.getId(), gimnasio.getCosto());
        return "redirect:/servicios-basicos/gimnasios";
    }

    @GetMapping("/servicios-basicos/gimnasios/{id}/edit")
    public String gimnasioEditarForm(@PathVariable("id") int id, Model model) {
        ServicioBasico servicioBasico = servicioBasicoRepository.darServicioBasico(id);
        Gimnasio gimnasio = gimnasioRepository.darGimnasio(id);
        if (gimnasio != null) {
            model.addAttribute("gimnasio", gimnasio);
            model.addAttribute("servicioBasico", servicioBasico);
            return "gimnasioEditar";
        } else {
            return "redirect:/servicios-basicos/gimnasios";
        }
    }

    @PostMapping("/servicios-basicos/gimnasios/{id}/edit/save")
    public String gimnasioEditarGuardar(@PathVariable("id") int id, @ModelAttribute Gimnasio gimnasio, @ModelAttribute ServicioBasico servicioBasico) {
        servicioBasicoRepository.actualizarServicioBasico(servicioBasico.getId(), servicioBasico.getNombre(), servicioBasico.getCapacidad());
        gimnasioRepository.actualizarGimnasio(id, gimnasio.getCosto());
        return "redirect:/servicios-basicos/gimnasios";
    }

    @GetMapping("/servicios-basicos/gimnasios/{id}/delete")
    public String gimnasioBorrar(@PathVariable("id") int id) {
        gimnasioRepository.eliminarGimnasio(id);
        return "redirect:/servicios-basicos/gimnasios";
    }
}
