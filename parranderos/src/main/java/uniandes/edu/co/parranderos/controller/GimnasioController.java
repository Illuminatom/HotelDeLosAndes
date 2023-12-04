package uniandes.edu.co.parranderos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uniandes.edu.co.parranderos.modelo.Gimnasio;
import uniandes.edu.co.parranderos.modelo.ServicioBasico;
import uniandes.edu.co.parranderos.repositorios.GimnasioRepository;
import uniandes.edu.co.parranderos.repositorios.ServicioBasicoRepository;

@Controller
@RequestMapping("/servicios-basicos/gimnasios")
public class GimnasioController {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    @Autowired
    private ServicioBasicoRepository servicioBasicoRepository;

    @GetMapping
    public String gimnasios(Model model) {
        Collection<Gimnasio> gimnasios = gimnasioRepository.findAll();
        model.addAttribute("gimnasios", gimnasios);
        return "gimnasios";
    }

    @GetMapping("/new")
    public String gimnasioForm(Model model) {
        model.addAttribute("gimnasio", new Gimnasio());
        return "gimnasioNuevo";
    }

    @PostMapping("/new/save")
    public String saveGimnasio(Gimnasio gimnasio) {
        ServicioBasico servicio = new ServicioBasico(gimnasio.getId(), gimnasio.getNombreServicio(),
                gimnasio.getCapacidadServicio(), gimnasio.getCostoServicio(), gimnasio.getHoraAperturaServicio(),
                gimnasio.getHoraCierreServicio());
        gimnasio.setServicio(servicio);
        servicio.setServicioEspecifico(gimnasio.getId());
        servicioBasicoRepository.save(servicio);
        gimnasioRepository.save(gimnasio);
        return "redirect:/servicios-basicos/gimnasios";
    }

    @GetMapping("/{id}/edit")
    public String gimnasioForm(@PathVariable("id") String id, Model model) {
        Gimnasio gimnasio = gimnasioRepository.findById(id);
        gimnasio.setNombreServicio(gimnasio.getServicio().getNombre());
        gimnasio.setCapacidadServicio(gimnasio.getServicio().getCapacidad());
        gimnasio.setCostoServicio(gimnasio.getServicio().getCosto());
        gimnasio.setHoraAperturaServicio(gimnasio.getServicio().getHoraApertura());
        gimnasio.setHoraCierreServicio(gimnasio.getServicio().getHoraCierre());

        model.addAttribute("gimnasio", gimnasio);
        return "gimnasioEditar";
    }

    @PostMapping("/{id}/edit/save")
    public String updateGimnasio(@PathVariable("id") String id, @ModelAttribute Gimnasio gimnasio) {        
        ServicioBasico servicio = new ServicioBasico(gimnasio.getId(), gimnasio.getNombreServicio(),
                gimnasio.getCapacidadServicio(), gimnasio.getCostoServicio(), gimnasio.getHoraAperturaServicio(),
                gimnasio.getHoraCierreServicio());

        gimnasio.setServicio(servicio);
        servicioBasicoRepository.deleteById(servicio.getId());
        
        servicioBasicoRepository.save(servicio);
        gimnasioRepository.deleteById(gimnasio.getId());
        gimnasioRepository.save(gimnasio);
        return "redirect:/servicios-basicos/gimnasios";
    }

    @GetMapping("/{id}/delete")
    public String deleteGimnasio(@PathVariable("id") String id) {
        Gimnasio gimnasio = gimnasioRepository.findById(id);
        servicioBasicoRepository.deleteById(gimnasio.getServicio().getId());
        gimnasioRepository.deleteById(id);
        return "redirect:/servicios-basicos/gimnasios";
    }
}
