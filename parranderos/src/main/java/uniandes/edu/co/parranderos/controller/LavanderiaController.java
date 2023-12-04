package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uniandes.edu.co.parranderos.modelo.Lavanderia;
import uniandes.edu.co.parranderos.modelo.ServicioBasico;
import uniandes.edu.co.parranderos.repositorios.LavanderiaRepository;
import uniandes.edu.co.parranderos.repositorios.ServicioBasicoRepository;

@Controller
@RequestMapping("/servicios-basicos/lavanderias")
public class LavanderiaController {
    
    @Autowired
    private LavanderiaRepository lavanderiaRepository;
    
    @Autowired
    private ServicioBasicoRepository servicioBasicoRepository;

    @GetMapping
    public String lavanderias(Model model) {
        model.addAttribute("lavanderias", lavanderiaRepository.findAll());    
        return "lavanderias";
    }

    @GetMapping("/new")
    public String newLavanderia(Model model) {
        model.addAttribute("lavanderia", new Lavanderia());
        return "lavanderiaNueva";
    }

    @PostMapping("/new/save")
    public String saveLavanderia(Lavanderia lavanderia) {
        ServicioBasico servicio = new ServicioBasico(lavanderia.getId(), lavanderia.getNombreServicio(),
                lavanderia.getCapacidadServicio(), lavanderia.getCostoServicio(), lavanderia.getHoraAperturaServicio(),
                lavanderia.getHoraCierreServicio());
        lavanderia.setServicio(servicio);
        servicio.setServicioEspecifico(lavanderia.getId());
        servicioBasicoRepository.save(servicio);
        lavanderiaRepository.save(lavanderia);
        return "redirect:/servicios-basicos/lavanderias";
    }

    @GetMapping("/{id}/edit")
    public String editLavanderia(@PathVariable("id") String id, Model model) {
        Lavanderia lavanderia = lavanderiaRepository.findById(id);
        lavanderia.setNombreServicio(lavanderia.getServicio().getNombre());
        lavanderia.setCapacidadServicio(lavanderia.getServicio().getCapacidad());
        lavanderia.setCostoServicio(lavanderia.getServicio().getCosto());
        lavanderia.setHoraAperturaServicio(lavanderia.getServicio().getHoraApertura());
        lavanderia.setHoraCierreServicio(lavanderia.getServicio().getHoraCierre());

        model.addAttribute("lavanderia", lavanderia);
        return "lavanderiaEditar";
    }

    @PostMapping("/{id}/edit/save")
    public String updateLavanderia(@ModelAttribute Lavanderia lavanderia, @PathVariable("id") String id) {
        ServicioBasico servicio = new ServicioBasico(lavanderia.getId(), lavanderia.getNombreServicio(),
                lavanderia.getCapacidadServicio(), lavanderia.getCostoServicio(), lavanderia.getHoraAperturaServicio(),
                lavanderia.getHoraCierreServicio());

        lavanderia.setServicio(servicio);
        servicioBasicoRepository.deleteById(id);
        
        servicioBasicoRepository.save(servicio);
        lavanderiaRepository.deleteById(id);
        lavanderiaRepository.save(lavanderia);
        return "redirect:/servicios-basicos/lavanderias";
    }

    @GetMapping("/{id}/delete")
    public String deleteLavanderia(@PathVariable("id") String id) {
        Lavanderia lavanderia = lavanderiaRepository.findById(id);
        servicioBasicoRepository.deleteById(lavanderia.getServicio().getId());
        lavanderiaRepository.deleteById(id);
        return "redirect:/servicios-basicos/lavanderias";
    }
}
