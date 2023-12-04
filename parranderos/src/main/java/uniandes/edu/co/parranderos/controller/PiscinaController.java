package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uniandes.edu.co.parranderos.modelo.Piscina;
import uniandes.edu.co.parranderos.modelo.ServicioBasico;
import uniandes.edu.co.parranderos.repositorios.PiscinaRepository;
import uniandes.edu.co.parranderos.repositorios.ServicioBasicoRepository;

@Controller
@RequestMapping("/servicios-basicos/piscinas")
public class PiscinaController {

    @Autowired
    private PiscinaRepository piscinaRepository;

    @Autowired
    private ServicioBasicoRepository servicioBasicoRepository;

    @GetMapping
    public String piscinas(Model model) {
        model.addAttribute("piscinas", piscinaRepository.findAll());
        return "piscinas";
    }

    @GetMapping("/new")
    public String newPiscina(Model model) {
        model.addAttribute("piscina", new Piscina());
        return "piscinaNueva";
    }

    @PostMapping("/new/save")
    public String savePiscina(@ModelAttribute Piscina piscina) {
        ServicioBasico servicio = new ServicioBasico(piscina.getId(), piscina.getNombreServicio(),
                piscina.getCapacidadServicio(), piscina.getCostoServicio(), piscina.getHoraAperturaServicio(),
                piscina.getHoraCierreServicio());
        piscina.setServicio(servicio);
        servicio.setServicioEspecifico(piscina.getId());
        servicioBasicoRepository.save(servicio);
        piscinaRepository.save(piscina);
        return "redirect:/servicios-basicos/piscinas";
    }

    @GetMapping("/{id}/edit")
    public String editPiscina(@PathVariable("id") String id, Model model) {
        Piscina piscina = piscinaRepository.findById(id);
        piscina.setNombreServicio(piscina.getServicio().getNombre());
        piscina.setCapacidadServicio(piscina.getServicio().getCapacidad());
        piscina.setCostoServicio(piscina.getServicio().getCosto());
        piscina.setHoraAperturaServicio(piscina.getServicio().getHoraApertura());
        piscina.setHoraCierreServicio(piscina.getServicio().getHoraCierre());

        model.addAttribute("piscina", piscina);
        return "piscinaEditar";
    }

    @PostMapping("/{id}/edit/save")
    public String saveEditPiscina(@PathVariable("id") String id, @ModelAttribute Piscina piscina) {
        ServicioBasico servicio = new ServicioBasico(piscina.getId(), piscina.getNombreServicio(),
                piscina.getCapacidadServicio(), piscina.getCostoServicio(), piscina.getHoraAperturaServicio(),
                piscina.getHoraCierreServicio());

        piscina.setServicio(servicio);
        servicioBasicoRepository.deleteById(piscina.getServicio().getId());
        
        servicioBasicoRepository.save(servicio);
        piscinaRepository.deleteById(id);
        piscinaRepository.save(piscina);
        return "redirect:/servicios-basicos/piscinas";
    }

    @GetMapping("/{id}/delete")
    public String deletePiscina(@PathVariable("id") String id) {
        Piscina piscina = piscinaRepository.findById(id);
        servicioBasicoRepository.deleteById(piscina.getServicio().getId());
        piscinaRepository.deleteById(id);
        return "redirect:/servicios-basicos/piscinas";
    }
}
