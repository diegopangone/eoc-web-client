package br.com.eoc.web.client.dao.productcertificate;

import br.com.eoc.web.client.vo.ProductCertificateVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductCertificateRowMapper implements RowMapper<ProductCertificateVO> {

    @Override
    public ProductCertificateVO mapRow(ResultSet rs, int i) throws SQLException {

        ProductCertificateVO productCertificateVO = new ProductCertificateVO();
        productCertificateVO.setIdProductCertificate(rs.getInt("ID_PRODUCT_CERTIFICATE"));
        productCertificateVO.setAcronym("ACRONYM");
        productCertificateVO.setDescription(rs.getString("PC_DESCRIPTION"));

        return productCertificateVO;
    }
}
