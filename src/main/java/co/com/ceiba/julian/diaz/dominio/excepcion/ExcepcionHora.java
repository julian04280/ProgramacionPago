package co.com.ceiba.julian.diaz.dominio.excepcion;

public class ExcepcionHora extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionHora(String mensaje) {
        super(mensaje);
    }
}
