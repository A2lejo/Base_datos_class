import javafx.scene.input.InputMethodTextRun;

import java.sql.*;
import java.sql.DriverManager;

public class insertarDatos {
    String nombre;
    String cedula;
    int calif1;
    int calif2;

    /*Se recomienda poner dos constructores uno con todos y uno vacio*/
    public insertarDatos(String nombre, String cedula, int calif1, int calif2) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.calif1 = calif1;
        this.calif2 = calif2;
    }
    public insertarDatos(){
    }
    public void ingresoDatos(String nombre, String cedula, int calif1, int calif2){
        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/estudiantes",
                "root", "A2lejx0227")){
            String sql="INSERT INTO calificaciones(nombre, cedula, calificacion1, calificacion2) values(?,?,?,?)";
            try(PreparedStatement preparedStatement=connection.prepareStatement(sql)){
                preparedStatement.setString(1,nombre);
                preparedStatement.setString(2,cedula);
                preparedStatement.setInt(3,calif1);
                preparedStatement.setInt(4, calif2);
                //al final sale cuantas filas han sido insertadas
                int filasAfectadas=preparedStatement.executeUpdate();
                if(filasAfectadas>0){
                    System.out.println("Inserción exitosa");
                }
                else {
                    System.out.println("Inserción fallida");
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}
