package ejecutadores;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.*;
import javax.swing.*;
import java.io.*;

public class RaizNum extends JFrame implements ActionListener {
	private JLabel titulo, numero, resultado;
	private JTextField txtnum, txtres;
	private JButton boton;
	public RaizNum() {
		// TODO Auto-generated constructor stub
		titulo = new JLabel("Raiz de un numero");
		numero = new JLabel("Ingrese numero");
		resultado = new JLabel("Resultado");
		txtnum = new JTextField(8);
		txtres = new JTextField(30);
		boton = new JButton("Ejecutar");
		boton.addActionListener(this);
		getContentPane().setLayout(new FlowLayout());
		add(titulo);
		add(numero);
		add(txtnum);
		add(boton);
		add(resultado);
		add(txtres);
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RaizNum ob = new RaizNum();
		ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == boton) {
			try {
				int d = Integer.parseInt(txtnum.getText());
				txtres.setText("La raiz de " + d + " es: "+raiz(d));
			}
			catch(ArithmeticException ex) {
				txtres.setText(ex.getMessage());
			}
			catch(NumberFormatException ex) {
				txtres.setText(ex.getMessage());
			}
		}
	}
	
	public double raiz(int num) throws ArithmeticException, NumberFormatException {
		for(int i=0; i<txtnum.getText().length(); i++) {
			if(txtnum.getText().charAt(i) < 48 || txtnum.getText().charAt(i) > 57 && 
					txtnum.getText().charAt(i) !=',') {
				throw new NumberFormatException("Error, no se ingreso un numer o coma");
			}
		}
		if(num<0) {
			throw new ArithmeticException("Error, numero negativo");
		}
		else {
			return Math.sqrt(num);
		}
	}

}
