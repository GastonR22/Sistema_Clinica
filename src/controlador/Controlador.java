package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.LoginModelo;
import modelo.PacienteModelo;
import vista.FormularioModificar;
import vista.Login;
import vista.Principal;

public class Controlador implements ActionListener {

    private LoginModelo loginModeloControlador;
    private Conexion conexionControlador;
    private Login loginVistaControlador;
    private Principal principalVistaControlador;
    private PacienteModelo pacienteModeloControlador;
    private FormularioModificar formularioModificarControlador;
    private boolean auxCamposVacios;

    public Controlador() {
    }

    public Controlador(LoginModelo loginModeloControlador, Conexion conexionControlador, Login loginVistaControlador, Principal principalVistaControlador, PacienteModelo pacienteModeloControlador, FormularioModificar formularioModificarControlador) {
        this.loginModeloControlador = loginModeloControlador;
        this.conexionControlador = conexionControlador;
        this.loginVistaControlador = loginVistaControlador;
        this.principalVistaControlador = principalVistaControlador;
        this.pacienteModeloControlador = pacienteModeloControlador;
        this.formularioModificarControlador = formularioModificarControlador;
        this.loginVistaControlador.btnIngresarLogin.addActionListener(this);
        this.principalVistaControlador.jButtonAgregarRegistro.addActionListener(this);
        this.principalVistaControlador.jButtonMostrarRegistroPacienteDB.addActionListener(this);
        this.principalVistaControlador.jButtonModificarRegistro.addActionListener(this);
        this.formularioModificarControlador.jButton1ModificarFormulario.addActionListener(this);
        this.principalVistaControlador.jButtonEliminarRegistro.addActionListener(this);
        this.principalVistaControlador.jButtonBuscarPrincipal.addActionListener(this);
    }

    public LoginModelo getLoginModeloControlador() {
        return loginModeloControlador;
    }

    public void setLoginModeloControlador(LoginModelo loginModeloControlador) {
        this.loginModeloControlador = loginModeloControlador;
    }

    public Conexion getConexionControlador() {
        return conexionControlador;
    }

    public void setConexionControlador(Conexion conexionControlador) {
        this.conexionControlador = conexionControlador;
    }

    public Login getLoginVistaControlador() {
        return loginVistaControlador;
    }

    public void setLoginVistaControlador(Login loginVistaControlador) {
        this.loginVistaControlador = loginVistaControlador;
    }

    public Principal getPrincipalVistaControlador() {
        return principalVistaControlador;
    }

    public void setPrincipalVistaControlador(Principal principalVistaControlador) {
        this.principalVistaControlador = principalVistaControlador;
    }

    public PacienteModelo getPacienteModeloControlador() {
        return pacienteModeloControlador;
    }

    public void setPacienteModeloControlador(PacienteModelo pacienteModeloControlador) {
        this.pacienteModeloControlador = pacienteModeloControlador;
    }

    public FormularioModificar getFormularioModificarControlador() {
        return formularioModificarControlador;
    }

    public void setFormularioModificarControlador(FormularioModificar formularioModificarControlador) {
        this.formularioModificarControlador = formularioModificarControlador;
    }

    public void iniciarLogin() {
        this.loginVistaControlador.setTitle("Login C.R.U.D Clínica");
        this.loginVistaControlador.setVisible(true);
        this.loginVistaControlador.setLocationRelativeTo(null);
    }

    public void iniciarPrincipal() {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);

        mes = mes + 1;

        this.principalVistaControlador.setTitle("C.R.U.D Clínica");
        this.principalVistaControlador.setVisible(true);
        this.principalVistaControlador.setLocationRelativeTo(null);
        this.principalVistaControlador.jLabelFechaPrincipal.setText(dia + " / " + mes + " / " + año);

    }

    public void iniciarFormularioModificar() {
        this.formularioModificarControlador.setTitle("Formulario modificar");
        this.formularioModificarControlador.setVisible(true);
        this.formularioModificarControlador.setLocationRelativeTo(null);
        JOptionPane.showMessageDialog(null, "Se le presentaran TODOS los datos del registro, por favor solo modifique los que sean necesarios, "
                + "los datos restantes deben quedar iguales para evitar perdidas de información, tampoco debe quedar ningún campo vacío");

    }

    public void limpiarCamposPaciente() {

        principalVistaControlador.jTextFieldDni.setText("");
        principalVistaControlador.jTextFieldNombre.setText("");
        principalVistaControlador.jTextFieldApellido.setText("");
        principalVistaControlador.jTextFieldTelefono.setText("");
        principalVistaControlador.jTextFieldDireccion.setText("");
        principalVistaControlador.jTextFieldFechaNacimiento.setText("Ejemplo AAAA-MM-DD o 1999-12-31");
        principalVistaControlador.jTextFieldMail.setText("");
        principalVistaControlador.jLabelCodigoPostal.setText("");

    }

    public void agregarDatosTablaPacientes() {
        int aux = pacienteModeloControlador.getAux();

        for (int i = 0; i < aux; i++) {
            //Creamos un objeto dentro del metodo addRow para mostrar los datos 
            principalVistaControlador.modelo.addRow(new Object[]{
                pacienteModeloControlador.getMatrizPaciente()[i][0],
                pacienteModeloControlador.getMatrizPaciente()[i][1],
                pacienteModeloControlador.getMatrizPaciente()[i][2],
                pacienteModeloControlador.getMatrizPaciente()[i][3],
                pacienteModeloControlador.getMatrizPaciente()[i][4],
                pacienteModeloControlador.getMatrizPaciente()[i][5],
                pacienteModeloControlador.getMatrizPaciente()[i][6],
                pacienteModeloControlador.getMatrizPaciente()[i][7]
            });
        }
    }

    public void agregarDatosAlbuscarTablaPacientes() {

        principalVistaControlador.modelo.addRow(new Object[]{
            pacienteModeloControlador.getArrayBuscar()[0],
            pacienteModeloControlador.getArrayBuscar()[1],
            pacienteModeloControlador.getArrayBuscar()[2],
            pacienteModeloControlador.getArrayBuscar()[3],
            pacienteModeloControlador.getArrayBuscar()[4],
            pacienteModeloControlador.getArrayBuscar()[5],
            pacienteModeloControlador.getArrayBuscar()[6],
            pacienteModeloControlador.getArrayBuscar()[7]
        });

    }

    public void borrarContenidoTablaPacientes() {
        int filas = principalVistaControlador.modelo.getRowCount();
        //Pedimos la cuenta de las filas en la base de datos y le restamos uno ya que nuestro for termina en 0 y no en 1
        for (int i = (filas - 1); i >= 0; i--) {
            principalVistaControlador.modelo.removeRow(i);
        }

    }

    public void verificacionCamposFormularioPacientes() {
        if ("".equals(principalVistaControlador.jTextFieldDni.getText())
                || "".equals(principalVistaControlador.jTextFieldNombre.getText())
                || "".equals(principalVistaControlador.jTextFieldApellido.getText())
                || "".equals(principalVistaControlador.jTextFieldTelefono.getText())
                || "".equals(principalVistaControlador.jTextFieldDireccion.getText())
                || "".equals(principalVistaControlador.jTextFieldFechaNacimiento.getText())
                || "Ejemplo AAAA-MM-DD o 1999-12-31".equals(principalVistaControlador.jTextFieldFechaNacimiento.getText())
                || "".equals(principalVistaControlador.jTextFieldMail.getText())) {

            JOptionPane.showMessageDialog(null, "Los campos no pueden ir vacíos o con el texto por defecto, por favor inténtelo nuevamente");
            auxCamposVacios = false;
        } else {
            auxCamposVacios = true;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //INICIO login
        //ActionEvent boton ingresar del login
        if (loginVistaControlador.btnIngresarLogin == e.getSource()) {

            loginModeloControlador.setUsuario(loginVistaControlador.usuarioTxt.getText());
            loginModeloControlador.setPass(loginVistaControlador.contraseñaPassField.getPassword());

            try {
                conexionControlador.conectarDB();
                conexionControlador.consultarCantidadRegistrosLoginDB();
                conexionControlador.consultarTodoTablaLogin();

            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Enviamos la matriz que copiamos en la conexion al login para utilizar su funcion
            loginModeloControlador.verificarUsuarioContraseña(conexionControlador.getMatrizLogin());

            if (loginModeloControlador.isVerificacionUC() == false) {

                loginVistaControlador.usuarioTxt.setText("");
                loginVistaControlador.contraseñaPassField.setText("");

            } else {

                try {
                    //Cierro la conexion abierta por el Jframe del login y pongo en null la variable conexion
                    conexionControlador.cerrarConexion();
                    //Abro el Jframe de la ventana principal y cierro el frame de login
                    iniciarPrincipal();
                    loginVistaControlador.dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            //FIN login
            //INICIO boton AgregarRegistro
        } else if (principalVistaControlador.jButtonAgregarRegistro == e.getSource()) {
            verificacionCamposFormularioPacientes();
            if (auxCamposVacios == true) {
                pacienteModeloControlador.setDni(Integer.parseInt(principalVistaControlador.jTextFieldDni.getText()));
                pacienteModeloControlador.setNombre(principalVistaControlador.jTextFieldNombre.getText());
                pacienteModeloControlador.setApellido(principalVistaControlador.jTextFieldApellido.getText());
                pacienteModeloControlador.setTelefono(Integer.parseInt(principalVistaControlador.jTextFieldTelefono.getText()));
                pacienteModeloControlador.setDireccion(principalVistaControlador.jTextFieldDireccion.getText());
                pacienteModeloControlador.setFechaNacimiento(principalVistaControlador.jTextFieldFechaNacimiento.getText());
                pacienteModeloControlador.setMail(principalVistaControlador.jTextFieldMail.getText());
                pacienteModeloControlador.setLocalidad((String) principalVistaControlador.jComboBoxLocalidad.getSelectedItem());
                pacienteModeloControlador.ponerNumeroCodigoPostal();
                principalVistaControlador.jLabelCodigoPostal.setText(String.valueOf("M" + pacienteModeloControlador.getCodigoPostal()));

                try {
                    conexionControlador.conectarDB();
                    pacienteModeloControlador.insertarDatosPaciente(conexionControlador.getCon());
                    JOptionPane.showMessageDialog(null, "Paciente cargado exitosamente, apriete el botón MOSTRAR BASE DE DATOS para visualizar los cambios");
                    limpiarCamposPaciente();
                    conexionControlador.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error al cargar el paciente");

                }
            }
            //FIN boton agregar registro 
            //INICIO boton mostrar registros pacientes
        } else if (principalVistaControlador.jButtonMostrarRegistroPacienteDB == e.getSource()) {
            try {
                borrarContenidoTablaPacientes();
                conexionControlador.conectarDB();
                pacienteModeloControlador.contarRegistrosDB(conexionControlador.getCon());
                pacienteModeloControlador.guardarDatosMatrizPaciente(conexionControlador.getCon());
                agregarDatosTablaPacientes();
                conexionControlador.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al mostrar los pacientes en la tabla");

            }

            //FIN boton mostrar registros pacientes
            //INICIO boton modificar registro
        } else if (principalVistaControlador.jButtonModificarRegistro == e.getSource()) {
            //Verficacion que el campo no este vacio ni con el texto por defecto
            pacienteModeloControlador.verificarcampoModificar(principalVistaControlador.jTextFieldModificarRegistro.getText());

            if (pacienteModeloControlador.isAuxModificar() == true) {

                try {
                    conexionControlador.conectarDB();
                    pacienteModeloControlador.buscarRegistroAmodificar(conexionControlador.getCon(), Integer.parseInt(principalVistaControlador.jTextFieldModificarRegistro.getText()));

                    iniciarFormularioModificar();
                    //Agregamos los datos al subFormulario para modificar el registro
                    formularioModificarControlador.jTextFieldDniModificar.setText(pacienteModeloControlador.getArrayModificar()[0]);
                    formularioModificarControlador.jTextFieldNombreModificar.setText(pacienteModeloControlador.getArrayModificar()[1]);
                    formularioModificarControlador.jTextFieldApellidoModificar.setText(pacienteModeloControlador.getArrayModificar()[2]);
                    formularioModificarControlador.jTextFieldTelefonoModificar.setText(pacienteModeloControlador.getArrayModificar()[3]);
                    formularioModificarControlador.jTextFieldDireccionModificar.setText(pacienteModeloControlador.getArrayModificar()[4]);
                    formularioModificarControlador.jTextFieldFechaNacimientoModificar.setText(pacienteModeloControlador.getArrayModificar()[5]);
                    formularioModificarControlador.jTextFieldMailModificar.setText(pacienteModeloControlador.getArrayModificar()[6]);
                    formularioModificarControlador.jTextFieldCodigoPostalModificar.setText(pacienteModeloControlador.getArrayModificar()[7]);

                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            //FIN boton modificar registro
            //INICIO boton modificar subFormulario
            //Cuando el boton modificar es llamado corremos el metodo para insertar los datos en la base de datos
        } else if (formularioModificarControlador.jButton1ModificarFormulario == e.getSource()) {

            //Comprobamos que los campos no esten vacios
            pacienteModeloControlador.verificarCamposFormularioModificar(conexionControlador.getCon(),
                    formularioModificarControlador.jTextFieldDniModificar.getText(),
                    formularioModificarControlador.jTextFieldNombreModificar.getText(),
                    formularioModificarControlador.jTextFieldApellidoModificar.getText(),
                    formularioModificarControlador.jTextFieldTelefonoModificar.getText(),
                    formularioModificarControlador.jTextFieldDireccionModificar.getText(),
                    formularioModificarControlador.jTextFieldFechaNacimientoModificar.getText(),
                    formularioModificarControlador.jTextFieldMailModificar.getText(),
                    formularioModificarControlador.jTextFieldCodigoPostalModificar.getText());

            if (pacienteModeloControlador.isAuxModifiarFormulario() == true) {

                pacienteModeloControlador.modificarRegistro(conexionControlador.getCon(),
                        Integer.parseInt(formularioModificarControlador.jTextFieldDniModificar.getText()),
                        formularioModificarControlador.jTextFieldNombreModificar.getText(),
                        formularioModificarControlador.jTextFieldApellidoModificar.getText(),
                        Integer.parseInt(formularioModificarControlador.jTextFieldTelefonoModificar.getText()),
                        formularioModificarControlador.jTextFieldDireccionModificar.getText(),
                        formularioModificarControlador.jTextFieldFechaNacimientoModificar.getText(),
                        formularioModificarControlador.jTextFieldMailModificar.getText(),
                        Integer.parseInt(formularioModificarControlador.jTextFieldCodigoPostalModificar.getText()));
                try {
                    formularioModificarControlador.dispose();
                    conexionControlador.cerrarConexion();
                    principalVistaControlador.jTextFieldModificarRegistro.setText("Ingrese DNI del registro a modificar");
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            //Llamamos al metodo del paciente del modelo que se encargara de hacer el update en la base de datos y le enviamos los parametros

            //FIN boton modificar subFormulario
            //INICIO boton eliminar registro
        } else if (principalVistaControlador.jButtonEliminarRegistro == e.getSource()) {

            pacienteModeloControlador.verificarcampoEliminar(principalVistaControlador.jTextField1EliminarRegistro.getText());
            if (pacienteModeloControlador.isAuxEliminar() == true) {

                try {
                    conexionControlador.conectarDB();
                    pacienteModeloControlador.eliminarRegistro(conexionControlador.getCon(), Integer.parseInt(principalVistaControlador.jTextField1EliminarRegistro.getText()));
                    principalVistaControlador.jTextField1EliminarRegistro.setText("Ingrese DNI del paciente a eliminar");
                    conexionControlador.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            //FIN boton eliminar registro
            //INCIO boton buscar
        } else if (principalVistaControlador.jButtonBuscarPrincipal == e.getSource()) {

            pacienteModeloControlador.verificarcampoBuscar(principalVistaControlador.jTextFieldBuscarPrincipal.getText());
            if (pacienteModeloControlador.isAuxBuscar() == true) {

                try {
                    conexionControlador.conectarDB();
                    borrarContenidoTablaPacientes();
                    pacienteModeloControlador.buscarRegistro(conexionControlador.getCon(), Integer.parseInt(principalVistaControlador.jTextFieldBuscarPrincipal.getText()));
                    agregarDatosAlbuscarTablaPacientes();
                    conexionControlador.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
            //FIN boton buscar
        }

    }

}
