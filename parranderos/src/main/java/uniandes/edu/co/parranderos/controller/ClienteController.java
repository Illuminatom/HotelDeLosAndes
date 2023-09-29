package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.parranderos.modelo.Cliente;
import uniandes.edu.co.parranderos.modelo.ClientePK;
import uniandes.edu.co.parranderos.modelo.Usuario;
import uniandes.edu.co.parranderos.repositorio.ClienteRepository;
import uniandes.edu.co.parranderos.repositorio.UsuarioRepository;

@Controller
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/clientes")
    public String clientes(Model model){
        model.addAttribute("clientes", clienteRepository.darClientes());
        return "clientes";
    }

    @GetMapping("/clientes/new")
    public String clienteForm(Model model){
        model.addAttribute("cliente", new Cliente());
        return "clienteNuevo";
    }

    @PostMapping("/clientes/new/save")
    public String clienteGuardar(@ModelAttribute("documento") int documento, @ModelAttribute("metodoPago") String metodoPago, @ModelAttribute("cobroTotal") int cobroTotal){

        Usuario usuario = usuarioRepository.darUsuario(documento);

        ClientePK pk = new ClientePK(usuario);
        Cliente cliente = new Cliente();
        cliente.setPk(pk);
        clienteRepository.insertarCliente(pk.getDocumento().getDocumento(), metodoPago, cobroTotal);
        return "redirect:/clientes";
    }



}
