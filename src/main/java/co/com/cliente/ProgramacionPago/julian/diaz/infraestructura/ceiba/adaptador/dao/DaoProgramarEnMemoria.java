package co.com.cliente.ProgramacionPago.julian.diaz.infraestructura.ceiba.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import co.com.cliente.ProgramacionPago.julian.diaz.dominio.modelo.dto.DtoProgramar;
import co.com.cliente.ProgramacionPago.julian.diaz.dominio.puerto.dao.DaoProgramar;

@Repository
public class DaoProgramarEnMemoria implements DaoProgramar {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public Collection<DtoProgramar> listar() {
		return jdbcTemplate.query("SELECT VALOR,ID_USUARIO,FECHA_INGRESO,FECHA_PROGRAMADA,HORA_PROGRAMADA FROM PROGRAMAR", new CustomerRowMapper());
	}
	
	public class CustomerRowMapper implements RowMapper<DtoProgramar> {

	    @Override
	    public DtoProgramar mapRow(ResultSet rs, int rowNum) throws SQLException {

	    	DtoProgramar dtoProgramar = new DtoProgramar();
	    	dtoProgramar.setValor(rs.getDouble("VALOR"));
	    	dtoProgramar.setIdUsuario(rs.getString("ID_USUARIO"));
	    	dtoProgramar.setFechaIngreso(rs.getDate("FECHA_INGRESO"));
	    	dtoProgramar.setFechaProgramada(rs.getDate("FECHA_PROGRAMADA"));
	    	dtoProgramar.setHoraProgramada(rs.getString("HORA_PROGRAMADA"));
	    	
	        return dtoProgramar;

	    }
	}

}


