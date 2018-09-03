package br.com.eoc.web.client.dao.productsupplier;

import br.com.eoc.web.client.dao.product.ProductRowMapper;
import br.com.eoc.web.client.dao.productcertificate.ProductCertificateRowMapper;
import br.com.eoc.web.client.dao.supplier.SupplierRowMapper;
import br.com.eoc.web.client.vo.ProductSupplierVO;
import br.com.eoc.web.client.vo.ProductVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSupplierRowMapper implements RowMapper<ProductSupplierVO> {

    private final static ProductRowMapper productRowMapper = new ProductRowMapper();
    private final static SupplierRowMapper supplierRowMapper = new SupplierRowMapper();
    private final static ProductCertificateRowMapper productCertificateRowMapper = new ProductCertificateRowMapper();

    @Override
    public ProductSupplierVO mapRow(ResultSet rs, int i) throws SQLException {

        //Detalhes do produto com o fornecedor
        ProductSupplierVO productSupplierVO = new ProductSupplierVO();
        productSupplierVO.setIdProductSupplier(rs.getInt("ID_PRODUCT_SUPPLIER"));
        productSupplierVO.setCost(rs.getFloat("COST"));
        productSupplierVO.setPercGain(rs.getFloat("PERC_GAIN"));
        productSupplierVO.setDetail(rs.getString("DETAIL"));

        // Fornecedor
        productSupplierVO.setSupplierVO(supplierRowMapper.mapRow(rs, i));

        // Produto
        productSupplierVO.setProductVO(productRowMapper.mapRow(rs, i));

        // Certificadora do Produto
        productSupplierVO.setProductCertificateVO(productCertificateRowMapper.mapRow(rs, i));

        return productSupplierVO;
    }
}
