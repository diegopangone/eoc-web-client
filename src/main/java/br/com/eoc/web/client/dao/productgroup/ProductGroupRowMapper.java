package br.com.eoc.web.client.dao.productgroup;

import br.com.eoc.web.client.vo.ProductGroupVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductGroupRowMapper implements RowMapper<ProductGroupVO> {

    @Override
    public ProductGroupVO mapRow(ResultSet rs, int i) throws SQLException {

        ProductGroupVO vo = new ProductGroupVO();
        vo.setIdProductGroup(rs.getInt("ID_PRODUCT_GROUP"));
        vo.setDescription(rs.getString("DESCRIPTION"));
        vo.setActive(rs.getBoolean("IS_ACTIVE"));
        return vo;
    }
}
