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
		
		Object[] params = new Object[] { programar.getValor(), programar.getIdUsuario(), programar.getFechaIngreso(),
				programar.getFechaProgramada(),programar.getHoraProgramada()};
		
        jdbcTemplate.update(" INSERT INTO PROGRAMAR (VALOR,ID_USUARIO,FECHA_INGRESO,FECHA_PROGRAMADA,HORA_PROGRAMADA)"
				+ " VALUES (?,?,?,?,?)",params);
        		
	}

	@Override
	public boolean existe(Programar programar) {
		
		String sql = " SELECT COUNT(*) "
				+ " FROM PROGRAMAR "
				+ " WHERE ID_USUARIO = ? "
				+ " AND VALOR = ? "
				+ " AND FECHA_PROGRAMADA = ? "
				+ " AND HORA_PROGRAMADA = ? ";

		Object[] params = new Object[] { programar.getIdUsuario(), programar.getValor(),
				programar.getFechaProgramada(),programar.getHoraProgramada()};
		
		return jdbcTemplate.queryForObject(sql,Boolean.class,params).booleanValue();
		
	}
	
	@Override
	public void borrar(Programar programar) {
		
		Object[] params = new Object[] { programar.getValor(), programar.getIdUsuario(),
				programar.getFechaProgramada(),programar.getHoraProgramada()};
		
        jdbcTemplate.update(" DELETE PROGRAMAR WHERE "
        		+ "VALOR = ? "
        		+ "AND ID_USUARIO = ? "
        		+ "AND FECHA_PROGRAMADA = ? "
        		+ "AND HORA_PROGRAMADA = ? ",params);
		
	}
}
