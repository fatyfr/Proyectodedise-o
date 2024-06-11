package interfazgrafico;

import entidadesdenegocio.Estudiante;
import logicadenegocio.EstudianteBL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class MantenimientoEstudiante  extends JFrame{
    private JTextField txtId;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JComboBox cbCarrera;
    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnCancelar;
    private JButton btnSalir;
    private JRadioButton rdbId;
    private JRadioButton rdbApellido;
    private JRadioButton rdbCarrera;
    private JTextField txtCriterio;
    private JButton btnBuscar;
    private JTable jtEstudiantes;
    private JPanel jpPrincipal;
    private ButtonGroup CriterioBusqueda;

    //estas son instancias propias
    ArrayList<Estudiante> listaEstudiante;
    Estudiante student;
    EstudianteBL estudianteBL = new EstudianteBL();

    public static void main(String[] args) throws SQLException{
        new MantenimientoEstudiante();
    }

    public MantenimientoEstudiante() throws SQLException {
        inicializar();
        actualizarFrom();

        btnSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });
        btnCancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try{
                    actualizarFrom();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnNuevo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                txtCodigo.setEnabled(true);
                txtNombre.setEnabled(true);
                txtApellido.setEnabled(true);
                cbCarrera.setEnabled(true);
                txtCodigo.grabFocus();
                btnGuardar.setEnabled(false);
                btnNuevo.setEnabled(false);
                btnCancelar.setEnabled(true);
            }
        });
        btnGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                student = new Estudiante();
                student.setCodigo(txtCodigo.getText());
                student.setNombre(txtNombre.getText());
                student.setApellido(txtApellido.getText());
                student.setCarrera(cbCarrera.getSelectedItem().toString());

                try{
                    estudianteBL.guardar(student);
                    JOptionPane.showConfirmDialog(null,"Se guardo con exito");
                    actualizarFrom();
                }catch (SQLException ex){
                    throw new RuntimeException(ex);
                }
            }
        });
        btnModificar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                student = new Estudiante();
                student.setId(Integer.parseInt(txtId.getText()));
                student.setCodigo(txtCodigo.getText());
                student.setNombre(txtNombre.getText());
                student.setApellido(txtApellido.getText());
                student.setCarrera(cbCarrera.getSelectedItem().toString());

                try{
                    estudianteBL.modificar(student);
                    JOptionPane.showConfirmDialog(null,"Se modifico con exito");
                    actualizarFrom();
                }catch (SQLException ex){
                    throw new RuntimeException(ex);
                }
            }
        });
        jtEstudiantes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int fila = jtEstudiantes.getSelectedRow();
                txtId.setText(jtEstudiantes.getValueAt(fila,0).toString());
                txtCodigo.setText(jtEstudiantes.getValueAt(fila,1).toString());
                txtNombre.setText(jtEstudiantes.getValueAt(fila,2).toString());
                txtApellido.setText(jtEstudiantes.getValueAt(fila,3).toString());
                cbCarrera.setSelectedItem(jtEstudiantes.getValueAt(fila,4));

                txtCodigo.setEnabled(true);
                txtNombre.setEnabled(true);
                txtApellido.setEnabled(true);
                cbCarrera.setEnabled(true);
                txtCodigo.grabFocus();

                btnNuevo.setEnabled(false);
                btnModificar.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnCancelar.setEnabled(true);


            }
        });
    }

    void inicializar(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600,700);
        setTitle("Control de Estudiante");
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        CriterioBusqueda = new ButtonGroup();
        CriterioBusqueda.add(rdbId);
        CriterioBusqueda.add(rdbApellido);
        CriterioBusqueda.add(rdbCarrera);



        setContentPane(jpPrincipal);
        setVisible(true);
    }

    void llenarTabla(ArrayList<Estudiante> estudiantes){
        Object[] objects = new Object[6];
        listaEstudiante = new ArrayList<>();
        String[] encabezado = {"ID", "CODIGO", "NOMBRE", "APELLIDO", "CARRERA"};
        DefaultTableModel tm = new DefaultTableModel(null, encabezado);
        listaEstudiante.addAll(estudiantes);
        for (Estudiante item : listaEstudiante){
            objects[0] = item.getId();
            objects[1] = item.getCodigo();
            objects[2] = item.getNombre();
            objects[3] = item.getApellido();
            objects[4] = item.getCarrera();
            tm.addRow(objects);
        }
        jtEstudiantes.setModel(tm);
    }

    void actualizarFrom() throws SQLException {
        txtId.setText("");
        txtCodigo.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        cbCarrera.setSelectedIndex(0);


        txtId.setEnabled(false);
        txtCodigo.setEnabled(false);
        txtNombre.setEnabled(false);
        txtApellido.setEnabled(false);
        cbCarrera.setEnabled(false);

        btnNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);

        txtCriterio.setText("");
        CriterioBusqueda.clearSelection();

        llenarTabla(EstudianteBL.obtenerTodos());
    }

}
