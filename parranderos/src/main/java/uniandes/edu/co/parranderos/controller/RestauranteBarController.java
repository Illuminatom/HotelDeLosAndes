package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.parranderos.modelo.RestauranteBar;
import uniandes.edu.co.parranderos.modelo.ServicioBasico;
import uniandes.edu.co.parranderos.repositorio.RestauranteBarRepository;
import uniandes.edu.co.parranderos.repositorio.ServicioBasicoRepository;

import java.util.Collection;

@Controller
public class RestauranteBarController {

    @Autowired
    RestauranteBarRepository restauranteBarRepository;
    
    @Autowired
    ServicioBasicoRepository servicioBasicoRepository;

    @GetMapping("/servicios-basicos/restaurantes-bares")
    public String restaurantesBares(Model model) {
        Collection<RestauranteBar> restaurantesBares = restauranteBarRepository.darRestaurantesBares();
        model.addAttribute("restaurantesBares", restaurantesBares);
        return "restaurantesBares";
    }

    @GetMapping("/servicios-basicos/restaurantes-bares/new")
    public String restauranteBarForm(Model model) {
        model.addAttribute("restauranteBar", new RestauranteBar());
        model.addAttribute("servicioBasico", new ServicioBasico());
        return "restauranteBarNuevo";
    }

    @PostMapping("/servicios-basicos/restaurantes-bares/new/save")
    public String restauranteBarGuardar(@ModelAttribute RestauranteBar restauranteBar, @ModelAttribute ServicioBasico servicioBasico) {
        servicioBasicoRepository.insertarServicioBasico(servicioBasico.getId(), servicioBasico.getNombre(), servicioBasico.getCapacidad());
        restauranteBarRepository.insertarRestauranteBar(servicioBasico.getId(), restauranteBar.getEstilo());
        return "redirect:/servicios-basicos/restaurantes-bares";
    }

    @GetMapping("/servicios-basicos/restaurantes-bares/{id}/edit")
    public String restauranteBarEditarForm(@PathVariable("id") int id, Model model) {
        RestauranteBar restauranteBar = restauranteBarRepository.darRestauranteBar(id);
        ServicioBasico servicioBasico = servicioBasicoRepository.darServicioBasico(id);
        if (restauranteBar != null && servicioBasico != null) {
            model.addAttribute("restauranteBar", restauranteBar);
            model.addAttribute("servicioBasico", servicioBasico);
            return "restauranteBarEditar";
        } else {
            return "redirect:/servicios-basicos/restaurantes-bares";
        }
    }

    @PostMapping("/servicios-basicos/restaurantes-bares/{id}/edit/save")
    public String restauranteBarEditarGuardar(@PathVariable("id") int id, @ModelAttribute ServicioBasico servicioBasico, @ModelAttribute RestauranteBar restauranteBar) {
        servicioBasicoRepository.actualizarServicioBasico(id, servicioBasico.getNombre(), servicioBasico.getCapacidad());
        restauranteBarRepository.actualizarRestauranteBar(id, servicioBasico.getId(), restauranteBar.getEstilo());
        return "redirect:/servicios-basicos/restaurantes-bares";
    }

    @GetMapping("/servicios-basicos/restaurantes-bares/{id}/delete")
    public String restauranteBarBorrar(@PathVariable("id") int id) {
        restauranteBarRepository.eliminarRestauranteBar(id);
        return "redirect:/servicios-basicos/restaurantes-bares";
    }
}
