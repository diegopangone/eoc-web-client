package br.com.eoc.web.client.dao.productgroup;

import br.com.eoc.web.client.vo.ProductSubGroupVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSubGroupRowMapper implements RowMapper<ProductSubGroupVO> {

    @Override
    public ProductSubGroupVO mapRow(ResultSet rs, int i) throws SQLException {

        ProductSubGroupVO vo = new ProductSubGroupVO();
        vo.setIdProductSubGroup(rs.getInt("ID_PRODUCT_SUB_GROUP"));
        vo.setDescription(rs.getString("DESCRIPTION"));
        vo.setActive(rs.getBoolean("IS_ACTIVE"));
        return vo;
    }
}
