package crudmvc;

import controlador.Controlador;
import java.sql.SQLException;
import modelo.Conexion;
import modelo.LoginModelo;
import modelo.PacienteModelo;
import vista.FormularioModificar;
import vista.Login;
import vista.Principal;

public class CrudMvc {

    public static void main(String[] args) throws SQLException {

        LoginModelo loginModelo1 = new LoginModelo();
        Conexion conexion1 = new Conexion();
        Login loginVista1 = new Login();
        Principal principalVista1 = new Principal();
        PacienteModelo pacienteModelo1 = new PacienteModelo();
        FormularioModificar formularioModificarControlador1 = new FormularioModificar();

        Controlador controlador1 = new Controlador(loginModelo1, conexion1, loginVista1, principalVista1, pacienteModelo1, formularioModificarControlador1);
        controlador1.iniciarLogin();

    }

}
