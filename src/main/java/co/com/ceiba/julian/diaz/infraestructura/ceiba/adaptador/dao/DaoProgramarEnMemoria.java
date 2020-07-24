package co.com.ceiba.julian.diaz.infraestructura.ceiba.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import co.com.ceiba.julian.diaz.dominio.modelo.dto.DtoProgramar;
import co.com.ceiba.julian.diaz.dominio.modelo.entidad.Programar;
import co.com.ceiba.julian.diaz.dominio.puerto.dao.DaoProgramar;

@Repository
public class DaoProgramarEnMemoria implements DaoProgramar {
		
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public Collection<DtoProgramar> listar() {
		return jdbcTemplate.query("SELECT VALOR,NOMBRE,ID_USUARIO,FECHA_INGRESO,FECHA_PROGRAMADA,HORA_PROGRAMADA FROM PROGRAMAR ORDER BY ID", new CustomerRowMapper());
	}
	
	@Override
	public Collection<DtoProgramar> buscarPagosProgramadosUsuario(Programar programar) {
		
		Object[] params = new Object[] {programar.getIdUsuario()};
		
		return jdbcTemplate.query("SELECT VALOR,NOMBRE,ID_USUARIO,FECHA_INGRESO,FECHA_PROGRAMADA,HORA_PROGRAMADA FROM PROGRAMAR"
				+ "ID_USUARIO = ? ",params, new CustomerRowMapper());
	}
	
	public class CustomerRowMapper implements RowMapper<DtoProgramar> {

	    @Override
	    public DtoProgramar mapRow(ResultSet rs, int rowNum) throws SQLException {

	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	
	    	DtoProgramar dtoProgramar = new DtoProgramar();
	    	dtoProgramar.setValor(rs.getDouble("VALOR"));
	    	dtoProgramar.setNombre(rs.getString("NOMBRE"));
	    	dtoProgramar.setIdUsuario(rs.getString("ID_USUARIO"));
	    	dtoProgramar.setFechaIngreso(sdf.format(rs.getDate("FECHA_INGRESO")));
	    	dtoProgramar.setFechaProgramada(sdf.format(rs.getDate("FECHA_PROGRAMADA")));
	    	dtoProgramar.setHoraProgramada(rs.getString("HORA_PROGRAMADA"));
	    	
	        return dtoProgramar;

	    }
	}

}


