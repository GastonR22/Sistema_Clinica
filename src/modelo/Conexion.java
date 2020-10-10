package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {

    private Connection con;
    private String[][] matrizLogin;
    private int contadorRegistros;

    public Conexion() {
    }

    public Conexion(Connection con, String[][] matrizLogin, int contadorRegistros) {
        this.con = con;
        this.matrizLogin = matrizLogin;
        this.contadorRegistros = contadorRegistros;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String[][] getMatrizLogin() {
        return matrizLogin;
    }

    public void setMatrizLogin(String[][] matrizLogin) {
        this.matrizLogin = matrizLogin;
    }

    public int getContadorRegistros() {
        return contadorRegistros;
    }

    public void setContadorRegistros(int contadorRegistros) {
        this.contadorRegistros = contadorRegistros;
    }

    public Connection conectarDB() {

        if (con == null) {

            try {

                //Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:sqlite:crudmvcdb.db");
                //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudmvcdb", "root", "");
                JOptionPane.showMessageDialog(null, "Conexión a la base de datos exitosa");

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos \n" + e.getMessage());
            }

        }

        return con;
    }

    public Connection cerrarConexion() throws SQLException {
        try {

            if (con != null) {
                con.close();
                JOptionPane.showMessageDialog(null, "La conexión a la base de datos se ha cerrado exitosamente");

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión a la base de datos \n" + e.getErrorCode());

        }

        setCon(null);
        return con;

    }

    public int consultarCantidadRegistrosLoginDB() throws SQLException {

        try {

            Statement statement1 = con.createStatement();

            ResultSet resultSet = statement1.executeQuery("SELECT * FROM login");

            //While que cuenta filas
            while (resultSet.next()) {
                contadorRegistros += contadorRegistros;
                contadorRegistros++;
            }

            this.matrizLogin = new String[contadorRegistros][3];

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error en la consulta cantidad de registros \n" + e.getMessage());
        }

        return contadorRegistros;
    }

    public void consultarTodoTablaLogin() throws SQLException {
        int aux = 0;

        try {
            Statement statement1 = con.createStatement();

            ResultSet resultSet = statement1.executeQuery("SELECT * FROM login");

            //while que asigna los valores de la base de datos a atributo global matriz
            while (resultSet.next()) {
                matrizLogin[aux][0] = String.valueOf(resultSet.getInt("Id_Login"));
                matrizLogin[aux][1] = resultSet.getString("usuario");
                matrizLogin[aux][2] = resultSet.getString("contraseña");
                aux++;
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error en la consulta \n" + e.getMessage());

        }

    }

}
