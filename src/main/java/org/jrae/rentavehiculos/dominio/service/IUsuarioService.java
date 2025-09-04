package org.jrae.rentavehiculos.dominio.service;
import org.jrae.rentavehiculos.persistence.entity.Usuario;
import java.util.List;
public interface IUsuarioService {
    List<Usuario> listarUsuarios();
    Usuario listarPorId(Integer id);
    void guardarUsuario(Usuario usuario);
    void eliminarUsuario(Usuario usuario);
    List<Usuario> listarUsuariosporCorreo(String correo);
}
