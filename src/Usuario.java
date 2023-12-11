import java.util.ArrayList;
import java.util.List;

class Usuario {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    // Método getter
    public String getNombre() {
        return nombre;
    }
}

class Permiso {
    private String operacion;

    public Permiso(String operacion) {
        this.operacion = operacion;
    }

    // Método getter
    public String getOperacion() {
        return operacion;
    }
}

class ControlAcceso {
    private List<Usuario> usuariosConAcceso;
    private List<Permiso> permisos;

    public ControlAcceso() {
        this.usuariosConAcceso = new ArrayList<>();
        this.permisos = new ArrayList<>();
    }

    public void agregarUsuarioConAcceso(Usuario usuario) {
        usuariosConAcceso.add(usuario);
    }

    public void agregarPermiso(Permiso permiso) {
        permisos.add(permiso);
    }

    public boolean tieneAcceso(Usuario usuario, Permiso permiso) {
        return usuariosConAcceso.contains(usuario) && permisos.contains(permiso);
    }
}

class PrivacidadYSeguridad {
    private ControlAcceso controlAcceso;

    public PrivacidadYSeguridad() {
        this.controlAcceso = new ControlAcceso();
    }

    public void asignarAcceso(Usuario usuario, Permiso permiso) {
        controlAcceso.agregarUsuarioConAcceso(usuario);
        controlAcceso.agregarPermiso(permiso);
    }

    public boolean verificarAcceso(Usuario usuario, Permiso permiso) {
        return controlAcceso.tieneAcceso(usuario, permiso);
    }
}