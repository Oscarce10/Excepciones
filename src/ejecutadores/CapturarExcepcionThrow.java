package ejecutadores;

public class CapturarExcepcionThrow {
	static void capturarExcepcion() {
		try {
			throw new NullPointerException("excepcion_throw");
		}
		catch (NullPointerException e){
			System.out.println("Capturada la excepcion en capturarExcepcion");
			throw e;
		}
	}
	
	public static void main(String [] args) {
		try {
			capturarExcepcion();
		}
		catch(NullPointerException e) {
			System.out.println("Excepcion capturada en el main() nuevamente: "+ e);
		}
	}

}
