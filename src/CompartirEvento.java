import java.util.LinkedList;
        import java.util.List;

class CompartirEvento {
    private String fecha;
    private String hora;
    private String titulo;

    public CompartirEvento(String fecha, String hora, String titulo) {
        this.fecha = fecha;
        this.hora = hora;
        this.titulo = titulo;
    }

    // Métodos getters
    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getTitulo() {
        return titulo;
    }
}

class Participante {
    private String nombre;

    public Participante(String nombre) {
        this.nombre = nombre;
    }

    // Método getter
    public String getNombre() {
        return nombre;
    }
}

class RegistroEventoCompartido {
    private Evento evento;
    private List<Participante> participantes;

    public RegistroEventoCompartido(Evento evento) {
        this.evento = evento;
        this.participantes = new LinkedList<>();
    }

    public void agregarParticipante(Participante participante) {
        participantes.add(participante);
    }

    public void mostrarRegistro() {
       // System.out.println("Evento: " + evento.getTitulo());
       // System.out.println("Fecha: " + evento.getFecha() + " Hora: " + evento.getHora());
        System.out.println("Participantes:");
        for (Participante participante : participantes) {
            System.out.println("- " + participante.getNombre());
        }
        System.out.println("-----------------------------");
    }
}

class CompartirEventos {
    private List<RegistroEventoCompartido> listaEventosCompartidos;

    public CompartirEventos() {
        this.listaEventosCompartidos = new LinkedList<>();
    }

    public void compartirEvento(Evento evento, List<Participante> participantes) {
        RegistroEventoCompartido registro = new RegistroEventoCompartido(evento);
        registro.agregarParticipante(new Participante("Propietario")); // Añadir al propietario por defecto
        registro.agregarParticipante((Participante) participantes);
        listaEventosCompartidos.add(registro);
    }

    public void mostrarEventosCompartidos() {
        for (RegistroEventoCompartido registro : listaEventosCompartidos) {
            registro.mostrarRegistro();
        }
    }
}