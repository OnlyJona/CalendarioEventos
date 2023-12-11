import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

class Main2 {
    private String nombre;
    private String fecha;

    public Main2(String nombre, String fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

public class Main extends JFrame {
    private Map<String, Evento> agenda;
    private DefaultListModel<String> eventosListModel;
    private JList<String> eventosList;

    public Main() {
        super("Organizador de Eventos");

        this.agenda = new HashMap<>();
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

        if (nombreEvento != null && fechaEvento != null) {
            Evento evento2 = new Evento(nombreEvento, fechaEvento);
            agenda.put(nombreEvento, evento2);
            eventosListModel.addElement(nombreEvento);
            JOptionPane.showMessageDialog(this, "Evento agregado: " + nombreEvento);
        }
    }

    private void mostrarEventos() {
        if (agenda.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La agenda está vacía.");
        } else {
            StringBuilder eventosText = new StringBuilder("Eventos en la agenda:\n");
            for (Evento evento2 : agenda.values()) {
                eventosText.append("Fecha: ").append(evento2.getHora()).append(", Nombre: ").append(evento2.getFecha()).append("\n");
            }
            JOptionPane.showMessageDialog(this, eventosText.toString());
        }
    }

    private void modificarEvento() {
        String selectedEvento = eventosList.getSelectedValue();
        if (selectedEvento == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un evento para modificar.");
            return;
        }

        String nuevaFecha = JOptionPane.showInputDialog("Ingrese la nueva fecha para el evento " + selectedEvento + ":");
        if (nuevaFecha != null) {
            Evento evento2 = agenda.get(selectedEvento);
            evento2.getFecha();
            JOptionPane.showMessageDialog(this, "Fecha del evento " + selectedEvento + " modificada.");
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OrganizadorEventosGUI();
            }
        });
    }
}