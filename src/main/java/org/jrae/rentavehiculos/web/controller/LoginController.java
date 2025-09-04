package org.jrae.rentavehiculos.web.controller;

import org.jrae.rentavehiculos.dominio.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class LoginController {
    @Autowired
    private IUsuarioService usuarioService;
    private Usuario usuarioSeleccionado;
    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String correo, @RequestParam String contrasena, Model model) {
        this.usuarioSeleccionado.listarUsuariosporCorreo(correo);
        if (usuarioSeleccionado != null){
            for (Usuario u : usuarioSeleccionado){
                if (u.getCorreo.equals(correo) && u.getContrasena.equals(contrasena)) {
                    // Autenticación exitosa
                    return "redirect:/Reservas";
                } else {
                    model.addAttribute("error", "Credenciales incorrectas");
                    return "login";
                }
            }
        }else {
            model.addAttribute("error", "Correo no existente");
            return "login";
        }

    }
}