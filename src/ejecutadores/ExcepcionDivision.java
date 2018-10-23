package ejecutadores;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import javax.swing.JFrame;

public class ExcepcionDivision extends JFrame implements ActionListener {
	JLabel texto, texto1;
	JTextField numero, numero1, resultado;
	JButton check;
	int numerador, denominador, division;
	
	
	public ExcepcionDivision(){
		super();
		Container contenedor = getContentPane();
		contenedor.setLayout(new FlowLayout());
		texto = new JLabel("Digite numerador");
		numero = new JTextField(10);
		texto1 = new JLabel("Digite denominador");
		numero1 = new JTextField(10);
		check = new JButton("Resultado");
		resultado = new JTextField(20);
		check.addActionListener(this);
		contenedor.add(texto);
		contenedor.add(numero);
		contenedor.add(texto1);
		contenedor.add(numero1);
		contenedor.add(check);
		contenedor.add(resultado);
		setSize(350, 200);
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == check) {
			try {
				numerador = Integer.parseInt(numero.getText());
				denominador = Integer.parseInt(numero1.getText());
				numero();
				division = numerador/denominador;
				resultado.setText(""+division);
			}
			catch (ArithmeticException ev){
				resultado.setText("Error, division por cero");
			}
			catch(NumberFormatException ev) {
				resultado.setText("Error, solo se permiten numeros enteros");
			}
			catch (ExceptionBig ev) {
				resultado.setText(ev.getMessage());
			}
		}
	}
	
	public static void main(String [] args) {
		ExcepcionDivision ventana = new ExcepcionDivision();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void numero() throws ExceptionBig{
		if(Integer.parseInt(numero.getText()) > 2147483647 || Integer.parseInt(numero1.getText()) > 2147483647) {
			throw new ExceptionBig("Error, el numero nu puede ser mayor a 2147483647");
		}
	}
	public class ExceptionBig extends Exception{
		public ExceptionBig(String m) {
			super(m);
		}
	}

}
