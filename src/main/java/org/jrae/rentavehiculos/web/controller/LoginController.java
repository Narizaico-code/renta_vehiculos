package org.jrae.rentavehiculos.web.controller;

import org.jrae.rentavehiculos.dominio.service.IUsuarioService;
import org.jrae.rentavehiculos.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.List;

// Importaciones de JSF
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.application.FacesMessage;
import java.io.Serializable;

@Controller
@ManagedBean
@SessionScoped
public class LoginController implements Serializable {

    @Autowired
    private IUsuarioService usuarioService;

    // Propiedades para enlazar con el formulario JSF
    private String correo;
    private String contrasena;

    // Getters y Setters
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    // Este metodo ahora es llamado por JSF. Elimina @PostMapping y @RequestParam.
    public String procesarLogin() {
        FacesContext context = FacesContext.getCurrentInstance();
        List<Usuario> usuariosEncontrados = this.usuarioService.listarUsuariosporCorreo(this.correo);

        if (usuariosEncontrados != null && !usuariosEncontrados.isEmpty()) {
            Usuario usuario = usuariosEncontrados.get(0);
            if (usuario.getContrasena().equals(this.contrasena)) {
                // Autenticación exitosa
                return "redirect:/reservas";
            }
        }

        // Si las credenciales son incorrectas
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de autenticación", "Correo o contraseña incorrectos."));
        return null; // Vuelve a la misma página
    }
}