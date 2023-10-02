package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.parranderos.modelo.Lavanderia;
import uniandes.edu.co.parranderos.repositorio.LavanderiaRepository;

import java.util.Collection;

@Controller
public class LavanderiaController {

    @Autowired
    LavanderiaRepository lavanderiaRepository;

    @GetMapping("/servicios-basicos/lavanderias")
    public String lavanderias(Model model) {
        Collection<Lavanderia> lavanderias = lavanderiaRepository.darLavanderias();
        model.addAttribute("lavanderias", lavanderias);
        return "lavanderias";
    }

    @GetMapping("/servicios-basicos/lavanderias/new")
    public String lavanderiaForm(Model model) {
        model.addAttribute("lavanderia", new Lavanderia());
        return "lavanderiaNuevo";
    }

    @PostMapping("/servicios-basicos/lavanderias/new/save")
    public String lavanderiaGuardar(@ModelAttribute Lavanderia lavanderia) {
        lavanderiaRepository.insertarLavanderia(
            lavanderia.getPk().getId().getId(), 
            lavanderia.getCostoPorPrenda(), 
            lavanderia.getCostoPorParZapatos()
        );
        return "redirect:/servicios-basicos/lavanderias";
    }

    @GetMapping("/servicios-basicos/lavanderias/{id}/edit")
    public String lavanderiaEditarForm(@PathVariable("id") int id, Model model) {
        Lavanderia lavanderia = lavanderiaRepository.darLavanderia(id);
        if (lavanderia != null) {
            model.addAttribute("lavanderia", lavanderia);
            return "lavanderiaEditar";
        } else {
            return "redirect:/servicios-basicos/lavanderias";
        }
    }

    @PostMapping("/servicios-basicos/lavanderias/{id}/edit/save")
    public String lavanderiaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Lavanderia lavanderia) {
        lavanderiaRepository.actualizarLavanderia(
            id,
            lavanderia.getPk().getId().getId(),
            lavanderia.getCostoPorPrenda(),
            lavanderia.getCostoPorParZapatos()
        );
        return "redirect:/servicios-basicos/lavanderias";
    }

    @GetMapping("/servicios-basicos/lavanderias/{id}/delete")
    public String lavanderiaBorrar(@PathVariable("id") int id) {
        lavanderiaRepository.eliminarLavanderia(id);
        return "redirect:/servicios-basicos/lavanderias";
    }
}
