package uniandes.edu.co.parranderos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.parranderos.modelo.Hotel;
import uniandes.edu.co.parranderos.modelo.TipoUsuario;
import uniandes.edu.co.parranderos.modelo.Usuario;
import uniandes.edu.co.parranderos.repositorio.HotelRepository;
import uniandes.edu.co.parranderos.repositorio.TipoUsuarioRepository;
import uniandes.edu.co.parranderos.repositorio.UsuarioRepository;

@Controller
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TipoUsuarioRepository tipoUsuarioRepository;

    @Autowired 
    HotelRepository hotelRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model){
        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return "usuarios";
    }

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model){
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("hoteles", hotelRepository.darHoteles());
        model.addAttribute("tiposUsuarios", tipoUsuarioRepository.darTiposUsuarios());
        return "usuarioNuevo";
    }
    
    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario){
        usuarioRepository.insertarUsuario(usuario.getDocumento(), usuario.getTipoDocumento(), usuario.getNombre(), usuario.getCorreoElectronico(), usuario.getTipoUsuario_id().getId(), usuario.getHotel_id().getId());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/edit")
    public String usuarioEditarForm(@PathVariable("id") int id, Model model){
        Usuario usuario = usuarioRepository.darUsuario(id);
        Collection<TipoUsuario> tiposUsuarios = tipoUsuarioRepository.darTiposUsuarios();
        Collection<Hotel> hoteles = hotelRepository.darHoteles();

         if(usuario!=null){
            model.addAttribute("usuario", usuario);
            model.addAttribute("hoteles", hoteles);
            model.addAttribute("tiposUsuarios", tiposUsuarios);
            return "usuarioEditar";
        }
        else{
            return "redirect:/usuarios";
        }
    }
    
    @PostMapping("/usuarios/{id}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("id") int id, @ModelAttribute Usuario usuario, @RequestParam("hotel_id") int hotelId, @RequestParam("tipoUsuario_id") int tipoUsuarioId) {
        Hotel hotel_id = hotelRepository.darHotel(hotelId);
        TipoUsuario tipoUsuario_id = tipoUsuarioRepository.darTipoUsuario(tipoUsuarioId);  

        usuario.setHotel_id(hotel_id);
        usuario.setTipoUsuario_id(tipoUsuario_id); 

        usuarioRepository.actualizarUsuario(usuario.getDocumento(), usuario.getTipoDocumento(), usuario.getNombre(), usuario.getCorreoElectronico(), usuario.getTipoUsuario_id().getId(), usuario.getHotel_id().getId());   

        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/delete")
    public String usuarioBorrar(@PathVariable("id") int id){
        usuarioRepository.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
}
