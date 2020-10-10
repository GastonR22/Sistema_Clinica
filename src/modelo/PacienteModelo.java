package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class PacienteModelo {

    private String nombre;
    private String apellido;
    private int telefono;
    private String direccion;
    private int dni;
    private String fechaNacimiento;
    private String mail;
    private String localidad;

    private int codigoPostal;
    private String[][] matrizPaciente;
    private int aux;
    private int auxContadorRegistros;
    private String[] arrayModificar;
    private String[] arrayBuscar;
    //booleanos para verificar que los jtextfield no esten vacios ni con el texto por defecto
    private boolean auxBuscar;
    private boolean auxModificar;
    private boolean auxEliminar;
    private boolean auxModifiarFormulario;

    public PacienteModelo() {
    }

    public PacienteModelo(String nombre, String apellido, int telefono, String direccion, int dni, String fechaNacimiento, String mail, String localidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.mail = mail;
        this.localidad = localidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String[][] getMatrizPaciente() {
        return matrizPaciente;
    }

    public void setMatrizPaciente(String[][] matrizPaciente) {
        this.matrizPaciente = matrizPaciente;
    }

    public int getAux() {
        return aux;
    }

    public void setAux(int aux) {
        this.aux = aux;
    }

    public String[] getArrayModificar() {
        return arrayModificar;
    }

    public void setArrayModificar(String[] arrayModificar) {
        this.arrayModificar = arrayModificar;
    }

    public String[] getArrayBuscar() {
        return arrayBuscar;
    }

    public void setArrayBuscar(String[] arrayBuscar) {
        this.arrayBuscar = arrayBuscar;
    }

    public boolean isAuxBuscar() {
        return auxBuscar;
    }

    public void setAuxBuscar(boolean auxBuscar) {
        this.auxBuscar = auxBuscar;
    }

    public boolean isAuxModificar() {
        return auxModificar;
    }

    public void setAuxModificar(boolean auxModificar) {
        this.auxModificar = auxModificar;
    }

    public boolean isAuxEliminar() {
        return auxEliminar;
    }

    public void setAuxEliminar(boolean auxEliminar) {
        this.auxEliminar = auxEliminar;
    }

    public boolean isAuxModifiarFormulario() {
        return auxModifiarFormulario;
    }

    public void setAuxModifiarFormulario(boolean auxModifiarFormulario) {
        this.auxModifiarFormulario = auxModifiarFormulario;
    }

    public void ponerNumeroCodigoPostal() {

        switch (localidad) {

            case "Capital":
                this.codigoPostal = 5500;
                break;

            case "Godoy Cruz":
                this.codigoPostal = 5501;
                break;

            case "Guaymallen":
                this.codigoPostal = 5521;
                break;

            case "Las heras":
                this.codigoPostal = 5502;
                break;

            case "Maipu":
                this.codigoPostal = 5515;
                break;

            case "Lujan de cuyo":
                this.codigoPostal = 5507;
                break;

            case "San Martin":
                this.codigoPostal = 5570;
                break;

            case "Rivadavia":
                this.codigoPostal = 5577;
                break;

            case "La paz":
                this.codigoPostal = 5590;
                break;

            case "Tupungato":
                this.codigoPostal = 5561;
                break;

            case "Tunuyan":
                this.codigoPostal = 5560;
                break;

            case "San Rafael":
                this.codigoPostal = 5600;
                break;

            case "Malargue":
                this.codigoPostal = 5613;
                break;

            case "General Alvear":
                this.codigoPostal = 5620;
                break;

        }

    }

    public void insertarDatosPaciente(Connection con) {

        try {
            String query = "INSERT INTO pacientes (dniPaciente, nombre, apellido, telefono,direccion,fechaNacimiento,email,codigoPostal_localidades) VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement(query);

            preparedStatement.setInt(1, dni);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellido);
            preparedStatement.setInt(4, telefono);
            preparedStatement.setString(5, direccion);
            preparedStatement.setString(6, fechaNacimiento);
            preparedStatement.setString(7, mail);
            preparedStatement.setInt(8, codigoPostal);

            preparedStatement.executeUpdate();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error en el método insertar datos Paciente " + e.getMessage());

        }

    }

    public void contarRegistrosDB(Connection con) {
        this.auxContadorRegistros = 0;

        try {

            Statement statement1 = con.createStatement();

            ResultSet resultSet = statement1.executeQuery("SELECT * FROM pacientes");

            while (resultSet.next()) {

                auxContadorRegistros++;

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error método contar Registros DB " + e.getMessage());

        }

    }

    public void guardarDatosMatrizPaciente(Connection con) {

        this.aux = 0;
        //Auxiliar que pone la cantidad de registros cambiantes, mientras que la cantidad de campos se mantiene en 8
        matrizPaciente = new String[auxContadorRegistros][8];

        try {

            Statement statement1 = con.createStatement();

            ResultSet resultSet = statement1.executeQuery("SELECT * FROM pacientes");

            while (resultSet.next()) {

                matrizPaciente[aux][0] = String.valueOf(resultSet.getInt("dniPaciente"));
                matrizPaciente[aux][1] = resultSet.getString("nombre");
                matrizPaciente[aux][2] = resultSet.getString("apellido");
                matrizPaciente[aux][3] = String.valueOf(resultSet.getInt("telefono"));
                matrizPaciente[aux][4] = resultSet.getString("direccion");
                matrizPaciente[aux][5] = resultSet.getString("fechaNacimiento");
                matrizPaciente[aux][6] = resultSet.getString("email");
                matrizPaciente[aux][7] = String.valueOf(resultSet.getInt("codigoPostal_localidades"));

                aux++;

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error método guardar datos matriz" + e.getMessage());

        }

    }

    public void buscarRegistroAmodificar(Connection con, int dni) throws SQLException {
        arrayModificar = new String[8];

        try {

            Statement statement1 = con.createStatement();

            ResultSet resultSet = statement1.executeQuery("SELECT * FROM pacientes where dniPaciente = " + dni);

            if (resultSet.next()) {
                arrayModificar[0] = String.valueOf(resultSet.getInt("dniPaciente"));
                arrayModificar[1] = resultSet.getString("nombre");
                arrayModificar[2] = resultSet.getString("apellido");
                arrayModificar[3] = String.valueOf(resultSet.getInt("telefono"));
                arrayModificar[4] = resultSet.getString("direccion");
                arrayModificar[5] = resultSet.getString("fechaNacimiento");
                arrayModificar[6] = resultSet.getString("email");
                arrayModificar[7] = String.valueOf(resultSet.getInt("codigoPostal_localidades"));

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error método buscar Registro" + e.getMessage());
        }

    }

    public void modificarRegistro(Connection con, int dni, String nombre, String apellido, int telefono, String direccion, String fechaNacimiento, String email, int codigoPostal_localidades) {
        int dni2 = Integer.parseInt(getArrayModificar()[0]);

        String query = "UPDATE pacientes "
                + "SET dniPaciente = ?,"
                + "nombre = ? ,"
                + "apellido = ? ,"
                + "telefono = ?,"
                + "direccion = ?,"
                + "fechaNacimiento = ?,"
                + "email = ?,"
                + "codigoPostal_localidades = ? "
                + " WHERE dniPaciente =" + dni2;

        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement(query);

            preparedStatement.setInt(1, dni);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellido);
            preparedStatement.setInt(4, telefono);
            preparedStatement.setString(5, direccion);
            preparedStatement.setString(6, fechaNacimiento);
            preparedStatement.setString(7, email);
            preparedStatement.setInt(8, codigoPostal_localidades);

            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "El registro se ha modificado exitosamente , apriete el botón MOSTRAR BASE DE DATOS para visualizar los cambios");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error método modificar Registro" + e.getMessage());
        }

    }

    public void eliminarRegistro(Connection con, int dni) {
        int verificacion;

        verificacion = JOptionPane.showConfirmDialog(null, "Se efectuara la eliminación , esta seguro de continuar?");

        if (verificacion == 0) {

            try {
                Statement statement1 = con.createStatement();

                statement1.execute("DELETE FROM pacientes where dniPaciente = " + dni);

                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente , apriete el botón MOSTRAR BASE DE DATOS para visualizar los cambios");
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Error método eliminar Registro" + e.getMessage());
            }

        } else {

            JOptionPane.showMessageDialog(null, "La eliminación del registro ha sido cancelada");

        }

    }

    public void buscarRegistro(Connection con, int dni) {
        arrayBuscar = new String[8];

        try {
            Statement statement1 = con.createStatement();

            ResultSet resultSet = statement1.executeQuery("SELECT * FROM pacientes where dniPaciente = " + dni);

            if (resultSet.next()) {
                arrayBuscar[0] = String.valueOf(resultSet.getInt("dniPaciente"));
                arrayBuscar[1] = resultSet.getString("nombre");
                arrayBuscar[2] = resultSet.getString("apellido");
                arrayBuscar[3] = String.valueOf(resultSet.getInt("telefono"));
                arrayBuscar[4] = resultSet.getString("direccion");
                arrayBuscar[5] = resultSet.getString("fechaNacimiento");
                arrayBuscar[6] = resultSet.getString("email");
                arrayBuscar[7] = String.valueOf(resultSet.getInt("codigoPostal_localidades"));

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error método buscar Registro" + e.getMessage());
        }

    }

    public void verificarcampoBuscar(String campoBuscar) {

        if ("".equals(campoBuscar) || "Ingrese DNI del paciente a buscar".equals(campoBuscar)) {

            JOptionPane.showMessageDialog(null, "El campo del botón buscar no puede ir vacío o con el texto por defecto por favor inténtelo nuevamente");

            auxBuscar = false;

        } else {

            auxBuscar = true;

        }

    }

    public void verificarCamposFormularioModificar(Connection con, String dni, String nombre, String apellido, String telefono, String direccion, String fechaNacimiento, String email, String codigoPostal_localidades) {

        if ("".equals(dni) || "".equals(nombre) || "".equals(apellido) || "".equals(telefono) || "".equals(direccion) || "".equals(fechaNacimiento) || "".equals(email) || "".equals(codigoPostal_localidades)) {

            JOptionPane.showMessageDialog(null, "Los campos no pueden ir vacío, por favor inténtelo nuevamente");

            auxModifiarFormulario = false;
        } else {

            auxModifiarFormulario = true;

        }

    }

    public void verificarcampoModificar(String campoModificar) {

        if ("".equals(campoModificar) || "Ingrese DNI del paciente a modificar".equals(campoModificar)) {

            JOptionPane.showMessageDialog(null, "El campo del botón modificar no puede ir vacío o con el texto por defecto por favor inténtelo nuevamente");

            auxModificar = false;

        } else {

            auxModificar = true;

        }

    }

    public void verificarcampoEliminar(String campoEliminar) {

        if ("".equals(campoEliminar) || "Ingrese DNI del paciente a eliminar".equals(campoEliminar)) {

            JOptionPane.showMessageDialog(null, "El campo del botón eliminar no puede ir vacío o con el texto por defecto por favor inténtelo nuevamente");

            auxEliminar = false;

        } else {

            auxEliminar = true;

        }

    }

}
