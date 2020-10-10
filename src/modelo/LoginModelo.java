package modelo;

import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;

public class LoginModelo {

    private String usuario;
    private char[] pass;
    //Booleano automaticamente incializado como falso
    private boolean verificacionUC;

    public LoginModelo() {
    }

    public LoginModelo(String usuario, char[] pass, boolean verificacionUC) {
        this.usuario = usuario;
        this.pass = pass;
        this.verificacionUC = verificacionUC;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public char[] getPass() {
        return pass;
    }

    public void setPass(char[] pass) {
        this.pass = pass;
    }

    public boolean isVerificacionUC() {
        return verificacionUC;
    }

    public void setVerificacionUC(boolean verificacionUC) {
        this.verificacionUC = verificacionUC;
    }

    public String cifrarConstraseña() {

        String password = DigestUtils.sha1Hex(String.valueOf(this.pass));
        return password;
    }

    public boolean verificarUsuarioContraseña(String[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {
            if (usuario.equals(matriz[i][1]) && cifrarConstraseña().equals(matriz[i][2])) {

                verificacionUC = true;
            }
        }

        if (verificacionUC == true) {

            JOptionPane.showMessageDialog(null, "Usuario y contraseña ingresados correctamente");
            JOptionPane.showMessageDialog(null, "              Bienvenido");
        } else {
            JOptionPane.showMessageDialog(null, "El usuario y la contraseña ingresados no son correctos, por favor inténtelo nuevamente");
        }

        return verificacionUC;
    }

}
