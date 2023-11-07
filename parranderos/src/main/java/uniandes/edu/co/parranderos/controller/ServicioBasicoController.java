package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.parranderos.modelo.ServicioBasico;
import uniandes.edu.co.parranderos.repositorio.ServicioBasicoRepository;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Locale;

@Controller
public class ServicioBasicoController {

    @Autowired
    ServicioBasicoRepository servicioBasicoRepository;

    @GetMapping("/servicios-basicos")
    public String serviciosBasicos(Model model, @RequestParam(name = "piso", required = false) Integer piso, @RequestParam(name = "techo", required = false) Integer techo) {
        
        if (piso == null) {
            piso = 0;
        }

        if (techo == null) {
            techo = 50;
        }

        Collection<ServicioBasico> serviciosBasicos = servicioBasicoRepository.darServiciosBasicosEnIntervalo(piso, techo);
        model.addAttribute("serviciosBasicos", serviciosBasicos);
        return "serviciosBasicos";
    }

    @GetMapping("/servicios-basicos/new")
    public String servicioBasicoForm(Model model) {
        model.addAttribute("crear", true);
        model.addAttribute("servicioBasico", new ServicioBasico());
        return "servicioBasicoNuevo";
    }

    @PostMapping("/servicios-basicos/new/save")
    public String servicioBasicoGuardar(@ModelAttribute ServicioBasico servicioBasico) {
        servicioBasicoRepository.insertarServicioBasico(servicioBasico.getId(), servicioBasico.getNombre(), servicioBasico.getCapacidad(), servicioBasico.getCosto(), servicioBasico.getHora_apertura(), servicioBasico.getHora_cierre());
        return "redirect:/servicios-basicos";
    }

    @GetMapping("/servicios-basicos/{id}/edit")
    public String servicioBasicoEditarForm(@PathVariable("id") int id, Model model) {
        ServicioBasico servicioBasico = servicioBasicoRepository.darServicioBasico(id);
        if (servicioBasico != null) {
            model.addAttribute("servicioBasico", servicioBasico);
            return "servicioBasicoEditar";
        } else {
            return "redirect:/servicios-basicos";
        }
    }

    @PostMapping("/servicios-basicos/{id}/edit/save")
    public String servicioBasicoEditarGuardar(@PathVariable("id") int id, @ModelAttribute ServicioBasico servicioBasico) {
        servicioBasicoRepository.actualizarServicioBasico(id, servicioBasico.getNombre(), servicioBasico.getCapacidad(), servicioBasico.getCosto(), servicioBasico.getHora_apertura(), servicioBasico.getHora_cierre());
        return "redirect:/servicios-basicos";
    }

    @GetMapping("/servicios-basicos/{id}/delete")
    public String servicioBasicoBorrar(@PathVariable("id") int id) {
        servicioBasicoRepository.eliminarServicioBasico(id);
        return "redirect:/servicios-basicos";
    }

    @GetMapping("/servicios-basicos/consumos")
    public String servicioBasicoConsumos(@RequestParam("fecha_menor") Date fecha_menor, @RequestParam("fecha_mayor") Date fecha_mayor, Model model) {
        Collection<ServicioBasico> serviciosPopulares = servicioBasicoRepository.darServiciosMasPopularesEnUnIntervalo(fecha_menor, fecha_mayor);

        SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy", new Locale("es", "ES"));
        String fechaMenorFormateada = sdf.format(fecha_menor);
        String fechaMayorFormateada = sdf.format(fecha_mayor);

        model.addAttribute("fecha_menor", fechaMenorFormateada);
        model.addAttribute("fecha_mayor", fechaMayorFormateada);
        model.addAttribute("serviciosPopulares", serviciosPopulares);
        return "serviciosBasicosConsumos";
    }
}
