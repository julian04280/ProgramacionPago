package co.com.cliente.ProgramacionPago.julian.diaz.dominio.excepcion;

public class ExcepcionDuplicidad extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionDuplicidad(String mensaje) {
        super(mensaje);
    }
}
