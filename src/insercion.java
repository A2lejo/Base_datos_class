import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class insercion {
    private JButton conectarBD;
    JPanel form1;
    private JLabel mensajetxt;
    private JButton insertar;
    private JTextField nombreTF;
    private JTextField cedulaTF;
    private JTextField cali1TF;
    private JTextField cali2TF;
    private JButton borrar;

    public insercion() {
        conectarBD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConexionBD miconexion = new ConexionBD();
                miconexion.conexionlocal("jdbc:mysql://localhost:3306/estudiantes",
                        "root","A2lejx0227");
                mensajetxt.setText(miconexion.getMensaje());
            }
        });
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreTF.setText("");
                cedulaTF.setText("");
                cali1TF.setText("");
                cali2TF.setText("");
            }
        });
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarDatos insertarDatos = new insertarDatos();

                insertarDatos.ingresoDatos(nombreTF.getText(),cedulaTF.getText(),
                        Integer.parseInt(cali1TF.getText()),Integer.parseInt(cali2TF.getText()));
            }
        });
    }
}
