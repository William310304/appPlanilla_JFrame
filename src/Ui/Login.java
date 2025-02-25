package Ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputAdapter;

import controller.EmpleadoDAO;
import model.Empleado;

import java.awt.Label;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String Empleado = null;
	JTextField txtDni;
	JPasswordField txtPassword;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 400, 300);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);//centra en la pantalla
		setUndecorated(true);//quita boton de cerrar 
		
		JPanel pnlLogin=new JPanel();
		pnlLogin.setBounds(0, 0, 400, 60);
		pnlLogin.setBackground(new Color(94,17,90));//da color al background
		pnlLogin.setLayout(null);
		getContentPane().add(pnlLogin);//agrega la JFram
		
		JLabel imgLogo = new JLabel();
		imgLogo.setIcon(new ImageIcon(Login.class.getResource("/img/logo.png")));
		imgLogo.setBounds(96,8,208,43);//x,y,with, h
		pnlLogin.add(imgLogo);
		
		JLabel imgCerrar =new JLabel();
		
		imgCerrar.setIcon(new ImageIcon(Login.class.getResource("/img/salir.png")));
		imgCerrar.setBounds(360,18,24,24);
		pnlLogin.add(imgCerrar);
		
		JLabel lblDni = new JLabel("DNI :");
		lblDni.setBounds(130,110,80,30);
		getContentPane().add(lblDni);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(130,160,80,30);
		getContentPane().add(lblPassword);
		
		txtDni = new JTextField();
		txtDni.setBounds(220,110,80,30);
		txtDni.setColumns(8);
		txtDni.setMargin(new Insets(5, 5, 5, 5));
		getContentPane().add(txtDni);
		//--------------------------------------
		txtPassword = new JPasswordField();
		txtPassword.setBounds(220,160,80,30);
		txtPassword.setColumns(6);
		txtPassword.setMargin(new Insets(5, 5, 5, 5));
		getContentPane().add(txtPassword);
		//--------------------------------------
		JButton btnIniciar =new JButton("Iniciar");
		btnIniciar.setBounds(90,220,100,30);
		btnIniciar.setBackground(new Color(94,17,90));
		btnIniciar.setFocusPainted(false);
		btnIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnIniciar.setForeground(Color.white);
		btnIniciar.setBorderPainted(false);
		btnIniciar.setMnemonic('i');
		getContentPane().add(btnIniciar);
		
		JButton btnCancelar =new JButton("Cancelar");
		btnCancelar.setBounds(210,220,100,30);
		btnCancelar.setBackground(new Color(94,17,90));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancelar.setForeground(Color.white);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setMnemonic('a');
		getContentPane().add(btnCancelar);
		
		btnIniciar.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {}} );
		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override public void mouseEntered(MouseEvent e) {btn_focus(btnIniciar,true);}
			@Override public void mouseExited(MouseEvent e) {btn_focus(btnIniciar,false);}
			@Override
			public void mouseClicked(MouseEvent e) {btnIniciar_actionPerformed();
			}
		});
		btnIniciar.addFocusListener(new FocusAdapter() {
			@Override public void focusGained(FocusEvent e) {btn_focus(btnIniciar,true);}
			@Override public void focusLost(FocusEvent e) {btn_focus(btnIniciar,false);}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {}} );
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override public void mouseEntered(MouseEvent e) {btn_focus(btnCancelar,true);}
			@Override public void mouseExited(MouseEvent e) {btn_focus(btnCancelar,false);}
		});
		btnCancelar.addFocusListener(new FocusAdapter() {
			@Override public void focusGained(FocusEvent e) {btn_focus(btnCancelar,true);}
			@Override public void focusLost(FocusEvent e) {btn_focus(btnCancelar,false);}
		});
		
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {txt_keyTyped(txtDni,e);}
		});
		txtDni.addFocusListener(new FocusAdapter() {
			@Override public void focusGained(FocusEvent e) {txt_focus(txtDni,true); }
			@Override public void focusLost(FocusEvent e) { txt_focus(txtDni,false); }
		});
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {txt_keyTyped(txtPassword,e);}
		});
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override public void focusGained(FocusEvent e) {txt_focus(txtPassword,true); }
			@Override public void focusLost(FocusEvent e) {txt_focus(txtPassword,false); } 
		});
		imgCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {imgCerrar_mouseClick();
				
			}
		});
		
	}
	protected void btnIniciar_actionPerformed() {
		String sDni=txtDni.getText();
		String sPassword = String.valueOf(txtPassword.getPassword());
		String sMensaje="";
		if(sDni.isEmpty() || sDni.length()<8)sMensaje="Ingrese Dni";
		else if(sPassword.isEmpty()|| sPassword.length()<6)sMensaje="Ingrese Password";
		if(sMensaje.isEmpty()) {
			Empleado empleado =new Empleado();
			empleado.setDni(sDni);
			empleado.setPasswordd(sPassword);
			if(new EmpleadoDAO().Login(empleado)) {
				Planilla planilla =new Planilla();
				planilla.setEmpleado(empleado);
				planilla.setVisible(true);
			}else sMensaje ="Dni y/o password invalido";
		}
		if(!sMensaje.isEmpty()) {
			btnCancelar_actionPerformed();
			JOptionPane.showConfirmDialog(this, sMensaje);
		}
		
	}
	protected void btnCancelar_actionPerformed() {
		
		
	}
	protected void imgCerrar_mouseClick() {
		if (JOptionPane.showConfirmDialog(null, "¿Deseas salir?", "Salir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) System.exit(0);

	}

	protected void btn_focus(JButton btn, boolean bFocus) {
		btn.setBackground(bFocus?Color.black:new Color(94,17,90));
		
	}

	protected void txt_keyTyped(JTextField txt,KeyEvent e) {
		char tecla =e.getKeyChar();
		if(!Character.isDigit(tecla)|| txt.getText().length()>=txt.getColumns())e.consume();
		
	}

	protected void txt_focus(JTextField txt, boolean bFocus) {
		txt.setBackground(bFocus? Color.YELLOW:Color.WHITE);
		
	}

}
