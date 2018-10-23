package ejecutadores;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ExcepcionNumero extends JFrame implements ActionListener{
	private JLabel texto, texto1;
	private JTextField numero, resultado;

	public ExcepcionNumero(){
		super();
		Container contenedor = getContentPane();
		contenedor.setLayout(new FlowLayout());
		texto = new JLabel("Digite un numero");
		numero = new JTextField(10);
		texto1 = new JLabel("Digito el numero: ");
		resultado = new JTextField(50);
		numero.addActionListener(this);
		contenedor.add(texto);
		contenedor.add(numero);
		contenedor.add(texto1);
		contenedor.add(resultado);
		setSize(400, 300);
		setVisible(true);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == numero) {
			try {
				int numeros = Integer.parseInt(numero.getText());
				resultado.setText("Lo digitado fue el numero: "+ numeros);
			} catch(NumberFormatException ev) {
				resultado.setText("Grave Error "+ev);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcepcionNumero ventana = new ExcepcionNumero();
ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}








}
