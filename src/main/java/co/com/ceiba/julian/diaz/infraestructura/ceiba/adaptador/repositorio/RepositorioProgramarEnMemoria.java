package co.com.ceiba.julian.diaz.infraestructura.ceiba.adaptador.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.com.ceiba.julian.diaz.dominio.modelo.entidad.Programar;
import co.com.ceiba.julian.diaz.dominio.puerto.repositorio.RepositorioProgramar;

@Repository
public class RepositorioProgramarEnMemoria implements RepositorioProgramar {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public void crear(Programar programar) {
		
		Object[] params = new Object[] { programar.getValor(), programar.getNombre(), programar.getIdUsuario(), programar.getFechaIngreso(),
				programar.getFechaProgramada(),programar.getHoraProgramada()};
		
        jdbcTemplate.update(" INSERT INTO PROGRAMAR (VALOR,NOMBRE,ID_USUARIO,FECHA_INGRESO,FECHA_PROGRAMADA,HORA_PROGRAMADA)"
				+ " VALUES (?,?,?,?,?,?)",params);
        		
	}

	@Override
	public boolean existe(Programar programar) {
		
		String sql = " SELECT COUNT(*) "
				+ " FROM PROGRAMAR "
				+ " WHERE NOMBRE = ? "
				+ " AND ID_USUARIO = ?";

		Object[] params = new Object[] { programar.getNombre(),programar.getIdUsuario()};
		
		return jdbcTemplate.queryForObject(sql,Boolean.class,params).booleanValue();
		
	}
	
	@Override
	public void borrar(Programar programar) {
		
		Object[] params = new Object[] { programar.getNombre(), programar.getIdUsuario()};
		
        jdbcTemplate.update(" DELETE PROGRAMAR WHERE "
        		+ " NOMBRE = ? "
				+ " AND ID_USUARIO = ?",params);
		
	}
	
	@Override
	public void modificar(Programar programar) {
		
		Object[] params = new Object[] { programar.getNombre(), programar.getIdUsuario()};
		
        jdbcTemplate.update(" UPDATE PROGRAMAR "
        		+ "SET VALOR = ? ,"
        		+ "FECHA_PROGRAMADA = ? "
        		+ "HORA_PROGRAMADA = ? "
        		+ "WHERE "
        		+ "NOMBRE = ? "
        		+ "AND ID_USUARIO = ? ",params);
		
	}
}
