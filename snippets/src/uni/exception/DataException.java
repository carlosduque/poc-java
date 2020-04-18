package uni.exception;

public class DataException extends Exception {

	/** C�digo de error */
	private String errorCode;	
	/** Causa de la excepci�n*/
	private Throwable cause;

	/**
	 * Constructor default.
	 */
	public DataException() {}
	
	/**
	 * Constructor. Establece el mensaje de detalle.
	 * @param message el mensaje de detalle
	 */
	public DataException(String message) {
		super(message);
	}

	/**
	 * Constructor. Establece la causa de la excepci�n.
	 * @param cause la causa de la excepci�n
	 */
	public DataException(Throwable cause) {
		this.cause = cause;
	}

	/**
	 * Constructor. Establece el c�digo de error y el mensaje de detalle.
	 * @param errorCode el c�digo de error
	 * @param message el mensaje de detalle
	 */
	public DataException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	/**
	 * Constructor. Establece el mensaje de detalle y la causa de la excepci�n.
	 * @param message el mensaje de detalle
	 * @param cause la causa de la excepci�n
	 */
	public DataException(String message, Throwable cause) {
		super(message);
		this.cause = cause;
	}

	/**
	 * Constructor. Establece el c�digo de error, el mensaje de detalle y la causa de la excepci�n.
	 * @param errorCode el c�digo de error
	 * @param message el mensaje de detalle
	 * @param cause la causa de la excepci�n
	 */
	public DataException(String errorCode, String message, Throwable cause) {
		super(message);
		this.errorCode = errorCode;
		this.cause = cause;
	}
	
	/**
	 * Retorna el c�digo de error.
	 * @return el c�digo de error
	 */
	public String getErrorCode() {
		return errorCode;
	}
		
	/**
	 * Retorna la causa de la excepci�n.
	 * @return la causa de la excepci�n.
	 */
	public Throwable getCause() {
		return cause;
	}
	
	/**
	 * Imprime el stack trace de la causa de la excepci�n al standard error stream.
	 */
	public void printStackTrace() {

		System.err.println(this.toString());
		
		if (cause != null) {
			System.err.print("Caused by: ");
			cause.printStackTrace();
		}
	}
}
