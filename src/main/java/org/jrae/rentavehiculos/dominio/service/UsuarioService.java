package org.jrae.rentavehiculos.dominio.service;

import org.jrae.rentavehiculos.persistence.crud.UsuarioCrud;
import org.jrae.rentavehiculos.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    UsuarioCrud crud;

    @Override
    public List<Usuario> listarUsuarios() {
        return crud.findAll();
    }

    @Override
    public Usuario listarPorId(Integer id) {
        return crud.findById(id).orElse(null);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        crud.save(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        crud.delete(usuario);
    }

    @Override
    public List<Usuario> listarUsuariosporCorreo(String correo){
        return crud.findByCorreo(correo);
    }

//    @Override
//    public Usuario listarUsuariosporCorreo(String correo){
//        return crud.findByCorreo(correo);
//    }
}

