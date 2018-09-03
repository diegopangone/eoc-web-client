package br.com.eoc.web.client.dao.route;

import br.com.eoc.web.client.dao.AbstractDAO;
import br.com.eoc.web.client.vo.CustomerVO;
import br.com.eoc.web.client.vo.RouteVO;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RouteDAO extends AbstractDAO {

    private static final RouteRowMapper routeRowMapper = new RouteRowMapper();

    public List<RouteVO> selectRoutesByCustomer(CustomerVO customerVO){

        String sql = ""+
              "          SELECT R.ID_ROUTE,                         "+
              "          R.DESCRIPTION,                             "+
              "          R.RATE_DELIVERY,                           "+
              "          R.IS_ACTIVE,                               "+
              "          R.DELIVERY_DAY                             "+
              "  FROM TB_ROUTE_ZIP_CODE ZC                          "+
              "  JOIN TB_ROUTE R ON ( ZC.ID_ROUTE = R.ID_ROUTE )    "+
              " WHERE ZIP_CODE = :zipCode                           "+
              "  AND R.IS_ACTIVE = TRUE                             ";

        return namedParameterJdbcTemplate.query(sql, new MapSqlParameterSource("zipCode", customerVO.getZipCode()), routeRowMapper);
    }

}
