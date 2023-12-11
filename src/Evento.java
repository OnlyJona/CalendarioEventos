import java.util.LinkedList;
import java.util.List;

// Clase para representar un evento
class Evento {
    private String fecha;
    private String hora;
    private String titulo;
    private String descripcion;
    private String ubicacion;
    private List<String> participantes;

    public Evento(String fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.participantes = participantes;
    }

    // Métodos getters y setters
    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public List<String> getParticipantes() {
        return participantes;
    }
}

// Clase "Eventos" que contiene una lista enlazada de eventos
class Eventos {
    private List<Evento> listaEventos;

    public Eventos() {
        this.listaEventos = new LinkedList<>();
    }

    public void agregarEvento(Evento evento) {
        listaEventos.add(evento);
    }

    public List<Evento> obtenerEventos() {
        return listaEventos;
    }
}