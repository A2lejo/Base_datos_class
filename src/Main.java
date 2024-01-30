import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ingreso de calificacioens");
        frame.setContentPane(new insercion().form1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(540,380);
        frame.setVisible(true);
    }
}