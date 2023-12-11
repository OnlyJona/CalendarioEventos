import java.util.ArrayList;
import java.util.List;

class VisualizacionCalendario {
    private static final int NUMERO_DIAS_SEMANA = 7; // Puedes ajustar según tus necesidades
    private static final int NUMERO_HORAS_DIA = 24; // Puedes ajustar según tus necesidades

    private Evento[][] matrizCalendario;

    public VisualizacionCalendario() {
        this.matrizCalendario = new Evento[NUMERO_DIAS_SEMANA][NUMERO_HORAS_DIA];
    }

    public void agregarEvento(int dia, int hora, Evento evento) {
        if (dia >= 0 && dia < NUMERO_DIAS_SEMANA && hora >= 0 && hora < NUMERO_HORAS_DIA) {
            matrizCalendario[dia][hora] = evento;
        } else {
            System.out.println("Día u hora fuera de rango.");
        }
    }

    public void mostrarCalendario() {
        for (int hora = 0; hora < NUMERO_HORAS_DIA; hora++) {
            System.out.printf("%2d:00 - %2d:59 |", hora, hora);

            for (int dia = 0; dia < NUMERO_DIAS_SEMANA; dia++) {
                Evento evento = matrizCalendario[dia][hora];
                if (evento != null) {
                   // System.out.printf(" %s |", evento.getTitulo());
                } else {
                    System.out.print("          |"); // Espacios para visualización
                }
            }

            System.out.println(); // Nueva línea para la siguiente hora
        }
    }
}