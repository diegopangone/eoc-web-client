package br.com.eoc.web.client.dao.route;

import br.com.eoc.web.client.enums.DayOfWeek;
import br.com.eoc.web.client.enums.PersonType;
import br.com.eoc.web.client.enums.Sex;
import br.com.eoc.web.client.vo.CustomerVO;
import br.com.eoc.web.client.vo.RouteVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RouteRowMapper implements RowMapper<RouteVO> {

    @Override
    public RouteVO mapRow(ResultSet rs, int i) throws SQLException {

        RouteVO vo = new RouteVO();
        vo.setIdRoute(rs.getInt("ID_ROUTE"));
        vo.setDescription(rs.getString("DESCRIPTION"));
        vo.setRateDelivery(rs.getFloat("RATE_DELIVERY"));
        vo.setDeliveryDay(DayOfWeek.fromValue(rs.getInt("DELIVERY_DAY")));
        vo.setActive(rs.getBoolean("IS_ACTIVE"));
        return vo;
    }
}
