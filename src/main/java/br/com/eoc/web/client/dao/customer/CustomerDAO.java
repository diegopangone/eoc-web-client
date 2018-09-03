package br.com.eoc.web.client.dao.customer;

import br.com.eoc.web.client.dao.AbstractDAO;
import br.com.eoc.web.client.vo.CustomerVO;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO extends AbstractDAO {

    private static final CustomerRowMapper customerRowMapper= new CustomerRowMapper();

    public CustomerVO selectCustomerByEmail(String email){
        String sql = ""+
                "SELECT *               " +
                "FROM TB_CUSTOMER       "+
                "WHERE EMAIL = :email   ";

        return namedParameterJdbcTemplate.queryForObject(sql, new MapSqlParameterSource("email", email), customerRowMapper);
    }

    public void updateDataAccess(CustomerVO customerVO){
        String sql = ""+
                "UPDATE TB_CUSTOMER "+
                "SET AMOUNT_ACCESS = AMOUNT_ACCESS + 1,     "+
                "    DT_LAST_ACCESS = CURRENT_TIMESTAMP     " +
                "WHERE ID_CUSTOMER = :idCustomer            ";

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("idCustomer", customerVO.getIdCustomer()));
    }

}
