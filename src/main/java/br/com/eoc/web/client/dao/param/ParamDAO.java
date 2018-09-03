package br.com.eoc.web.client.dao.param;

import br.com.eoc.web.client.dao.AbstractDAO;
import br.com.eoc.web.client.enums.Parameters;
import br.com.eoc.web.client.vo.ParamVO;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ParamDAO extends AbstractDAO {

    private static final ParamRowMapper paramRowMapper = new ParamRowMapper();

    public ParamVO selectByName(Parameters param) {
        String sql = ""+
                "   SELECT *            "+
                "       FROM TB_PARAM   "+
                "   WHERE PARAM = :param     ";

        return namedParameterJdbcTemplate.queryForObject(sql, new MapSqlParameterSource("param", param.name()), paramRowMapper);
    }
}
