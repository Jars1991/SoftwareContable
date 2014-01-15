/*
 * ConexionBD.java nos permite crear un enlace a la base de datos especificada.
 * Author: Jassael Ruiz
 * Version: 1.0
 */

package conexion;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionBD {

	String baseDatos = "", server = "", puerto = "", url = "", user = "",
			pass = "";

	public Connection Conectar(String baseDatos, String url, String server,
			String puerto, String user, String pass) {

		this.baseDatos = baseDatos;
		this.url = url;
		this.server = server;
		this.puerto = puerto;
		this.user = user;
		this.pass = pass;

		Connection con = null;

		try {
			// Cargamos el Driver MySQL
			Class.forName("org.gjt.mm.mysql.Driver");
			// Creamos un enlace hacia la base de datos
			con = DriverManager.getConnection(this.url, this.user, this.pass);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No se encontro la clase",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			System.out.println("Se produjo un error inesperado: ");
		}
		return con;
	}
}
