package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uniandes.edu.co.parranderos.modelo.Prestamo;
import uniandes.edu.co.parranderos.modelo.Producto;
import uniandes.edu.co.parranderos.modelo.ServicioBasico;
import uniandes.edu.co.parranderos.repositorios.PrestamoRepository;
import uniandes.edu.co.parranderos.repositorios.ProductoRepository;
import uniandes.edu.co.parranderos.repositorios.ServicioBasicoRepository;

@Controller
@RequestMapping("/servicios-basicos/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ServicioBasicoRepository servicioBasicoRepository;

    @GetMapping
    public String prestamos(Model model) {
        model.addAttribute("prestamos", prestamoRepository.findAll());
        return "prestamos";
    }

    @GetMapping("/new")
    public String newPrestamo(Model model) {
        model.addAttribute("prestamo", new Prestamo());
        return "prestamoNuevo";
    }

    @PostMapping("/new/save")
    public String savePrestamo(@ModelAttribute Prestamo prestamo) {
        ServicioBasico servicio = new ServicioBasico(prestamo.getId(), prestamo.getNombreServicio(),
                prestamo.getCapacidadServicio(), prestamo.getCostoServicio(), prestamo.getHoraAperturaServicio(),
                prestamo.getHoraCierreServicio());
        prestamo.setServicio(servicio);
        servicio.setServicioEspecifico(prestamo.getId());
        servicioBasicoRepository.save(servicio);

        Producto producto = new Producto(prestamo.getId(), prestamo.getNombreProducto(), prestamo.getPrecioProducto(), 
                prestamo.getTipoProducto());
        prestamo.setProducto(producto);
        productoRepository.save(producto);

        prestamoRepository.save(prestamo);
        return "redirect:/servicios-basicos/prestamos";
    }

    @GetMapping("/{id}/edit")
    public String editPrestamo(@PathVariable("id") String id, Model model) {
        Prestamo prestamo = prestamoRepository.findById(id);
        prestamo.setNombreServicio(prestamo.getServicio().getNombre());
        prestamo.setCapacidadServicio(prestamo.getServicio().getCapacidad());
        prestamo.setCostoServicio(prestamo.getServicio().getCosto());
        prestamo.setHoraAperturaServicio(prestamo.getServicio().getHoraApertura());
        prestamo.setHoraCierreServicio(prestamo.getServicio().getHoraCierre());

        prestamo.setNombreProducto(prestamo.getProducto().getNombre());
        prestamo.setPrecioProducto(prestamo.getProducto().getPrecio());
        prestamo.setTipoProducto(prestamo.getProducto().getTipoProducto());

        model.addAttribute("prestamo", prestamo);
        return "prestamoEditar";
    }

    @PostMapping("/{id}/edit/save")
    public String saveEditPrestamo(@PathVariable("id") String id, @ModelAttribute Prestamo prestamo) {
        ServicioBasico servicio = new ServicioBasico(prestamo.getId(), prestamo.getNombreServicio(),
                prestamo.getCapacidadServicio(), prestamo.getCostoServicio(), prestamo.getHoraAperturaServicio(),
                prestamo.getHoraCierreServicio());

        prestamo.setServicio(servicio);
        servicioBasicoRepository.deleteById(prestamo.getServicio().getId());
        servicioBasicoRepository.save(servicio);

        Producto producto = new Producto(prestamo.getId(), prestamo.getNombreProducto(), prestamo.getPrecioProducto(), 
                prestamo.getTipoProducto());
        prestamo.setProducto(producto);
        productoRepository.deleteById(prestamo.getProducto().getId());
        productoRepository.save(producto);

        prestamoRepository.deleteById(id);
        prestamoRepository.save(prestamo);
        return "redirect:/servicios-basicos/prestamos";
    }

    @GetMapping("/{id}/delete")
    public String deletePrestamo(@PathVariable("id") String id) {
        Prestamo prestamo = prestamoRepository.findById(id);
        servicioBasicoRepository.deleteById(prestamo.getServicio().getId());
        prestamoRepository.deleteById(id);
        return "redirect:/servicios-basicos/prestamos";
    }
}
