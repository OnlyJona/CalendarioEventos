import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

class Event {
    private String nombre;
    private String fecha;
    private String descripcion;
    private String participantes;

    public Event(String nombre, String fecha, String descripcion, String participantes) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.participantes = participantes;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getParticipantes() {
        return participantes;
    }

    public void setParticipantes(String participantes) {
        this.participantes = participantes;
    }
}

public class MainApp extends JFrame {
    private Map<String, Event> agenda;
    private DefaultListModel<String> eventosListModel;
    private JList<String> eventosList;

    public MainApp() {
        super("Organizador de Eventos");

        this.agenda = new HashMap<String, Event>();
        this.eventosListModel = new DefaultListModel<>();
        this.eventosList = new JList<>(eventosListModel);

        createMenuBar();
        createUI();

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu archivoMenu = new JMenu("Archivo");
        JMenuItem salirItem = new JMenuItem("Salir");
        salirItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        archivoMenu.add(salirItem);

        JMenu eventosMenu = new JMenu("Eventos");
        JMenuItem agregarEventoItem = new JMenuItem("Agregar Evento");
        agregarEventoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEvento();
            }
        });

        JMenuItem mostrarEventosItem = new JMenuItem("Mostrar Eventos");
        mostrarEventosItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarEventos();
            }
        });

        JMenuItem modificarEventoItem = new JMenuItem("Modificar Evento");
        modificarEventoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarEvento();
            }
        });

        eventosMenu.add(agregarEventoItem);
        eventosMenu.add(mostrarEventosItem);
        eventosMenu.add(modificarEventoItem);

        menuBar.add(archivoMenu);
        menuBar.add(eventosMenu);

        setJMenuBar(menuBar);
    }

    private void createUI() {
        setLayout(new BorderLayout());

        JScrollPane eventosScrollPane = new JScrollPane(eventosList);
        add(eventosScrollPane, BorderLayout.CENTER);
    }

    private void agregarEvento() {
        String nombreEvento = JOptionPane.showInputDialog("Ingrese el nombre del evento:");
        String fechaEvento = JOptionPane.showInputDialog("Ingrese la fecha del evento:");
        String descripcionEvento = JOptionPane.showInputDialog("Ingrese la descripción del evento:");
        String participantesEvento = JOptionPane.showInputDialog("Ingrese los participantes del evento:");

        if (nombreEvento != null && fechaEvento != null && descripcionEvento != null && participantesEvento != null) {
            Event evento = new Event(nombreEvento, fechaEvento, descripcionEvento, participantesEvento);
            agenda.put(nombreEvento, evento);
            eventosListModel.addElement(nombreEvento);
            JOptionPane.showMessageDialog(this, "Evento agregado: " + nombreEvento);
        }
    }

    private void mostrarEventos() {
        String selectedEvento = eventosList.getSelectedValue();
        if (selectedEvento == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un evento para ver detalles.");
            return;
        }

        Event evento = agenda.get(selectedEvento);
        String detallesEvento = "Detalles del evento:\n" +
                "Nombre: " + evento.getNombre() + "\n" +
                "Fecha: " + evento.getFecha() + "\n" +
                "Descripción: " + evento.getDescripcion() + "\n" +
                "Participantes: " + evento.getParticipantes();

        JOptionPane.showMessageDialog(this, detallesEvento);
    }

    private void modificarEvento() {
        String selectedEvento = eventosList.getSelectedValue();
        if (selectedEvento == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un evento para modificar.");
            return;
        }

        String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese la nueva descripción para el evento " + selectedEvento + ":");
        String nuevosParticipantes = JOptionPane.showInputDialog("Ingrese los nuevos participantes para el evento " + selectedEvento + ":");

        if (nuevaDescripcion != null && nuevosParticipantes != null) {
            Event evento = agenda.get(selectedEvento);
            evento.setDescripcion(nuevaDescripcion);
            evento.setParticipantes(nuevosParticipantes);
            JOptionPane.showMessageDialog(this, "Detalles del evento " + selectedEvento + " modificados.");
        }
    }

    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainApp();
            }
        });
    }
}