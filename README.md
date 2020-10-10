# Sistema-Clinica

Sistema c.r.u.d de clínica desarrollado en NetBeans IDE 8.2, utilizando java, base de datos, tablas relacionales , sqlite3 y la libreria Commons Codec para el cifrado de contraseñas. Usando también la arquitectura modelo, vista , controlador o MVC.
El proyecto consta con un login de inicio de sesión , una ventana principal que nos permite consultar la base de datos asi como también modificar, buscar y eliminar registros.
Se han cargado ya algunos registros para comprobar el correcto funcionamiento del programa (los cuales pueden ser eliminados si lo desean), los datos utilizados no corresponden a personas reales, son solo de prueba.


Para ingresar al traves del login deberá ingresar los siguientes datos:

Usuario: admin

Contraseña: admin123


![](imagenes/loginClinica.jpg)


La ventana principal nos permite tango agregar registros, buscarlos, eliminarlos y modificarlos, todos a traves del DNI del registro.
Para cargar correctamente un registro al utilizar el botón 'Agregar registro' deberá introducir el formato de fecha AAAA-MM-DD o 1999-12-31 , exactamente como sale en el ejemplo utilizando los -


![](imagenes/ventanaPrincipal.jpg)


Por ultimo los datos a modificar se presentaran por completo en un sub-formulario lo cual deberá modificar solo lo que quiera cambiar y no modificar aquellos que estén plasmados correctamente a la hora de darle al botón modificar.


![](imagenes/ventanModificar.jpg)

El programa solo puede ser ejecutado a traves de un IDE ya que no cuenta con ejecutable, se recomienda usar el IDE NetBeans 8.2 ya que fue probado correctamente en distintas computadoras dando siempre un resultado positivo
