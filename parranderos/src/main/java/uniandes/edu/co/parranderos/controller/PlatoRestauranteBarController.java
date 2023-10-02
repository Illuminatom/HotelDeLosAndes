package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.parranderos.modelo.PlatosRestauranteBar;
import uniandes.edu.co.parranderos.repositorio.PlatosRestauranteBarRepository;

import java.util.Collection;

@Controller
public class PlatoRestauranteBarController {

    @Autowired
    PlatosRestauranteBarRepository platosRestauranteBarRepository;

    @GetMapping("/servicios-basicos/restaurantes-bares/{id}/menu")
    public String mostrarMenu(@PathVariable("id") int id, Model model) {
        Collection<PlatosRestauranteBar> menu = platosRestauranteBarRepository.darPlatosDeUnRestauranteBar(id);

        model.addAttribute("menu", menu);
        return "platosRestaurantesBares";
    }

    @PostMapping("/servicios-basicos/restaurantes-bares/{id}/menu/agregar-plato")
    public String agregarPlatoAlMenu(@PathVariable("id") int id, @RequestParam("platoId") int platoId) {
        platosRestauranteBarRepository.insertarPlatosRestauranteBar(id, platoId);
        return "redirect:/servicios-basicos/restaurantes-bares/" + id + "/menu";
    }

    @GetMapping("/servicios-basicos/restaurantes-bares/{id}/menu/quitar-plato/{platoId}")
    public String quitarPlatoDelMenu(@PathVariable("id") int id, @PathVariable("platoId") int platoId) {
        platosRestauranteBarRepository.eliminarPlatosRestauranteBar(id, platoId);
        return "redirect:/servicios-basicos/restaurantes-bares/" + id + "/menu";
    }
}
