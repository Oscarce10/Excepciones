package ejecutadores;

public class CapturarExcepcionThrows {
	
	static void capturarExcepcion() throws IllegalAccessException{
		throw new IllegalAccessException("Ex2");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			capturarExcepcion();
		}
		catch(IllegalAccessException e) {
			System.out.println("Excepcion capturada en el main() nuevamente: "+e);
		}

	}

}
