/*
 * Swc.java es la clase principal del programa. Aqui se creo toda la interfaz grafica con la cual
 * interactuara el usuari final.
 * Author: Jassael Ruiz
 * Version: 1.0
 */

package codigo;

import conexion.ConexionBD;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 * 
 * @author Jassael
 */
public class Swc extends javax.swing.JFrame {

	/**
	 * Creates new form Interfaz
	 */
	boolean bandera1 = false;
	InputMap map = new InputMap();
	InputMap map2 = new InputMap();
	InputMap map3 = new InputMap();
	JPopupMenu pm, pmt, buscaro;
	JMenuItem mi, del, bus, oper;
	DefaultMutableTreeNode cuenta;
	JSeparator sep;
	JTree arbol;
	DefaultTreeModel modelo;
	DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(
			"CATALAGO DE CUENTAS");
	DefaultMutableTreeNode activo = new DefaultMutableTreeNode("ACTIVO");
	DefaultMutableTreeNode a_circulante = new DefaultMutableTreeNode(
			"CIRCULANTE");
	DefaultMutableTreeNode p_circulante = new DefaultMutableTreeNode(
			"CIRCULANTE");
	DefaultMutableTreeNode caja = new DefaultMutableTreeNode("CAJA");
	DefaultMutableTreeNode bancos = new DefaultMutableTreeNode("BANCOS");
	DefaultMutableTreeNode inventario = new DefaultMutableTreeNode("INVENTARIO");
	DefaultMutableTreeNode clientes = new DefaultMutableTreeNode("CLIENTES");
	DefaultMutableTreeNode docobrar = new DefaultMutableTreeNode(
			"DOCUMENTOS POR COBRAR");
	DefaultMutableTreeNode deudores = new DefaultMutableTreeNode(
			"DEUDORES DIVERSOS");
	DefaultMutableTreeNode a_fijo = new DefaultMutableTreeNode("FIJO");
	DefaultMutableTreeNode p_fijo = new DefaultMutableTreeNode("FIJO");
	DefaultMutableTreeNode terrenos = new DefaultMutableTreeNode("TERRENOS");
	DefaultMutableTreeNode edificios = new DefaultMutableTreeNode("EDIFICIOS");
	DefaultMutableTreeNode transporte = new DefaultMutableTreeNode(
			"EQUIPO DE TRANSPORTE");
	DefaultMutableTreeNode moviliario = new DefaultMutableTreeNode(
			"MOBILIARIO Y EQUIPO DE OFICINA");
	DefaultMutableTreeNode equipoeyr = new DefaultMutableTreeNode(
			"EQUIPO DE ENTREGA Y DE REPARTO");
	DefaultMutableTreeNode depositosg = new DefaultMutableTreeNode(
			"DEPOSITOS EN GARANTIA");
	DefaultMutableTreeNode acciones = new DefaultMutableTreeNode(
			"ACCIONES Y VALORES");
	DefaultMutableTreeNode equipoe = new DefaultMutableTreeNode(
			"EQUIPO ELECTRONICO");
	DefaultMutableTreeNode gastosiya = new DefaultMutableTreeNode(
			"GASTOS DE INSTALACION Y ADAPTACION");
	DefaultMutableTreeNode propaganda = new DefaultMutableTreeNode(
			"PROPAGANDA Y PUBLICIDAD");
	DefaultMutableTreeNode impuestos = new DefaultMutableTreeNode(
			"IMPUESTOS ANTICIPADOS");
	DefaultMutableTreeNode rentas_anticipado = new DefaultMutableTreeNode(
			"RENTAS PAGADAS POR ANTICIPADO");
	DefaultMutableTreeNode intereses_anticipado = new DefaultMutableTreeNode(
			"INTERESES PAGADOS POR ANTICIPADO");
	DefaultMutableTreeNode pasivo = new DefaultMutableTreeNode("PASIVO");
	DefaultMutableTreeNode proveedores = new DefaultMutableTreeNode(
			"PROVEEDORES");
	DefaultMutableTreeNode doc_pagar = new DefaultMutableTreeNode(
			"DOCUMENTOS POR PAGAR");
	DefaultMutableTreeNode acreedores = new DefaultMutableTreeNode(
			"ACREEDORES DIVERSOS");
	DefaultMutableTreeNode doc_pagar_largo = new DefaultMutableTreeNode(
			"DOCUMENTOS A PAGAR A LARGO PLAZO");
	DefaultMutableTreeNode acreedores_h = new DefaultMutableTreeNode(
			"ACREEDORES HIPOTECARIOS");
	DefaultMutableTreeNode a_diferido = new DefaultMutableTreeNode("DIFERIDO");
	DefaultMutableTreeNode p_diferido = new DefaultMutableTreeNode("DIFERIDO");
	DefaultMutableTreeNode intereses_cobrados = new DefaultMutableTreeNode(
			"INTERESES COBRADOS POR ADELANTADO");
	DefaultMutableTreeNode rentas_cobradas = new DefaultMutableTreeNode(
			"RENTAS COBRADAS POR ANTICIPADO");
	DefaultMutableTreeNode capital = new DefaultMutableTreeNode("CAPITAL");
	DefaultMutableTreeNode c_social = new DefaultMutableTreeNode(
			"CAPITAL SOCIAL");
	DefaultMutableTreeNode c_contable = new DefaultMutableTreeNode(
			"CAPITAL CONTABLE");
	DefaultMutableTreeNode uope = new DefaultMutableTreeNode(
			"UTILIDAD O PERDIDA DEL EJERCICIO");
	DefaultMutableTreeNode r_acreedoras = new DefaultMutableTreeNode(
			"RESULTADOS ACREEDORAS");
	DefaultMutableTreeNode resultados = new DefaultMutableTreeNode("RESULTADOS");
	DefaultMutableTreeNode ventas = new DefaultMutableTreeNode("VENTAS");
	DefaultMutableTreeNode dev_venta = new DefaultMutableTreeNode(
			"DEVOLUCIONES SOBRE VENTAS");
	DefaultMutableTreeNode desc_venta = new DefaultMutableTreeNode(
			"DESCUENTOS SOBRE VENTAS");
	DefaultMutableTreeNode r_deudores = new DefaultMutableTreeNode(
			"RESULTADOS DEUDORES");
	DefaultMutableTreeNode gastos_venta = new DefaultMutableTreeNode(
			"GASTOS DE VENTA");
	DefaultMutableTreeNode p_seguro = new DefaultMutableTreeNode(
			"PRIMAS DE SEGURO");
	DefaultMutableTreeNode pyu = new DefaultMutableTreeNode(
			"PAPELERIA Y UTILES");
	DefaultMutableTreeNode fletes_v = new DefaultMutableTreeNode(
			"FLETES Y ACARREOS");
	DefaultMutableTreeNode gastos_varios_v = new DefaultMutableTreeNode(
			"GASTOS VARIOS");
	DefaultMutableTreeNode gastos_admon = new DefaultMutableTreeNode(
			"GASTOS ADMINISTRATIVOS");
	DefaultMutableTreeNode fletes_admon = new DefaultMutableTreeNode(
			"FLETES Y ACARREOS");
	DefaultMutableTreeNode gastos_varios_admon = new DefaultMutableTreeNode(
			"GASTOS VARIOS");
	DefaultMutableTreeNode costo_v = new DefaultMutableTreeNode(
			"COSTO DE VENTA");
	DefaultMutableTreeNode compras = new DefaultMutableTreeNode("COMPRAS");
	DefaultMutableTreeNode gasto_compras = new DefaultMutableTreeNode(
			"GASTOS SOBRE COMPRAS");
	DefaultMutableTreeNode dev_compras = new DefaultMutableTreeNode(
			"DEVOLUCIONES SOBRE COMPRAS");
	DefaultMutableTreeNode desc_compras = new DefaultMutableTreeNode(
			"DESCUENTOS SOBRE COMPRAS");
	Hashtable<Integer, String> buscar = new Hashtable<Integer, String>();
	Hashtable<Integer, String> insertar = new Hashtable<Integer, String>();
	String subt;
	GraphicsDevice grafica = GraphicsEnvironment.getLocalGraphicsEnvironment()
			.getDefaultScreenDevice();
	private int nivel = -1;
	private int id_empresa = -1, id_catalogo = -1, id_cuentas, id_subcuentas,
			id_conceptos, id_sub_conceptos, id_empresamod = -1;
	String tabla_bd = "";
	String sql;
	String registro[];
	ConexionBD obc;
	Connection conn;
	String padre = "";
	String nombre_concepto = "";
	int ultimo = 0;
	CallableStatement cst;
	int numero_hijos = 0;
	private String mt = "Software Contable", titulo_ventanap = mt;
	String tempresa = "", tcatalogo = "";
	private int id_catalogomod;
	private int id_cuenta_combo;
	private int id_subcuenta_combo;
	private String nom_cuenta_combo1;
	private String nom_subcuenta_combo;
	private String nom_concepto_combo;
	private int id_concepto_combo;
	private String nom_subconcepto_combo;
	private int id_subconcepto_combo;
	private int tipo_operacion;
	private double debe;
	private double cantidad;
	private double abono;
	private String tipo_opera;
	private String nom_cuenta_combo2;
	private int id_cuenta_combo2;
	private String nom_subcuenta_combo2;
	private int id_subcuenta_combo2;
	private String nom_concepto_combo2;
	private int id_concepto_combo2;
	private String nom_subconcepto_combo2;
	private int id_subconcepto_combo2;
	String bd = "", server = "", puerto = "", url = "", user = "", pass = "";
	private double haber;
	private BigDecimal bvar;
	private BigDecimal bvar1;
	private int numero_operacion;
	private String nombre_subconcepto;
	private String nom_subconcepto_combo3;
	private int id_subconcepto_combo3;
	private double sutilidad_ai;
	private int id_articulo_borrar;
	private String nom_articulo_borrar;
	private String nombre_concepto2;
	private boolean cargando_mayor = false;

	private void colapsar_arbol() {
		int renglones = arbol.getRowCount() - 1;

		while (renglones >= 0) {
			arbol.collapseRow(renglones);
			renglones--;
		}
	}

	private void reiniciar() {

		colapsar_arbol();
		// raiz.removeAllChildren();
		cargar_arbol2();
		// jScrollPane1.setViewportView(arbol);
		caja.removeAllChildren();
		bancos.removeAllChildren();
		inventario.removeAllChildren();
		clientes.removeAllChildren();
		docobrar.removeAllChildren();
		deudores.removeAllChildren();
		terrenos.removeAllChildren();
		edificios.removeAllChildren();
		transporte.removeAllChildren();
		moviliario.removeAllChildren();
		equipoeyr.removeAllChildren();
		depositosg.removeAllChildren();
		acciones.removeAllChildren();
		equipoe.removeAllChildren();
		gastosiya.removeAllChildren();
		propaganda.removeAllChildren();
		impuestos.removeAllChildren();
		rentas_anticipado.removeAllChildren();
		intereses_anticipado.removeAllChildren();
		proveedores.removeAllChildren();
		doc_pagar.removeAllChildren();
		acreedores.removeAllChildren();
		doc_pagar_largo.removeAllChildren();
		acreedores_h.removeAllChildren();
		intereses_cobrados.removeAllChildren();
		rentas_cobradas.removeAllChildren();
		c_social.removeAllChildren();
		c_contable.removeAllChildren();
		uope.removeAllChildren();
		ventas.removeAllChildren();
		dev_venta.removeAllChildren();
		desc_venta.removeAllChildren();
		gastos_venta.removeAllChildren();
		p_seguro.removeAllChildren();
		pyu.removeAllChildren();
		fletes_v.removeAllChildren();
		gastos_varios_v.removeAllChildren();
		gastos_admon.removeAllChildren();
		fletes_admon.removeAllChildren();
		gastos_varios_admon.removeAllChildren();
		costo_v.removeAllChildren();
		compras.removeAllChildren();
		gasto_compras.removeAllChildren();
		dev_compras.removeAllChildren();
		desc_compras.removeAllChildren();
	}

	public Swc(String bd, String server, String puerto, String user,
			String pass, String url) {

		this.bd = bd;
		this.url = url;
		this.server = server;
		this.puerto = puerto;
		this.user = user;
		this.pass = pass;
		obc = new ConexionBD();
		// conn = obc.Conectar(bd, url, server, puerto, user, pass);

		pm = new JPopupMenu();
		pmt = new JPopupMenu();
		buscaro = new JPopupMenu();
		mi = new JMenuItem("Agregar subcuenta");
		del = new JMenuItem("Borrar subcuenta");
		bus = new JMenuItem("Buscar articulo");
		oper = new JMenuItem("Buscar operacion de diario");
		sep = new JSeparator();
		mi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (nivel == 3) {
					jTextField11.setText("");
					jTextField38.setText("");
					agregar_subc.setVisible(true);
					jTextField11.requestFocusInWindow();
				} else {
					JOptionPane.showMessageDialog(arbol,
							"No se puedes ingresar conceptos a <<"
									+ nombre_concepto + " >>", "Mensaje",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		bus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buscar_articulo();
			}
		});
		del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				borrarsubc();
			}
		});

		oper.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buscar_operacion();
			}
		});

		pm.add(mi);
		pm.add(sep);
		pm.add(del);
		pmt.add(bus);
		buscaro.add(oper);
		initComponents();
		// jTable8.is;
		cargar_arbol();
		arbol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				jTree1MouseClicked(evt);
			}
		});
		map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "pressed");
		map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "released");
		jButton1.setInputMap(0, map);

		map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "pressed");
		map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "released");
		jButton10.setInputMap(0, map2);

		map3.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "pressed");
		map3.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "released");
		jButton43.setInputMap(0, map3);

		arbol.setDragEnabled(true);
		jScrollPane1.setViewportView(arbol);
		// grafica.setFullScreenWindow(this);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		cargarbuscar();
		cargarinsertar();
		// setLocation((int)(getGraphicsConfiguration().getBounds().getWidth()/4),(int)(getGraphicsConfiguration().getBounds().getHeight()/10));
	}// fin interfaz

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jDesktopPane1 = new javax.swing.JDesktopPane();
		acercade = new javax.swing.JInternalFrame();
		jPanel16 = new javax.swing.JPanel();
		jScrollPane14 = new javax.swing.JScrollPane();
		jTextPane1 = new javax.swing.JTextPane();
		jLabel38 = new javax.swing.JLabel();
		administrar_catalogos = new javax.swing.JInternalFrame();
		jScrollPane28 = new javax.swing.JScrollPane();
		jPanel18 = new javax.swing.JPanel();
		jScrollPane29 = new javax.swing.JScrollPane();
		jTable11 = new javax.swing.JTable();
		jButton36 = new javax.swing.JButton();
		jButton37 = new javax.swing.JButton();
		jButton38 = new javax.swing.JButton();
		jButton39 = new javax.swing.JButton();
		jButton40 = new javax.swing.JButton();
		administrar_empresa = new javax.swing.JInternalFrame();
		jScrollPane24 = new javax.swing.JScrollPane();
		jPanel14 = new javax.swing.JPanel();
		jScrollPane12 = new javax.swing.JScrollPane();
		jTable8 = new javax.swing.JTable();
		jButton6 = new javax.swing.JButton();
		jButton31 = new javax.swing.JButton();
		jButton32 = new javax.swing.JButton();
		jButton33 = new javax.swing.JButton();
		jButton34 = new javax.swing.JButton();
		agregar_articulo = new javax.swing.JInternalFrame();
		jScrollPane34 = new javax.swing.JScrollPane();
		jPanel21 = new javax.swing.JPanel();
		jComboBox11 = new javax.swing.JComboBox();
		jButton43 = new javax.swing.JButton();
		jTextField39 = new javax.swing.JTextField();
		jLabel54 = new javax.swing.JLabel();
		jLabel55 = new javax.swing.JLabel();
		jLabel56 = new javax.swing.JLabel();
		jTextField40 = new javax.swing.JTextField();
		jLabel62 = new javax.swing.JLabel();
		jTextField46 = new javax.swing.JTextField();
		agregar_subc = new javax.swing.JInternalFrame();
		jScrollPane4 = new javax.swing.JScrollPane();
		jPanel6 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jTextField11 = new javax.swing.JTextField();
		jLabel47 = new javax.swing.JLabel();
		jTextField38 = new javax.swing.JTextField();
		balance_general = new javax.swing.JInternalFrame();
		jScrollPane23 = new javax.swing.JScrollPane();
		jPanel13 = new javax.swing.JPanel();
		jLabel35 = new javax.swing.JLabel();
		jTextField28 = new javax.swing.JTextField();
		jLabel36 = new javax.swing.JLabel();
		jLabel37 = new javax.swing.JLabel();
		jTextField29 = new javax.swing.JTextField();
		jScrollPane11 = new javax.swing.JScrollPane();
		jTable7 = new javax.swing.JTable();
		jLabel39 = new javax.swing.JLabel();
		jLabel40 = new javax.swing.JLabel();
		jLabel41 = new javax.swing.JLabel();
		jTextField32 = new javax.swing.JTextField();
		jTextField33 = new javax.swing.JTextField();
		jTextField34 = new javax.swing.JTextField();
		jLabel42 = new javax.swing.JLabel();
		jTextField35 = new javax.swing.JTextField();
		jLabel43 = new javax.swing.JLabel();
		jTextField36 = new javax.swing.JTextField();
		jLabel64 = new javax.swing.JLabel();
		jTextField48 = new javax.swing.JTextField();
		balance_inicial = new javax.swing.JInternalFrame();
		jScrollPane20 = new javax.swing.JScrollPane();
		jPanel4 = new javax.swing.JPanel();
		jLabel20 = new javax.swing.JLabel();
		jTextField15 = new javax.swing.JTextField();
		jLabel21 = new javax.swing.JLabel();
		jLabel22 = new javax.swing.JLabel();
		jTextField16 = new javax.swing.JTextField();
		jScrollPane8 = new javax.swing.JScrollPane();
		jTable4 = new javax.swing.JTable();
		jLabel23 = new javax.swing.JLabel();
		jTextField17 = new javax.swing.JTextField();
		jTextField18 = new javax.swing.JTextField();
		jLabel24 = new javax.swing.JLabel();
		jLabel25 = new javax.swing.JLabel();
		jLabel26 = new javax.swing.JLabel();
		jTextField19 = new javax.swing.JTextField();
		jTextField20 = new javax.swing.JTextField();
		jTextField21 = new javax.swing.JTextField();
		jLabel49 = new javax.swing.JLabel();
		jLabel50 = new javax.swing.JLabel();
		catalogo = new javax.swing.JInternalFrame();
		jScrollPane15 = new javax.swing.JScrollPane();
		jSplitPane1 = new javax.swing.JSplitPane();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane6 = new javax.swing.JScrollPane();
		jPanel2 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jTextField4 = new javax.swing.JTextField();
		jButton5 = new javax.swing.JButton();
		jTextField6 = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jLabel44 = new javax.swing.JLabel();
		jTextField30 = new javax.swing.JTextField();
		jLabel45 = new javax.swing.JLabel();
		jTextField31 = new javax.swing.JTextField();
		jLabel46 = new javax.swing.JLabel();
		jTextField37 = new javax.swing.JTextField();
		jLabel63 = new javax.swing.JLabel();
		jTextField47 = new javax.swing.JTextField();
		compra = new javax.swing.JInternalFrame();
		jScrollPane18 = new javax.swing.JScrollPane();
		jPanel10 = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jButton15 = new javax.swing.JButton();
		jButton18 = new javax.swing.JButton();
		jButton19 = new javax.swing.JButton();
		jLabel17 = new javax.swing.JLabel();
		jTextField12 = new javax.swing.JTextField();
		jButton20 = new javax.swing.JButton();
		jButton21 = new javax.swing.JButton();
		jButton22 = new javax.swing.JButton();
		devoluciones = new javax.swing.JInternalFrame();
		jScrollPane19 = new javax.swing.JScrollPane();
		jPanel11 = new javax.swing.JPanel();
		jScrollPane7 = new javax.swing.JScrollPane();
		jTable3 = new javax.swing.JTable();
		jButton24 = new javax.swing.JButton();
		jButton25 = new javax.swing.JButton();
		jButton26 = new javax.swing.JButton();
		jLabel19 = new javax.swing.JLabel();
		jTextField14 = new javax.swing.JTextField();
		jButton27 = new javax.swing.JButton();
		jButton28 = new javax.swing.JButton();
		jButton29 = new javax.swing.JButton();
		edo_res = new javax.swing.JInternalFrame();
		jScrollPane21 = new javax.swing.JScrollPane();
		jPanel9 = new javax.swing.JPanel();
		jLabel27 = new javax.swing.JLabel();
		jTextField22 = new javax.swing.JTextField();
		jLabel28 = new javax.swing.JLabel();
		jLabel29 = new javax.swing.JLabel();
		jTextField23 = new javax.swing.JTextField();
		jScrollPane9 = new javax.swing.JScrollPane();
		jTable5 = new javax.swing.JTable();
		libro_diario = new javax.swing.JInternalFrame();
		jScrollPane35 = new javax.swing.JScrollPane();
		jPanel22 = new javax.swing.JPanel();
		jLabel57 = new javax.swing.JLabel();
		jScrollPane36 = new javax.swing.JScrollPane();
		jTable14 = new javax.swing.JTable();
		jLabel58 = new javax.swing.JLabel();
		jTextField41 = new javax.swing.JTextField();
		jLabel59 = new javax.swing.JLabel();
		jTextField42 = new javax.swing.JTextField();
		jLabel60 = new javax.swing.JLabel();
		jTextField43 = new javax.swing.JTextField();
		jLabel61 = new javax.swing.JLabel();
		jTextField44 = new javax.swing.JTextField();
		jTextField45 = new javax.swing.JTextField();
		libro_mayor = new javax.swing.JInternalFrame();
		jScrollPane22 = new javax.swing.JScrollPane();
		jPanel12 = new javax.swing.JPanel();
		jLabel30 = new javax.swing.JLabel();
		jComboBox6 = new javax.swing.JComboBox();
		jScrollPane10 = new javax.swing.JScrollPane();
		jTable6 = new javax.swing.JTable();
		jLabel31 = new javax.swing.JLabel();
		jTextField24 = new javax.swing.JTextField();
		jLabel32 = new javax.swing.JLabel();
		jTextField25 = new javax.swing.JTextField();
		jLabel33 = new javax.swing.JLabel();
		jTextField26 = new javax.swing.JTextField();
		jLabel34 = new javax.swing.JLabel();
		jTextField27 = new javax.swing.JTextField();
		modificar_catalogos = new javax.swing.JInternalFrame();
		jScrollPane32 = new javax.swing.JScrollPane();
		jPanel20 = new javax.swing.JPanel();
		jScrollPane33 = new javax.swing.JScrollPane();
		jTable13 = new javax.swing.JTable();
		jButton42 = new javax.swing.JButton();
		modificar_empresa = new javax.swing.JInternalFrame();
		jScrollPane26 = new javax.swing.JScrollPane();
		jPanel17 = new javax.swing.JPanel();
		jScrollPane27 = new javax.swing.JScrollPane();
		jTable10 = new javax.swing.JTable();
		jButton35 = new javax.swing.JButton();
		nuevo_catalogo = new javax.swing.JInternalFrame();
		jScrollPane30 = new javax.swing.JScrollPane();
		jPanel19 = new javax.swing.JPanel();
		jScrollPane31 = new javax.swing.JScrollPane();
		jTable12 = new javax.swing.JTable();
		jButton41 = new javax.swing.JButton();
		nueva_empresa = new javax.swing.JInternalFrame();
		jScrollPane25 = new javax.swing.JScrollPane();
		jPanel15 = new javax.swing.JPanel();
		jScrollPane13 = new javax.swing.JScrollPane();
		jTable9 = new javax.swing.JTable();
		jButton30 = new javax.swing.JButton();
		operaciones_diario = new javax.swing.JInternalFrame();
		jScrollPane16 = new javax.swing.JScrollPane();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel7 = new javax.swing.JPanel();
		jLabel12 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox();
		jTextField7 = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jComboBox3 = new javax.swing.JComboBox();
		jButton9 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jLabel8 = new javax.swing.JLabel();
		jTextField13 = new javax.swing.JTextField();
		jLabel48 = new javax.swing.JLabel();
		jComboBox7 = new javax.swing.JComboBox();
		jComboBox8 = new javax.swing.JComboBox();
		jLabel51 = new javax.swing.JLabel();
		jPanel8 = new javax.swing.JPanel();
		jLabel10 = new javax.swing.JLabel();
		jTextField8 = new javax.swing.JTextField();
		jComboBox2 = new javax.swing.JComboBox();
		jButton8 = new javax.swing.JButton();
		jLabel13 = new javax.swing.JLabel();
		jButton23 = new javax.swing.JButton();
		jComboBox5 = new javax.swing.JComboBox();
		jLabel18 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jTextField5 = new javax.swing.JTextField();
		jLabel52 = new javax.swing.JLabel();
		jComboBox9 = new javax.swing.JComboBox();
		jLabel53 = new javax.swing.JLabel();
		jComboBox10 = new javax.swing.JComboBox();
		jButton44 = new javax.swing.JButton();
		simple = new javax.swing.JInternalFrame();
		jScrollPane5 = new javax.swing.JScrollPane();
		jPanel3 = new javax.swing.JPanel();
		jComboBox4 = new javax.swing.JComboBox();
		jButton10 = new javax.swing.JButton();
		jTextField9 = new javax.swing.JTextField();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		venta = new javax.swing.JInternalFrame();
		jScrollPane17 = new javax.swing.JScrollPane();
		jPanel5 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton11 = new javax.swing.JButton();
		jButton12 = new javax.swing.JButton();
		jButton13 = new javax.swing.JButton();
		jLabel16 = new javax.swing.JLabel();
		jTextField10 = new javax.swing.JTextField();
		jButton14 = new javax.swing.JButton();
		jButton16 = new javax.swing.JButton();
		jButton17 = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem3 = new javax.swing.JMenuItem();
		jSeparator5 = new javax.swing.JPopupMenu.Separator();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem7 = new javax.swing.JMenuItem();
		jSeparator1 = new javax.swing.JPopupMenu.Separator();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenuItem5 = new javax.swing.JMenuItem();
		jSeparator2 = new javax.swing.JPopupMenu.Separator();
		jMenuItem8 = new javax.swing.JMenuItem();
		jMenu3 = new javax.swing.JMenu();
		jMenuItem4 = new javax.swing.JMenuItem();
		jMenu7 = new javax.swing.JMenu();
		jMenuItem12 = new javax.swing.JMenuItem();
		jSeparator8 = new javax.swing.JPopupMenu.Separator();
		jMenuItem14 = new javax.swing.JMenuItem();
		jMenuItem13 = new javax.swing.JMenuItem();
		jMenu4 = new javax.swing.JMenu();
		jMenuItem6 = new javax.swing.JMenuItem();
		jSeparator3 = new javax.swing.JPopupMenu.Separator();
		jMenuItem9 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem11 = new javax.swing.JMenuItem();
		jSeparator6 = new javax.swing.JPopupMenu.Separator();
		jMenuItem10 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle(titulo_ventanap);
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setFocusCycleRoot(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				ClassLoader.getSystemResource("img/finance-icon.png")));

		jDesktopPane1.setBackground(new java.awt.Color(204, 204, 204));

		acercade.setClosable(true);
		acercade.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		acercade.setTitle("Acerca de...");
		acercade.setPreferredSize(new java.awt.Dimension(323, 484));
		acercade.setVisible(false);

		jTextPane1.setEditable(false);
		jTextPane1
				.setText("Software Contable Swc\n\nCopyright 2013 JARS 1991\nDevelopment by Ruiz Serratos Jassael Alfredo\nVersion 1.38, Build 24062013\n\nSoftware realizado en la materia de Contabilidad\nFinanciera de la carrera de\nIngenieria en Sistemas Computacionales\ndel  Instituto Tecnologico  de Jiquilpan.\n\n");
		jScrollPane14.setViewportView(jTextPane1);

		jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/contabilidad.jpg"))); // NOI18N

		javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(
				jPanel16);
		jPanel16.setLayout(jPanel16Layout);
		jPanel16Layout
				.setHorizontalGroup(jPanel16Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel16Layout
										.createSequentialGroup()
										.addGap(10, 10, 10)
										.addGroup(
												jPanel16Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																jLabel38,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jScrollPane14))
										.addGap(10, 10, 10)));
		jPanel16Layout
				.setVerticalGroup(jPanel16Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel16Layout
										.createSequentialGroup()
										.addGap(10, 10, 10)
										.addComponent(jLabel38)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane14,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												112,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(10, 10, 10)));

		javax.swing.GroupLayout acercadeLayout = new javax.swing.GroupLayout(
				acercade.getContentPane());
		acercade.getContentPane().setLayout(acercadeLayout);
		acercadeLayout.setHorizontalGroup(acercadeLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		acercadeLayout.setVerticalGroup(acercadeLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		acercade.setBounds(400, 100, 323, 484);
		jDesktopPane1.add(acercade, javax.swing.JLayeredPane.DEFAULT_LAYER);

		administrar_catalogos.setClosable(true);
		administrar_catalogos
				.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		administrar_catalogos.setIconifiable(true);
		administrar_catalogos.setMaximizable(true);
		administrar_catalogos.setResizable(true);
		administrar_catalogos.setTitle("Administrar Catalogos");
		administrar_catalogos
				.setPreferredSize(new java.awt.Dimension(746, 260));
		administrar_catalogos.setVisible(false);

		jPanel18.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		jPanel18.setPreferredSize(new java.awt.Dimension(705, 185));

		jTable11.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null } }, new String[] {
						"Numero de catalogo", "Nombre del catalogo",
						"Numero de empresa", "Fecha de creacion" }) {
			Class[] types = new Class[] { java.lang.Integer.class,
					java.lang.String.class, java.lang.Integer.class,
					java.lang.String.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		jScrollPane29.setViewportView(jTable11);

		jButton36.setText("Abrir");
		jButton36.setToolTipText("Abrir un catalogo");
		jButton36.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton36ActionPerformed(evt);
			}
		});

		jButton37.setText("Nuevo");
		jButton37.setToolTipText("Nuevo catalogo");
		jButton37.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton37ActionPerformed(evt);
			}
		});

		jButton38.setText("Borrar");
		jButton38.setToolTipText("Borrar catalogo");
		jButton38.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton38ActionPerformed(evt);
			}
		});

		jButton39.setText("Modificar");
		jButton39.setToolTipText("Modificar un catalogo");
		jButton39.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton39ActionPerformed(evt);
			}
		});

		jButton40.setText("Actualizar");
		jButton40.setToolTipText("Actualizar catalogos");
		jButton40.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton40ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(
				jPanel18);
		jPanel18.setLayout(jPanel18Layout);
		jPanel18Layout
				.setHorizontalGroup(jPanel18Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel18Layout
										.createSequentialGroup()
										.addContainerGap(29, Short.MAX_VALUE)
										.addComponent(
												jScrollPane29,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												566,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel18Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																jButton39,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jButton36,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jButton37,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jButton38,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jButton40,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap(28, Short.MAX_VALUE)));
		jPanel18Layout
				.setVerticalGroup(jPanel18Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel18Layout
										.createSequentialGroup()
										.addContainerGap(25, Short.MAX_VALUE)
										.addGroup(
												jPanel18Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																jScrollPane29,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																0,
																Short.MAX_VALUE)
														.addGroup(
																jPanel18Layout
																		.createSequentialGroup()
																		.addComponent(
																				jButton36)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton37)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton38)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton39)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton40)))
										.addContainerGap(38, Short.MAX_VALUE)));

		jScrollPane28.setViewportView(jPanel18);

		javax.swing.GroupLayout administrar_catalogosLayout = new javax.swing.GroupLayout(
				administrar_catalogos.getContentPane());
		administrar_catalogos.getContentPane().setLayout(
				administrar_catalogosLayout);
		administrar_catalogosLayout
				.setHorizontalGroup(administrar_catalogosLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 740, Short.MAX_VALUE)
						.addGroup(
								administrar_catalogosLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												administrar_catalogosLayout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(
																jScrollPane28,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																720,
																Short.MAX_VALUE)
														.addContainerGap())));
		administrar_catalogosLayout
				.setVerticalGroup(administrar_catalogosLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 234, Short.MAX_VALUE)
						.addGroup(
								administrar_catalogosLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												administrar_catalogosLayout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(
																jScrollPane28,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																212,
																Short.MAX_VALUE)
														.addContainerGap())));

		administrar_catalogos.setBounds(20, 70, 746, 260);
		jDesktopPane1.add(administrar_catalogos,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		administrar_empresa.setClosable(true);
		administrar_empresa
				.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		administrar_empresa.setIconifiable(true);
		administrar_empresa.setMaximizable(true);
		administrar_empresa.setResizable(true);
		administrar_empresa.setTitle("Administrar Empresas");
		administrar_empresa.setPreferredSize(new java.awt.Dimension(743, 260));
		administrar_empresa.setVisible(false);

		jPanel14.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		jPanel14.setPreferredSize(new java.awt.Dimension(705, 185));

		jTable8.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null } }, new String[] {
						"Numero de empresa", "Nombre de la empresa",
						"Descripcion", "Fecha de creacion" }) {
			Class[] types = new Class[] { java.lang.Integer.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		});
		jScrollPane12.setViewportView(jTable8);

		jButton6.setText("Abrir");
		jButton6.setToolTipText("Abrir una empresa");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jButton31.setText("Nueva");
		jButton31.setToolTipText("Nueva empresa");
		jButton31.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton31ActionPerformed(evt);
			}
		});

		jButton32.setText("Borrar");
		jButton32.setToolTipText("Borrar una empresa");
		jButton32.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton32ActionPerformed(evt);
			}
		});

		jButton33.setText("Modificar");
		jButton33.setToolTipText("Modificar datos de la empresa");
		jButton33.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton33ActionPerformed(evt);
			}
		});

		jButton34.setText("Actualizar");
		jButton34.setToolTipText("Mostrar empresas creadas");
		jButton34.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton34ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(
				jPanel14);
		jPanel14.setLayout(jPanel14Layout);
		jPanel14Layout
				.setHorizontalGroup(jPanel14Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel14Layout
										.createSequentialGroup()
										.addContainerGap(27, Short.MAX_VALUE)
										.addComponent(
												jScrollPane12,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												566,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel14Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																jButton33,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jButton6,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jButton31,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jButton32,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jButton34,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap(27, Short.MAX_VALUE)));
		jPanel14Layout
				.setVerticalGroup(jPanel14Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel14Layout
										.createSequentialGroup()
										.addContainerGap(31, Short.MAX_VALUE)
										.addGroup(
												jPanel14Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																jScrollPane12,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																0,
																Short.MAX_VALUE)
														.addGroup(
																jPanel14Layout
																		.createSequentialGroup()
																		.addComponent(
																				jButton6)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton31)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton32)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton33)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton34)))
										.addContainerGap(32, Short.MAX_VALUE)));

		jScrollPane24.setViewportView(jPanel14);

		javax.swing.GroupLayout administrar_empresaLayout = new javax.swing.GroupLayout(
				administrar_empresa.getContentPane());
		administrar_empresa.getContentPane().setLayout(
				administrar_empresaLayout);
		administrar_empresaLayout
				.setHorizontalGroup(administrar_empresaLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								administrar_empresaLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane24,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												717, Short.MAX_VALUE)
										.addContainerGap()));
		administrar_empresaLayout
				.setVerticalGroup(administrar_empresaLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								administrar_empresaLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane24,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												212, Short.MAX_VALUE)
										.addContainerGap()));

		administrar_empresa.setBounds(20, 20, 743, 260);
		jDesktopPane1.add(administrar_empresa,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		agregar_articulo.setClosable(true);
		agregar_articulo
				.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		agregar_articulo.setIconifiable(true);
		agregar_articulo.setMaximizable(true);
		agregar_articulo.setResizable(true);
		agregar_articulo.setTitle("Agregar articulo");
		agregar_articulo.setVisible(false);

		jScrollPane34.setBorder(null);
		jScrollPane34.setMinimumSize(new java.awt.Dimension(23, 23));

		jPanel21.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		jPanel21.setMinimumSize(new java.awt.Dimension(23, 23));

		jComboBox11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox11ActionPerformed(evt);
			}
		});

		jButton43.setText("Aceptar");
		jButton43.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton43ActionPerformed(evt);
			}
		});

		jTextField39.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField39ActionPerformed(evt);
			}
		});

		jLabel54.setText("Articulo");

		jLabel55.setText("Cantidad");

		jLabel56.setText("Precio de costo $");

		jTextField40.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField40ActionPerformed(evt);
			}
		});

		jLabel62.setText("Lote del articulo");

		jTextField46.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField46ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(
				jPanel21);
		jPanel21.setLayout(jPanel21Layout);
		jPanel21Layout
				.setHorizontalGroup(jPanel21Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel21Layout
										.createSequentialGroup()
										.addGap(25, 25, 25)
										.addGroup(
												jPanel21Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jButton43)
														.addGroup(
																jPanel21Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel21Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel55)
																						.addComponent(
																								jLabel54)
																						.addComponent(
																								jLabel56)
																						.addComponent(
																								jLabel62))
																		.addGap(31,
																				31,
																				31)
																		.addGroup(
																				jPanel21Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jTextField40,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								121,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jComboBox11,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								251,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField39,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								121,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField46,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								121,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(99, Short.MAX_VALUE)));
		jPanel21Layout
				.setVerticalGroup(jPanel21Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel21Layout
										.createSequentialGroup()
										.addGap(25, 25, 25)
										.addGroup(
												jPanel21Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jComboBox11,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel54))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel21Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jTextField39,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel55))
										.addGap(26, 26, 26)
										.addGroup(
												jPanel21Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jTextField40,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel56))
										.addGap(26, 26, 26)
										.addGroup(
												jPanel21Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jTextField46,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel62))
										.addGap(39, 39, 39)
										.addComponent(jButton43)
										.addContainerGap(52, Short.MAX_VALUE)));

		jScrollPane34.setViewportView(jPanel21);

		javax.swing.GroupLayout agregar_articuloLayout = new javax.swing.GroupLayout(
				agregar_articulo.getContentPane());
		agregar_articulo.getContentPane().setLayout(agregar_articuloLayout);
		agregar_articuloLayout
				.setHorizontalGroup(agregar_articuloLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 514, Short.MAX_VALUE)
						.addGroup(
								agregar_articuloLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												agregar_articuloLayout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(
																jScrollPane34,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addContainerGap())));
		agregar_articuloLayout
				.setVerticalGroup(agregar_articuloLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 319, Short.MAX_VALUE)
						.addGroup(
								agregar_articuloLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												agregar_articuloLayout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(
																jScrollPane34,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addContainerGap())));

		agregar_articulo.setBounds(20, 20, 520, 345);
		jDesktopPane1.add(agregar_articulo,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		agregar_subc.setClosable(true);
		agregar_subc
				.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		agregar_subc.setIconifiable(true);
		agregar_subc.setMaximizable(true);
		agregar_subc.setResizable(true);
		agregar_subc.setTitle("Agregar");
		agregar_subc.setPreferredSize(new java.awt.Dimension(542, 246));
		agregar_subc.setVisible(false);

		jScrollPane4.setBorder(null);

		jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));

		jLabel5.setText("Sub concepto");

		jButton1.setText("Aceptar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jTextField11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField11ActionPerformed(evt);
			}
		});

		jLabel47.setText("Descripcion");

		jTextField38.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField38ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(
				jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout
				.setHorizontalGroup(jPanel6Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel6Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel6Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel6Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel47)
																		.addGap(30,
																				30,
																				30)
																		.addGroup(
																				jPanel6Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jTextField11,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								280,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField38,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								280,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addComponent(jButton1))
										.addContainerGap(136, Short.MAX_VALUE))
						.addGroup(
								jPanel6Layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												jPanel6Layout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(jLabel5)
														.addContainerGap(435,
																Short.MAX_VALUE))));
		jPanel6Layout
				.setVerticalGroup(jPanel6Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel6Layout
										.createSequentialGroup()
										.addGap(22, 22, 22)
										.addComponent(
												jTextField11,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(40, 40, 40)
										.addGroup(
												jPanel6Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel47)
														.addComponent(
																jTextField38,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(28, 28, 28)
										.addComponent(jButton1)
										.addContainerGap(39, Short.MAX_VALUE))
						.addGroup(
								jPanel6Layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												jPanel6Layout
														.createSequentialGroup()
														.addGap(22, 22, 22)
														.addComponent(jLabel5)
														.addContainerGap(156,
																Short.MAX_VALUE))));

		jScrollPane4.setViewportView(jPanel6);

		javax.swing.GroupLayout agregar_subcLayout = new javax.swing.GroupLayout(
				agregar_subc.getContentPane());
		agregar_subc.getContentPane().setLayout(agregar_subcLayout);
		agregar_subcLayout.setHorizontalGroup(agregar_subcLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						agregar_subcLayout.createSequentialGroup()
								.addContainerGap().addComponent(jScrollPane4)
								.addContainerGap()));
		agregar_subcLayout.setVerticalGroup(agregar_subcLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						agregar_subcLayout.createSequentialGroup()
								.addContainerGap().addComponent(jScrollPane4)
								.addContainerGap()));

		agregar_subc.setBounds(140, 140, 542, 246);
		jDesktopPane1.add(agregar_subc, javax.swing.JLayeredPane.DEFAULT_LAYER);

		balance_general.setClosable(true);
		balance_general
				.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		balance_general.setIconifiable(true);
		balance_general.setMaximizable(true);
		balance_general.setResizable(true);
		balance_general.setTitle("Balance General");
		balance_general.setPreferredSize(new java.awt.Dimension(916, 717));
		balance_general.setVisible(false);

		jScrollPane23.setPreferredSize(new java.awt.Dimension(878, 664));

		jPanel13.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));

		jLabel35.setText("Nombre de la Empresa: ");

		jTextField28.setEditable(false);

		jLabel36.setText("BALANCE GENERAL");

		jLabel37.setText("Fecha final: ");
		jLabel37.setToolTipText("Fecha del final del ejercicio");

		jTextField29.setEditable(false);

		jTable7.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null } }, new String[] {
						"Concepto", "Parcial", "Debe", "Haber" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		jScrollPane11.setViewportView(jTable7);

		jLabel39.setText("Total activos");

		jLabel40.setText("Total pasivos");

		jLabel41.setText("Capital Contable");

		jTextField32.setEditable(false);

		jTextField33.setEditable(false);

		jTextField34.setEditable(false);

		jLabel42.setText("U.O.P.D.E.");
		jLabel42.setToolTipText("Utilidad o Perdida Del Ejercicio");

		jTextField35.setEditable(false);

		jLabel43.setText("C.S");
		jLabel43.setToolTipText("Capital Social");

		jTextField36.setEditable(false);

		jLabel64.setText("Fecha inicial: ");
		jLabel64.setToolTipText("Fecha de inicio del ejercicio");

		jTextField48.setEditable(false);

		javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(
				jPanel13);
		jPanel13.setLayout(jPanel13Layout);
		jPanel13Layout
				.setHorizontalGroup(jPanel13Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel13Layout
										.createSequentialGroup()
										.addContainerGap(23, Short.MAX_VALUE)
										.addGroup(
												jPanel13Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel13Layout
																		.createSequentialGroup()
																		.addGap(30,
																				30,
																				30)
																		.addGroup(
																				jPanel13Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								jLabel41,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								88,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel39,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel40,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel42,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel43,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addGap(18,
																				18,
																				18)
																		.addGroup(
																				jPanel13Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jTextField32,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								135,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField33,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								135,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField34,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								135,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField35,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								135,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField36,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								135,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addContainerGap(
																				586,
																				Short.MAX_VALUE))
														.addGroup(
																jPanel13Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel13Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jScrollPane11)
																						.addGroup(
																								jPanel13Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel35)
																										.addGap(27,
																												27,
																												27)
																										.addComponent(
																												jTextField28,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												176,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												jLabel64)
																										.addGap(27,
																												27,
																												27)
																										.addComponent(
																												jTextField48,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												107,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(18,
																												18,
																												18)
																										.addComponent(
																												jLabel37)
																										.addGap(27,
																												27,
																												27)
																										.addComponent(
																												jTextField29,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												107,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								jPanel13Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel36)
																										.addGap(0,
																												739,
																												Short.MAX_VALUE)))
																		.addContainerGap(
																				25,
																				Short.MAX_VALUE)))));
		jPanel13Layout
				.setVerticalGroup(jPanel13Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel13Layout
										.createSequentialGroup()
										.addContainerGap(57, Short.MAX_VALUE)
										.addComponent(jLabel36)
										.addGap(30, 30, 30)
										.addGroup(
												jPanel13Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel13Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jLabel64)
																		.addComponent(
																				jTextField48,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel13Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jLabel35)
																		.addComponent(
																				jTextField28,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jLabel37)
																		.addComponent(
																				jTextField29,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(33, 33, 33)
										.addComponent(
												jScrollPane11,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												297,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(20, 20, 20)
										.addGroup(
												jPanel13Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel39)
														.addComponent(
																jTextField32,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel13Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel40)
														.addComponent(
																jTextField33,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel13Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel41)
														.addComponent(
																jTextField34,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel13Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel42)
														.addComponent(
																jTextField35,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel13Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel43)
														.addComponent(
																jTextField36,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(64, Short.MAX_VALUE)));

		jScrollPane23.setViewportView(jPanel13);

		javax.swing.GroupLayout balance_generalLayout = new javax.swing.GroupLayout(
				balance_general.getContentPane());
		balance_general.getContentPane().setLayout(balance_generalLayout);
		balance_generalLayout
				.setHorizontalGroup(balance_generalLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 910, Short.MAX_VALUE)
						.addGroup(
								balance_generalLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												balance_generalLayout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(
																jScrollPane23,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																890,
																Short.MAX_VALUE)
														.addContainerGap())));
		balance_generalLayout
				.setVerticalGroup(balance_generalLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 691, Short.MAX_VALUE)
						.addGroup(
								balance_generalLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												balance_generalLayout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(
																jScrollPane23,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																669,
																Short.MAX_VALUE)
														.addContainerGap())));

		balance_general.setBounds(10, 10, 916, 717);
		jDesktopPane1.add(balance_general,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		balance_inicial.setClosable(true);
		balance_inicial
				.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		balance_inicial.setIconifiable(true);
		balance_inicial.setMaximizable(true);
		balance_inicial.setResizable(true);
		balance_inicial.setTitle("Balance Inicial");
		balance_inicial.setPreferredSize(new java.awt.Dimension(833, 619));
		balance_inicial.setVisible(false);

		jScrollPane20.setPreferredSize(new java.awt.Dimension(795, 571));

		jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		jPanel4.setPreferredSize(new java.awt.Dimension(785, 560));

		jLabel20.setText("Nombre de la Empresa: ");

		jTextField15.setEditable(false);

		jLabel21.setText("BALANCE INICIAL O ACIENTO DE APERTURA");

		jLabel22.setText("Fecha: ");

		jTextField16.setEditable(false);

		jTable4.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null } },
				new String[] { "Concepto", "Parcial", "Debe", "Haber",
						"Fecha creacion" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.Double.class, java.lang.Double.class,
					java.lang.Double.class, java.lang.String.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		jScrollPane8.setViewportView(jTable4);

		jLabel23.setText("Sumas");

		jTextField17.setEditable(false);

		jTextField18.setEditable(false);

		jLabel24.setText("Total activos");

		jLabel25.setText("Total pasivos");

		jLabel26.setText("Capital Contable");

		jTextField19.setEditable(false);

		jTextField20.setEditable(false);

		jTextField21.setEditable(false);

		jLabel49.setText("Total Debe");

		jLabel50.setText("Total Haber");

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout
				.setHorizontalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jScrollPane8)
														.addGroup(
																jPanel4Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel21)
																		.addGap(0,
																				0,
																				Short.MAX_VALUE))
														.addGroup(
																jPanel4Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel20)
																		.addGap(27,
																				27,
																				27)
																		.addComponent(
																				jTextField15,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				176,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jLabel22)
																		.addGap(27,
																				27,
																				27)
																		.addComponent(
																				jTextField16,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				107,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel4Layout
																		.createSequentialGroup()
																		.addGap(30,
																				30,
																				30)
																		.addGroup(
																				jPanel4Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel4Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING,
																												false)
																										.addComponent(
																												jLabel26,
																												javax.swing.GroupLayout.Alignment.LEADING,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												88,
																												Short.MAX_VALUE)
																										.addComponent(
																												jLabel24,
																												javax.swing.GroupLayout.Alignment.LEADING,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												jLabel25,
																												javax.swing.GroupLayout.Alignment.LEADING,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE))
																						.addComponent(
																								jLabel23,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								45,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(18,
																				18,
																				18)
																		.addGroup(
																				jPanel4Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel4Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel49,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												88,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextField17,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												110,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(39,
																												39,
																												39)
																										.addComponent(
																												jLabel50,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												88,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								jTextField19,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								135,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField20,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								135,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField21,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								135,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(31,
																				31,
																				31)
																		.addComponent(
																				jTextField18,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				110,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(31,
																				31,
																				31)))
										.addContainerGap()));
		jPanel4Layout
				.setVerticalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addContainerGap(34, Short.MAX_VALUE)
										.addComponent(jLabel21)
										.addGap(30, 30, 30)
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel20)
														.addComponent(
																jTextField15,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel22)
														.addComponent(
																jTextField16,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(33, 33, 33)
										.addComponent(
												jScrollPane8,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												233,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(20, 20, 20)
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextField17,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField18,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel23)
														.addComponent(jLabel49)
														.addComponent(jLabel50))
										.addGap(50, 50, 50)
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel24)
														.addComponent(
																jTextField19,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel25)
														.addComponent(
																jTextField20,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel26)
														.addComponent(
																jTextField21,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(35, Short.MAX_VALUE)));

		jScrollPane20.setViewportView(jPanel4);

		javax.swing.GroupLayout balance_inicialLayout = new javax.swing.GroupLayout(
				balance_inicial.getContentPane());
		balance_inicial.getContentPane().setLayout(balance_inicialLayout);
		balance_inicialLayout
				.setHorizontalGroup(balance_inicialLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								balance_inicialLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane20,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												807, Short.MAX_VALUE)
										.addContainerGap()));
		balance_inicialLayout.setVerticalGroup(balance_inicialLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						balance_inicialLayout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPane20,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addContainerGap()));

		balance_inicial.setBounds(10, 10, 833, 619);
		jDesktopPane1.add(balance_inicial,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		catalogo.setClosable(true);
		catalogo.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		catalogo.setIconifiable(true);
		catalogo.setMaximizable(true);
		catalogo.setResizable(true);
		catalogo.setTitle("Catalogo de cuentas");
		catalogo.setFocusCycleRoot(false);
		catalogo.setPreferredSize(new java.awt.Dimension(753, 732));
		catalogo.setVisible(false);

		jScrollPane15.setPreferredSize(new java.awt.Dimension(748, 684));

		jSplitPane1.setBorder(null);
		jSplitPane1.setDividerLocation(250);
		jSplitPane1.setDividerSize(3);
		jSplitPane1.setToolTipText("");
		jSplitPane1.setMinimumSize(new java.awt.Dimension(200, 200));

		jScrollPane1.setPreferredSize(new java.awt.Dimension(248, 563));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 250, Short.MAX_VALUE)
				.addGroup(
						jPanel1Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										250, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 680, Short.MAX_VALUE)
				.addGroup(
						jPanel1Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										680, Short.MAX_VALUE)));

		jSplitPane1.setLeftComponent(jPanel1);

		jScrollPane6.setPreferredSize(new java.awt.Dimension(442, 470));
		jScrollPane6.setRequestFocusEnabled(false);

		jPanel2.setPreferredSize(new java.awt.Dimension(437, 461));

		jLabel1.setText("Concepto");

		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jLabel2.setText("Debe");

		jTextField2.setEditable(false);
		jTextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});

		jLabel3.setText("Haber");

		jTextField3.setEditable(false);
		jTextField3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField3ActionPerformed(evt);
			}
		});

		jLabel4.setText("Ruta");

		jTextField4.setEditable(false);
		jTextField4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField4ActionPerformed(evt);
			}
		});

		jButton5.setText("Modificar");
		jButton5.setToolTipText("Modificar sub concepto");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jTextField6.setEditable(false);

		jLabel6.setText("Codigo");

		jLabel44.setText("Descripcion");

		jTextField30.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField30ActionPerformed(evt);
			}
		});

		jLabel45.setText("Saldo Deudor");

		jTextField31.setEditable(false);
		jTextField31.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField31ActionPerformed(evt);
			}
		});

		jLabel46.setText("Fecha de creacion");

		jTextField37.setEditable(false);
		jTextField37.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField37ActionPerformed(evt);
			}
		});

		jLabel63.setText("Saldo Acreedor");

		jTextField47.setEditable(false);
		jTextField47.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField47ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGap(15, 15, 15)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jButton5)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel1)
																						.addComponent(
																								jLabel44)
																						.addComponent(
																								jLabel6)
																						.addComponent(
																								jLabel2)
																						.addComponent(
																								jLabel3)
																						.addComponent(
																								jLabel45)
																						.addComponent(
																								jLabel46)
																						.addComponent(
																								jLabel63))
																		.addGap(20,
																				20,
																				20)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jTextField3,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								242,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								242,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField6,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								242,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								242,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField30,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								242,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField31,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								242,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField4,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								239,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField37,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								242,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField47,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								242,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addComponent(jLabel4))
										.addContainerGap(102, Short.MAX_VALUE)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGap(31, 31, 31)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel4)
														.addComponent(
																jTextField4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(25, 25, 25)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(25, 25, 25)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel46)
														.addComponent(
																jTextField37,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(25, 25, 25)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel44)
														.addComponent(
																jTextField30,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(25, 25, 25)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel6)
														.addComponent(
																jTextField6,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(25, 25, 25)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																jTextField2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(25, 25, 25)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(
																jTextField3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(25, 25, 25)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel45)
														.addComponent(
																jTextField31,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(25, 25, 25)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel63)
														.addComponent(
																jTextField47,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(39, 39, 39)
										.addComponent(jButton5)
										.addContainerGap(203, Short.MAX_VALUE)));

		jScrollPane6.setViewportView(jPanel2);

		jSplitPane1.setRightComponent(jScrollPane6);

		jScrollPane15.setViewportView(jSplitPane1);

		javax.swing.GroupLayout catalogoLayout = new javax.swing.GroupLayout(
				catalogo.getContentPane());
		catalogo.getContentPane().setLayout(catalogoLayout);
		catalogoLayout.setHorizontalGroup(catalogoLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				catalogoLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane15,
								javax.swing.GroupLayout.DEFAULT_SIZE, 727,
								Short.MAX_VALUE).addContainerGap()));
		catalogoLayout.setVerticalGroup(catalogoLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				catalogoLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane15,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));

		catalogo.setBounds(10, 10, 753, 732);
		jDesktopPane1.add(catalogo, javax.swing.JLayeredPane.DEFAULT_LAYER);

		compra.setClosable(true);
		compra.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		compra.setIconifiable(true);
		compra.setMaximizable(true);
		compra.setResizable(true);
		compra.setTitle("Sub concepto compra");
		compra.setPreferredSize(new java.awt.Dimension(781, 298));
		compra.setVisible(false);

		jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		jPanel10.setPreferredSize(new java.awt.Dimension(751, 238));

		jTable2.setAutoCreateRowSorter(true);
		jTable2.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null } },
				new String[] { "Nombre", "Cantidad", "Lote", "Precio de costo",
						"Sub Total" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Double.class, java.lang.Double.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTable2MouseClicked(evt);
			}
		});
		jScrollPane3.setViewportView(jTable2);

		jButton15.setText("Aceptar");
		jButton15.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton15ActionPerformed(evt);
			}
		});

		jButton18.setText("+");
		jButton18.setToolTipText("Agregar renglon");
		jButton18.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton18ActionPerformed(evt);
			}
		});

		jButton19.setText("-");
		jButton19.setToolTipText("Borrar renglon");
		jButton19.setPreferredSize(new java.awt.Dimension(43, 23));
		jButton19.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton19ActionPerformed(evt);
			}
		});

		jLabel17.setText("Total : $");

		jButton20.setText("A Tabla");
		jButton20.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton20ActionPerformed(evt);
			}
		});

		jButton21.setText("Calcular total");
		jButton21.setToolTipText("Calcular el total de la compra");
		jButton21.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton21ActionPerformed(evt);
			}
		});

		jButton22.setText("Limpiar");
		jButton22.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton22ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(
				jPanel10);
		jPanel10.setLayout(jPanel10Layout);
		jPanel10Layout
				.setHorizontalGroup(jPanel10Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel10Layout
										.createSequentialGroup()
										.addGap(4, 4, 4)
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel10Layout
																		.createSequentialGroup()
																		.addComponent(
																				jButton21,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				105,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(28,
																				28,
																				28)
																		.addComponent(
																				jLabel17)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jTextField12,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				115,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel10Layout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				650,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel10Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jButton22)
																						.addComponent(
																								jButton19,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								43,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jButton18,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								43,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																jPanel10Layout
																		.createSequentialGroup()
																		.addComponent(
																				jButton15)
																		.addGap(42,
																				42,
																				42)
																		.addComponent(
																				jButton20)))
										.addContainerGap(18, Short.MAX_VALUE)));
		jPanel10Layout
				.setVerticalGroup(jPanel10Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel10Layout
										.createSequentialGroup()
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel10Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jScrollPane3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				121,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel10Layout
																		.createSequentialGroup()
																		.addGap(26,
																				26,
																				26)
																		.addComponent(
																				jButton18)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton19,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				23,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jButton22)))
										.addGap(14, 14, 14)
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton21)
														.addComponent(jLabel17)
														.addComponent(
																jTextField12,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(29, 29, 29)
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton15)
														.addComponent(jButton20))
										.addContainerGap(19, Short.MAX_VALUE)));

		jScrollPane18.setViewportView(jPanel10);

		javax.swing.GroupLayout compraLayout = new javax.swing.GroupLayout(
				compra.getContentPane());
		compra.getContentPane().setLayout(compraLayout);
		compraLayout.setHorizontalGroup(compraLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				compraLayout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane18).addContainerGap()));
		compraLayout.setVerticalGroup(compraLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				compraLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane18,
								javax.swing.GroupLayout.DEFAULT_SIZE, 250,
								Short.MAX_VALUE).addContainerGap()));

		compra.setBounds(60, 60, 781, 298);
		jDesktopPane1.add(compra, javax.swing.JLayeredPane.DEFAULT_LAYER);

		devoluciones.setClosable(true);
		devoluciones
				.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		devoluciones.setIconifiable(true);
		devoluciones.setMaximizable(true);
		devoluciones.setResizable(true);
		devoluciones.setTitle("Devolucionees");
		devoluciones.setPreferredSize(new java.awt.Dimension(793, 315));
		devoluciones.setVisible(false);

		jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		jPanel11.setPreferredSize(new java.awt.Dimension(755, 260));

		jTable3.setAutoCreateRowSorter(true);
		jTable3.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null } },
				new String[] { "Nombre", "Cantidad", "Lote", "Precio de venta",
						"Sub Total" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Double.class, java.lang.Double.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTable3MouseClicked(evt);
			}
		});
		jScrollPane7.setViewportView(jTable3);

		jButton24.setText("Aceptar");
		jButton24.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton24ActionPerformed(evt);
			}
		});

		jButton25.setText("+");
		jButton25.setToolTipText("Agregar renglon");
		jButton25.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton25ActionPerformed(evt);
			}
		});

		jButton26.setText("-");
		jButton26.setToolTipText("Borrar renglon");
		jButton26.setPreferredSize(new java.awt.Dimension(43, 23));
		jButton26.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton26ActionPerformed(evt);
			}
		});

		jLabel19.setText("Total : $");

		jButton27.setText("A Tabla");
		jButton27.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton27ActionPerformed(evt);
			}
		});

		jButton28.setText("Calcular total");
		jButton28.setToolTipText("Calcular el total de la compra");
		jButton28.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton28ActionPerformed(evt);
			}
		});

		jButton29.setText("Limpiar");
		jButton29.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton29ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(
				jPanel11);
		jPanel11.setLayout(jPanel11Layout);
		jPanel11Layout
				.setHorizontalGroup(jPanel11Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel11Layout
										.createSequentialGroup()
										.addGap(4, 4, 4)
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel11Layout
																		.createSequentialGroup()
																		.addComponent(
																				jButton28,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				105,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(28,
																				28,
																				28)
																		.addComponent(
																				jLabel19)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jTextField14,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				115,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel11Layout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane7,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				650,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel11Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jButton29)
																						.addComponent(
																								jButton26,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								43,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jButton25,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								43,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																jPanel11Layout
																		.createSequentialGroup()
																		.addComponent(
																				jButton24)
																		.addGap(42,
																				42,
																				42)
																		.addComponent(
																				jButton27)))
										.addContainerGap(22, Short.MAX_VALUE)));
		jPanel11Layout
				.setVerticalGroup(jPanel11Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel11Layout
										.createSequentialGroup()
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																jPanel11Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jScrollPane7,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				115,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(20,
																				20,
																				20))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																jPanel11Layout
																		.createSequentialGroup()
																		.addGap(29,
																				29,
																				29)
																		.addComponent(
																				jButton25)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton26,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				23,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jButton29)))
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton28)
														.addComponent(jLabel19)
														.addComponent(
																jTextField14,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(29, 29, 29)
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton24)
														.addComponent(jButton27))
										.addGap(33, 33, 33)));

		jScrollPane19.setViewportView(jPanel11);

		javax.swing.GroupLayout devolucionesLayout = new javax.swing.GroupLayout(
				devoluciones.getContentPane());
		devoluciones.getContentPane().setLayout(devolucionesLayout);
		devolucionesLayout.setHorizontalGroup(devolucionesLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						devolucionesLayout
								.createSequentialGroup()
								.addContainerGap(14, Short.MAX_VALUE)
								.addComponent(jScrollPane19,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(14, Short.MAX_VALUE)));
		devolucionesLayout.setVerticalGroup(devolucionesLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						devolucionesLayout
								.createSequentialGroup()
								.addContainerGap(12, Short.MAX_VALUE)
								.addComponent(jScrollPane19,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										265, Short.MAX_VALUE)
								.addContainerGap(12, Short.MAX_VALUE)));

		devoluciones.setBounds(60, 60, 793, 315);
		jDesktopPane1.add(devoluciones, javax.swing.JLayeredPane.DEFAULT_LAYER);

		edo_res.setClosable(true);
		edo_res.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		edo_res.setIconifiable(true);
		edo_res.setMaximizable(true);
		edo_res.setResizable(true);
		edo_res.setTitle("Estado de resultados");
		edo_res.setPreferredSize(new java.awt.Dimension(1001, 526));
		edo_res.setVisible(false);

		jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));

		jLabel27.setText("Nombre de la Empresa: ");

		jTextField22.setEditable(false);

		jLabel28.setText("Estado de resultados");

		jLabel29.setText("Fecha: ");

		jTextField23.setEditable(false);

		jTable5.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null } },
				new String[] { "Conceptos", "", "", "", "" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		jScrollPane9.setViewportView(jTable5);

		javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(
				jPanel9);
		jPanel9.setLayout(jPanel9Layout);
		jPanel9Layout
				.setHorizontalGroup(jPanel9Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel9Layout
										.createSequentialGroup()
										.addContainerGap(54, Short.MAX_VALUE)
										.addGroup(
												jPanel9Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jScrollPane9,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																850,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																jPanel9Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(
																				jPanel9Layout
																						.createSequentialGroup()
																						.addComponent(
																								jLabel27)
																						.addGap(27,
																								27,
																								27)
																						.addComponent(
																								jTextField22,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								176,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(365,
																								365,
																								365)
																						.addComponent(
																								jLabel29)
																						.addGap(27,
																								27,
																								27)
																						.addComponent(
																								jTextField23,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								107,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addComponent(
																				jLabel28)))
										.addContainerGap(59, Short.MAX_VALUE)));
		jPanel9Layout
				.setVerticalGroup(jPanel9Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel9Layout
										.createSequentialGroup()
										.addGap(28, 28, 28)
										.addComponent(jLabel28)
										.addGap(30, 30, 30)
										.addGroup(
												jPanel9Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel27)
														.addComponent(
																jTextField22,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel29)
														.addComponent(
																jTextField23,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(32, 32, 32)
										.addComponent(
												jScrollPane9,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												257,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(87, Short.MAX_VALUE)));

		jScrollPane21.setViewportView(jPanel9);

		javax.swing.GroupLayout edo_resLayout = new javax.swing.GroupLayout(
				edo_res.getContentPane());
		edo_res.getContentPane().setLayout(edo_resLayout);
		edo_resLayout.setHorizontalGroup(edo_resLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				edo_resLayout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane21).addContainerGap()));
		edo_resLayout.setVerticalGroup(edo_resLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				edo_resLayout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane21).addContainerGap()));

		edo_res.setBounds(10, 10, 1001, 526);
		jDesktopPane1.add(edo_res, javax.swing.JLayeredPane.DEFAULT_LAYER);

		libro_diario.setClosable(true);
		libro_diario
				.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		libro_diario.setIconifiable(true);
		libro_diario.setMaximizable(true);
		libro_diario.setResizable(true);
		libro_diario.setTitle("Libro Diario");
		libro_diario.setVisible(false);

		jPanel22.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		jPanel22.setPreferredSize(new java.awt.Dimension(828, 378));

		jLabel57.setText("Concepto a buscar");

		jTable14.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		jTable14.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null } },
				new String[] { "No. de operacion", "Nombre subconcepto",
						"Debe", "Haber", "Fecha creacion" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		jTable14.setShowVerticalLines(false);
		jTable14.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTable14MouseClicked(evt);
			}
		});
		jScrollPane36.setViewportView(jTable14);

		jLabel58.setText("Movimiento Deudor");

		jLabel59.setText("Movimiento Acredor");

		jLabel60.setText("Saldo Deudor");

		jLabel61.setText("Saldo Acredor");

		jTextField45.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField45ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(
				jPanel22);
		jPanel22.setLayout(jPanel22Layout);
		jPanel22Layout
				.setHorizontalGroup(jPanel22Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel22Layout
										.createSequentialGroup()
										.addGap(20, 20, 20)
										.addGroup(
												jPanel22Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel22Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel57)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jTextField45,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				250,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel22Layout
																		.createSequentialGroup()
																		.addGap(260,
																				260,
																				260)
																		.addGroup(
																				jPanel22Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addGroup(
																								jPanel22Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel58)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextField41,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												112,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								jPanel22Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel60)
																										.addGap(32,
																												32,
																												32)
																										.addComponent(
																												jTextField43,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												112,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addGap(18,
																				18,
																				18)
																		.addGroup(
																				jPanel22Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel59)
																						.addComponent(
																								jLabel61))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel22Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jTextField44,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								112,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField42,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								112,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addGap(55, 55, 55))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel22Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane36,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												746,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(90, 90, 90)));
		jPanel22Layout
				.setVerticalGroup(jPanel22Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel22Layout
										.createSequentialGroup()
										.addGap(31, 31, 31)
										.addGroup(
												jPanel22Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel57)
														.addComponent(
																jTextField45,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(46, 46, 46)
										.addComponent(
												jScrollPane36,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												164,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addGroup(
												jPanel22Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel58)
														.addComponent(
																jTextField41,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel59)
														.addComponent(
																jTextField42,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel22Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel60)
														.addComponent(
																jTextField43,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel61)
														.addComponent(
																jTextField44,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(35, 35, 35)));

		jScrollPane35.setViewportView(jPanel22);

		javax.swing.GroupLayout libro_diarioLayout = new javax.swing.GroupLayout(
				libro_diario.getContentPane());
		libro_diario.getContentPane().setLayout(libro_diarioLayout);
		libro_diarioLayout
				.setHorizontalGroup(libro_diarioLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								libro_diarioLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane35,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												866, Short.MAX_VALUE)
										.addContainerGap()));
		libro_diarioLayout
				.setVerticalGroup(libro_diarioLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								libro_diarioLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane35,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												392, Short.MAX_VALUE)
										.addContainerGap()));

		libro_diario.setBounds(0, 0, 892, 440);
		jDesktopPane1.add(libro_diario, javax.swing.JLayeredPane.DEFAULT_LAYER);

		libro_mayor.setClosable(true);
		libro_mayor
				.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		libro_mayor.setIconifiable(true);
		libro_mayor.setMaximizable(true);
		libro_mayor.setResizable(true);
		libro_mayor.setTitle("Libro Mayor");
		libro_mayor.setPreferredSize(new java.awt.Dimension(894, 435));
		libro_mayor.setVisible(false);

		jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		jPanel12.setPreferredSize(new java.awt.Dimension(828, 378));

		jLabel30.setText("Concepto a buscar");

		jComboBox6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox6ActionPerformed(evt);
			}
		});

		jTable6.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		jTable6.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null } }, new String[] {
						"No. de operacion", "Debe", "Haber", "Fecha creacion" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		jTable6.setShowVerticalLines(false);
		jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTable6MouseClicked(evt);
			}
		});
		jScrollPane10.setViewportView(jTable6);

		jLabel31.setText("Movimiento Deudor");

		jLabel32.setText("Movimiento Acredor");

		jLabel33.setText("Saldo Deudor");

		jLabel34.setText("Saldo Acredor");

		javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(
				jPanel12);
		jPanel12.setLayout(jPanel12Layout);
		jPanel12Layout
				.setHorizontalGroup(jPanel12Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel12Layout
										.createSequentialGroup()
										.addGap(20, 20, 20)
										.addGroup(
												jPanel12Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel12Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel30)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jComboBox6,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel12Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																		.addGroup(
																				jPanel12Layout
																						.createSequentialGroup()
																						.addGroup(
																								jPanel12Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING,
																												false)
																										.addGroup(
																												jPanel12Layout
																														.createSequentialGroup()
																														.addComponent(
																																jLabel31)
																														.addPreferredGap(
																																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																														.addComponent(
																																jTextField24,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																112,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGroup(
																												jPanel12Layout
																														.createSequentialGroup()
																														.addComponent(
																																jLabel33)
																														.addGap(32,
																																32,
																																32)
																														.addComponent(
																																jTextField26,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																112,
																																javax.swing.GroupLayout.PREFERRED_SIZE)))
																						.addGap(18,
																								18,
																								18)
																						.addGroup(
																								jPanel12Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																										.addComponent(
																												jLabel32)
																										.addComponent(
																												jLabel34))
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addGroup(
																								jPanel12Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																										.addComponent(
																												jTextField27,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												112,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												jTextField25,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												112,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addComponent(
																				jScrollPane10,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				697,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(55, 55, 55)));
		jPanel12Layout
				.setVerticalGroup(jPanel12Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel12Layout
										.createSequentialGroup()
										.addGap(30, 30, 30)
										.addGroup(
												jPanel12Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel30)
														.addComponent(
																jComboBox6))
										.addGap(45, 45, 45)
										.addComponent(
												jScrollPane10,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												164,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addGroup(
												jPanel12Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel31)
														.addComponent(
																jTextField24,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel32)
														.addComponent(
																jTextField25,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel12Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel33)
														.addComponent(
																jTextField26,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel34)
														.addComponent(
																jTextField27,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(35, 35, 35)));

		jScrollPane22.setViewportView(jPanel12);

		javax.swing.GroupLayout libro_mayorLayout = new javax.swing.GroupLayout(
				libro_mayor.getContentPane());
		libro_mayor.getContentPane().setLayout(libro_mayorLayout);
		libro_mayorLayout
				.setHorizontalGroup(libro_mayorLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 888, Short.MAX_VALUE)
						.addGroup(
								libro_mayorLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												libro_mayorLayout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(
																jScrollPane22,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																868,
																Short.MAX_VALUE)
														.addContainerGap())));
		libro_mayorLayout
				.setVerticalGroup(libro_mayorLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 409, Short.MAX_VALUE)
						.addGroup(
								libro_mayorLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												libro_mayorLayout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(
																jScrollPane22,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																387,
																Short.MAX_VALUE)
														.addContainerGap())));

		libro_mayor.setBounds(20, 20, 894, 435);
		jDesktopPane1.add(libro_mayor, javax.swing.JLayeredPane.DEFAULT_LAYER);

		modificar_catalogos.setClosable(true);
		modificar_catalogos
				.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		modificar_catalogos.setIconifiable(true);
		modificar_catalogos.setMaximizable(true);
		modificar_catalogos.setResizable(true);
		modificar_catalogos.setTitle("Modificar Catalogo de Cuentas");
		modificar_catalogos.setPreferredSize(new java.awt.Dimension(558, 221));
		modificar_catalogos.setVisible(false);

		jPanel20.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		jPanel20.setPreferredSize(new java.awt.Dimension(497, 167));

		jTable13.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null } },
				new String[] { "Nombre del catalogo" }) {
			Class[] types = new Class[] { java.lang.String.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		jScrollPane33.setViewportView(jTable13);

		jButton42.setText("Modificar");
		jButton42.setToolTipText("Modificar empresa");
		jButton42.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton42ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(
				jPanel20);
		jPanel20.setLayout(jPanel20Layout);
		jPanel20Layout.setHorizontalGroup(jPanel20Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel20Layout
						.createSequentialGroup()
						.addGap(21, 21, 21)
						.addComponent(jScrollPane33,
								javax.swing.GroupLayout.PREFERRED_SIZE, 332,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(jButton42)
						.addContainerGap(74, Short.MAX_VALUE)));
		jPanel20Layout
				.setVerticalGroup(jPanel20Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel20Layout
										.createSequentialGroup()
										.addContainerGap(59, Short.MAX_VALUE)
										.addGroup(
												jPanel20Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jScrollPane33,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																44,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton42))
										.addContainerGap(60, Short.MAX_VALUE)));

		jScrollPane32.setViewportView(jPanel20);

		javax.swing.GroupLayout modificar_catalogosLayout = new javax.swing.GroupLayout(
				modificar_catalogos.getContentPane());
		modificar_catalogos.getContentPane().setLayout(
				modificar_catalogosLayout);
		modificar_catalogosLayout
				.setHorizontalGroup(modificar_catalogosLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 552, Short.MAX_VALUE)
						.addGroup(
								modificar_catalogosLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												modificar_catalogosLayout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(
																jScrollPane32,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																532,
																Short.MAX_VALUE)
														.addContainerGap())));
		modificar_catalogosLayout
				.setVerticalGroup(modificar_catalogosLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 195, Short.MAX_VALUE)
						.addGroup(
								modificar_catalogosLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												modificar_catalogosLayout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(
																jScrollPane32,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																173,
																Short.MAX_VALUE)
														.addContainerGap())));

		modificar_catalogos.setBounds(60, 100, 558, 221);
		jDesktopPane1.add(modificar_catalogos,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		modificar_empresa.setClosable(true);
		modificar_empresa
				.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		modificar_empresa.setIconifiable(true);
		modificar_empresa.setMaximizable(true);
		modificar_empresa.setResizable(true);
		modificar_empresa.setTitle("Modificar Empresa");
		modificar_empresa.setPreferredSize(new java.awt.Dimension(726, 182));
		modificar_empresa.setVisible(false);

		jPanel17.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		jPanel17.setPreferredSize(new java.awt.Dimension(680, 73));

		jTable10.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null } }, new String[] {
						"Nombre de la empresa", "Descripcion" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		jScrollPane27.setViewportView(jTable10);
		jTable10.getColumnModel().getColumn(1).setHeaderValue("Descripcion");

		jButton35.setText("Modificar");
		jButton35.setToolTipText("Modificar catalogo de cuentas");
		jButton35.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton35ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(
				jPanel17);
		jPanel17.setLayout(jPanel17Layout);
		jPanel17Layout
				.setHorizontalGroup(jPanel17Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel17Layout
										.createSequentialGroup()
										.addGap(21, 21, 21)
										.addComponent(
												jScrollPane27,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												566,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton35)
										.addContainerGap(20, Short.MAX_VALUE)));
		jPanel17Layout
				.setVerticalGroup(jPanel17Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel17Layout
										.createSequentialGroup()
										.addContainerGap(40, Short.MAX_VALUE)
										.addGroup(
												jPanel17Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jScrollPane27,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																44,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton35))
										.addContainerGap(40, Short.MAX_VALUE)));

		jScrollPane26.setViewportView(jPanel17);

		javax.swing.GroupLayout modificar_empresaLayout = new javax.swing.GroupLayout(
				modificar_empresa.getContentPane());
		modificar_empresa.getContentPane().setLayout(modificar_empresaLayout);
		modificar_empresaLayout
				.setHorizontalGroup(modificar_empresaLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 720, Short.MAX_VALUE)
						.addGroup(
								modificar_empresaLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												modificar_empresaLayout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(
																jScrollPane26,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																700,
																Short.MAX_VALUE)
														.addContainerGap())));
		modificar_empresaLayout
				.setVerticalGroup(modificar_empresaLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 156, Short.MAX_VALUE)
						.addGroup(
								modificar_empresaLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												modificar_empresaLayout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(
																jScrollPane26,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																134,
																Short.MAX_VALUE)
														.addContainerGap())));

		modificar_empresa.setBounds(30, 140, 726, 182);
		jDesktopPane1.add(modificar_empresa,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		nuevo_catalogo.setClosable(true);
		nuevo_catalogo
				.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		nuevo_catalogo.setIconifiable(true);
		nuevo_catalogo.setMaximizable(true);
		nuevo_catalogo.setResizable(true);
		nuevo_catalogo.setTitle("Nuevo Catalogo de Cuentas");
		nuevo_catalogo.setVisible(false);

		jPanel19.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		jPanel19.setPreferredSize(new java.awt.Dimension(706, 121));

		jTable12.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null } }, new String[] {
						"Nombre del catalogo de cuentas", "Numero de empresa" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == 1) {
					return false;
				}
				return true;
			}
		});
		jScrollPane31.setViewportView(jTable12);

		jButton41.setText("Guardar");
		jButton41.setToolTipText("Guardar catalogo de cuentas");
		jButton41.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton41ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(
				jPanel19);
		jPanel19.setLayout(jPanel19Layout);
		jPanel19Layout
				.setHorizontalGroup(jPanel19Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel19Layout
										.createSequentialGroup()
										.addGap(21, 21, 21)
										.addComponent(
												jScrollPane31,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												566,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton41)
										.addContainerGap(35, Short.MAX_VALUE)));
		jPanel19Layout
				.setVerticalGroup(jPanel19Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel19Layout
										.createSequentialGroup()
										.addContainerGap(41, Short.MAX_VALUE)
										.addGroup(
												jPanel19Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jScrollPane31,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																44,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton41))
										.addContainerGap(40, Short.MAX_VALUE)));

		jScrollPane30.setViewportView(jPanel19);

		javax.swing.GroupLayout nuevo_catalogoLayout = new javax.swing.GroupLayout(
				nuevo_catalogo.getContentPane());
		nuevo_catalogo.getContentPane().setLayout(nuevo_catalogoLayout);
		nuevo_catalogoLayout
				.setHorizontalGroup(nuevo_catalogoLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 731, Short.MAX_VALUE)
						.addGroup(
								nuevo_catalogoLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												nuevo_catalogoLayout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(
																jScrollPane30,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																711,
																Short.MAX_VALUE)
														.addContainerGap())));
		nuevo_catalogoLayout
				.setVerticalGroup(nuevo_catalogoLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 157, Short.MAX_VALUE)
						.addGroup(
								nuevo_catalogoLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												nuevo_catalogoLayout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(
																jScrollPane30,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																135,
																Short.MAX_VALUE)
														.addContainerGap())));

		nuevo_catalogo.setBounds(40, 40, 737, 183);
		jDesktopPane1.add(nuevo_catalogo,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		nueva_empresa.setClosable(true);
		nueva_empresa
				.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		nueva_empresa.setIconifiable(true);
		nueva_empresa.setMaximizable(true);
		nueva_empresa.setResizable(true);
		nueva_empresa.setTitle("Nueva Empresa");
		nueva_empresa.setPreferredSize(new java.awt.Dimension(726, 182));
		nueva_empresa.setVisible(false);

		jPanel15.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		jPanel15.setPreferredSize(new java.awt.Dimension(680, 73));

		jTable9.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null } }, new String[] {
						"Nombre de la empresa", "Descripcion" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		jScrollPane13.setViewportView(jTable9);

		jButton30.setText("Guardar");
		jButton30.setToolTipText("Guardar empresa");
		jButton30.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton30ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(
				jPanel15);
		jPanel15.setLayout(jPanel15Layout);
		jPanel15Layout
				.setHorizontalGroup(jPanel15Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel15Layout
										.createSequentialGroup()
										.addGap(21, 21, 21)
										.addComponent(
												jScrollPane13,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												566,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton30)
										.addContainerGap(24, Short.MAX_VALUE)));
		jPanel15Layout
				.setVerticalGroup(jPanel15Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel15Layout
										.createSequentialGroup()
										.addContainerGap(40, Short.MAX_VALUE)
										.addGroup(
												jPanel15Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jScrollPane13,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																44,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton30))
										.addContainerGap(40, Short.MAX_VALUE)));

		jScrollPane25.setViewportView(jPanel15);

		javax.swing.GroupLayout nueva_empresaLayout = new javax.swing.GroupLayout(
				nueva_empresa.getContentPane());
		nueva_empresa.getContentPane().setLayout(nueva_empresaLayout);
		nueva_empresaLayout
				.setHorizontalGroup(nueva_empresaLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 720, Short.MAX_VALUE)
						.addGroup(
								nueva_empresaLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												nueva_empresaLayout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(
																jScrollPane25,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																700,
																Short.MAX_VALUE)
														.addContainerGap())));
		nueva_empresaLayout
				.setVerticalGroup(nueva_empresaLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 156, Short.MAX_VALUE)
						.addGroup(
								nueva_empresaLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												nueva_empresaLayout
														.createSequentialGroup()
														.addContainerGap()
														.addComponent(
																jScrollPane25,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																134,
																Short.MAX_VALUE)
														.addContainerGap())));

		nueva_empresa.setBounds(20, 20, 726, 182);
		jDesktopPane1
				.add(nueva_empresa, javax.swing.JLayeredPane.DEFAULT_LAYER);

		operaciones_diario.setClosable(true);
		operaciones_diario
				.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		operaciones_diario.setIconifiable(true);
		operaciones_diario.setMaximizable(true);
		operaciones_diario.setResizable(true);
		operaciones_diario.setTitle("Operaciones de Diario");
		operaciones_diario.setPreferredSize(new java.awt.Dimension(552, 569));
		operaciones_diario.setVisible(false);

		jScrollPane16.setPreferredSize(new java.awt.Dimension(477, 518));

		jTabbedPane1.setPreferredSize(new java.awt.Dimension(442, 498));

		jPanel7.setPreferredSize(new java.awt.Dimension(517, 425));

		jLabel12.setText("Cuenta");

		jComboBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox1ActionPerformed(evt);
			}
		});

		jTextField7.setText("0.0");

		jLabel9.setText("Cantidad: $");

		jLabel11.setText("Operacion");

		jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Simple", "Compra", "Devolucion", "Venta", "Agregar articulo",
				"Ninguna" }));
		jComboBox3.setSelectedIndex(5);

		jButton9.setText("Agregar");
		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});

		jButton7.setText("Cargar");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jLabel8.setText("Numero de la operacion");

		jTextField13.setText("1");

		jLabel48.setText("Sub cuenta");

		jComboBox7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox7ActionPerformed(evt);
			}
		});

		jComboBox8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox8ActionPerformed(evt);
			}
		});

		jLabel51.setText("Concepto");

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(
				jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout
				.setHorizontalGroup(jPanel7Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel7Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jButton7)
														.addGroup(
																jPanel7Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel7Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel8)
																						.addComponent(
																								jLabel12)
																						.addComponent(
																								jLabel9)
																						.addComponent(
																								jLabel11)
																						.addComponent(
																								jLabel48)
																						.addComponent(
																								jLabel51))
																		.addGap(18,
																				18,
																				18)
																		.addGroup(
																				jPanel7Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								jTextField7,
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jComboBox8,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								0,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jComboBox7,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								0,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jComboBox1,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								0,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jComboBox3,
																								0,
																								110,
																								Short.MAX_VALUE)
																						.addComponent(
																								jTextField13,
																								javax.swing.GroupLayout.Alignment.LEADING))
																		.addGap(94,
																				94,
																				94)
																		.addComponent(
																				jButton9)))
										.addGap(93, 93, 93)));
		jPanel7Layout
				.setVerticalGroup(jPanel7Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel7Layout
										.createSequentialGroup()
										.addGap(29, 29, 29)
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel8)
														.addComponent(
																jTextField13))
										.addGap(38, 38, 38)
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jComboBox1)
														.addComponent(jLabel12))
										.addGap(38, 38, 38)
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jComboBox7)
														.addComponent(jLabel48))
										.addGap(38, 38, 38)
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jComboBox8)
														.addComponent(jLabel51))
										.addGap(38, 38, 38)
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel9)
														.addComponent(
																jTextField7))
										.addGap(26, 26, 26)
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton9)
														.addComponent(jLabel11)
														.addComponent(
																jComboBox3))
										.addGap(27, 27, 27)
										.addComponent(jButton7)
										.addGap(108, 108, 108)));

		jTabbedPane1.addTab("Cargos", jPanel7);

		jLabel10.setText("Cantidad: $");

		jTextField8.setText("0.0");

		jComboBox2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox2ActionPerformed(evt);
			}
		});

		jButton8.setText("Abonar");
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});

		jLabel13.setText("Cuenta");

		jButton23.setText("Agregar");
		jButton23.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton23ActionPerformed(evt);
			}
		});

		jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Simple", "Compra", "Devolucion", "Venta", "Ninguna" }));
		jComboBox5.setSelectedIndex(4);

		jLabel18.setText("Operacion");

		jLabel7.setText("Numero de la operacion");

		jTextField5.setText("1");

		jLabel52.setText("Sub cuenta");

		jComboBox9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox9ActionPerformed(evt);
			}
		});

		jLabel53.setText("Concepto");

		jComboBox10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox10ActionPerformed(evt);
			}
		});

		jButton44.setText("Calcular Capital Contable");
		jButton44.setToolTipText("Activo - Pasivo");
		jButton44.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton44ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(
				jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout
				.setHorizontalGroup(jPanel8Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel8Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel8Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jButton8)
														.addGroup(
																jPanel8Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel8Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel7)
																						.addComponent(
																								jLabel10)
																						.addComponent(
																								jLabel13)
																						.addComponent(
																								jLabel18)
																						.addComponent(
																								jLabel52)
																						.addComponent(
																								jLabel53))
																		.addGap(18,
																				18,
																				18)
																		.addGroup(
																				jPanel8Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								jTextField8,
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jComboBox9,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								0,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jComboBox2,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								0,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jTextField5,
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jComboBox10,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								0,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jComboBox5,
																								0,
																								110,
																								Short.MAX_VALUE))
																		.addGap(94,
																				94,
																				94)
																		.addComponent(
																				jButton23))
														.addComponent(jButton44))
										.addGap(93, 93, 93)));
		jPanel8Layout
				.setVerticalGroup(jPanel8Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel8Layout
										.createSequentialGroup()
										.addGap(29, 29, 29)
										.addGroup(
												jPanel8Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel7)
														.addComponent(
																jTextField5))
										.addGap(38, 38, 38)
										.addGroup(
												jPanel8Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jComboBox2)
														.addComponent(jLabel13))
										.addGap(38, 38, 38)
										.addGroup(
												jPanel8Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jComboBox9)
														.addComponent(jLabel52))
										.addGap(38, 38, 38)
										.addGroup(
												jPanel8Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jComboBox10)
														.addComponent(jLabel53))
										.addGap(38, 38, 38)
										.addGroup(
												jPanel8Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextField8)
														.addComponent(jLabel10))
										.addGap(26, 26, 26)
										.addGroup(
												jPanel8Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jComboBox5)
														.addComponent(jLabel18)
														.addComponent(jButton23))
										.addGap(27, 27, 27)
										.addComponent(jButton8)
										.addGap(27, 27, 27)
										.addComponent(jButton44)
										.addGap(39, 39, 39)));

		jTabbedPane1.addTab("Abonos", jPanel8);

		jScrollPane16.setViewportView(jTabbedPane1);

		javax.swing.GroupLayout operaciones_diarioLayout = new javax.swing.GroupLayout(
				operaciones_diario.getContentPane());
		operaciones_diario.getContentPane().setLayout(operaciones_diarioLayout);
		operaciones_diarioLayout
				.setHorizontalGroup(operaciones_diarioLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								operaciones_diarioLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane16,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												526, Short.MAX_VALUE)
										.addContainerGap()));
		operaciones_diarioLayout
				.setVerticalGroup(operaciones_diarioLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								operaciones_diarioLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane16,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												521, Short.MAX_VALUE)
										.addContainerGap()));

		operaciones_diario.setBounds(5, 5, 552, 569);
		jDesktopPane1.add(operaciones_diario,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		simple.setClosable(true);
		simple.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		simple.setIconifiable(true);
		simple.setMaximizable(true);
		simple.setResizable(true);
		simple.setTitle("Sub Conceptos Simple");
		simple.setPreferredSize(new java.awt.Dimension(551, 271));
		simple.setVisible(false);

		jScrollPane5.setBorder(null);
		jScrollPane5.setMinimumSize(new java.awt.Dimension(23, 23));

		jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		jPanel3.setMinimumSize(new java.awt.Dimension(23, 23));

		jComboBox4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox4ActionPerformed(evt);
			}
		});

		jButton10.setText("Aceptar");
		jButton10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton10ActionPerformed(evt);
			}
		});

		jTextField9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField9ActionPerformed(evt);
			}
		});

		jLabel14.setText("Sub concepto");

		jLabel15.setText("Cantidad: $");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout
				.setHorizontalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addGap(25, 25, 25)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel3Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel3Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel15)
																						.addComponent(
																								jLabel14))
																		.addGap(31,
																				31,
																				31)
																		.addGroup(
																				jPanel3Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jComboBox4,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								251,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField9,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								121,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addComponent(jButton10))
										.addContainerGap(147, Short.MAX_VALUE)));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addGap(25, 25, 25)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel3Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel3Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jComboBox4,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel14))
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				jTextField9,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(
																jLabel15,
																javax.swing.GroupLayout.Alignment.TRAILING))
										.addGap(33, 33, 33)
										.addComponent(jButton10)
										.addContainerGap(76, Short.MAX_VALUE)));

		jScrollPane5.setViewportView(jPanel3);

		javax.swing.GroupLayout simpleLayout = new javax.swing.GroupLayout(
				simple.getContentPane());
		simple.getContentPane().setLayout(simpleLayout);
		simpleLayout.setHorizontalGroup(simpleLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				simpleLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane5,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));
		simpleLayout.setVerticalGroup(simpleLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				simpleLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane5,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));

		simple.setBounds(60, 60, 551, 271);
		jDesktopPane1.add(simple, javax.swing.JLayeredPane.DEFAULT_LAYER);

		venta.setClosable(true);
		venta.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		venta.setIconifiable(true);
		venta.setMaximizable(true);
		venta.setResizable(true);
		venta.setTitle("Sub Concepto Venta");
		venta.setPreferredSize(new java.awt.Dimension(792, 308));
		venta.setVisible(false);

		jScrollPane17.setPreferredSize(new java.awt.Dimension(766, 260));

		jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		jPanel5.setPreferredSize(new java.awt.Dimension(741, 238));

		jTable1.setAutoCreateRowSorter(true);
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null,
						null } }, new String[] { "Nombre", "Existencia",
						"Lote", "Precio de costo", "Incremento %",
						"Precio de venta", "Cantidad", "Sub Total" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Double.class, java.lang.Double.class,
					java.lang.Double.class, java.lang.Integer.class,
					java.lang.Double.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTable1MouseClicked(evt);
			}
		});
		jScrollPane2.setViewportView(jTable1);

		jButton11.setText("Aceptar");
		jButton11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton11ActionPerformed(evt);
			}
		});

		jButton12.setText("+");
		jButton12.setToolTipText("Agregar renglon");
		jButton12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton12ActionPerformed(evt);
			}
		});

		jButton13.setText("-");
		jButton13.setToolTipText("Borrar renglon");
		jButton13.setPreferredSize(new java.awt.Dimension(43, 23));
		jButton13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton13ActionPerformed(evt);
			}
		});

		jLabel16.setText("Total : $");

		jButton14.setText("A Tabla");
		jButton14.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton14ActionPerformed(evt);
			}
		});

		jButton16.setText("Calcular total");
		jButton16.setToolTipText("Calcular el total de la venta");

		jButton17.setText("Limpiar");
		jButton17.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton17ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout
				.setHorizontalGroup(jPanel5Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel5Layout
										.createSequentialGroup()
										.addGap(4, 4, 4)
										.addGroup(
												jPanel5Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel5Layout
																		.createSequentialGroup()
																		.addComponent(
																				jButton16,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				105,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(28,
																				28,
																				28)
																		.addComponent(
																				jLabel16)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jTextField10,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				115,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel5Layout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				650,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel5Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jButton17)
																						.addComponent(
																								jButton13,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								43,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jButton12,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								43,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																jPanel5Layout
																		.createSequentialGroup()
																		.addComponent(
																				jButton11)
																		.addGap(42,
																				42,
																				42)
																		.addComponent(
																				jButton14)))
										.addContainerGap(29, Short.MAX_VALUE)));
		jPanel5Layout
				.setVerticalGroup(jPanel5Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel5Layout
										.createSequentialGroup()
										.addGroup(
												jPanel5Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																jPanel5Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jScrollPane2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				115,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(20,
																				20,
																				20))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																jPanel5Layout
																		.createSequentialGroup()
																		.addGap(29,
																				29,
																				29)
																		.addComponent(
																				jButton12)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton13,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				23,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jButton17)))
										.addGroup(
												jPanel5Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton16)
														.addComponent(jLabel16)
														.addComponent(
																jTextField10,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(29, 29, 29)
										.addGroup(
												jPanel5Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton11)
														.addComponent(jButton14))
										.addContainerGap(29, Short.MAX_VALUE)));

		jScrollPane17.setViewportView(jPanel5);

		javax.swing.GroupLayout ventaLayout = new javax.swing.GroupLayout(
				venta.getContentPane());
		venta.getContentPane().setLayout(ventaLayout);
		ventaLayout.setHorizontalGroup(ventaLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				ventaLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane17,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));
		ventaLayout.setVerticalGroup(ventaLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				ventaLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane17,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));

		venta.setBounds(60, 60, 792, 308);
		jDesktopPane1.add(venta, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jMenu1.setText("Archivo");

		jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_A,
				java.awt.event.InputEvent.SHIFT_MASK
						| java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem3.setText("Administrar Empresas");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem3);
		jMenu1.add(jSeparator5);

		jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_C,
				java.awt.event.InputEvent.SHIFT_MASK
						| java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem1.setText("Administrar Catalogos de Cuentas");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem1);

		jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_R,
				java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem7.setText("Restaurar Catalogo de cuentas");
		jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem7ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem7);
		jMenu1.add(jSeparator1);

		jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_X,
				java.awt.event.InputEvent.SHIFT_MASK
						| java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem2.setText("Cerrar empresa");
		jMenuItem2.setToolTipText("Cierra la empresa abierta");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem2);

		jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_X,
				java.awt.event.InputEvent.ALT_MASK
						| java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem5.setText("Cerrar catalogo de cuentas");
		jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem5ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem5);
		jMenu1.add(jSeparator2);

		jMenuItem8.setText("Salir");
		jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem8ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem8);

		jMenuBar1.add(jMenu1);

		jMenu3.setText("Catalogo de cuentas");

		jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F1, 0));
		jMenuItem4.setText("Abrir catalogo de cuentas");
		jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem4ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem4);

		jMenuBar1.add(jMenu3);

		jMenu7.setText("Estados financieros");

		jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F2, 0));
		jMenuItem12.setText("Balance inicial");
		jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem12ActionPerformed(evt);
			}
		});
		jMenu7.add(jMenuItem12);
		jMenu7.add(jSeparator8);

		jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F3, 0));
		jMenuItem14.setText("Estado de resultados");
		jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem14ActionPerformed(evt);
			}
		});
		jMenu7.add(jMenuItem14);

		jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F4, 0));
		jMenuItem13.setText("Balance general");
		jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem13ActionPerformed(evt);
			}
		});
		jMenu7.add(jMenuItem13);

		jMenuBar1.add(jMenu7);

		jMenu4.setText("Libros");
		jMenu4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenu4ActionPerformed(evt);
			}
		});

		jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F5, 0));
		jMenuItem6.setText("Libro diario");
		jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem6ActionPerformed(evt);
			}
		});
		jMenu4.add(jMenuItem6);
		jMenu4.add(jSeparator3);

		jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F6, 0));
		jMenuItem9.setText("Libro mayor");
		jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem9ActionPerformed(evt);
			}
		});
		jMenu4.add(jMenuItem9);

		jMenuBar1.add(jMenu4);

		jMenu2.setText("Ayuda");

		jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F7, 0));
		jMenuItem11.setText("Contenidos de ayuda");
		jMenu2.add(jMenuItem11);
		jMenu2.add(jSeparator6);

		jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F8, 0));
		jMenuItem10.setText("Acerca de");
		jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem10ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem10);

		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679,
				Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void cargarbuscar() {
		buscar.put(new Integer(0), "catalogo_de_cuentas");
		buscar.put(new Integer(1), "cuentas");
		buscar.put(new Integer(2), "sub_cuentas");
		buscar.put(new Integer(3), "conceptos");
		buscar.put(new Integer(4), "sub_conceptos");
	}

	private void cargarinsertar() {
		insertar.put(new Integer(1), "sub_cuentas");
		insertar.put(new Integer(2), "conceptos");
		insertar.put(new Integer(3), "sub_conceptos");
	}

	private void cargar_valores(String padre1, String padre2, String padre3) {

		padre = padre1;// nombre de la cuenta
		
		sql = "call obtener_idcuenta('" + padre + "'," + id_catalogo + ",?);";
		registro = new String[1];
		conn = obc.Conectar(bd, url, server, puerto, user, pass);

		try {
			// ejecutar procedimiento almacenado
			ejecutar_procedimiento(sql);
			id_cuentas = Integer.parseInt(registro[0]);

			// obtener id_subcuenta
			padre = padre2;
			sql = "call obtener_idsubcuenta('" + padre + "'," + id_cuentas
					+ ",?);";
			registro = new String[1];

			// ejecutar procedimiento almacenado
			ejecutar_procedimiento(sql);
			id_subcuentas = Integer.parseInt(registro[0]);

			// obtener id_concepto
			padre = padre3;
			sql = "call obtener_idconcepto('" + padre + "'," + id_subcuentas
					+ ",?);";
			registro = new String[1];

			// ejecutar procedimiento almacenado
			ejecutar_procedimiento(sql);
			id_conceptos = Integer.parseInt(registro[0]);

			// obtener succonceptos
			sql = "select nombre from sub_conceptos where id_concepto = "
					+ id_conceptos + ";";
			registro = new String[1];
			Statement stm = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rst = stm.executeQuery(sql);

			while (rst.next()) {
				registro[0] = rst.getString(1) + ""; // nombre sub concepto
				agregar_arbol(registro[0], padre3);
			}

			conn.close();
			rst.close();
			stm.close();
			cst.close();
		} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cargar_subconceptos() {
		cargar_activosc();
		cargar_activosf();
		cargar_activosd();
		cargar_pasivoc();
		cargar_pasivof();
		cargar_pasivod();
		cargar_resultadoscap();
		cargar_resacree();
		cargar_ressdeu();
	}

	private void ejecutar_cargar(String codigo_sql, String padre1, String padre2) {
		String padre3 = "";

		try {

			conn = obc.Conectar(bd, url, server, puerto, user, pass);

			padre = padre1;// nombre de la cuenta
			sql = "call obtener_idcuenta('" + padre + "'," + id_catalogo
					+ ",?);";
			registro = new String[1];

			// ejecutar procedimiento almacenado
			ejecutar_procedimiento(sql);
			id_cuentas = Integer.parseInt(registro[0]);

			padre = padre2;
			sql = "call obtener_idsubcuenta('" + padre + "'," + id_cuentas
					+ ",?);";
			registro = new String[1];

			// ejecutar procedimiento almacenado
			ejecutar_procedimiento(sql);
			id_subcuentas = Integer.parseInt(registro[0]);

			sql = "select nombre from conceptos where codigo like '"
					+ codigo_sql + "' and id_subcuenta = " + id_subcuentas
					+ ";";
			Statement stm = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rst = stm.executeQuery(sql);
			registro = new String[1];

			while (rst.next()) {
				registro[0] = rst.getString(1) + ""; // nombre sub concepto
				padre3 = registro[0];
				cargar_valores(padre1, padre2, padre3);
			}

			conn.close();
			rst.close();
			stm.close();
			cst.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	private void cargar_activosc() {
		String padre1 = "Activo", padre2 = "Circulante", codigo_sql = "1-1-%";
		

		ejecutar_cargar(codigo_sql, padre1, padre2);
	}

	private void cargar_activosf() {
		String padre1 = "Activo", padre2 = "Fijo", codigo_sql = "1-2-%";
		

		ejecutar_cargar(codigo_sql, padre1, padre2);
	}

	private void cargar_activosd() {
		String padre1 = "Activo", padre2 = "Diferido", codigo_sql = "1-3-%";
		

		ejecutar_cargar(codigo_sql, padre1, padre2);
	}

	private void cargar_pasivoc() {
		String padre1 = "Pasivo", padre2 = "Circulante", codigo_sql = "2-1-%";
		

		ejecutar_cargar(codigo_sql, padre1, padre2);
	}

	private void cargar_pasivof() {
		String padre1 = "Pasivo", padre2 = "Fijo", codigo_sql = "2-2-%";
		

		ejecutar_cargar(codigo_sql, padre1, padre2);
	}

	private void cargar_pasivod() {
		String padre1 = "Pasivo", padre2 = "Diferido", codigo_sql = "2-3-%";
		

		ejecutar_cargar(codigo_sql, padre1, padre2);
	}

	private void cargar_resultadoscap() {
		String padre1 = "Resultados", padre2 = "Capital", codigo_sql = "3-1-%";
		

		ejecutar_cargar(codigo_sql, padre1, padre2);
	}

	private void cargar_resacree() {
		String padre1 = "Resultados", padre2 = "Resultados Acreedoras", codigo_sql = "3-2-%";
		

		ejecutar_cargar(codigo_sql, padre1, padre2);
	}

	private void cargar_ressdeu() {
		String padre1 = "Resultados", padre2 = "Resultados Deudores", codigo_sql = "3-3-%";
		

		ejecutar_cargar(codigo_sql, padre1, padre2);
	}

	private void agregar_arbol(String conceptoi, String opcion) {
		DefaultMutableTreeNode nuevo = new DefaultMutableTreeNode(conceptoi);

		switch (opcion) {
		case "ACCIONES Y VALORES":
			acciones.add(nuevo);
			break;

		case "ACREEDORES DIVERSOS":
			acreedores.add(nuevo);
			break;

		case "ACREEDORES HIPOTECARIOS":
			acreedores_h.add(nuevo);
			break;

		case "Bancos":
			bancos.add(nuevo);
			break;

		case "Caja":
			caja.add(nuevo);
			break;

		case "Capital Contable":
			c_contable.add(nuevo);
			break;

		case "Capital Social":
			c_social.add(nuevo);
			break;

		case "Clientes":
			clientes.add(nuevo);
			break;

		case "Compras":
			compras.add(nuevo);
			break;

		case "Costo de venta":
			costo_v.add(nuevo);
			break;

		case "DEPOSITOS EN GARANTIA":
			depositosg.add(nuevo);
			break;

		case "DOCUMENTOS A PAGAR A LARGO PLAZO":
			doc_pagar_largo.add(nuevo);
			break;
		// ////

		case "DOCUMENTOS POR PAGAR":
			doc_pagar.add(nuevo);
			break;

		case "Descuentos sobre Compras":
			desc_compras.add(nuevo);
			break;

		case "Descuentos sobre Ventas":
			desc_venta.add(nuevo);
			break;

		case "Deudores diversos":
			deudores.add(nuevo);
			break;

		case "Devoluciones sobre Compras":
			dev_compras.add(nuevo);
			break;

		case "Devoluciones sobre Ventas":
			dev_venta.add(nuevo);
			break;

		case "Documentos por cobrar":
			docobrar.add(nuevo);
			break;

		case "EQUIPO DE ENTREGA Y DE REPARTO":
			equipoeyr.add(nuevo);
			break;

		case "EQUIPO ELECTRONICO":
			equipoe.add(nuevo);
			break;

		case "Edificios":
			edificios.add(nuevo);
			break;

		case "Equipo de transporte":
			transporte.add(nuevo);
			break;

		case "GASTOS DE INSTALACION Y ADAPTACION":
			gastosiya.add(nuevo);

			break;

		// ////

		case "Gastos administrativos":
			gastos_admon.add(nuevo);
			break;

		case "Gastos de venta":
			gastos_venta.add(nuevo);
			break;

		case "Gastos sobre Compras":
			gasto_compras.add(nuevo);
			break;

		case "IMPUESTOS ANTICIPADOS":
			impuestos.add(nuevo);
			break;

		case "INTERESES COBRADOS POR ADELANTADO":
			intereses_cobrados.add(nuevo);
			break;

		case "INTERESES PAGADOS POR ANTICIPADO":
			intereses_anticipado.add(nuevo);
			break;

		case "Inventario":
			inventario.add(nuevo);
			break;

		case "MOBILIARIO Y EQUIPO DE OFICINA":
			moviliario.add(nuevo);
			break;

		case "PROPAGANDA Y PUBLICIDAD":
			propaganda.add(nuevo);
			break;

		case "PROVEEDORES":
			proveedores.add(nuevo);
			break;

		case "Papeleria y utiles":
			pyu.add(nuevo);
			break;

		case "Primas de seguro":
			p_seguro.add(nuevo);

			break;
		// ////

		case "RENTAS COBRADAS POR ANTICIPADO":
			rentas_cobradas.add(nuevo);
			break;

		case "RENTAS PAGADAS POR ANTICIPADO":
			rentas_anticipado.add(nuevo);
			break;

		case "Terrenos":
			terrenos.add(nuevo);
			break;

		case "Utilidad o perdida del ejercicio":
			uope.add(nuevo);
			break;

		case "Ventas":
			ventas.add(nuevo);
			break;
		}

	}

	private void borrar_edor() {
		jTable5.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Conceptos", "", "", "", "" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class };

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
	}

	private void cargar_edoresultados() {

		String opcion = JOptionPane.showInputDialog(this,
				"Dame el inventario final", 0.0);
		double sinvt_final = 0.0;
		if (opcion != null) {
			sinvt_final = Double.parseDouble(opcion);

			borrar_edor();
			DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel();
			String col1 = "0.0", col2 = "0.0", col3 = "0.0", col4 = "0.0";
			String nombre_cuenta, nombre_subcuenta, nombre_concepto;

			nombre_cuenta = "RESULTADOS";
			nombre_subcuenta = "RESULTADOS ACREEDORAS";
			nombre_concepto = "Ventas";

			sql = "call saldo_total(\"" + id_catalogo + "\",\"" + nombre_cuenta
					+ "\",\"" + nombre_subcuenta + "\",\"" + nombre_concepto
					+ "\",?);";
			conn = obc.Conectar(bd, url, server, puerto, user, pass);
			registro = new String[1];

			ejecutar_procedimiento2(sql);
			double saldo_venta = Double.parseDouble(registro[0]);
			col1 = 0.0 + "";
			col2 = 0.0 + "";
			col3 = saldo_venta + "";
			col4 = 0.0 + "";

			Object ventas_totales[] = { "Ventas Totales", col1, col2, col3,
					col4 };
			dtm.insertRow(dtm.getRowCount(), ventas_totales);

			// -------------------------
			nombre_cuenta = "RESULTADOS";
			nombre_subcuenta = "RESULTADOS ACREEDORAS";
			nombre_concepto = "DEVOLUCIONES SOBRE VENTAS";

			sql = "call saldo_total(\"" + id_catalogo + "\",\"" + nombre_cuenta
					+ "\",\"" + nombre_subcuenta + "\",\"" + nombre_concepto
					+ "\",?);";
			conn = obc.Conectar(bd, url, server, puerto, user, pass);
			registro = new String[1];

			ejecutar_procedimiento2(sql);
			double saldo_dev_vta = Double.parseDouble(registro[0]);
			col1 = 0.0 + "";
			col2 = saldo_dev_vta + "";
			col3 = 0.0 + "";
			col4 = 0.0 + "";

			Object dev_vta[] = { "Dev. / Vta.", col1, col2, col3, col4 };
			dtm.insertRow(dtm.getRowCount(), dev_vta);

			// -------------------------
			nombre_cuenta = "RESULTADOS";
			nombre_subcuenta = "RESULTADOS ACREEDORAS";
			nombre_concepto = "DESCUENTOS SOBRE VENTAS";

			sql = "call saldo_total(\"" + id_catalogo + "\",\"" + nombre_cuenta
					+ "\",\"" + nombre_subcuenta + "\",\"" + nombre_concepto
					+ "\",?);";
			conn = obc.Conectar(bd, url, server, puerto, user, pass);
			registro = new String[1];

			ejecutar_procedimiento2(sql);
			double saldo_desc_vta = Double.parseDouble(registro[0]);
			col1 = 0.0 + "";
			col2 = saldo_desc_vta + "";

			col3 = (saldo_dev_vta - saldo_desc_vta) + "";
			col4 = 0.0 + "";

			Object desc_vta[] = { "Desc. / Vta.", col1, col2, col3, col4 };
			dtm.insertRow(dtm.getRowCount(), desc_vta);

			// ------------------
			double ventas_netas = (saldo_venta - (saldo_dev_vta - saldo_desc_vta));
			col1 = 0.0 + "";
			col2 = 0.0 + "";
			col3 = 0.0 + "";
			col4 = ventas_netas + "";

			Object vtas_netas[] = { "VENTAS NETAS", col1, col2, col3, col4 };
			dtm.insertRow(dtm.getRowCount(), vtas_netas);

			// ------------------
			nombre_cuenta = "Activo";
			nombre_subcuenta = "Circulante";
			nombre_concepto = "INVENTARIO";

			sql = "call saldo_total(\"" + id_catalogo + "\",\"" + nombre_cuenta
					+ "\",\"" + nombre_subcuenta + "\",\"" + nombre_concepto
					+ "\",?);";
			conn = obc.Conectar(bd, url, server, puerto, user, pass);
			registro = new String[1];

			ejecutar_procedimiento2(sql);
			double inv_inicial = Double.parseDouble(registro[0]);
			col1 = 0.0 + "";
			col2 = 0.0 + "";
			col3 = inv_inicial + "";
			col4 = 0.0 + "";

			Object invt_inicial[] = { "Inventario inicial", col1, col2, col3,
					col4 };
			dtm.insertRow(dtm.getRowCount(), invt_inicial);

			// ------------------
			nombre_cuenta = "RESULTADOS";
			nombre_subcuenta = "RESULTADOS DEUDORES";
			nombre_concepto = "COMPRAS";

			sql = "call saldo_total(\"" + id_catalogo + "\",\"" + nombre_cuenta
					+ "\",\"" + nombre_subcuenta + "\",\"" + nombre_concepto
					+ "\",?);";
			conn = obc.Conectar(bd, url, server, puerto, user, pass);
			registro = new String[1];

			ejecutar_procedimiento2(sql);
			double saldo_compras = Double.parseDouble(registro[0]);
			col1 = saldo_compras + "";
			col2 = 0.0 + "";
			col3 = 0.0 + "";
			col4 = 0.0 + "";

			Object compras[] = { "Compras", col1, col2, col3, col4 };
			dtm.insertRow(dtm.getRowCount(), compras);

			// ------------------
			nombre_cuenta = "RESULTADOS";
			nombre_subcuenta = "RESULTADOS DEUDORES";
			nombre_concepto = "GASTOS SOBRE COMPRAS";

			sql = "call saldo_total(\"" + id_catalogo + "\",\"" + nombre_cuenta
					+ "\",\"" + nombre_subcuenta + "\",\"" + nombre_concepto
					+ "\",?);";
			conn = obc.Conectar(bd, url, server, puerto, user, pass);
			registro = new String[1];

			ejecutar_procedimiento2(sql);
			double saldo_gcompras = Double.parseDouble(registro[0]);
			col1 = saldo_gcompras + "";
			col2 = 0.0 + "";
			col3 = 0.0 + "";
			col4 = 0.0 + "";

			Object gastos_compras[] = { "GASTOS SOBRE COMPRAS", col1, col2,
					col3, col4 };
			dtm.insertRow(dtm.getRowCount(), gastos_compras);

			// ---------------------------
			double compras_totales = (saldo_compras - saldo_gcompras);
			col1 = 0.0 + "";
			col2 = compras_totales + "";
			col3 = 0.0 + "";
			col4 = 0.0 + "";

			Object compras_tot[] = { "COMPRAS TOTALES", col1, col2, col3, col4 };
			dtm.insertRow(dtm.getRowCount(), compras_tot);

			// ---------------------------
			nombre_cuenta = "RESULTADOS";
			nombre_subcuenta = "RESULTADOS DEUDORES";
			nombre_concepto = "DEVOLUCIONES SOBRE COMPRAS";

			sql = "call saldo_total(\"" + id_catalogo + "\",\"" + nombre_cuenta
					+ "\",\"" + nombre_subcuenta + "\",\"" + nombre_concepto
					+ "\",?);";
			conn = obc.Conectar(bd, url, server, puerto, user, pass);
			registro = new String[1];

			ejecutar_procedimiento2(sql);
			double dev_compras = Double.parseDouble(registro[0]);
			col1 = dev_compras + "";
			col2 = 0.0 + "";
			col3 = 0.0 + "";
			col4 = 0.0 + "";

			Object dev_compra[] = { "Dev. / Compra", col1, col2, col3, col4 };
			dtm.insertRow(dtm.getRowCount(), dev_compra);

			// ---------------------------
			nombre_cuenta = "RESULTADOS";
			nombre_subcuenta = "RESULTADOS DEUDORES";
			nombre_concepto = "DEVOLUCIONES SOBRE COMPRAS";

			sql = "call saldo_total(\"" + id_catalogo + "\",\"" + nombre_cuenta
					+ "\",\"" + nombre_subcuenta + "\",\"" + nombre_concepto
					+ "\",?);";
			conn = obc.Conectar(bd, url, server, puerto, user, pass);
			registro = new String[1];

			ejecutar_procedimiento2(sql);
			double desc_compras = Double.parseDouble(registro[0]);
			col1 = desc_compras + "";
			col2 = (dev_compras - desc_compras) + "";
			col3 = 0.0 + "";
			col4 = 0.0 + "";

			Object desc_compra[] = { "Desc. / Compra", col1, col2, col3, col4 };
			dtm.insertRow(dtm.getRowCount(), desc_compra);

			// ---------------------------
			double scompras_netas = compras_totales
					- (dev_compras - desc_compras);
			col1 = 0.0 + "";
			col2 = 0.0 + "";
			col3 = scompras_netas + "";
			col4 = 0.0 + "";

			Object compras_netas[] = { "COMPRAS NETAS", col1, col2, col3, col4 };
			dtm.insertRow(dtm.getRowCount(), compras_netas);

			// ------------------
			double t_mercancias = inv_inicial - scompras_netas;
			col1 = 0.0 + "";
			col2 = 0.0 + "";
			col3 = t_mercancias + "";
			col4 = 0.0 + "";

			Object total_mercancias[] = { "Total de mercancias", col1, col2,
					col3, col4 };
			dtm.insertRow(dtm.getRowCount(), total_mercancias);

			// ------------------

			col1 = 0.0 + "";
			col2 = 0.0 + "";
			col3 = sinvt_final + "";
			col4 = 0.0 + "";

			Object invt_final[] = { "Inventario final", col1, col2, col3, col4 };
			dtm.insertRow(dtm.getRowCount(), invt_final);

			// ------------------
			double scosto_venta = t_mercancias - sinvt_final;
			col1 = 0.0 + "";
			col2 = 0.0 + "";
			col3 = 0.0 + "";
			col4 = scosto_venta + "";

			Object costo_venta[] = { "COSTO DE VENTA", col1, col2, col3, col4 };
			dtm.insertRow(dtm.getRowCount(), costo_venta);

			// ------------------
			double sutilida = ventas_netas - scosto_venta;
			col1 = 0.0 + "";
			col2 = 0.0 + "";
			col3 = 0.0 + "";
			col4 = sutilida + "";

			Object utilidad_bruta[] = { "UTILIDAD BRUTA", col1, col2, col3,
					col4 };
			dtm.insertRow(dtm.getRowCount(), utilidad_bruta);

			// ---------------------------
			nombre_cuenta = "RESULTADOS";
			nombre_subcuenta = "RESULTADOS DEUDORES";
			nombre_concepto = "GASTOS ADMINISTRATIVOS";

			sql = "call saldo_total(\"" + id_catalogo + "\",\"" + nombre_cuenta
					+ "\",\"" + nombre_subcuenta + "\",\"" + nombre_concepto
					+ "\",?);";
			conn = obc.Conectar(bd, url, server, puerto, user, pass);
			registro = new String[1];

			ejecutar_procedimiento2(sql);
			double sgastos_admon = Double.parseDouble(registro[0]);
			col1 = 0.0 + "";
			col2 = 0.0 + "";
			col3 = sgastos_admon + "";
			col4 = 0.0 + "";

			Object gastos_admon[] = { "Gastos de admon.", col1, col2, col3,
					col4 };
			dtm.insertRow(dtm.getRowCount(), gastos_admon);

			// ---------------------------
			nombre_cuenta = "RESULTADOS";
			nombre_subcuenta = "RESULTADOS DEUDORES";
			nombre_concepto = "GASTOS DE VENTA";

			sql = "call saldo_total(\"" + id_catalogo + "\",\"" + nombre_cuenta
					+ "\",\"" + nombre_subcuenta + "\",\"" + nombre_concepto
					+ "\",?);";
			conn = obc.Conectar(bd, url, server, puerto, user, pass);
			registro = new String[1];

			ejecutar_procedimiento2(sql);
			double sgastos_vta = Double.parseDouble(registro[0]);
			col1 = 0.0 + "";
			col2 = 0.0 + "";
			col3 = sgastos_vta + "";
			col4 = 0.0 + "";

			Object gastos_vta[] = { "Gastos de venta", col1, col2, col3, col4 };
			dtm.insertRow(dtm.getRowCount(), gastos_vta);

			// ------------------
			double sgastos_oper = sgastos_admon - sgastos_vta;
			col1 = 0.0 + "";
			col2 = 0.0 + "";
			col3 = 0.0 + "";
			col4 = sgastos_oper + "";

			Object gastos_operaciones[] = { "GASTOS DE OPERACIONES", col1,
					col2, col3, col4 };
			dtm.insertRow(dtm.getRowCount(), gastos_operaciones);

			// ------------------
			sutilidad_ai = sutilida - sgastos_oper;
			col1 = 0.0 + "";
			col2 = 0.0 + "";
			col3 = 0.0 + "";
			col4 = sutilidad_ai + "";

			Object utilidad_ai[] = { "UTILIDAD ANTES DE IMPUESTOS", col1, col2,
					col3, col4 };
			dtm.insertRow(dtm.getRowCount(), utilidad_ai);

			bandera1 = true;
			edo_res.setVisible(true);

		} else {
			bandera1 = false;
			edo_res.setVisible(false);
			JOptionPane.showMessageDialog(this,
					"Debes ingresar un valor valido para el inventario final",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void buscar_articulo() {
		int col = jTable1.getSelectedColumn();
		int ren = jTable1.getSelectedRow();
		String art = jTable1.getModel().getValueAt(ren, col).toString();
		jTextField10.setText(art);
	}

	private void cargar_arbol() {
		// activos
		if (id_catalogo != -1) {
			cargar_subconceptos();
		}

		raiz.removeAllChildren();
		activo.add(a_circulante);
		a_circulante.add(caja);
		a_circulante.add(bancos);
		a_circulante.add(inventario);
		a_circulante.add(clientes);
		a_circulante.add(docobrar);
		a_circulante.add(deudores);

		activo.add(a_fijo);
		a_fijo.add(terrenos);
		a_fijo.add(edificios);
		a_fijo.add(moviliario);
		a_fijo.add(equipoeyr);
		a_fijo.add(depositosg);
		a_fijo.add(acciones);
		a_fijo.add(equipoe);
		a_fijo.add(transporte);

		activo.add(a_diferido);
		a_diferido.add(gastosiya);
		a_diferido.add(propaganda);
		a_diferido.add(impuestos);
		a_diferido.add(rentas_anticipado);
		a_diferido.add(intereses_anticipado);
		a_diferido.add(pyu);
		a_diferido.add(p_seguro);

		raiz.add(activo);

		// pasivos

		pasivo.add(p_circulante);
		p_circulante.add(proveedores);
		p_circulante.add(doc_pagar);
		p_circulante.add(acreedores);

		pasivo.add(p_fijo);
		p_fijo.add(doc_pagar_largo);
		p_fijo.add(acreedores_h);

		pasivo.add(p_diferido);
		p_diferido.add(intereses_cobrados);
		p_diferido.add(rentas_cobradas);

		raiz.add(pasivo);

		// capital

		capital.add(c_social);
		capital.add(c_contable);
		capital.add(uope);

		resultados.add(capital);

		// resultado acreedoras

		r_acreedoras.add(ventas);
		r_acreedoras.add(dev_venta);
		r_acreedoras.add(desc_venta);

		raiz.add(r_acreedoras);

		// resultado deudores

		r_deudores.add(gastos_venta);

		r_deudores.add(gastos_admon);

		r_deudores.add(costo_v);
		r_deudores.add(compras);
		r_deudores.add(gasto_compras);
		r_deudores.add(dev_compras);
		r_deudores.add(desc_compras);

		raiz.add(r_deudores);

		// resultados
		resultados.add(r_acreedoras);
		resultados.add(r_deudores);
		raiz.add(resultados);

		modelo = new DefaultTreeModel(raiz);
		arbol = new JTree();
		arbol.setModel(modelo);

	}

	private void cargar_arbol2() {
		// activos
		if (id_catalogo != -1) {
			cargar_subconceptos();
		}

		raiz.removeAllChildren();
		activo.add(a_circulante);
		a_circulante.add(caja);
		a_circulante.add(bancos);
		a_circulante.add(inventario);
		a_circulante.add(clientes);
		a_circulante.add(docobrar);
		a_circulante.add(deudores);

		activo.add(a_fijo);
		a_fijo.add(terrenos);
		a_fijo.add(edificios);
		a_fijo.add(moviliario);
		a_fijo.add(equipoeyr);
		a_fijo.add(depositosg);
		a_fijo.add(acciones);
		a_fijo.add(equipoe);
		a_fijo.add(transporte);

		activo.add(a_diferido);
		a_diferido.add(gastosiya);
		a_diferido.add(propaganda);
		a_diferido.add(impuestos);
		a_diferido.add(rentas_anticipado);
		a_diferido.add(intereses_anticipado);
		a_diferido.add(pyu);
		a_diferido.add(p_seguro);

		raiz.add(activo);

		// pasivos

		pasivo.add(p_circulante);
		p_circulante.add(proveedores);
		p_circulante.add(doc_pagar);
		p_circulante.add(acreedores);

		pasivo.add(p_fijo);
		p_fijo.add(doc_pagar_largo);
		p_fijo.add(acreedores_h);

		pasivo.add(p_diferido);
		p_diferido.add(intereses_cobrados);
		p_diferido.add(rentas_cobradas);

		raiz.add(pasivo);

		// capital

		capital.add(c_social);
		capital.add(c_contable);
		capital.add(uope);

		resultados.add(capital);

		// resultado acreedoras

		r_acreedoras.add(ventas);
		r_acreedoras.add(dev_venta);
		r_acreedoras.add(desc_venta);

		raiz.add(r_acreedoras);

		// resultado deudores

		r_deudores.add(gastos_venta);

		r_deudores.add(gastos_admon);

		r_deudores.add(costo_v);
		r_deudores.add(compras);
		r_deudores.add(gasto_compras);
		r_deudores.add(dev_compras);
		r_deudores.add(desc_compras);

		raiz.add(r_deudores);

		// resultados
		resultados.add(r_acreedoras);
		resultados.add(r_deudores);
		raiz.add(resultados);

		modelo = new DefaultTreeModel(raiz);
		arbol.setModel(modelo);

	}

	private void restaurar_catalogo() {
		int option = JOptionPane
				.showConfirmDialog(
						null,
						"Estas seguro de restablecer el catalogo de cuentas?"
								+ "\nSi lo haces todos los saldos volveran a 0.0 y \nse eliminaran los registros de diario y mayor",
						"Mensaje", JOptionPane.INFORMATION_MESSAGE);
		if (option == JOptionPane.OK_OPTION) {

			if (id_catalogo != -1) {

				int idcuenta = 0, idsubcuenta = 0, idconcepto = 0;
				String ncuenta = "", nsubcuenta = "", nconcepto = "", nsubconcepto = "";

				sql = "select nombre from cuentas where id_catalogo = "
						+ id_catalogo + "; ";

				String sql1 = "update cuentas set saldo_acreedor = " + 0.0
						+ " where id_catalogo = " + id_catalogo + " ";
				String sql11 = "update cuentas set saldo_deudor = " + 0.0
						+ " where id_catalogo = " + id_catalogo + " ";

				conn = obc.Conectar(bd, url, server, puerto, user, pass);

				try {
					Statement stm = conn.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
					ResultSet rst = stm.executeQuery(sql);// nombre sub cuentas
					PreparedStatement pstm;
					pstm = conn.prepareStatement(sql1,
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
					pstm.executeUpdate();// saldo acreedor

					pstm = conn.prepareStatement(sql11,
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
					pstm.executeUpdate();// saldo deudor

					registro = new String[1];

					// ciclo 1
					while (rst.next()) {

						registro[0] = rst.getString(1); // nombre cuenta
						ncuenta = registro[0];

						String sql2 = "call obtener_idcuenta('" + ncuenta
								+ "'," + id_catalogo + ",?);";
						ejecutar_procedimiento(sql2);// obtener id cuenta,
														// return = registro
						idcuenta = Integer.parseInt(registro[0]);

						String sql8 = "select nombre from sub_cuentas where id_cuenta = "
								+ idcuenta + "; ";
						stm = conn.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_UPDATABLE);
						ResultSet rst2 = stm.executeQuery(sql8);// nombre sub
																// cuentas

						// ciclo 2
						while (rst2.next()) {
							registro[0] = rst2.getString(1); // nombre subcuenta
							nsubcuenta = registro[0];

							String sql5 = "update sub_cuentas set saldo_deudor = "
									+ 0.0
									+ " where id_cuenta = "
									+ idcuenta
									+ " and nombre like '"
									+ nsubcuenta
									+ "' ; ";
							String sql12 = "update sub_cuentas set saldo_acreedor = "
									+ 0.0
									+ " where id_cuenta = "
									+ idcuenta
									+ " and nombre like '"
									+ nsubcuenta
									+ "' ; ";

							pstm = conn.prepareStatement(sql5,
									ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_UPDATABLE);
							pstm.executeUpdate();

							pstm = conn.prepareStatement(sql12,
									ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_UPDATABLE);
							pstm.executeUpdate();

							String sql3 = "call obtener_idsubcuenta('"
									+ nsubcuenta + "'," + idcuenta + ",?);";
							ejecutar_procedimiento(sql3);// obtener id
															// subcuenta, return
															// = registro
							idsubcuenta = Integer.parseInt(registro[0]);

							String sql9 = "select nombre from conceptos where id_subcuenta = "
									+ idsubcuenta + " ";
							stm = conn.createStatement(
									ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_UPDATABLE);
							ResultSet rst3 = stm.executeQuery(sql9);// nombre
																	// conceptos
																	// cuentas

							// ciclo 3
							while (rst3.next()) {
								registro[0] = rst3.getString(1); // nombre
																	// subcuenta
								nconcepto = registro[0];

								String sql6 = "update conceptos set saldo_deudor = "
										+ 0.0
										+ ", debe = "
										+ 0.0
										+ ", haber = "
										+ 0.0
										+ "  where id_subcuenta = "
										+ idsubcuenta
										+ " and nombre like '"
										+ nconcepto + "'; ";
								pstm = conn.prepareStatement(sql6,
										ResultSet.TYPE_SCROLL_INSENSITIVE,
										ResultSet.CONCUR_UPDATABLE);
								pstm.executeUpdate();

								String sql13 = "update conceptos set saldo_acreedor = "
										+ 0.0
										+ ", debe = "
										+ 0.0
										+ ", haber = "
										+ 0.0
										+ "  where id_subcuenta = "
										+ idsubcuenta
										+ " and nombre like '"
										+ nconcepto + "'; ";
								pstm = conn.prepareStatement(sql13,
										ResultSet.TYPE_SCROLL_INSENSITIVE,
										ResultSet.CONCUR_UPDATABLE);
								pstm.executeUpdate();

								String sql4 = "call obtener_idconcepto('"
										+ nconcepto + "'," + idsubcuenta
										+ ",?);";
								ejecutar_procedimiento(sql4);// obtener id
																// CONCEPTO,
																// return =
																// registro
								idconcepto = Integer.parseInt(registro[0]);

								String sql10 = "select nombre from sub_conceptos where id_concepto = "
										+ Integer.parseInt(registro[0]) + " ";
								stm = conn.createStatement(
										ResultSet.TYPE_SCROLL_INSENSITIVE,
										ResultSet.CONCUR_UPDATABLE);
								ResultSet rst4 = stm.executeQuery(sql10);// nombre
																			// subconceptos
																			// cuentas

								// ciclo 4
								while (rst4.next()) {
									registro[0] = rst4.getString(1); // nombre
																		// subcuenta
									nsubconcepto = registro[0];

									String sql7 = "update sub_conceptos set saldo_deudor = "
											+ 0.0
											+ ", debe = "
											+ 0.0
											+ ", haber = "
											+ 0.0
											+ "  where id_concepto = "
											+ idconcepto
											+ " and nombre like '"
											+ nsubconcepto + "'; ";
									pstm = conn.prepareStatement(sql7,
											ResultSet.TYPE_SCROLL_INSENSITIVE,
											ResultSet.CONCUR_UPDATABLE);
									pstm.executeUpdate();

									String sql14 = "update sub_conceptos set saldo_acreedor = "
											+ 0.0
											+ ", debe = "
											+ 0.0
											+ ", haber = "
											+ 0.0
											+ "  where id_concepto = "
											+ idconcepto
											+ " and nombre like '"
											+ nsubconcepto + "'; ";
									pstm = conn.prepareStatement(sql14,
											ResultSet.TYPE_SCROLL_INSENSITIVE,
											ResultSet.CONCUR_UPDATABLE);
									pstm.executeUpdate();
								} // 4
							} // 4
						} // 2
					} // 1

					sql = "call borrarDiario(\"" + id_catalogo + "\", ?);";
					registro = new String[1];
					ejecutar_procedimiento(sql);
					if (Integer.parseInt(registro[0]) == 1) {
						JOptionPane.showMessageDialog(null,
								"Diario restablecido satisfactoriamente",
								"Mensaje", JOptionPane.INFORMATION_MESSAGE);
					}

					sql = "call borrarDiarioSubConceptos(\"" + id_catalogo
							+ "\", ?);";
					registro = new String[1];
					ejecutar_procedimiento(sql);
					if (Integer.parseInt(registro[0]) == 1) {
						JOptionPane
								.showMessageDialog(
										null,
										"Diario SubConceptos restablecido satisfactoriamente",
										"Mensaje",
										JOptionPane.INFORMATION_MESSAGE);
					}

					conn.close();
					stm.close();
					rst.close();
					pstm.close();

					JOptionPane.showMessageDialog(this,
							"Restauracion efectuada con exito ", "Mensaje",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException ex) {
								JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this,
						"No has abierto ningun catalogo de cuentas ", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}// seguro

	}

	private void borrar_labels() {
		jTextField4.setText("");
		jTextField1.setText("");
		jTextField30.setText("");
		jTextField6.setText("");
		jTextField2.setText("");
		jTextField3.setText("");
		jTextField31.setText("");
		jTextField37.setText("");
	}

	private void jTree1MouseClicked(MouseEvent evt) {
		padre = "";
		ultimo = 0;

		borrar_labels();

		if (arbol.getSelectionPath() != null) {
			ruta = arbol.getSelectionPath().getPath();
			if (ruta.length != 0) {
				r = "";
			}

			if (ruta != null) {

				for (int i = 0; i < ruta.length; i++) {
					r += ruta[i];
				}
				ultimo = ruta.length - 1;
				nombre_concepto = ruta[ultimo].toString();
				jTextField1.setText(nombre_concepto);
				jTextField4.setText(r);

				// obtener nivel de un elemeto en el arbol
				DefaultMutableTreeNode parentNode = null;
				TreePath parentPath = arbol.getSelectionPath();
				// System.out.println(arbol.getSelectionPath());
				if (parentPath == null) {
				} else {
					parentNode = (DefaultMutableTreeNode) (parentPath
							.getLastPathComponent());
					// System.out.println(parentPath.getLastPathComponent());
					nivel = parentNode.getLevel();
					// System.out.println(nivel);
					numero_hijos = parentNode.getChildCount();
				}

				switch (nivel) {
				case 0:
					nivel_cero(); // catalogo
					break;
				case 1:
					nivel_uno(); // cuentas
					break;
				case 2:
					nivel_dos(); // sub cuentas
					break;
				case 3:
					nivel_tres(); // conceptos
					break;
				case 4:
					nivel_cuatro(); // sub conceptos
					break;
				}

				if (evt.getButton() == 3) {
					pm.show(arbol, evt.getX(), evt.getY());
				}
			} else {
				JOptionPane.showMessageDialog(this,
						"No has seleccionado nada del arbol.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this,
					"No has seleccionado nada del arbol..", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// catalogo de cuentas
	private void nivel_cero() {
		tabla_bd = buscar.get(nivel);
		
		sql = "select * from " + tabla_bd + " where id_empresa = " + id_empresa
				+ " and id_catalogo = " + id_catalogo + ";";
		registro = new String[4];

		conn = obc.Conectar(bd, url, server, puerto, user, pass);

		try {

			Statement stm = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rst = stm.executeQuery(sql);

			while (rst.next()) {
				registro[0] = rst.getInt(1) + ""; // id_catalogo
				registro[1] = rst.getString(2); // nombre
				registro[2] = rst.getInt(3) + ""; // id_empresa
				registro[3] = rst.getString(4);// fecha_creacion
			}

			jTextField30.setText(registro[1]);// jtfdescrpcion
			jTextField37.setText(registro[3]);// fecha de creacion

			conn.close();
			stm.close();
			rst.close();

		} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void guardar_registro(String sql) {
		try {

			Statement stm = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rst = stm.executeQuery(sql);

			while (rst.next()) {
				registro[0] = rst.getInt(1) + "";
				registro[1] = rst.getString(2);
				registro[2] = rst.getString(3);
				registro[3] = rst.getString(4);
				registro[4] = rst.getFloat(5) + "";
				registro[5] = rst.getFloat(6) + "";
				registro[6] = rst.getString(7);
			}

			stm.close();
			rst.close();
		} catch (SQLException ex) {
						JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// cuentas
	private void nivel_uno() {
		tabla_bd = buscar.get(nivel);
		
		sql = "select * from " + tabla_bd + " where id_catalogo = "
				+ id_catalogo + " and nombre like '" + nombre_concepto + "';";
		registro = new String[8];
		//
		conn = obc.Conectar(bd, url, server, puerto, user, pass);

		try {
			guardar_registro(sql);
			jTextField30.setText(registro[3]);// descripcion
			jTextField6.setText(registro[2]);// codigo
			jTextField31.setText(registro[4]);// saldo deudor
			jTextField47.setText(registro[5]);// saldo acreedor
			jTextField37.setText(registro[6]); // fecha creacion

			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void ejecutar_procedimiento(String sql) {
		try {
			cst = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			// parametros de salida
			cst.registerOutParameter("ban", Types.INTEGER);// Tipo entero
			cst.executeQuery();
			registro[0] = cst.getString("ban");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void ejecutar_procedimiento2(String sql) {
		try {
			cst = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			// parametros de salida
			cst.registerOutParameter("ban", Types.DOUBLE);// Tipo entero
			cst.executeQuery();
			registro[0] = cst.getString("ban");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// sub cuentas
	private void nivel_dos() {
		tabla_bd = buscar.get(nivel);
		padre = ruta[(ultimo - 1)].toString();
		
		sql = "call obtener_idcuenta('" + padre + "'," + id_catalogo + ",?);";
		registro = new String[1];
		//
		conn = obc.Conectar(bd, url, server, puerto, user, pass);

		try {
			// ejecutar procedimiento almacenado
			ejecutar_procedimiento(sql);

			id_cuentas = Integer.parseInt(registro[0]);

			sql = "select * from " + tabla_bd + " where id_cuenta = "
					+ id_cuentas + " and nombre like '" + nombre_concepto
					+ "';";
			registro = new String[9];

			// guardar registro
			guardar_registro(sql);

			jTextField30.setText(registro[3]);// descripcion
			jTextField6.setText(registro[2]);// codigo
			jTextField31.setText(registro[4]);// saldo deudor
			jTextField47.setText(registro[5]);// saldo acreedor
			jTextField37.setText(registro[6]); // fecha creacion

			conn.close();
			cst.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// conceptos
	private void nivel_tres() {
		tabla_bd = buscar.get(nivel);
		padre = ruta[(ultimo - 2)].toString();// nombre de la cuenta
		
		sql = "call obtener_idcuenta('" + padre + "'," + id_catalogo + ",?);";
		registro = new String[1];
		//
		conn = obc.Conectar(bd, url, server, puerto, user, pass);

		try {
			// ejecutar procedimiento almacenado
			ejecutar_procedimiento(sql);
			id_cuentas = Integer.parseInt(registro[0]);

			// obtener id_subcuenta
			padre = ruta[(ultimo - 1)].toString();
			sql = "call obtener_idsubcuenta('" + padre + "'," + id_cuentas
					+ ",?);";
			registro = new String[1];

			// ejecutar procedimiento almacenado
			ejecutar_procedimiento(sql);
			id_subcuentas = Integer.parseInt(registro[0]);

			// llenar labels
			sql = "select * from " + tabla_bd + " where id_subcuenta = "
					+ id_subcuentas + " and nombre like '" + nombre_concepto
					+ "';";
			registro = new String[11];

			Statement stm = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rst = stm.executeQuery(sql);

			while (rst.next()) {
				registro[0] = rst.getInt(1) + ""; // id_concepto
				registro[1] = rst.getString(2); // nombre
				registro[2] = rst.getString(3); // codigo
				registro[3] = rst.getString(4);// descripcion
				registro[4] = rst.getFloat(5) + "";// debe
				registro[5] = rst.getFloat(6) + "";// haber
				registro[6] = rst.getString(7);// fecha creacion
				registro[7] = rst.getFloat(8) + "";// saldo deudor
				registro[8] = rst.getFloat(9) + "";// saldo acreedor
				registro[9] = rst.getInt(10) + "";// id_subcuenta
				
			}

			jTextField6.setText(registro[2]);
			jTextField30.setText(registro[3]);
			jTextField2.setText(registro[4]);
			jTextField3.setText(registro[5]);
			jTextField31.setText(registro[7]);
			jTextField47.setText(registro[8]);
			jTextField37.setText(registro[6]); // fecha creacion
			id_conceptos = Integer.parseInt(registro[0]);

			conn.close();
			rst.close();
			stm.close();
			cst.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// sub conceptos
	private void nivel_cuatro() {

		tabla_bd = buscar.get(nivel);
		padre = ruta[(ultimo - 3)].toString();// nombre de la cuenta
		
		sql = "call obtener_idcuenta('" + padre + "'," + id_catalogo + ",?);";
		registro = new String[1];
		//
		conn = obc.Conectar(bd, url, server, puerto, user, pass);

		try {
			// ejecutar procedimiento almacenado
			ejecutar_procedimiento(sql);
			id_cuentas = Integer.parseInt(registro[0]);

			// obtener id_subcuenta
			padre = ruta[(ultimo - 2)].toString();
			sql = "call obtener_idsubcuenta('" + padre + "'," + id_cuentas
					+ ",?);";
			registro = new String[1];

			// ejecutar procedimiento almacenado
			ejecutar_procedimiento(sql);
			id_subcuentas = Integer.parseInt(registro[0]);

			// obtener id_concepto
			padre = ruta[(ultimo - 1)].toString();
			nombre_concepto2 = padre;
			sql = "call obtener_idconcepto('" + padre + "'," + id_subcuentas
					+ ",?);";
			registro = new String[1];

			// ejecutar procedimiento almacenado
			ejecutar_procedimiento(sql);
			id_conceptos = Integer.parseInt(registro[0]);

			// llenar labels
			sql = "select * from " + tabla_bd + " where id_concepto = "
					+ id_conceptos + " and nombre like '" + nombre_concepto
					+ "';";
			registro = new String[11];
			Statement stm = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rst = stm.executeQuery(sql);

			while (rst.next()) {
				registro[0] = rst.getInt(1) + ""; // id_subconcepto
				registro[1] = rst.getString(2); // nombre
				registro[2] = rst.getString(3); // codigo
				registro[3] = rst.getString(4);// descripcion
				registro[4] = rst.getFloat(5) + "";// debe
				registro[5] = rst.getFloat(6) + "";// haber
				registro[6] = rst.getString(7); // fecha creacion;
				registro[7] = rst.getFloat(8) + "";// saldo deudor
				registro[8] = rst.getFloat(9) + "";// saldo acreedor
				registro[9] = rst.getInt(10) + "";// id_concepto
			}

			jTextField6.setText(registro[2]);
			jTextField30.setText(registro[3]);
			jTextField2.setText(registro[4]);
			jTextField3.setText(registro[5]);
			jTextField31.setText(registro[7]);
			jTextField47.setText(registro[8]);
			jTextField37.setText(registro[6]);
			id_articulo_borrar = Integer.parseInt(registro[0]);
			nom_articulo_borrar = registro[1];

			conn.close();
			rst.close();
			stm.close();
			cst.close();
		} catch (SQLException ex) {
						JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem3ActionPerformed
		// TODO add your handling code here:
		try {
			if (administrar_empresa.isIcon()) {
				administrar_empresa.setIcon(false);
			} else if (administrar_empresa.isVisible()) {
				administrar_empresa.setIcon(true);
			}
		} catch (PropertyVetoException ex) {
			Logger.getLogger(Swc.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		cargar_empresas();
		administrar_empresa.setVisible(true);
	}// GEN-LAST:event_jMenuItem3ActionPerformed

	private void borrar_demp() {
		jTable8.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Numero de empresa", "Nombre de la empresa", "Descripcion",
				"Fecha de creacion" }) {
			Class[] types = new Class[] { java.lang.Integer.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class };

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		});
	}

	private void borrar_tcat() {
		jTable11.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Numero de catalogo", "Nombre del catalogo",
						"Numero de la empresa", "Fecha de creacion" }) {
			Class[] types = new Class[] { java.lang.Integer.class,
					java.lang.String.class, java.lang.Integer.class,
					java.lang.String.class };

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
	}

	private void cargar_empresas() {
		sql = "select * from empresas; ";
		// mostrar empresas
		conn = obc.Conectar(bd, url, server, puerto, user, pass);
		registro = new String[4];

		borrar_demp();
		DefaultTableModel model = (DefaultTableModel) jTable8.getModel();

		try {
			Statement stm = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rst = stm.executeQuery(sql);

			while (rst.next()) {
				registro[0] = rst.getInt(1) + ""; // id_empresa
				registro[1] = rst.getString(2); // nombre
				registro[2] = rst.getString(3); // descripcion
				registro[3] = rst.getString(4);// fecha creaccion
				model.insertRow(model.getRowCount(), registro);
			}

			conn.close();
			rst.close();
			stm.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem4ActionPerformed
		// TODO add your handling code here:
		try {
			if (catalogo.isIcon()) {
				catalogo.setIcon(false);
			} else if (catalogo.isVisible()) {
				catalogo.setIcon(true);
			}
		} catch (PropertyVetoException ex) {
			Logger.getLogger(Swc.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		if (id_catalogo != -1) {
			catalogo.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this,
					"No has abierto ningun catalogo", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}// GEN-LAST:event_jMenuItem4ActionPerformed

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField1ActionPerformed

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField2ActionPerformed

	private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField3ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField3ActionPerformed

	String r = "";
	Object ruta[] = null;

	private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField4ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField4ActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		// agregar subcuenta
		agregarsubc();
		jButton1.requestFocus(false);
		arbol.requestFocusInWindow();
	}// GEN-LAST:event_jButton1ActionPerformed

	private void agregarsubc() {
		conn = obc.Conectar(bd, url, server, puerto, user, pass);
		sql = "call inserta_subconceptos(\"" + jTextField11.getText() + "\",\""
				+ obtener_numerohijos(numero_hijos + 1) + "\",\""
				+ jTextField38.getText() + "\"," + id_conceptos + ",\""
				+ id_catalogo + "\",?);";

		// ejecutar procedimiento
		ejecutar_procedimiento(sql);
		int ban = Integer.parseInt(registro[0]);

		if (ban == 1) {
			cuenta = new DefaultMutableTreeNode(jTextField11.getText());

			DefaultMutableTreeNode parentNode = null;
			TreePath parentPath = arbol.getSelectionPath();

			if (parentPath == null) {
			} else {
				parentNode = (DefaultMutableTreeNode) (parentPath
						.getLastPathComponent());
			}

			modelo = (DefaultTreeModel) arbol.getModel();
			modelo.insertNodeInto(cuenta, parentNode,
					parentNode.getChildCount());

			if (parentNode.getUserObject().toString().equals("INVENTARIO")) {
				inserta_articulo(id_conceptos);
			}

			JOptionPane.showMessageDialog(this,
					"Se guardo satisfactoriamente el sub_concepto <<"
							+ jTextField11.getText() + " >> en la BD",
					"Mensaje", JOptionPane.INFORMATION_MESSAGE);

		} else {
			JOptionPane.showMessageDialog(this, "El sub_concepto <<"
					+ jTextField11.getText() + " >> ya existe en la BD",
					"Mensaje", JOptionPane.ERROR_MESSAGE);
		}

		jTextField11.setText("");
		jTextField38.setText("");
		agregar_subc.setVisible(false);
	}

	private void inserta_articulo(int id_concepto) {

		sql = "call obtener_idsubconcepto(\"" + jTextField11.getText()
				+ "\",\"" + id_concepto + "\",?);";
		conn = obc.Conectar(bd, url, server, puerto, user, pass);
		registro = new String[1];

		ejecutar_procedimiento(sql);
		int ban = Integer.parseInt(registro[0]);

		sql = "call inserta_articulosv(\"" + jTextField11.getText() + "\",\""
				+ 0 + "\",\"" + 0.0 + "\",\"" + 0.0 + "\",\"" + ban + "\",\""
				+ 1 + "\",?);";

		// ejecutar procedimiento
		ejecutar_procedimiento(sql);
		ban = Integer.parseInt(registro[0]);

		if (ban == 1) {
			JOptionPane.showMessageDialog(this, "El articulo: <<"
					+ jTextField11.getText()
					+ " >> se guardo correctamente en la base de datos",
					"Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private String obtener_numerohijos(int nh) {
		String numh = nh + "";

		if (numh.length() == 1) {
			numh = "00" + numh;
		} else if (numh.length() == 2) {
			numh = "0" + numh;
		}

		return numh;
	}

	private void borrarsubc() {
		int option = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar la sub cuenta??", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
		
		if(option == JOptionPane.OK_OPTION){
			
			if (nivel > 3) {
				DefaultMutableTreeNode parentNode = null;
				TreePath parentPath = arbol.getSelectionPath();
				if (parentPath == null) {
				} else {
					parentNode = (DefaultMutableTreeNode) (parentPath
							.getLastPathComponent());
				}
				modelo = (DefaultTreeModel) arbol.getModel();
				if (parentNode != null & parentNode.getParent() != null) {
					modelo.removeNodeFromParent(parentNode);
				}

				agregar_subc.setVisible(false);

				if (nombre_concepto2.equalsIgnoreCase("Inventario")) {
					sql = "call borrar_articulo(" + id_articulo_borrar + ",'"
							+ nom_articulo_borrar + "',?);";
					conn = obc.Conectar(bd, url, server, puerto, user, pass);
					// ejecutar procedimiento
					ejecutar_procedimiento(sql);
					int ban = Integer.parseInt(registro[0]);

					if (ban == 1) {
						JOptionPane.showMessageDialog(this,
								"Se borro satisfactoriamente el articulo <<"
										+ nom_articulo_borrar + " >> en la BD",
								"Mensaje", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(this,
								"No se borro satisfactoriamente el articulo <<"
										+ nom_articulo_borrar + " >> en la BD",
								"Mensaje", JOptionPane.ERROR_MESSAGE);
					}
				}

				// eliminar base de datos
				//
				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				sql = "call borrar_subconceptos('" + nombre_concepto + "',"
						+ id_conceptos + ",?);";

				// ejecutar procedimiento
				ejecutar_procedimiento(sql);
				int ban = Integer.parseInt(registro[0]);

				if (ban == 1) {
					JOptionPane.showMessageDialog(this,
							"Se borro satisfactoriamente el sub_concepto <<"
									+ nombre_concepto + " >> en la BD", "Mensaje",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this,
							"No se borro satisfactoriamente el sub_concepto <<"
									+ nombre_concepto + " >> en la BD", "Mensaje",
							JOptionPane.ERROR_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(this,
						"No puedes eliminar esa cuenta", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			jTextField11.setText("");	
		}
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
		// TODO add your handling code here:
		// modificar subc
		if (nivel > 3) {
			String cade = jTextField1.getText();
			TreePath currentSelection = arbol.getSelectionPath();
			if (currentSelection != null) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) currentSelection
						.getLastPathComponent();
				node.setUserObject(cade);
				DefaultTreeModel model = ((DefaultTreeModel) arbol.getModel());
				model.nodeChanged(node);

				// eliminar base de datos
				//
				conn = obc.Conectar(bd, url, server, puerto, user, pass);

				// jTextField1 nombre
				// jTextField30 descripcion

				sql = "call actualiza_subconceptos('" + nombre_concepto + "',"
						+ id_conceptos + ",'" + jTextField1.getText() + "','"
						+ jTextField30.getText() + "',?);";

				// ejecutar procedimiento
				ejecutar_procedimiento(sql);
				int ban = Integer.parseInt(registro[0]);

				if (ban == 1) {
					JOptionPane.showMessageDialog(this,
							"Se actualizo satisfactoriamente el sub_concepto <<"
									+ nombre_concepto + " >> en la BD",
							"Mensaje", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this,
							"No se actualizo satisfactoriamente el sub_concepto <<"
									+ nombre_concepto + " >> en la BD",
							"Mensaje", JOptionPane.ERROR_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(this,
						"No puedes eliminar esa cuenta", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this,
					"No puedes modificar esa cuenta", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}// GEN-LAST:event_jButton5ActionPerformed

	private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenu4ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jMenu4ActionPerformed

	private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem6ActionPerformed
		// TODO add your handling code here:
		try {
			if (operaciones_diario.isIcon()) {
				operaciones_diario.setIcon(false);
			} else if (operaciones_diario.isVisible()) {
				operaciones_diario.setIcon(true);
			}
		} catch (PropertyVetoException ex) {
			Logger.getLogger(Swc.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		jTextField8.setText("0.0");
		jTextField7.setText("0.0");

		if (id_catalogo != -1) {
			operaciones_diario.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this,
					"No has abierto ningun catalogo", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_jMenuItem6ActionPerformed

	private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField9ActionPerformed
		// TODO add your handling code here:

		jButton10.requestFocusInWindow();
	}// GEN-LAST:event_jTextField9ActionPerformed

	private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton10ActionPerformed
		// TODO add your handling code here:

		// aceptar cargo

		if (jComboBox4.getSelectedItem() != null) {

			if (tipo_operacion == 1) {
				debe = Double.parseDouble(jTextField9.getText());
				bvar = new BigDecimal(debe);

				sql = "call actualizar_subconceptos(\"" + nom_subconcepto_combo
						+ "\",\"" + id_subconcepto_combo + "\",\"" + bvar
						+ "\",\"" + tipo_operacion + "\",?);";
				//
				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				int ban = Integer.parseInt(registro[0]);

				if (ban == 1) {
					JOptionPane.showMessageDialog(this,
							"Se realizo el cargo satisfactoriamente al sub concepto: "
									+ nom_subconcepto_combo
									+ ", por la cantidad de: $" + bvar,
							"Mensaje", JOptionPane.INFORMATION_MESSAGE);
				}

				if (tipo_operacion == 1) {
					tipo_opera = "cargo";
				}

				if (tipo_operacion == 2) {
					tipo_opera = "abono";
				}

				// insertar en diario el sub concepto

				sql = "call inserta_diario_subconceptos(\""
						+ nom_subconcepto_combo + "\",\"" + bvar + "\",\""
						+ tipo_opera + "\",\"" + nom_concepto_combo + "\",\""
						+ Integer.parseInt(jTextField13.getText()) + "\",\""
						+ id_catalogo + "\",?);";
				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				ban = Integer.parseInt(registro[0]);

				if (ban == 1) {
					JOptionPane.showMessageDialog(this,
							"Se realizo la operacion de diario satisfactoriamente: "
									+ nom_subconcepto_combo, "Mensaje",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} // fin tipo operacion 1

			if (tipo_operacion == 2) {
				abono = Double.parseDouble(jTextField9.getText());
				bvar = new BigDecimal(abono);

				sql = "call actualizar_subconceptos(\""
						+ nom_subconcepto_combo2 + "\",\""
						+ id_subconcepto_combo2 + "\",\"" + bvar + "\",\""
						+ tipo_operacion + "\",?);";
				//
				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				int ban = Integer.parseInt(registro[0]);

				if (ban == 2) {
					JOptionPane.showMessageDialog(this,
							"Se realizo el abono satisfactoriamente al sub concepto: "
									+ nom_subconcepto_combo2
									+ ", por la cantidad de: $" + bvar,
							"Mensaje", JOptionPane.INFORMATION_MESSAGE);
				}

				if (tipo_operacion == 1) {
					tipo_opera = "cargo";
				}

				if (tipo_operacion == 2) {
					tipo_opera = "abono";
				}

				// insertar en diario el sub concepto

				sql = "call inserta_diario_subconceptos(\""
						+ nom_subconcepto_combo2 + "\",\"" + bvar + "\",\""
						+ tipo_opera + "\",\"" + nom_concepto_combo2 + "\",\""
						+ Integer.parseInt(jTextField13.getText()) + "\",\""
						+ id_catalogo + "\",?);";
				//
				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				ban = Integer.parseInt(registro[0]);

				if (ban == 1) {
					JOptionPane.showMessageDialog(this,
							"Se realizo la operacion de diario satisfactoriamente: "
									+ nom_subconcepto_combo2, "Mensaje",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} // fin tipo operacion 2
		}

		if (subt.equals("1")) {

			cantidad = Double.parseDouble(jTextField7.getText()) + debe;
			bvar = new BigDecimal(cantidad);
			jTextField7.setText(bvar + "");
		}
		if (subt.equals("2")) {

			cantidad = Double.parseDouble(jTextField8.getText()) + abono;
			bvar = new BigDecimal(cantidad);
			jTextField8.setText(bvar + "");
		}

		jTextField9.setText("0.0");
		simple.setVisible(false);

		jButton10.requestFocus(false);
	}// GEN-LAST:event_jButton10ActionPerformed

	private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton11ActionPerformed
		// TODO add your handling code here:
		if (subt.equals("1")) {
			jTextField7.setText(jTextField10.getText());
		}
		if (subt.equals("2")) {
			jTextField8.setText(jTextField10.getText());
		}

		jTextField10.setText("");
		venta.setVisible(false);

	}// GEN-LAST:event_jButton11ActionPerformed

	private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton12ActionPerformed
		// TODO add your handling code here:
		// agregar renglo tabla 1

		DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
		Object vacio[] = { "", null, null, null, null, null, null, null };
		dtm.addRow(vacio);
		jButton13.setEnabled(true);
	}// GEN-LAST:event_jButton12ActionPerformed

	private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton13ActionPerformed
		// TODO add your handling code here:

		// borrar renglon tabla 1

		DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

		if (dtm.getRowCount() >= 1) {
			dtm.removeRow(dtm.getRowCount() - 1);
		}
		if (dtm.getRowCount() == 0) {
			jButton13.setEnabled(false);
		}
		System.out.println(dtm.getRowCount());
	}// GEN-LAST:event_jButton13ActionPerformed

	private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton14ActionPerformed
		// TODO add your handling code here:

		// inserta renglon prueba tabla 1

		DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
		Object datos[] = { "ARticulo a", 0, 0, 0, 0, .50, 34, 123123 };
		dtm.insertRow(0, datos);
		jButton13.setEnabled(true);
	}// GEN-LAST:event_jButton14ActionPerformed

	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton9ActionPerformed
		// TODO add your handling code here:

		tipo_operacion = 1;
		subt = "1";
		if (jComboBox3.getSelectedIndex() == 0) {
			if (simple.isIcon()) {
				try {
					simple.setIcon(false);
				} catch (PropertyVetoException ex) {
					Logger.getLogger(Swc.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}

			cargar_simple_cargo();
			jTextField9.setText("0.0");
			simple.setVisible(true);
			jTextField9.requestFocusInWindow();
		}
		if (jComboBox3.getSelectedIndex() == 3) {
			if (venta.isIcon()) {
				try {
					venta.setIcon(false);
				} catch (PropertyVetoException ex) {
					Logger.getLogger(Swc.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
			jTextField9.setText("0.0");
			venta.setVisible(true);
		}

		if (jComboBox3.getSelectedIndex() == 1) {
			if (compra.isIcon()) {
				try {
					compra.setIcon(false);
				} catch (PropertyVetoException ex) {
					Logger.getLogger(Swc.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
			jTextField9.setText("0.0");
			compra.setVisible(true);
		}
		if (jComboBox3.getSelectedIndex() == 2) {
			if (devoluciones.isIcon()) {
				try {
					devoluciones.setIcon(false);
				} catch (PropertyVetoException ex) {
					Logger.getLogger(Swc.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
			jTextField9.setText("0.0");
			devoluciones.setVisible(true);
		}
		if (jComboBox3.getSelectedIndex() == 4) {
			if (agregar_articulo.isIcon()) {
				try {
					agregar_articulo.setIcon(false);
				} catch (PropertyVetoException ex) {
					Logger.getLogger(Swc.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
			jTextField39.setText("0");
			jTextField40.setText("0.0");
			agregar_articulo.setVisible(true);
		}
	}// GEN-LAST:event_jButton9ActionPerformed

	private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem8ActionPerformed
		// TODO add your handling code here:
		System.exit(0);
	}// GEN-LAST:event_jMenuItem8ActionPerformed

	private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem10ActionPerformed
		// TODO add your handling code here:

		acercade.setVisible(true);
	}// GEN-LAST:event_jMenuItem10ActionPerformed

	private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField11ActionPerformed
		// TODO add your handling code here:
		jTextField38.requestFocusInWindow();
	}// GEN-LAST:event_jTextField11ActionPerformed

	private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton17ActionPerformed
		// TODO add your handling code here:

		// limpiar tabla 1
		jTable1.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Nombre", "Existencia", "Lote", "Precio de costo", "Cantidad",
				"Incremento %", "Precio de venta", "Sub Total" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Double.class, java.lang.Integer.class,
					java.lang.Double.class, java.lang.Double.class,
					java.lang.Double.class };

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		jButton13.setEnabled(false);
	}// GEN-LAST:event_jButton17ActionPerformed

	private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTable1MouseClicked
		// TODO add your handling code here:

		if (evt.getButton() == 3) {
			pmt.show(jTable1, evt.getX(), evt.getY());
		}
	}// GEN-LAST:event_jTable1MouseClicked

	private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTable2MouseClicked
		// TODO add your handling code here:
	}// GEN-LAST:event_jTable2MouseClicked

	private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton15ActionPerformed
		// TODO add your handling code here:

		// aceptar tablña compras
		if (subt.equals("1")) {
			jTextField7.setText(jTextField12.getText());
		}
		if (subt.equals("2")) {
			jTextField8.setText(jTextField12.getText());
		}

		jTextField12.setText("");
		compra.setVisible(false);

	}// GEN-LAST:event_jButton15ActionPerformed

	private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton18ActionPerformed
		// TODO add your handling code here:

		// agregar renglonm tabla compras
		DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
		Object vacio[] = { "", null, null, null, null };
		dtm.addRow(vacio);
		jButton19.setEnabled(true);
	}// GEN-LAST:event_jButton18ActionPerformed

	private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton19ActionPerformed
		// TODO add your handling code here:

		// eliminar renglomn tabbla compras
		DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();

		if (dtm.getRowCount() >= 1) {
			dtm.removeRow(dtm.getRowCount() - 1);
		}
		if (dtm.getRowCount() == 0) {
			jButton19.setEnabled(false);
		}
		System.out.println(dtm.getRowCount());
	}// GEN-LAST:event_jButton19ActionPerformed

	private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton20ActionPerformed
		// TODO add your handling code here:

		// prueba de agregar tabla compras
		DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
		Object datos[] = { "ARticulo a", 0, 0, 0, 0 };
		dtm.insertRow(0, datos);
		jButton19.setEnabled(true);
	}// GEN-LAST:event_jButton20ActionPerformed

	private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton22ActionPerformed
		// TODO add your handling code here:

		// limpiar tabla compras
		jTable2.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Nombre", "Cantidad", "Lote", "Precio de costo", "Sub Total" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Double.class, java.lang.Double.class };

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		jButton19.setEnabled(false);
	}// GEN-LAST:event_jButton22ActionPerformed

	private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton21ActionPerformed
		// TODO add your handling code here:
		// calcula total compras
	}// GEN-LAST:event_jButton21ActionPerformed

	private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton23ActionPerformed
		// TODO add your handling code here:
		// aceptar abono

		tipo_operacion = 2;
		subt = "2";
		if (jComboBox5.getSelectedIndex() == 0) {
			if (simple.isIcon()) {
				try {
					simple.setIcon(false);
				} catch (PropertyVetoException ex) {
					Logger.getLogger(Swc.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}

			cargar_simple_abono();
			jTextField9.setText("0.0");
			simple.setVisible(true);
			jTextField9.requestFocusInWindow();
		}
		if (jComboBox5.getSelectedIndex() == 3) {
			if (venta.isIcon()) {
				try {
					venta.setIcon(false);
				} catch (PropertyVetoException ex) {
					Logger.getLogger(Swc.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
			venta.setVisible(true);
		}

		if (jComboBox5.getSelectedIndex() == 1) {
			if (compra.isIcon()) {
				try {
					compra.setIcon(false);
				} catch (PropertyVetoException ex) {
					Logger.getLogger(Swc.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
			compra.setVisible(true);
		}
		if (jComboBox5.getSelectedIndex() == 2) {
			if (devoluciones.isIcon()) {
				try {
					devoluciones.setIcon(false);
				} catch (PropertyVetoException ex) {
					Logger.getLogger(Swc.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
			devoluciones.setVisible(true);
		}
	}// GEN-LAST:event_jButton23ActionPerformed

	private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTable3MouseClicked
		// TODO add your handling code here:
	}// GEN-LAST:event_jTable3MouseClicked

	private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton24ActionPerformed
		// TODO add your handling code here:

		// aceptar devoluciones
		if (subt.equals("1")) {
			jTextField7.setText(jTextField14.getText());
		}
		if (subt.equals("2")) {
			jTextField8.setText(jTextField14.getText());
		}

		jTextField14.setText("");
		devoluciones.setVisible(false);

	}// GEN-LAST:event_jButton24ActionPerformed

	private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton25ActionPerformed
		// TODO add your handling code here:
		// agregar renglonjTable3, devoluciones
		DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
		Object vacio[] = { "", null, null, null, null };
		dtm.addRow(vacio);
		jButton26.setEnabled(true);
	}// GEN-LAST:event_jButton25ActionPerformed

	private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton26ActionPerformed
		// TODO add your handling code here:
		// borrar renglon jTable3, devoluciones
		DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();

		if (dtm.getRowCount() >= 1) {
			dtm.removeRow(dtm.getRowCount() - 1);
		}
		if (dtm.getRowCount() == 0) {
			jButton26.setEnabled(false);
		}
		System.out.println(dtm.getRowCount());
	}// GEN-LAST:event_jButton26ActionPerformed

	private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton27ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton27ActionPerformed

	private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton28ActionPerformed
		// TODO add your handling code here:
		// calcular total jtable3
	}// GEN-LAST:event_jButton28ActionPerformed

	private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton29ActionPerformed
		// TODO add your handling code here:
		// limpiar jTable3, devoluciones
		jTable3.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Nombre", "Cantidad", "Lote", "Precio de venta", "Sub Total" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Double.class, java.lang.Double.class };

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		jButton26.setEnabled(false);
	}// GEN-LAST:event_jButton29ActionPerformed

	private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem12ActionPerformed
		// TODO add your handling code here:
		try {
			if (balance_inicial.isIcon()) {
				balance_inicial.setIcon(false);
			} else if (balance_inicial.isVisible()) {
				balance_inicial.setIcon(true);
			}
		} catch (PropertyVetoException ex) {
			Logger.getLogger(Swc.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		if (id_catalogo != -1) {
			cargar_balance_inicial();
		}
		balance_inicial.setVisible(true);
	}// GEN-LAST:event_jMenuItem12ActionPerformed

	private void borrar_tbinicial() {
		jTable4.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Concepto", "Parcial", "Debe", "Haber", "Fecha creacion" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class };

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
	}

	private void cargar_balance_inicial() {

		// jtable 4, concepto,parcial,debe,haber

		conn = obc.Conectar(bd, url, server, puerto, user, pass);
		String registron[] = new String[4], tipo_operacion;
		int no = 1;
		String nom_con = "";
		sql = "select concepto,saldo,tipo_operacion,fecha from diario where id_catalogo = "
				+ id_catalogo + ";";
		String nuevo_registro[] = new String[5];
		String nuevo_registro2[] = new String[5];
		String registron2[] = new String[4];

		borrar_tbinicial();
		DefaultTableModel model = (DefaultTableModel) jTable4.getModel();

		try {
			Statement stm = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rst = stm.executeQuery(sql);

			while (rst.next()) {
				registron[0] = rst.getString(1); // concepto
				registron[1] = rst.getDouble(2) + ""; // saldo
				registron[2] = rst.getString(3); // tipo
				registron[3] = rst.getString(4); // fecha

				tipo_operacion = registron[2];

				nuevo_registro[0] = registron[0];
				nuevo_registro[1] = "";
				nuevo_registro[4] = registron[3];

				if (tipo_operacion.equalsIgnoreCase("cargo")) {
					nuevo_registro[2] = registron[1];
					nuevo_registro[3] = "0.0";

				} else if (tipo_operacion.equalsIgnoreCase("abono")) {
					nuevo_registro[3] = registron[1];
					nuevo_registro[2] = "0.0";
				}

				model.insertRow(model.getRowCount(), nuevo_registro);
				nom_con = registron[0];
				String sql2 = "select sub_concepto,saldo,tipo_operacion,fecha from diario_subconceptos"
						+ " where id_catalogo = "
						+ id_catalogo
						+ " and nombre_concepto like '"
						+ nom_con
						+ "' and num_operacion = " + no + ";";
				Statement stm2 = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet rst2 = stm2.executeQuery(sql2);
				while (rst2.next()) {

					registron2[0] = rst2.getString(1); // sub_concepto
					registron2[1] = rst2.getDouble(2) + ""; // saldo
					registron2[2] = rst2.getString(3); // tipo_operacion
					registron2[3] = rst2.getString(4); // nombre_concepto

					tipo_operacion = registron2[2];

					nuevo_registro2[0] = registron2[0];
					nuevo_registro2[1] = registron2[1];
					nuevo_registro2[4] = registron2[3];
					nuevo_registro2[2] = "0.0";
					nuevo_registro2[3] = "0.0";

					model.insertRow(model.getRowCount(), nuevo_registro2);
				}// fin while 2

			}

			conn.close();
			rst.close();
			stm.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		// calculos

		double md = 0.0, ma = 0.0, sd = 0.0, sa = 0.0;

		for (int ind = 0; ind < jTable4.getRowCount(); ind++) {
			md += Double.parseDouble(jTable4.getValueAt(ind, 2).toString());
			ma += Double.parseDouble(jTable4.getValueAt(ind, 3).toString());
		}

		BigDecimal bma = new BigDecimal(ma);
		BigDecimal bmd = new BigDecimal(md);
		BigDecimal bsa = new BigDecimal(0.0), bsd = new BigDecimal(0.0), saldo;

		saldo = bmd.subtract(bma);

		if (saldo.doubleValue() >= 0) {
			bsd = saldo;
		} else {
			bsa = saldo;
		}

		jTextField17.setText(bmd + "");
		jTextField18.setText(bma + "");

		conn = obc.Conectar(bd, url, server, puerto, user, pass);
		registron = new String[3];
		sql = "select total_activos,total_pasivos,capital_contable from balance_inicial where id_catalogo = "
				+ id_catalogo + ";";
		try {
			Statement stm1 = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rst1 = stm1.executeQuery(sql);

			while (rst1.next()) {
				registron[0] = rst1.getDouble(1) + ""; // total_activos
				registron[1] = rst1.getDouble(2) + ""; // total_pasivos
				registron[2] = rst1.getDouble(3) + ""; // capital_contable
			}

			conn.close();
			rst1.close();
			stm1.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		jTextField19.setText(registron[0]);
		jTextField20.setText(registron[1]);
		jTextField21.setText(registron[2]);

	}

	private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem14ActionPerformed
		// TODO add your handling code here:
		try {
			if (edo_res.isIcon()) {
				edo_res.setIcon(false);
			} else if (edo_res.isVisible()) {
				edo_res.setIcon(true);
			}
		} catch (PropertyVetoException ex) {
			Logger.getLogger(Swc.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		if (id_catalogo != -1 && id_empresa != -1) {
			cargar_edoresultados();
		}
	}// GEN-LAST:event_jMenuItem14ActionPerformed

	private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem13ActionPerformed
		// TODO add your handling code here:
		// balance general
		try {
			if (balance_general.isIcon()) {
				balance_general.setIcon(false);
			} else if (balance_general.isVisible()) {
				balance_general.setIcon(true);
			}
		} catch (PropertyVetoException ex) {
			Logger.getLogger(Swc.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		if (id_catalogo != -1 && id_empresa != -1) {

			if (bandera1 != false) {
				cargar_balanceGeneral();

				sql = "select current_timestamp();";
				registro = new String[1];

				conn = obc.Conectar(bd, url, server, puerto, user, pass);

				try {
					Statement stm = conn.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
					ResultSet rst = stm.executeQuery(sql);

					while (rst.next()) {
						registro[0] = rst.getString(1); // fecha

						jTextField29.setText(registro[0]);
					}

					conn.close();
					rst.close();
					stm.close();

				} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				balance_general.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this,
						"No has hecho el estado de resultados", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this,
					"No has abiero una empresa o catalogo", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}// GEN-LAST:event_jMenuItem13ActionPerformed

	private void borrar_tg() {

		jTable7.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Concepto", "Parcial", "Debe", "Haber" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class };

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
	}

	private void cargar_balanceGeneral() {
		// jtable 7,concepto,parcial,debe,habeºº

		borrar_tg();
		DefaultTableModel dtm7 = (DefaultTableModel) jTable7.getModel();
		int idcuenta = 0, idsubcuenta = 0, idconcepto = 0;
		String ncuenta = "", nsubcuenta = "", nconcepto = "", nsubconcepto = "";
		String nuevor[] = new String[4];

		sql = "select nombre, saldo_deudor, saldo_acreedor from cuentas where id_catalogo = "
				+ id_catalogo + ";";

		conn = obc.Conectar(bd, url, server, puerto, user, pass);

		try {
			Statement stm = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rst = stm.executeQuery(sql);// nombre sub cuentas

			registro = new String[3];

			// ciclo 1
			while (rst.next()) {

				registro[0] = rst.getString(1); // nombre
				registro[1] = rst.getString(2); // saldo_deudor
				registro[2] = rst.getString(3); // saldo_acreedor
				ncuenta = registro[0];

				nuevor[0] = ncuenta;
				nuevor[1] = "";
				nuevor[2] = registro[1];
				nuevor[3] = registro[2];

				dtm7.insertRow(dtm7.getRowCount(), nuevor);
				if (ncuenta.equalsIgnoreCase("Activo")) {
					jTextField32
							.setText((Double.parseDouble(registro[1]) + Double
									.parseDouble(registro[2])) + "");
				}
				if (ncuenta.equalsIgnoreCase("Pasivo")) {
					jTextField33
							.setText((Double.parseDouble(registro[1]) + Double
									.parseDouble(registro[2])) + "");
				}

				String sql2 = "call obtener_idcuenta('" + ncuenta + "',"
						+ id_catalogo + ",?);";
				ejecutar_procedimiento(sql2);// obtener id cuenta, return =
												// registro
				idcuenta = Integer.parseInt(registro[0]);

				String sql8 = "select nombre, saldo_deudor, saldo_acreedor from sub_cuentas where id_cuenta = "
						+ idcuenta + "; ";
				stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet rst2 = stm.executeQuery(sql8);// nombre sub cuentas

				// ciclo 2
				while (rst2.next()) {
					registro[0] = rst2.getString(1); // nombre subcuenta
					registro[1] = rst2.getString(2); // saldo_deudor
					registro[2] = rst2.getString(3); // saldo_acreedor
					nsubcuenta = registro[0];

					nuevor[0] = nsubcuenta;
					nuevor[1] = "";
					nuevor[2] = registro[1];
					nuevor[3] = registro[2];

					dtm7.insertRow(dtm7.getRowCount(), nuevor);

					String sql3 = "call obtener_idsubcuenta('" + nsubcuenta
							+ "'," + idcuenta + ",?);";
					ejecutar_procedimiento(sql3);// obtener id subcuenta, return
													// = registro
					idsubcuenta = Integer.parseInt(registro[0]);

					String sql9 = "select nombre, saldo_deudor, saldo_acreedor from conceptos where id_subcuenta = "
							+ idsubcuenta + " ";
					stm = conn.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
					ResultSet rst3 = stm.executeQuery(sql9);// nombre conceptos
															// cuentas

					// ciclo 3
					while (rst3.next()) {
						registro[0] = rst3.getString(1); // nombre subcuenta
						registro[1] = rst3.getString(2); // saldo_deudor
						registro[2] = rst3.getString(3); // saldo_acreedor
						nconcepto = registro[0];

						nuevor[0] = nconcepto;
						nuevor[1] = "";
						nuevor[2] = registro[1];
						nuevor[3] = registro[2];

						dtm7.insertRow(dtm7.getRowCount(), nuevor);

						if (nconcepto.equalsIgnoreCase("Capital Contable")) {
							jTextField34.setText((Double
									.parseDouble(registro[1]) + Double
									.parseDouble(registro[2]))
									+ "");
						}

						String sql4 = "call obtener_idconcepto('" + nconcepto
								+ "'," + idsubcuenta + ",?);";
						ejecutar_procedimiento(sql4);// obtener id CONCEPTO,
														// return = registro
						idconcepto = Integer.parseInt(registro[0]);

						String sql10 = "select nombre, saldo_deudor, saldo_acreedor from sub_conceptos where id_concepto = "
								+ Integer.parseInt(registro[0]) + " ";
						stm = conn.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_UPDATABLE);
						ResultSet rst4 = stm.executeQuery(sql10);// nombre
																	// subconceptos
																	// cuentas

						// ciclo 4
						while (rst4.next()) {
							registro[0] = rst4.getString(1); // nombre
																// subconcepto
							registro[1] = rst4.getDouble(2) + ""; // saldo_deudor
							registro[2] = rst4.getDouble(3) + ""; // saldo_acreedor
							nsubconcepto = registro[0];

							nuevor[0] = nsubconcepto;
							nuevor[1] = (Double.parseDouble(registro[1]) + Double
									.parseDouble(registro[2])) + "";
							nuevor[2] = "";
							nuevor[3] = "";

							dtm7.insertRow(dtm7.getRowCount(), nuevor);

						}// fin ciclo 4
					}
				}
			}

			conn.close();
			stm.close();
			rst.close();

			jTextField35.setText(sutilidad_ai + "");
			sql = "call capital_social(\"" + id_catalogo + "\",?);";
			//
			conn = obc.Conectar(bd, url, server, puerto, user, pass);
			registro = new String[1];
			ejecutar_procedimiento2(sql);
			jTextField36.setText(registro[0]);

			// JOptionPane.showMessageDialog(this,
			// "Balance general realizado con exito", "Mensaje",
			// JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem9ActionPerformed
		// TODO add your handling code here:
		// libro mayor
		try {
			if (libro_mayor.isIcon()) {
				libro_mayor.setIcon(false);
			} else if (libro_mayor.isVisible()) {
				libro_mayor.setIcon(true);
			}
		} catch (PropertyVetoException ex) {
			Logger.getLogger(Swc.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		if (id_catalogo != -1) {
			libro_mayor.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this,
					"No has abierto ningun catalogo", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_jMenuItem9ActionPerformed

	private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTable6MouseClicked
		// TODO add your handling code here:

		if (evt.getButton() == 3) {
			buscaro.show(jTable6, evt.getX(), evt.getY());
		}
	}// GEN-LAST:event_jTable6MouseClicked

	private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton31ActionPerformed
		// TODO add your handling code here:

		// nueva empresa

		try {
			if (nueva_empresa.isIcon()) {
				nueva_empresa.setIcon(false);
			} else if (nueva_empresa.isVisible()) {
				nueva_empresa.setIcon(true);
			}
		} catch (PropertyVetoException ex) {
			Logger.getLogger(Swc.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		jTable9.setValueAt("", 0, 0);
		jTable9.setValueAt("", 0, 1);
		nueva_empresa.setVisible(true);
	}// GEN-LAST:event_jButton31ActionPerformed

	private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton30ActionPerformed
		if (jTable9.getValueAt(0, 0) != null
				&& jTable9.getValueAt(0, 1) != null) {
			try {
				// TODO add your handling code here:

				// guardar nueva empresa
				String nomemp = jTable9.getValueAt(0, 0).toString();
				String descemp = jTable9.getValueAt(0, 1).toString();

				if (!nomemp.equals("")) {
					sql = "call crear_empresa(\"" + nomemp + "\",\"" + descemp
							+ "\",?);";
					//
					conn = obc.Conectar(bd, url, server, puerto, user, pass);
					registro = new String[1];

					ejecutar_procedimiento(sql);
					int ban = Integer.parseInt(registro[0]);

					if (ban == 1) {
						cargar_empresas();
						JOptionPane.showMessageDialog(this,
								"Se creo satisfactoriamente la empresa <<"
										+ nomemp + " >> en la BD", "Mensaje",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(this,
								"Ya existe la empresa<< "
										+ nomemp + " >> en la BD", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}

					conn.close();
					nueva_empresa.setVisible(false);
				} else
					JOptionPane.showMessageDialog(null,
							"Escribe un nombre para la empresa", "Error",
							JOptionPane.ERROR_MESSAGE);

			} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(Swc.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
	}// GEN-LAST:event_jButton30ActionPerformed

	private void jTextField30ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField30ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField30ActionPerformed

	private void jTextField31ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField31ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField31ActionPerformed

	private void jTextField37ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField37ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField37ActionPerformed

	private void jTextField38ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField38ActionPerformed
		// TODO add your handling code here:
		jButton1.requestFocusInWindow();
	}// GEN-LAST:event_jTextField38ActionPerformed

	private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton34ActionPerformed
		// TODO add your handling code here:
		// actualizar empresas

		cargar_empresas();
	}// GEN-LAST:event_jButton34ActionPerformed

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton6ActionPerformed
		// TODO add your handling code here:
		// abrir empresa
		// significa que no hay empresa abierta
		if (id_empresa == -1) {

			int col = 0;
			int ren = jTable8.getSelectedRow();
			int empresa_selected = -1;

			if (ren != -1) {
				if (jTable8.getModel().getValueAt(ren, col) != null) {
					empresa_selected = Integer.parseInt(jTable8.getModel()
							.getValueAt(ren, col).toString());
					tempresa = " .:: "
							+ jTable8.getModel().getValueAt(ren, 1).toString()
							+ " ::. ";
					titulo_ventanap = mt + tempresa;
					JOptionPane.showMessageDialog(this,
							"Has abierto la empresa: " + tempresa, "Mensaje",
							JOptionPane.INFORMATION_MESSAGE);
					this.setTitle(titulo_ventanap);

					jTextField15.setText(jTable8.getModel().getValueAt(ren, 1)
							.toString());
					jTextField22.setText(jTable8.getModel().getValueAt(ren, 1)
							.toString());
					jTextField28.setText(jTable8.getModel().getValueAt(ren, 1)
							.toString());
				}
			} else {
				JOptionPane.showMessageDialog(this,
						"No has seleccionado ninguna empresa", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			id_empresa = empresa_selected;
		} else {
			JOptionPane.showMessageDialog(this,
					"Debes cerrar la empresa abierta " + tempresa
							+ " antes de abrir una nueva", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_jButton6ActionPerformed

	private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton32ActionPerformed
		// TODO add your handling code here:
		// borrar empresa
		int option = JOptionPane.showConfirmDialog(null,
				"Estas seguro de borrar la empresa?", "Mensaje",
				JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			int col = 0;
			int ren = jTable8.getSelectedRow();

			try {
				// TODO add your handling code here:

				if (ren != -1) {
					// borrar nueva empresa
					if (jTable8.getValueAt(ren, col) != null) {
						int num_emp = Integer.parseInt(jTable8.getValueAt(ren,
								col).toString());
						String nomemp = jTable8.getValueAt(ren, 1).toString();

						sql = "call borrar_empresa(" + num_emp + ",?);";
						//
						conn = obc
								.Conectar(bd, url, server, puerto, user, pass);
						registro = new String[1];

						ejecutar_procedimiento(sql);
						int ban = Integer.parseInt(registro[0]);

						if (ban == 1) {
							id_empresa = -1;
							id_catalogo = -1;
							tempresa = "";
							tcatalogo = "";
							titulo_ventanap = mt + tempresa + tcatalogo;
							this.setTitle(titulo_ventanap);
							administrar_catalogos.setVisible(false);
							catalogo.setVisible(false);
							libro_diario.setVisible(false);
							libro_mayor.setVisible(false);
							edo_res.setVisible(false);
							balance_general.setVisible(false);
							balance_inicial.setVisible(false);
							operaciones_diario.setVisible(false);
							JOptionPane.showMessageDialog(this,
									"Se borro satisfactoriamente la empresa <<"
											+ nomemp + " >> de la BD",
									"Mensaje", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(this,
									"No se borro satisfactoriamente la empresa <<"
											+ nomemp + " >> de la BD", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}

						conn.close();
						cargar_empresas();
						nueva_empresa.setVisible(false);
					}

				} else {
					JOptionPane.showMessageDialog(this,
							"No has seleccionado ninguna empresa", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(Swc.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}

	}// GEN-LAST:event_jButton32ActionPerformed

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem2ActionPerformed
		// TODO add your handling code here:
		// cerrar empresa

		id_empresa = -1;
		id_catalogo = -1;
		JOptionPane.showMessageDialog(this, "Has cerrado la empresa: "
				+ tempresa + ", y el catalogo de cuentas: " + tcatalogo,
				"Mensaje", JOptionPane.INFORMATION_MESSAGE);
		tempresa = "";
		tcatalogo = "";
		titulo_ventanap = mt + tempresa + tcatalogo;
		this.setTitle(titulo_ventanap);
		administrar_catalogos.setVisible(false);
		administrar_empresa.setVisible(false);
		catalogo.setVisible(false);
		libro_diario.setVisible(false);
		libro_mayor.setVisible(false);
		edo_res.setVisible(false);
		balance_general.setVisible(false);
		balance_inicial.setVisible(false);
		operaciones_diario.setVisible(false);
	}// GEN-LAST:event_jMenuItem2ActionPerformed

	private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton35ActionPerformed
		// TODO add your handling code here:
		// modificar catalogo de cuentas

		if (jTable10.getValueAt(0, 0) != null
				&& jTable10.getValueAt(0, 1) != null) {
			try {
				// TODO add your handling code here:

				// modificar empresa
				String nomemp = jTable10.getValueAt(0, 0).toString();
				String descemp = jTable10.getValueAt(0, 1).toString();

				sql = "call modificar_empresa(\"" + id_empresamod + "\",\""
						+ nomemp + "\",\"" + descemp + "\",?);";

				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				int ban = Integer.parseInt(registro[0]);

				switch (ban) {
				case 1:
					JOptionPane.showMessageDialog(this,
							"Se modifico satisfactoriamente la empresa: <<"
									+ nomemp + " >> en la BD", "Mensaje",
							JOptionPane.INFORMATION_MESSAGE);
					if (id_empresa != -1) {
						tempresa = " .:: " + nomemp + " ::. ";
						titulo_ventanap = mt + tempresa;
						this.setTitle(titulo_ventanap);
					}
					break;
				case -1:
					JOptionPane.showMessageDialog(this,
							"No existe la empresa a modificar <<" + nomemp
									+ " >> en la BD", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					break;
				case -2:
					JOptionPane.showMessageDialog(this,
							"Ya existe ese nombre de empresa <<" + nomemp
									+ " >> en la BD", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					break;
				case -3:
					JOptionPane.showMessageDialog(this,
							"Se actualizo en nombre de la empresa : <<"
									+ nomemp + ">> satisfactoriamente",
							"Mensaje", JOptionPane.INFORMATION_MESSAGE);
					if (id_empresa != -1) {
						tempresa = " .:: " + nomemp + " ::. ";
						titulo_ventanap = mt + tempresa;
						this.setTitle(titulo_ventanap);
					}
					break;
				case -4:
					JOptionPane.showMessageDialog(this,
							"Se actualizo la descripcion la empresa : <<"
									+ descemp + ">> satisfactoriamente",
							"Mensaje", JOptionPane.INFORMATION_MESSAGE);
					break;
				case -5:
					JOptionPane
							.showMessageDialog(
									this,
									"No se realizaron modificaciones a los datos de la empresa ",
									"Mensaje", JOptionPane.INFORMATION_MESSAGE);
					break;
				}

				conn.close();
				cargar_empresas();
				modificar_empresa.setVisible(false);

			} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(Swc.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}

	}// GEN-LAST:event_jButton35ActionPerformed

	private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton33ActionPerformed
		// TODO add your handling code here:
		// modificar empresa
		int col = 0;
		int ren = jTable8.getSelectedRow();

		if (ren != -1) {
			if (jTable8.getValueAt(ren, col) != null) {
				id_empresamod = Integer.parseInt(jTable8.getValueAt(ren, col)
						.toString());
				jTable10.setValueAt("", 0, 0);
				jTable10.setValueAt("", 0, 1);
				modificar_empresa.setVisible(true);
			}
		} else {
			JOptionPane.showMessageDialog(this,
					"No has seleccionado ninguna empresa", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_jButton33ActionPerformed

	private void cargar_mayor() {
		// combo 6
		sql = "select nombre from conceptos where id_catalogo = " + id_catalogo
				+ " order by nombre;";
		registro = new String[1];

		conn = obc.Conectar(bd, url, server, puerto, user, pass);

		try {
			Statement stm = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rst = stm.executeQuery(sql);
			cargando_mayor = true;
			jComboBox6.removeAllItems();

			while (rst.next()) {
				registro[0] = rst.getString(1); // nombre

				jComboBox6.addItem(registro[0]);
			}

			conn.close();
			rst.close();
			stm.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		cargando_mayor = false;
	}

	private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton36ActionPerformed
		// TODO add your handling code here:
		// abrir catalogo

		// significa que no hay catalogos abiertos
		if (id_catalogo == -1) {
			int col = 0;
			int ren = jTable11.getSelectedRow();
			int catalogo_selected = -1;

			if (ren != -1) {
				if (jTable11.getModel().getValueAt(ren, col) != null
						&& jTable11.getModel().getValueAt(ren, 1) != null) {
					catalogo_selected = Integer.parseInt(jTable11.getModel()
							.getValueAt(ren, col).toString());
					id_catalogo = catalogo_selected;
					reiniciar();
					cargar_subconceptos();
					cargar_combo_cuentas();
					cargar_mayor();

					tcatalogo = " .:: "
							+ jTable11.getModel().getValueAt(ren, 1).toString()
							+ " ::. ";
					titulo_ventanap = mt + tempresa + tcatalogo;
					JOptionPane.showMessageDialog(this,
							"Has abierto el catalogo: " + tcatalogo, "Mensaje",
							JOptionPane.INFORMATION_MESSAGE);
					this.setTitle(titulo_ventanap);
					jTextField48.setText(jTable11.getModel().getValueAt(ren, 3)
							.toString());// balance general
					jTextField16.setText(jTable11.getModel().getValueAt(ren, 3)
							.toString());// balance inicial
					jTextField23.setText(jTable11.getModel().getValueAt(ren, 3)
							.toString());// edo resultados
				}

			} else {
				JOptionPane.showMessageDialog(this,
						"No has seleccionado ningun catalogo", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			id_catalogo = catalogo_selected;

		} else {
			JOptionPane.showMessageDialog(this,
					"Debes cerrar el catalogo de cuentas abierto" + tcatalogo
							+ " antes de abrir uno nuevo", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_jButton36ActionPerformed

	private void cargar_combo_cuentas() {

		sql = "select nombre from cuentas where id_catalogo = " + id_catalogo
				+ ";";
		registro = new String[1];
		String registro2[] = new String[1];

		conn = obc.Conectar(bd, url, server, puerto, user, pass);

		try {
			Statement stm = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rst = stm.executeQuery(sql);
			jComboBox1.removeAllItems();
			jComboBox2.removeAllItems();

			while (rst.next()) {
				registro[0] = rst.getString(1); // nombre
				registro2[0] = registro[0];

				jComboBox1.addItem(registro[0]);
				jComboBox2.addItem(registro2[0]);
			}

			conn.close();
			rst.close();
			stm.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton37ActionPerformed
		// TODO add your handling code here:
		// nuevo catalogo

		try {
			if (nuevo_catalogo.isIcon()) {
				nuevo_catalogo.setIcon(false);
			} else if (nuevo_catalogo.isVisible()) {
				nuevo_catalogo.setIcon(true);
			}
		} catch (PropertyVetoException ex) {
			Logger.getLogger(Swc.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		jTable12.setValueAt("", 0, 0);
		jTable12.setValueAt(id_empresa, 0, 1);
		nuevo_catalogo.setVisible(true);
	}// GEN-LAST:event_jButton37ActionPerformed

	private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton38ActionPerformed
		// TODO add your handling code here:
		// borrar catalogo

		int option = JOptionPane.showConfirmDialog(null,
				"Estas seguro de borrar el catalogo de cuentas?", "Mensaje",
				JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			int col = 0;
			int ren = jTable11.getSelectedRow();

			try {
				// TODO add your handling code here:

				if (ren != -1) {
					// borrar catalogo de cuentas
					if (jTable11.getValueAt(ren, col) != null
							&& jTable11.getValueAt(ren, 1) != null) {
						int num_cat = Integer.parseInt(jTable11.getValueAt(ren,
								col).toString());
						String nom_cat = jTable11.getValueAt(ren, 1).toString();

						sql = "call borrar_catalogo(" + num_cat + ","
								+ id_empresa + ",?);";

						conn = obc
								.Conectar(bd, url, server, puerto, user, pass);
						registro = new String[1];

						ejecutar_procedimiento(sql);
						int ban = Integer.parseInt(registro[0]);

						if (ban == 1) {
							id_catalogo = -1;
							tcatalogo = "";
							titulo_ventanap = mt + tempresa + tcatalogo;
							this.setTitle(titulo_ventanap);
							administrar_empresa.setVisible(false);
							catalogo.setVisible(false);
							libro_diario.setVisible(false);
							libro_mayor.setVisible(false);
							edo_res.setVisible(false);
							balance_general.setVisible(false);
							balance_inicial.setVisible(false);
							operaciones_diario.setVisible(false);
							JOptionPane.showMessageDialog(this,
									"Se borro satisfactoriamente el catalogo de cuentas <<"
											+ nom_cat + " >> de la BD",
									"Mensaje", JOptionPane.INFORMATION_MESSAGE);
						} else if (ban == -1) {
							JOptionPane.showMessageDialog(this,
									"No se borro satisfactoriamente el catalogo de cuentas <<"
											+ nom_cat + " >> de la BD",
									"ERROR", JOptionPane.ERROR_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(this,
									"No existe la empresa: <<" + tempresa
											+ " >> de la BD", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}

						conn.close();
						cargar_catalogos();
						nuevo_catalogo.setVisible(false);
					}

				} else {
					JOptionPane.showMessageDialog(this,
							"No has seleccionado ningun catalogo", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(Swc.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}

	}// GEN-LAST:event_jButton38ActionPerformed

	private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton39ActionPerformed
		// TODO add your handling code here:
		// modificar catalogo
		int col = 0;
		int ren = jTable11.getSelectedRow();

		if (ren != -1) {
			if (jTable11.getValueAt(ren, col) != null) {
				id_catalogomod = Integer.parseInt(jTable11.getValueAt(ren, col)
						.toString());
				jTable13.setValueAt("", 0, 0);
				modificar_catalogos.setVisible(true);
			}
		} else {
			JOptionPane.showMessageDialog(this, "No has seleccionado catalogo",
					"Error", JOptionPane.ERROR_MESSAGE);
		}

	}// GEN-LAST:event_jButton39ActionPerformed

	private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton40ActionPerformed
		// TODO add your handling code here:
		// actualizar catalogos
		cargar_catalogos();
	}// GEN-LAST:event_jButton40ActionPerformed

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem1ActionPerformed
		// TODO add your handling code here:
		// admon catalogos
		try {
			if (administrar_catalogos.isIcon()) {
				administrar_catalogos.setIcon(false);
			} else if (administrar_catalogos.isVisible()) {
				administrar_catalogos.setIcon(true);
			}
		} catch (PropertyVetoException ex) {
			Logger.getLogger(Swc.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		if (id_empresa != -1) {
			cargar_catalogos();
			administrar_catalogos.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this,
					"No has abierto ninguna empresa", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_jMenuItem1ActionPerformed

	private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem5ActionPerformed
		// TODO add your handling code here:
		// cerrar catalogo
		id_catalogo = -1;
		JOptionPane.showMessageDialog(this,
				"Has cerrado el catalogo de cuentas: " + tcatalogo, "Mensaje",
				JOptionPane.INFORMATION_MESSAGE);
		tcatalogo = "";
		titulo_ventanap = mt + tempresa + tcatalogo;
		this.setTitle(titulo_ventanap);
		administrar_catalogos.setVisible(false);
		administrar_empresa.setVisible(false);
		catalogo.setVisible(false);
		libro_diario.setVisible(false);
		libro_mayor.setVisible(false);
		edo_res.setVisible(false);
		balance_general.setVisible(false);
		balance_inicial.setVisible(false);
		operaciones_diario.setVisible(false);

	}// GEN-LAST:event_jMenuItem5ActionPerformed

	private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton41ActionPerformed
		// TODO add your handling code here:
		// guardar nuevo catalogo de cuentas
		if (jTable12.getValueAt(0, 0) != null) {
			try {
				// TODO add your handling code here:

				// guardar nueva empresa

				String nomcat = jTable12.getValueAt(0, 0).toString();

				if(!nomcat.equals("")){
									sql = "call crear_catalogo(\"" + nomcat + "\",\"" + id_empresa
						+ "\",?);";

				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				int ban = Integer.parseInt(registro[0]);

				if (ban == -1) {
					JOptionPane.showMessageDialog(this,
							"Ya existe el catalogo de cuentas " + nomcat + ": <<"
									+ nomcat + " >> en la BD", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else if (ban == -2) {
					JOptionPane.showMessageDialog(this,
							"No existe la empresa: <<" + tempresa
									+ " >> en la BD", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					sql = "call cargar_cuentas(" + ban + ",?)";
					ejecutar_procedimiento(sql);

					sql = "call cargar_subcuentas(" + ban + ",?)";
					ejecutar_procedimiento(sql);

					sql = "call cargar_conceptos(" + ban + ",?)";
					ejecutar_procedimiento(sql);
					cargar_catalogos();

					JOptionPane.showMessageDialog(this,
							"Se creo satisfactoriamente el catalogo de cuentas: <<"
									+ nomcat + " >> en la BD", "Mensaje",
							JOptionPane.INFORMATION_MESSAGE);
				}

				conn.close();

				nuevo_catalogo.setVisible(false);
				}

			} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(Swc.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}

	}// GEN-LAST:event_jButton41ActionPerformed

	private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton42ActionPerformed
		// TODO add your handling code here:
		// modificar catalogos

		try {
			// TODO add your handling code here:
			if (jTable13.getValueAt(0, 0) != null) {
				String nomcat = jTable13.getValueAt(0, 0).toString();
				sql = "call modificar_catalogo(\"" + id_empresa + "\",\""
						+ id_catalogomod + "\",\"" + nomcat + "\",?);";

				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				int ban = Integer.parseInt(registro[0]);

				switch (ban) {
				case 1:
					JOptionPane.showMessageDialog(this,
							"Se modifico satisfactoriamente el catalogo de cuentas <<"
									+ nomcat + " >> de la BD", "Mensaje",
							JOptionPane.INFORMATION_MESSAGE);
					if (id_catalogo != -1) {
						tcatalogo = " .:: " + nomcat + " ::. ";
						titulo_ventanap = mt + tempresa + tcatalogo;
						this.setTitle(titulo_ventanap);
					}
					break;
				case -1:
					JOptionPane.showMessageDialog(this,
							"Error, no existe la empresa a modificar <<"
									+ nomcat + " >> en la BD", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					break;
				case -2:
					JOptionPane.showMessageDialog(this,
							"Ya existe ese nombre del catalogo de cuentas <<"
									+ nomcat + " >> en la BD", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					break;
				case -3:
					JOptionPane.showMessageDialog(this,
							"No se realizaron modificaciones al catalogo de cuentas<<"
									+ nomcat + " >> en la BD", "ERROR",
							JOptionPane.INFORMATION_MESSAGE);
					break;
				}

				conn.close();
				cargar_catalogos();
				modificar_catalogos.setVisible(false);
			} else
				JOptionPane.showMessageDialog(null,
						"No seleccionaste nada de la tabla", "Error",
						JOptionPane.ERROR_MESSAGE);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			Logger.getLogger(Swc.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}// GEN-LAST:event_jButton42ActionPerformed

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox1ActionPerformed
		// TODO add your handling code here:

		// combo box 1

		tipo_operacion = 1;

		if (jComboBox1.getSelectedItem() != null) {
			nom_cuenta_combo1 = jComboBox1.getSelectedItem().toString();

			try {

				sql = "call obtener_idcuenta(\"" + nom_cuenta_combo1 + "\",\""
						+ id_catalogo + "\",?);";

				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				int ban = Integer.parseInt(registro[0]);
				id_cuenta_combo = ban;

				sql = "select nombre from sub_cuentas where id_cuenta = "
						+ id_cuenta_combo + " ;";
				registro = new String[1];

				Statement stm = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet rst = stm.executeQuery(sql);
				jComboBox7.removeAllItems();

				while (rst.next()) {
					registro[0] = rst.getString(1); // nombre

					// aux.addItem(registro[0]);
					jComboBox7.addItem(registro[0]);
				}

				conn.close();
				stm.close();
				rst.close();

				jTextField7.setText("0.0");

			} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(Swc.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}

	}// GEN-LAST:event_jComboBox1ActionPerformed

	private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox7ActionPerformed
		// TODO add your handling code here:
		// combo subcuenta

		tipo_operacion = 1;

		if (jComboBox7.getSelectedItem() != null) {
			nom_subcuenta_combo = jComboBox7.getSelectedItem().toString();

			try {

				sql = "call obtener_idsubcuenta(\"" + nom_subcuenta_combo
						+ "\",\"" + id_cuenta_combo + "\",?);";

				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				int ban = Integer.parseInt(registro[0]);
				id_subcuenta_combo = ban;

				sql = "select nombre from conceptos where id_subcuenta = "
						+ id_subcuenta_combo + " ;";
				registro = new String[1];

				Statement stm = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet rst = stm.executeQuery(sql);
				jComboBox8.removeAllItems();

				while (rst.next()) {
					registro[0] = rst.getString(1); // nombre

					jComboBox8.addItem(registro[0]);
				}

				conn.close();
				stm.close();
				rst.close();

				jTextField7.setText("0.0");

			} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(Swc.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}

	}// GEN-LAST:event_jComboBox7ActionPerformed

	private void cargar_simple_cargo() {
		// combo conceptos

		tipo_operacion = 1;

		if (jComboBox8.getSelectedItem() != null) {
			nom_concepto_combo = jComboBox8.getSelectedItem().toString();

			try {

				sql = "call obtener_idconcepto(\"" + nom_concepto_combo
						+ "\",\"" + id_subcuenta_combo + "\",?);";

				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				int ban = Integer.parseInt(registro[0]);
				id_concepto_combo = ban;

				sql = "select nombre from sub_conceptos where id_concepto = "
						+ id_concepto_combo + " ;";
				registro = new String[1];

				Statement stm = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet rst = stm.executeQuery(sql);
				jComboBox4.removeAllItems();
				jComboBox11.removeAllItems();
				String nuevo_reg[] = new String[1];

				while (rst.next()) {
					registro[0] = rst.getString(1); // nombre
					nuevo_reg[0] = registro[0];

					jComboBox4.addItem(registro[0]);
					jComboBox11.addItem(nuevo_reg[0]);
				}

				conn.close();
				stm.close();
				rst.close();

				// jTextField7.setText("0.0");

			} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(Swc.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
	}

	private void jComboBox8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox8ActionPerformed
		// TODO add your handling code here:
		cargar_simple_cargo();
		jTextField7.setText("0.0");
	}// GEN-LAST:event_jComboBox8ActionPerformed

	private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox4ActionPerformed
		// TODO add your handling code here:
		// combo sub concepto

		if (jComboBox4.getSelectedItem() != null) {

			if (tipo_operacion == 1) {
				nom_subconcepto_combo = jComboBox4.getSelectedItem().toString();

				sql = "call obtener_idsubconcepto(\"" + nom_subconcepto_combo
						+ "\",\"" + id_concepto_combo + "\",?);";

				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				int ban = Integer.parseInt(registro[0]);
				id_subconcepto_combo = ban;

				jTextField9.setText("0.0");
			}

			if (tipo_operacion == 2) {
				nom_subconcepto_combo2 = jComboBox4.getSelectedItem()
						.toString();

				sql = "call obtener_idsubconcepto(\"" + nom_subconcepto_combo2
						+ "\",\"" + id_concepto_combo2 + "\",?);";

				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				int ban = Integer.parseInt(registro[0]);
				id_subconcepto_combo2 = ban;

				// jTextField7.setText("0.0");
				jTextField9.setText("0.0");
			}

		}
	}// GEN-LAST:event_jComboBox4ActionPerformed

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton7ActionPerformed
		// TODO add your handling code here:

		// cargar concepto

		tipo_opera = "cargo";
		int numoper = Integer.parseInt(jTextField13.getText());
		double saldo = Double.parseDouble(jTextField7.getText());
		bvar = new BigDecimal(saldo);

		sql = "call inserta_diario(\"" + numoper + "\",\"" + nom_concepto_combo
				+ "\",\"" + bvar + "\",\"" + tipo_opera + "\",\"" + id_catalogo
				+ "\",?);";

		conn = obc.Conectar(bd, url, server, puerto, user, pass);
		registro = new String[1];

		ejecutar_procedimiento(sql);
		int ban = Integer.parseInt(registro[0]);

		if (ban == 1) {
			JOptionPane.showMessageDialog(this,
					"Se realizo la operacion de diario satisfactoriamente: "
							+ nom_concepto_combo, "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
		}

		// actualizar concpetos

		tipo_opera = "cargo";
		tipo_operacion = 1;

		sql = "call actualizar_conceptos(\"" + id_concepto_combo + "\",\""
				+ saldo + "\",\"" + tipo_operacion + "\",?);";

		conn = obc.Conectar(bd, url, server, puerto, user, pass);
		registro = new String[1];

		ejecutar_procedimiento(sql);
		ban = Integer.parseInt(registro[0]);

		if (ban == 1) {
			JOptionPane.showMessageDialog(this,
					"Se realizo la operacion de cargo satisfactoriamente: "
							+ nom_concepto_combo, "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this,
					"Se realizo la operacion de abono satisfactoriamente: "
							+ nom_concepto_combo, "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
		}

		// actualizar sub cuentas

		tipo_opera = "cargo";

		sql = "call actualizar_subcuentas(\"" + id_subcuenta_combo + "\",\""
				+ saldo + "\",\"" + tipo_operacion + "\",?);";

		conn = obc.Conectar(bd, url, server, puerto, user, pass);
		registro = new String[1];

		ejecutar_procedimiento(sql);
		ban = Integer.parseInt(registro[0]);

		if (ban == 1) {
			JOptionPane.showMessageDialog(this,
					"Se realizo la operacion de cargo satisfactoriamente: "
							+ nom_subcuenta_combo, "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this,
					"Se realizo la operacion de abono satisfactoriamente: "
							+ nom_subcuenta_combo, "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
		}

		// actualizar cuentas

		tipo_opera = "cargo";

		sql = "call actualizar_cuentas(\"" + id_cuenta_combo + "\",\"" + bvar
				+ "\",\"" + tipo_operacion + "\",?);";

		conn = obc.Conectar(bd, url, server, puerto, user, pass);
		registro = new String[1];

		ejecutar_procedimiento(sql);
		ban = Integer.parseInt(registro[0]);

		if (ban == 1) {
			JOptionPane.showMessageDialog(this,
					"Se realizo la operacion de cargo satisfactoriamente: "
							+ nom_cuenta_combo1, "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this,
					"Se realizo la operacion de abono satisfactoriamente: "
							+ nom_cuenta_combo1, "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
		}

		jTextField7.setText("0.0");
	}// GEN-LAST:event_jButton7ActionPerformed

	private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox2ActionPerformed
		// TODO add your handling code here:

		// combo box 2

		tipo_operacion = 2;

		if (jComboBox2.getSelectedItem() != null) {
			nom_cuenta_combo2 = jComboBox2.getSelectedItem().toString();

			try {

				sql = "call obtener_idcuenta(\"" + nom_cuenta_combo2 + "\",\""
						+ id_catalogo + "\",?);";

				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				int ban = Integer.parseInt(registro[0]);
				id_cuenta_combo2 = ban;

				sql = "select nombre from sub_cuentas where id_cuenta = "
						+ id_cuenta_combo2 + " ;";
				registro = new String[1];

				Statement stm = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet rst = stm.executeQuery(sql);
				jComboBox9.removeAllItems();

				while (rst.next()) {
					registro[0] = rst.getString(1); // nombre

					// aux.addItem(registro[0]);
					jComboBox9.addItem(registro[0]);
				}

				conn.close();
				stm.close();
				rst.close();

				jTextField8.setText("0.0");

			} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(Swc.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}

	}// GEN-LAST:event_jComboBox2ActionPerformed

	private void jComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox9ActionPerformed
		// TODO add your handling code here:

		// combo subcuenta

		tipo_operacion = 2;

		if (jComboBox9.getSelectedItem() != null) {
			nom_subcuenta_combo2 = jComboBox9.getSelectedItem().toString();

			try {

				sql = "call obtener_idsubcuenta(\"" + nom_subcuenta_combo2
						+ "\",\"" + id_cuenta_combo2 + "\",?);";

				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				int ban = Integer.parseInt(registro[0]);
				id_subcuenta_combo2 = ban;

				sql = "select nombre from conceptos where id_subcuenta = "
						+ id_subcuenta_combo2 + " ;";
				registro = new String[1];

				Statement stm = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet rst = stm.executeQuery(sql);
				jComboBox10.removeAllItems();

				while (rst.next()) {
					registro[0] = rst.getString(1); // nombre

					jComboBox10.addItem(registro[0]);
				}

				conn.close();
				stm.close();
				rst.close();

				jTextField8.setText("0.0");

			} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(Swc.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
	}// GEN-LAST:event_jComboBox9ActionPerformed

	private void cargar_simple_abono() {
		// combo conceptos

		tipo_operacion = 2;

		if (jComboBox10.getSelectedItem() != null) {
			nom_concepto_combo2 = jComboBox10.getSelectedItem().toString();

			try {

				sql = "call obtener_idconcepto(\"" + nom_concepto_combo2
						+ "\",\"" + id_subcuenta_combo2 + "\",?);";

				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				int ban = Integer.parseInt(registro[0]);
				id_concepto_combo2 = ban;

				sql = "select nombre from sub_conceptos where id_concepto = "
						+ id_concepto_combo2 + " ;";
				registro = new String[1];

				Statement stm = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet rst = stm.executeQuery(sql);
				jComboBox4.removeAllItems();

				while (rst.next()) {
					registro[0] = rst.getString(1); // nombre

					jComboBox4.addItem(registro[0]);
				}

				conn.close();
				stm.close();
				rst.close();

				// jTextField8.setText("0.0");

			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(Swc.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
	}

	private void jComboBox10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox10ActionPerformed
		// TODO add your handling code here:
		cargar_simple_abono();
		jTextField8.setText("0.0");
	}// GEN-LAST:event_jComboBox10ActionPerformed

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton8ActionPerformed
		// TODO add your handling code here:
		// BOTON ABONAR

		// cargar concepto

		tipo_opera = "abono";
		int numoper = Integer.parseInt(jTextField5.getText());
		double saldo = Double.parseDouble(jTextField8.getText());
		bvar = new BigDecimal(saldo);

		sql = "call inserta_diario(\"" + numoper + "\",\""
				+ nom_concepto_combo2 + "\",\"" + bvar + "\",\"" + tipo_opera
				+ "\",\"" + id_catalogo + "\",?);";

		conn = obc.Conectar(bd, url, server, puerto, user, pass);
		registro = new String[1];

		ejecutar_procedimiento(sql);
		int ban = Integer.parseInt(registro[0]);

		if (ban == 1) {
			JOptionPane.showMessageDialog(this,
					"Se realizo la operacion de diario satisfactoriamente: "
							+ nom_concepto_combo2, "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
		}

		// actualizar concpetos

		tipo_opera = "abono";
		tipo_operacion = 2;

		sql = "call actualizar_conceptos(\"" + id_concepto_combo2 + "\",\""
				+ bvar + "\",\"" + tipo_operacion + "\",?);";

		conn = obc.Conectar(bd, url, server, puerto, user, pass);
		registro = new String[1];

		ejecutar_procedimiento(sql);
		ban = Integer.parseInt(registro[0]);

		if (ban == 1) {
			JOptionPane.showMessageDialog(this,
					"Se realizo la operacion de cargo satisfactoriamente: "
							+ nom_concepto_combo2, "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this,
					"Se realizo la operacion de abono satisfactoriamente: "
							+ nom_concepto_combo2, "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
		}

		// actualizar sub cuentas

		tipo_opera = "abono";

		sql = "call actualizar_subcuentas(\"" + id_subcuenta_combo2 + "\",\""
				+ bvar + "\",\"" + tipo_operacion + "\",?);";

		conn = obc.Conectar(bd, url, server, puerto, user, pass);
		registro = new String[1];

		ejecutar_procedimiento(sql);
		ban = Integer.parseInt(registro[0]);

		if (ban == 1) {
			JOptionPane.showMessageDialog(this,
					"Se realizo la operacion de cargo satisfactoriamente: "
							+ nom_subcuenta_combo2, "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this,
					"Se realizo la operacion de abono satisfactoriamente: "
							+ nom_subcuenta_combo2, "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
		}

		// actualizar cuentas

		tipo_opera = "abono";

		sql = "call actualizar_cuentas(\"" + id_cuenta_combo2 + "\",\"" + bvar
				+ "\",\"" + tipo_operacion + "\",?);";

		conn = obc.Conectar(bd, url, server, puerto, user, pass);
		registro = new String[1];

		ejecutar_procedimiento(sql);
		ban = Integer.parseInt(registro[0]);

		if (ban == 1) {
			JOptionPane.showMessageDialog(this,
					"Se realizo la operacion de cargo satisfactoriamente: "
							+ nom_cuenta_combo2, "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this,
					"Se realizo la operacion de abono satisfactoriamente: "
							+ nom_cuenta_combo2, "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
		}

		if (jComboBox10.getSelectedItem().equals("Capital Contable")) {

			sql = "call guardar_balance_inicial(\""
					+ Double.parseDouble(jTextField8.getText()) + "\",\""
					+ id_catalogo + "\",?);";

			conn = obc.Conectar(bd, url, server, puerto, user, pass);
			registro = new String[1];

			ejecutar_procedimiento(sql);
			ban = Integer.parseInt(registro[0]);

			if (ban == 1) {
				JOptionPane.showMessageDialog(this,
						"Se guardo el balance inicial correctamente ",
						"Mensaje", JOptionPane.INFORMATION_MESSAGE);
			}
		}

		jTextField8.setText("0.0");
		jTextField9.setText("0.0");
	}// GEN-LAST:event_jButton8ActionPerformed

	private void borrar_tmayor() {

		jTable6.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"No. de operacion", "Debe", "Haber", "Fecha creacion" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class };

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
	}

	private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox6ActionPerformed
		// TODO add your handling code here:

		// LIBRO MAYOR, tabla 6, combo 6
		if (jComboBox6.getSelectedItem() != null && cargando_mayor == false) {
			String concepto_buscar = jComboBox6.getSelectedItem().toString(), tipo_operacion;
			conn = obc.Conectar(bd, url, server, puerto, user, pass);
			String registron[] = new String[4];
			sql = "select num_operacion,saldo,tipo_operacion,fecha from diario where id_catalogo = "
					+ id_catalogo
					+ " and concepto like \""
					+ concepto_buscar
					+ "\";";
			String nuevo_registro[] = new String[4];

			borrar_tmayor();
			DefaultTableModel model = (DefaultTableModel) jTable6.getModel();

			try {
				Statement stm = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet rst = stm.executeQuery(sql);

				while (rst.next()) {
					registron[0] = rst.getInt(1) + ""; // num operacion
					registron[1] = rst.getDouble(2) + ""; // saldo
					registron[2] = rst.getString(3); // tipo operacion
					registron[3] = rst.getString(4); // fecha

					tipo_operacion = registron[2];

					nuevo_registro[0] = registron[0];

					nuevo_registro[3] = registron[3];

					if (tipo_operacion.equalsIgnoreCase("cargo")) {
						nuevo_registro[1] = registron[1];
						nuevo_registro[2] = "0.0";

					} else if (tipo_operacion.equalsIgnoreCase("abono")) {
						nuevo_registro[2] = registron[1];
						nuevo_registro[1] = "0.0";
					}

					model.insertRow(model.getRowCount(), nuevo_registro);
				}

				conn.close();
				rst.close();
				stm.close();

			} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}

			// calculos

			double md = 0.0, ma = 0.0, sd = 0.0, sa = 0.0;

			for (int ind = 0; ind < jTable6.getRowCount(); ind++) {
				md += Double.parseDouble(jTable6.getValueAt(ind, 1).toString());
				ma += Double.parseDouble(jTable6.getValueAt(ind, 2).toString());
			}

			BigDecimal bma = new BigDecimal(ma);
			BigDecimal bmd = new BigDecimal(md);
			BigDecimal bsa = new BigDecimal(0.0), bsd = new BigDecimal(0.0), saldo = new BigDecimal(
					0.0);

			saldo = bmd.subtract(bma);

			if (saldo.doubleValue() >= 0) {
				bsd = saldo;
			} else {
				bsa = saldo;
			}

			jTextField24.setText(bmd + "");
			jTextField25.setText(bma + "");

			jTextField26.setText(bsd + "");
			jTextField27.setText(bsa + "");
		}

	}// GEN-LAST:event_jComboBox6ActionPerformed

	private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton44ActionPerformed
		// TODO add your handling code here:
		// calcular capital contable

		sql = "call calcular_capital_contable(" + id_catalogo + ",?);";
		conn = obc.Conectar(bd, url, server, puerto, user, pass);
		registro = new String[1];

		ejecutar_procedimiento2(sql);
		double ban = Double.parseDouble(registro[0]);
		bvar = new BigDecimal(ban);

		JOptionPane.showMessageDialog(this,
				"Se realizo el calculo del capital contable satisfactoriamente: $"
						+ ban, "Mensaje", JOptionPane.INFORMATION_MESSAGE);

		jTextField8.setText(bvar + "");

	}// GEN-LAST:event_jButton44ActionPerformed

	private void jComboBox11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox11ActionPerformed
		// TODO add your handling code here:
		// combo sub concepto

		if (jComboBox11.getSelectedItem() != null) {

			if (tipo_operacion == 1) {
				nom_subconcepto_combo3 = jComboBox11.getSelectedItem()
						.toString();

				sql = "call obtener_idsubconcepto(\"" + nom_subconcepto_combo3
						+ "\",\"" + id_concepto_combo + "\",?);";

				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				int ban = Integer.parseInt(registro[0]);
				id_subconcepto_combo3 = ban;

				jTextField9.setText("0.0");
			}
		}
	}// GEN-LAST:event_jComboBox11ActionPerformed

	private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton43ActionPerformed
		// TODO add your handling code here:
		// aceptar cargo

		if (jComboBox11.getSelectedItem() != null) {

			if (tipo_operacion == 1) {

				bvar = new BigDecimal(jTextField39.getText());
				bvar1 = new BigDecimal(jTextField40.getText());

				cantidad = bvar.doubleValue() * bvar1.doubleValue(); // total
				bvar = new BigDecimal(cantidad);

				sql = "call actualizar_subconceptos(\""
						+ nom_subconcepto_combo3 + "\",\""
						+ id_subconcepto_combo3 + "\",\"" + bvar + "\",\""
						+ tipo_operacion + "\",?);";
				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				int ban = Integer.parseInt(registro[0]);

				if (ban == 1) {
					JOptionPane.showMessageDialog(this,
							"Se realizo el cargo satisfactoriamente al sub concepto: "
									+ nom_subconcepto_combo3
									+ ", por la cantidad de: $" + bvar,
							"Mensaje", JOptionPane.INFORMATION_MESSAGE);
				}

				String nombre_art = jComboBox11.getSelectedItem().toString();
				bvar = new BigDecimal(jTextField39.getText());
				bvar1 = new BigDecimal(jTextField40.getText());

				sql = "call actualiza_articulos(\"" + nombre_art + "\",\""
						+ bvar + "\",\"" + bvar1 + "\",\""
						+ id_subconcepto_combo + "\",\""
						+ Integer.parseInt(jTextField46.getText()) + "\",?);";
				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				ban = Integer.parseInt(registro[0]);

				if (ban == 1) {
					JOptionPane.showMessageDialog(this,
							"Se realizo la actualizacion del articulo: "
									+ nombre_art, "Mensaje",
							JOptionPane.INFORMATION_MESSAGE);
				}

				if (tipo_operacion == 1) {
					tipo_opera = "cargo";
				}

				if (tipo_operacion == 2) {
					tipo_opera = "abono";
				}

				// insertar en diario el sub concepto
				cantidad = bvar.doubleValue() * bvar1.doubleValue(); // total
				bvar = new BigDecimal(cantidad);

				sql = "call inserta_diario_subconceptos(\""
						+ jComboBox11.getSelectedItem().toString() + "\",\""
						+ bvar + "\",\"" + tipo_opera + "\",\""
						+ nom_concepto_combo + "\",\""
						+ Integer.parseInt(jTextField13.getText()) + "\",\""
						+ id_catalogo + "\",?);";
				conn = obc.Conectar(bd, url, server, puerto, user, pass);
				registro = new String[1];

				ejecutar_procedimiento(sql);
				ban = Integer.parseInt(registro[0]);

				if (ban == 1) {
					JOptionPane.showMessageDialog(this,
							"Se realizo la operacion de diario satisfactoriamente: "
									+ nom_subconcepto_combo, "Mensaje",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} // fin tipo operacion 1
		}

		if (subt.equals("1")) {

			cantidad = Double.parseDouble(jTextField7.getText())
					+ bvar.doubleValue();
			bvar = new BigDecimal(cantidad);
			jTextField7.setText(bvar + "");
		}

		jTextField39.setText("0");
		jTextField40.setText("0.0");
		agregar_articulo.setVisible(false);

		jButton43.requestFocus(false);
	}// GEN-LAST:event_jButton43ActionPerformed

	private void jTextField39ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField39ActionPerformed
		// TODO add your handling code here:
		jTextField40.requestFocusInWindow();
	}// GEN-LAST:event_jTextField39ActionPerformed

	private void jTextField40ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField40ActionPerformed
		// TODO add your handling code here:
		jTextField46.requestFocusInWindow();
	}// GEN-LAST:event_jTextField40ActionPerformed

	private void jTable14MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTable14MouseClicked
		// TODO add your handling code here:
	}// GEN-LAST:event_jTable14MouseClicked

	private void jTextField45ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField45ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField45ActionPerformed

	private void jTextField46ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField46ActionPerformed
		// TODO add your handling code here:
		jButton43.requestFocusInWindow();
	}// GEN-LAST:event_jTextField46ActionPerformed

	private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem7ActionPerformed
		// TODO add your handling code here:
		restaurar_catalogo();
	}// GEN-LAST:event_jMenuItem7ActionPerformed

	private void jTextField47ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField47ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField47ActionPerformed

	private void cargar_catalogos() {

		sql = "select * from catalogo_de_cuentas where id_empresa = "
				+ id_empresa + ";";

		conn = obc.Conectar(bd, url, server, puerto, user, pass);
		registro = new String[4];

		borrar_tcat();
		DefaultTableModel model = (DefaultTableModel) jTable11.getModel();
		try {
			Statement stm = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rst = stm.executeQuery(sql);

			while (rst.next()) {
				registro[0] = rst.getInt(1) + ""; // id_catalgo
				registro[1] = rst.getString(2); // nombre
				registro[2] = rst.getString(3); // id_empresa
				registro[3] = rst.getString(4);// fecha creaccion
				model.insertRow(model.getRowCount(), registro);
			}

			conn.close();
			rst.close();
			stm.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	private void buscar_operacion() {

		int col = 0;
		int ren = jTable6.getSelectedRow();
		numero_operacion = Integer.parseInt(jTable6.getModel()
				.getValueAt(ren, col).toString());
		nombre_subconcepto = jComboBox6.getSelectedItem().toString();

		jTextField45.setText(nombre_subconcepto);
		llenar_libro_diario(numero_operacion, nombre_subconcepto);
		libro_diario.setVisible(true);
	}

	private void borrar_tdiario() {
		jTable14.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "No. de operacion", "Nombre subconcepto",
						"Debe", "Haber", "Fecha creacion" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class };

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
	}

	private void llenar_libro_diario(int num_op, String nom_subc) {
		// LIBRO diario, tabla 14

		conn = obc.Conectar(bd, url, server, puerto, user, pass);
		String registron[] = new String[8], tipo_operacion;
		sql = "select * from diario_subconceptos where num_operacion = "
				+ num_op + " and nombre_concepto like \"" + nom_subc
				+ "\" and id_catalogo = " + id_catalogo + " ;";
		String nuevo_registro[] = new String[5];

		borrar_tdiario();
		DefaultTableModel model = (DefaultTableModel) jTable14.getModel();

		try {
			Statement stm = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rst = stm.executeQuery(sql);

			while (rst.next()) {
				registron[0] = rst.getInt(1) + ""; // id diarios
				registron[1] = rst.getString(2); // sub_concepto
				registron[2] = rst.getDouble(3) + ""; // saldo
				registron[3] = rst.getString(4); // tipo_operacion
				registron[4] = rst.getString(5); // nombre_concepto
				registron[5] = rst.getInt(6) + ""; // num_operacion
				registron[6] = rst.getInt(7) + ""; // id_catalogo
				registron[7] = rst.getInt(8) + ""; // fecha creacion

				tipo_operacion = registron[3];

				nuevo_registro[0] = registron[0];
				nuevo_registro[1] = registron[1];
				nuevo_registro[4] = registron[7];

				if (tipo_operacion.equalsIgnoreCase("cargo")) {
					nuevo_registro[2] = registron[2];
					nuevo_registro[3] = "0.0";

				} else if (tipo_operacion.equalsIgnoreCase("abono")) {
					nuevo_registro[3] = registron[2];
					nuevo_registro[2] = "0.0";
				}

				model.insertRow(model.getRowCount(), nuevo_registro);
			}

			conn.close();
			rst.close();
			stm.close();

		} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error de MySQL", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		// calculos

		double md = 0.0, ma = 0.0, sd = 0.0, sa = 0.0;

		for (int ind = 0; ind < jTable14.getRowCount(); ind++) {
			md += Double.parseDouble(jTable14.getValueAt(ind, 2).toString());
			ma += Double.parseDouble(jTable14.getValueAt(ind, 3).toString());
		}

		BigDecimal bma = new BigDecimal(ma);
		BigDecimal bmd = new BigDecimal(md);
		BigDecimal bsa = new BigDecimal(0.0), bsd = new BigDecimal(0.0), saldo;

		saldo = bmd.subtract(bma);

		if (saldo.doubleValue() >= 0) {
			bsd = saldo;
		} else {
			bsa = saldo;
		}

		jTextField41.setText(bmd + "");
		jTextField42.setText(bma + "");

		jTextField43.setText(bsd + "");
		jTextField44.setText(bsa + "");
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JInternalFrame acercade;
	private javax.swing.JInternalFrame administrar_catalogos;
	private javax.swing.JInternalFrame administrar_empresa;
	private javax.swing.JInternalFrame agregar_articulo;
	private javax.swing.JInternalFrame agregar_subc;
	private javax.swing.JInternalFrame balance_general;
	private javax.swing.JInternalFrame balance_inicial;
	private javax.swing.JInternalFrame catalogo;
	private javax.swing.JInternalFrame compra;
	private javax.swing.JInternalFrame devoluciones;
	private javax.swing.JInternalFrame edo_res;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton10;
	private javax.swing.JButton jButton11;
	private javax.swing.JButton jButton12;
	private javax.swing.JButton jButton13;
	private javax.swing.JButton jButton14;
	private javax.swing.JButton jButton15;
	private javax.swing.JButton jButton16;
	private javax.swing.JButton jButton17;
	private javax.swing.JButton jButton18;
	private javax.swing.JButton jButton19;
	private javax.swing.JButton jButton20;
	private javax.swing.JButton jButton21;
	private javax.swing.JButton jButton22;
	private javax.swing.JButton jButton23;
	private javax.swing.JButton jButton24;
	private javax.swing.JButton jButton25;
	private javax.swing.JButton jButton26;
	private javax.swing.JButton jButton27;
	private javax.swing.JButton jButton28;
	private javax.swing.JButton jButton29;
	private javax.swing.JButton jButton30;
	private javax.swing.JButton jButton31;
	private javax.swing.JButton jButton32;
	private javax.swing.JButton jButton33;
	private javax.swing.JButton jButton34;
	private javax.swing.JButton jButton35;
	private javax.swing.JButton jButton36;
	private javax.swing.JButton jButton37;
	private javax.swing.JButton jButton38;
	private javax.swing.JButton jButton39;
	private javax.swing.JButton jButton40;
	private javax.swing.JButton jButton41;
	private javax.swing.JButton jButton42;
	private javax.swing.JButton jButton43;
	private javax.swing.JButton jButton44;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox10;
	private javax.swing.JComboBox jComboBox11;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JComboBox jComboBox3;
	private javax.swing.JComboBox jComboBox4;
	private javax.swing.JComboBox jComboBox5;
	private javax.swing.JComboBox jComboBox6;
	private javax.swing.JComboBox jComboBox7;
	private javax.swing.JComboBox jComboBox8;
	private javax.swing.JComboBox jComboBox9;
	private javax.swing.JDesktopPane jDesktopPane1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel23;
	private javax.swing.JLabel jLabel24;
	private javax.swing.JLabel jLabel25;
	private javax.swing.JLabel jLabel26;
	private javax.swing.JLabel jLabel27;
	private javax.swing.JLabel jLabel28;
	private javax.swing.JLabel jLabel29;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel30;
	private javax.swing.JLabel jLabel31;
	private javax.swing.JLabel jLabel32;
	private javax.swing.JLabel jLabel33;
	private javax.swing.JLabel jLabel34;
	private javax.swing.JLabel jLabel35;
	private javax.swing.JLabel jLabel36;
	private javax.swing.JLabel jLabel37;
	private javax.swing.JLabel jLabel38;
	private javax.swing.JLabel jLabel39;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel40;
	private javax.swing.JLabel jLabel41;
	private javax.swing.JLabel jLabel42;
	private javax.swing.JLabel jLabel43;
	private javax.swing.JLabel jLabel44;
	private javax.swing.JLabel jLabel45;
	private javax.swing.JLabel jLabel46;
	private javax.swing.JLabel jLabel47;
	private javax.swing.JLabel jLabel48;
	private javax.swing.JLabel jLabel49;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel50;
	private javax.swing.JLabel jLabel51;
	private javax.swing.JLabel jLabel52;
	private javax.swing.JLabel jLabel53;
	private javax.swing.JLabel jLabel54;
	private javax.swing.JLabel jLabel55;
	private javax.swing.JLabel jLabel56;
	private javax.swing.JLabel jLabel57;
	private javax.swing.JLabel jLabel58;
	private javax.swing.JLabel jLabel59;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel60;
	private javax.swing.JLabel jLabel61;
	private javax.swing.JLabel jLabel62;
	private javax.swing.JLabel jLabel63;
	private javax.swing.JLabel jLabel64;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenu jMenu7;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem10;
	private javax.swing.JMenuItem jMenuItem11;
	private javax.swing.JMenuItem jMenuItem12;
	private javax.swing.JMenuItem jMenuItem13;
	private javax.swing.JMenuItem jMenuItem14;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JMenuItem jMenuItem6;
	private javax.swing.JMenuItem jMenuItem7;
	private javax.swing.JMenuItem jMenuItem8;
	private javax.swing.JMenuItem jMenuItem9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JPanel jPanel11;
	private javax.swing.JPanel jPanel12;
	private javax.swing.JPanel jPanel13;
	private javax.swing.JPanel jPanel14;
	private javax.swing.JPanel jPanel15;
	private javax.swing.JPanel jPanel16;
	private javax.swing.JPanel jPanel17;
	private javax.swing.JPanel jPanel18;
	private javax.swing.JPanel jPanel19;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel20;
	private javax.swing.JPanel jPanel21;
	private javax.swing.JPanel jPanel22;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane10;
	private javax.swing.JScrollPane jScrollPane11;
	private javax.swing.JScrollPane jScrollPane12;
	private javax.swing.JScrollPane jScrollPane13;
	private javax.swing.JScrollPane jScrollPane14;
	private javax.swing.JScrollPane jScrollPane15;
	private javax.swing.JScrollPane jScrollPane16;
	private javax.swing.JScrollPane jScrollPane17;
	private javax.swing.JScrollPane jScrollPane18;
	private javax.swing.JScrollPane jScrollPane19;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane20;
	private javax.swing.JScrollPane jScrollPane21;
	private javax.swing.JScrollPane jScrollPane22;
	private javax.swing.JScrollPane jScrollPane23;
	private javax.swing.JScrollPane jScrollPane24;
	private javax.swing.JScrollPane jScrollPane25;
	private javax.swing.JScrollPane jScrollPane26;
	private javax.swing.JScrollPane jScrollPane27;
	private javax.swing.JScrollPane jScrollPane28;
	private javax.swing.JScrollPane jScrollPane29;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane30;
	private javax.swing.JScrollPane jScrollPane31;
	private javax.swing.JScrollPane jScrollPane32;
	private javax.swing.JScrollPane jScrollPane33;
	private javax.swing.JScrollPane jScrollPane34;
	private javax.swing.JScrollPane jScrollPane35;
	private javax.swing.JScrollPane jScrollPane36;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JScrollPane jScrollPane6;
	private javax.swing.JScrollPane jScrollPane7;
	private javax.swing.JScrollPane jScrollPane8;
	private javax.swing.JScrollPane jScrollPane9;
	private javax.swing.JPopupMenu.Separator jSeparator1;
	private javax.swing.JPopupMenu.Separator jSeparator2;
	private javax.swing.JPopupMenu.Separator jSeparator3;
	private javax.swing.JPopupMenu.Separator jSeparator5;
	private javax.swing.JPopupMenu.Separator jSeparator6;
	private javax.swing.JPopupMenu.Separator jSeparator8;
	private javax.swing.JSplitPane jSplitPane1;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable10;
	private javax.swing.JTable jTable11;
	private javax.swing.JTable jTable12;
	private javax.swing.JTable jTable13;
	private javax.swing.JTable jTable14;
	private javax.swing.JTable jTable2;
	private javax.swing.JTable jTable3;
	private javax.swing.JTable jTable4;
	private javax.swing.JTable jTable5;
	private javax.swing.JTable jTable6;
	private javax.swing.JTable jTable7;
	private javax.swing.JTable jTable8;
	private javax.swing.JTable jTable9;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField10;
	private javax.swing.JTextField jTextField11;
	private javax.swing.JTextField jTextField12;
	private javax.swing.JTextField jTextField13;
	private javax.swing.JTextField jTextField14;
	private javax.swing.JTextField jTextField15;
	private javax.swing.JTextField jTextField16;
	private javax.swing.JTextField jTextField17;
	private javax.swing.JTextField jTextField18;
	private javax.swing.JTextField jTextField19;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField20;
	private javax.swing.JTextField jTextField21;
	private javax.swing.JTextField jTextField22;
	private javax.swing.JTextField jTextField23;
	private javax.swing.JTextField jTextField24;
	private javax.swing.JTextField jTextField25;
	private javax.swing.JTextField jTextField26;
	private javax.swing.JTextField jTextField27;
	private javax.swing.JTextField jTextField28;
	private javax.swing.JTextField jTextField29;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField30;
	private javax.swing.JTextField jTextField31;
	private javax.swing.JTextField jTextField32;
	private javax.swing.JTextField jTextField33;
	private javax.swing.JTextField jTextField34;
	private javax.swing.JTextField jTextField35;
	private javax.swing.JTextField jTextField36;
	private javax.swing.JTextField jTextField37;
	private javax.swing.JTextField jTextField38;
	private javax.swing.JTextField jTextField39;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField40;
	private javax.swing.JTextField jTextField41;
	private javax.swing.JTextField jTextField42;
	private javax.swing.JTextField jTextField43;
	private javax.swing.JTextField jTextField44;
	private javax.swing.JTextField jTextField45;
	private javax.swing.JTextField jTextField46;
	private javax.swing.JTextField jTextField47;
	private javax.swing.JTextField jTextField48;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField7;
	private javax.swing.JTextField jTextField8;
	private javax.swing.JTextField jTextField9;
	private javax.swing.JTextPane jTextPane1;
	private javax.swing.JInternalFrame libro_diario;
	private javax.swing.JInternalFrame libro_mayor;
	private javax.swing.JInternalFrame modificar_catalogos;
	private javax.swing.JInternalFrame modificar_empresa;
	private javax.swing.JInternalFrame nueva_empresa;
	private javax.swing.JInternalFrame nuevo_catalogo;
	private javax.swing.JInternalFrame operaciones_diario;
	private javax.swing.JInternalFrame simple;
	private javax.swing.JInternalFrame venta;
	// End of variables declaration//GEN-END:variables
}
