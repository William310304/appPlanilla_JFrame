package Ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Empleado;

public class Planilla extends JFrame {

	private static final long serialVersionUID = 1L;
	Empleado empleado = new Empleado();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Planilla frame = new Planilla();
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
	public Planilla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 960);
		setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
		
	}

}
