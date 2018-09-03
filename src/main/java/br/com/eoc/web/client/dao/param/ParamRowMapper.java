package br.com.eoc.web.client.dao.param;

import br.com.eoc.web.client.enums.ParamType;
import br.com.eoc.web.client.enums.Parameters;
import br.com.eoc.web.client.vo.ParamVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParamRowMapper implements RowMapper<ParamVO> {

    @Override
    public ParamVO mapRow(ResultSet rs, int i) throws SQLException {

        ParamVO vo = new ParamVO();
        vo.setIdParam(rs.getInt("ID_PARAM"));
        vo.setDescription(rs.getString("DESCRIPTION"));
        vo.setType(ParamType.fromValue(rs.getString("TYPE")));
        vo.setParam(Parameters.fromValue(rs.getString("PARAM")));
        vo.setValue(rs.getString("VALUE"));

        return vo;
    }
}
