
import java.util.ArrayList;
import java.util.List;

    class integracionCalendariosExternos {
        private String fecha;
        private String hora;
        private String titulo;

        public integracionCalendariosExternos(String fecha, String hora, String titulo) {
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

    class IntegracionCalendariosExternos {
        private List<integracionCalendariosExternos> eventos;

        public IntegracionCalendariosExternos() {
            this.eventos = new ArrayList<>();
        }

        public void importarEventos(List<integracionCalendariosExternos> eventosImportados) {
            eventos.addAll(eventosImportados);
            System.out.println("Eventos importados exitosamente.");
        }

        public List<integracionCalendariosExternos> exportarEventos() {
            System.out.println("Eventos exportados exitosamente.");
            return eventos;
        }
    }
