package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ECommerceSalesDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<ECommerceSale> list() {
		String sql = "SELECT * FROM ECommercesales";

		List<ECommerceSale> listSale = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(ECommerceSale.class));

		return listECommerceSale;
	}
	
	public void save(ECommerceSale sale) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Ecommercesales").usingColumns("item", "quantity", "amount");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ECommercesale);
		
		insertActor.execute(param);		
	}
	
	public ECommerceSale get(int id) {
		String sql = "SELECT * FROM ECommercesales WHERE id = ?";
		Object[] args = {id};
		ECommerceSale ECommercesale = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(ECommerceSale.class));
		return ECommercesale;
	}
	
	public void update(ECommerceSale sale) {
		String sql = "UPDATE ECommercesales SET item=:item, quantity=:quantity, amount=:amount WHERE id=:id";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(Ecommercesale);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM ECommercesales WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}
