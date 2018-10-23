package ejecutadores;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Personalizacion_throw_throws extends JFrame implements ActionListener {
	JLabel titulo, txt1, txt2;
	JTextField num1, num2, res;
	JButton boton;

	public Personalizacion_throw_throws() {
		super("Ejemplo de Excepciones personalizadas (throw-throws)");
		Container contenedor = getContentPane();
		contenedor.setLayout(new FlowLayout());
		titulo = new JLabel("Excepcion con mensaje personalizado");
		txt1 = new JLabel("Ingrese primer factor");
		txt2 = new JLabel("Ingrese segundo factor");
		num1 = new JTextField(20);
		num2 = new JTextField(20);
		res = new JTextField(20);
		boton = new JButton("Resultado");
		boton.addActionListener(this);
		add(titulo);
		add(txt1);
		add(num1);
		add(txt2);
		add(num2);
		add(boton);
		add(res);
		setSize(320, 250);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personalizacion_throw_throws ob = new Personalizacion_throw_throws();
		ob.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == boton) {
			try {
				int d1 = Integer.parseInt(num1.getText());
				int d2 = Integer.parseInt(num2.getText());
				determinarNegativos(d1, d2);
			}
			catch(MiExcepcion ex) {
				res.setText("Error: "+ ex.getMessage());
			}
		}
	}
	
	public void determinarNegativos(int d1, int d2) throws MiExcepcion {
		if(d1<0 || d2<0) {
			if(d1<0 && d2<0) {
				throw new MiExcepcion("Los numeros ingresados son negativos");
			}
			else {
			int m=0;
			if(d1<0) {
				m=d1;
			}
			else {
				m=d2;
			}
			throw new MiExcepcion("Un numero es negativo: " + m);
		}
	}
		else {
			res.setText("" + (d1*d2));
		}
}

class MiExcepcion extends Exception{
	public MiExcepcion(String mensaje) {
		super(mensaje);
	}
}
}
