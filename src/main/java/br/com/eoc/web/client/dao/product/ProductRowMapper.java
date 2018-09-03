package br.com.eoc.web.client.dao.product;

import br.com.eoc.web.client.vo.ProductVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<ProductVO> {

    @Override
    public ProductVO mapRow(ResultSet rs, int i) throws SQLException {

        ProductVO productVO = new ProductVO();
        productVO.setIdProduct(rs.getInt("ID_PRODUCT"));
        productVO.setDescription(rs.getString("P_DESCRIPTION"));
        productVO.setPerishable(rs.getBoolean("IS_PERISHABLE"));
        productVO.setImageName(rs.getString("IMAGE_NAME"));
        productVO.setDtRegister(rs.getDate("DT_REGISTER"));

        return productVO;
    }
}
