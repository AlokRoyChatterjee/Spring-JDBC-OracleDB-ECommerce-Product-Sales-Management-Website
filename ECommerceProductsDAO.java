package ecommerceproducts;
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
public class ECommerceProductsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<ECommerceProduct> list() {
		String sql = "SELECT * FROM ECommerceproducts";

		List<ECommerceProduct> listSale = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(ECommerceProduct.class));

		return listECommerceSale;
	}
	
	public void save(ECommerceSale sale) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("ECommerceproducts").usingColumns("item", "quantity", "amount");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ECommercesale);
		
		insertActor.execute(param);		
	}
	
	public ECommerceSale get(int id) {
		String sql = "SELECT * FROM ECommerceproducts WHERE id = ?";
		Object[] args = {id};
		ECommerceProduct product = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(ECommerceProduct.class));
		return product;
	}
	
	public void update(ECommerceProduct sale) {
		String sql = "UPDATE ECommerceproducts SET item=:item, quantity=:quantity, amount=:amount WHERE id=:id";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(Ecommercesale);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM ECommerceproducts WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}
