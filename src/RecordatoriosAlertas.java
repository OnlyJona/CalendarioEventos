import java.util.PriorityQueue;

class RecordatoriosAlertas {
    private PriorityQueue<Evento> colaPrioridad;

    public RecordatoriosAlertas() {
        this.colaPrioridad = new PriorityQueue<>();
    }

    public void programarAlerta(Evento evento) {
        colaPrioridad.add(evento);
    }

    public void enviarNotificacion() {
        // Implementa la lógica para enviar notificaciones
    }
}