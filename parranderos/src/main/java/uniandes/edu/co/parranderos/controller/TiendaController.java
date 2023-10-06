package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.parranderos.modelo.ServicioBasico;
import uniandes.edu.co.parranderos.modelo.Tienda;
import uniandes.edu.co.parranderos.repositorio.ServicioBasicoRepository;
import uniandes.edu.co.parranderos.repositorio.TiendaRepository;

import java.util.Collection;

@Controller
public class TiendaController {

    @Autowired
    TiendaRepository tiendaRepository;

    @Autowired
    ServicioBasicoRepository servicioBasicoRepository;

    @GetMapping("/servicios-basicos/tiendas")
    public String tiendas(Model model) {
        Collection<Tienda> tiendas = tiendaRepository.darTiendas();
        model.addAttribute("tiendas", tiendas);
        return "tiendas";
    }

    @GetMapping("/servicios-basicos/tiendas/new")
    public String tiendaForm(Model model) {
        model.addAttribute("servicioBasico", new ServicioBasico());
        model.addAttribute("tienda", new Tienda());
        return "tiendaNueva";
    }

    @PostMapping("/servicios-basicos/tiendas/new/save")
    public String tiendaGuardar(@ModelAttribute Tienda tienda, @ModelAttribute ServicioBasico servicioBasico) {
        servicioBasicoRepository.insertarServicioBasico(servicioBasico.getId(), servicioBasico.getNombre(), servicioBasico.getCapacidad());
        tiendaRepository.insertarTienda(servicioBasico.getId(), tienda.getTipo());
        return "redirect:/servicios-basicos/tiendas";
    }

    @GetMapping("/servicios-basicos/tiendas/{id}/edit")
    public String tiendaEditarForm(@PathVariable("id") int id, Model model) {
        ServicioBasico servicioBasico = servicioBasicoRepository.darServicioBasico(id);
        Tienda tienda = tiendaRepository.darTiendaPorId(id);
        if (tienda != null) {
            model.addAttribute("tienda", tienda);
            model.addAttribute("servicioBasico", servicioBasico);
            return "tiendaEditar";
        } else {
            return "redirect:/servicios-basicos/tiendas";
        }
    }

    @PostMapping("/servicios-basicos/tiendas/{id}/edit/save")
    public String tiendaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Tienda tienda, @ModelAttribute ServicioBasico servicioBasico) {
        servicioBasicoRepository.actualizarServicioBasico(id, servicioBasico.getNombre(), servicioBasico.getCapacidad());
        tiendaRepository.actualizarTienda(id, servicioBasico.getId(), tienda.getTipo());
        return "redirect:/servicios-basicos/tiendas";
    }

    @GetMapping("/servicios-basicos/tiendas/{id}/delete")
    public String tiendaBorrar(@PathVariable("id") int id) {
        tiendaRepository.eliminarTienda(id);
        return "redirect:/servicios-basicos/tiendas";
    }
}
