import java.util.HashMap;
import java.util.Map;

class PerfilUsuario {
    private String nombre;
    private String correo;
    // Puedes añadir más atributos según tus necesidades

    public PerfilUsuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }
}

class GestionUsuarios {
    private Map<String, PerfilUsuario> diccionarioUsuarios;

    public GestionUsuarios() {
        this.diccionarioUsuarios = new HashMap<>();
    }

    public void agregarUsuario(String nombre, PerfilUsuario perfil) {
        diccionarioUsuarios.put(nombre, perfil);
    }

    public PerfilUsuario obtenerPerfil(String nombre) {
        return diccionarioUsuarios.get(nombre);
    }

    public boolean existeUsuario(String nombre) {
        return diccionarioUsuarios.containsKey(nombre);
    }

    // Otros métodos de gestión de usuarios
}