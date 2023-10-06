package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.parranderos.modelo.SPA;
import uniandes.edu.co.parranderos.modelo.ServicioBasico;
import uniandes.edu.co.parranderos.repositorio.SPARepository;
import uniandes.edu.co.parranderos.repositorio.ServicioBasicoRepository;

import java.util.Collection;

@Controller
public class SPAController {

    @Autowired
    SPARepository spaRepository;

    @Autowired
    ServicioBasicoRepository servicioBasicoRepository;

    @GetMapping("/servicios-basicos/spas")
    public String spas(Model model) {
        Collection<SPA> spas = spaRepository.darSpas();
        model.addAttribute("spas", spas);
        return "spas";
    }

    @GetMapping("/servicios-basicos/spas/new")
    public String spaForm(Model model) {
        model.addAttribute("servicioBasico", new ServicioBasico());
        model.addAttribute("spa", new SPA());
        return "spaNuevo";
    }

    @PostMapping("/servicios-basicos/spas/new/save")
    public String spaGuardar(@ModelAttribute SPA spa, @ModelAttribute ServicioBasico servicioBasico) {
        servicioBasicoRepository.insertarServicioBasico(servicioBasico.getId(), servicioBasico.getNombre(), servicioBasico.getCapacidad());
        spaRepository.insertarSPA(servicioBasico.getId());
        return "redirect:/servicios-basicos/spas";
    }

    @GetMapping("/servicios-basicos/spas/{id}/edit")
    public String spaEditarForm(@PathVariable("id") int id, Model model) {
        ServicioBasico servicioBasico = servicioBasicoRepository.darServicioBasico(id);
        SPA spa = spaRepository.darSpaPorId(id);
        if (spa != null) {
            model.addAttribute("spa", spa);
            model.addAttribute("servicioBasico", servicioBasico);
            return "spaEditar";
        } else {
            return "redirect:/servicios-basicos/spas";
        }
    }

    @PostMapping("/servicios-basicos/spas/{id}/edit/save")
    public String spaEditarGuardar(@PathVariable("id") int id, @ModelAttribute SPA spa, @ModelAttribute ServicioBasico servicioBasico) {
        servicioBasicoRepository.actualizarServicioBasico(id, servicioBasico.getNombre(), servicioBasico.getCapacidad());
        spaRepository.actualizarSPA(id, servicioBasico.getId());
        return "redirect:/servicios-basicos/spas";
    }

    @GetMapping("/servicios-basicos/spas/{id}/delete")
    public String spaBorrar(@PathVariable("id") int id) {
        spaRepository.eliminarSPA(id);
        return "redirect:/servicios-basicos/spas";
    }
}
