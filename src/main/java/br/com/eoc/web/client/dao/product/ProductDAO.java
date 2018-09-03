package br.com.eoc.web.client.dao.product;

import br.com.eoc.web.client.dao.AbstractDAO;
import br.com.eoc.web.client.vo.ProductVO;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAO extends AbstractDAO {

    private static final ProductRowMapper productRowMapper = new ProductRowMapper();

    public List<ProductVO> getAllProducts(){

        String sql = "" +
                "SELECT P.ID_PRODUCT,                    " +
                "       P.DESCRIPTION P_DESCRIPTION,     " +
                "       P.IS_PERISHABLE,                 " +
                "       P.DT_REGISTER,                   " +
                "       P.IMAGE_NAME                     " +
                "FROM TB_PRODUCT P                       ";

       return namedParameterJdbcTemplate.query(sql, MapUtils.EMPTY_MAP, productRowMapper);
    }

}
