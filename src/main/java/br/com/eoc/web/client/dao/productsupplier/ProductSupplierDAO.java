package br.com.eoc.web.client.dao.productsupplier;

import br.com.eoc.web.client.dao.AbstractDAO;
import br.com.eoc.web.client.vo.ProductSupplierVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductSupplierDAO extends AbstractDAO {

    private static final ProductSupplierRowMapper productSupplierRowMapper = new ProductSupplierRowMapper();

    public List<ProductSupplierVO> getAllPromotionProducts(){

        String sql = ""+
                "	SELECT PS.ID_PRODUCT_SUPPLIER,																"+
                "	       PS.COST,                                                                             "+
                "	       PS.PERC_GAIN,                                                                        "+
                "	       PS.DETAIL,                                                                           "+
                "	                                                                                            "+
                "	       S.ID_SUPPLIER,                                                                       "+
                "	       S.CORPORATE_NAME,                                                                    "+
                "	       S.FINANCY_NAME,                                                                      "+
                "	                                                                                            "+
                "	       PC.ID_PRODUCT_CERTIFICATE,                                                           "+
                "	       PC.ACRONYM,                                                                          "+
                "	       PC.DESCRIPTION PC_DESCRIPTION,                                                       "+
                "	                                                                                            "+
                "	       P.ID_PRODUCT,                                                                        "+
                "	       P.DESCRIPTION P_DESCRIPTION,                                                         "+
                "	       P.IS_PERISHABLE,                                                                     "+
                "	       P.DT_REGISTER,                                                                       "+
                "	       P.IMAGE_NAME                                                                         "+
                "	                                                                                            "+
                "	FROM TB_PRODUCT_SUPPLIER PS                                                                 "+
                "	  JOIN TB_PRODUCT P ON PS.ID_PRODUCT = P.ID_PRODUCT                                         "+
                "	  JOIN TB_SUPPLIER S ON PS.ID_SUPPLIER = S.ID_SUPPLIER                                      "+
                "	  JOIN TB_PRODUCT_CERTIFICATE PC ON PS.ID_PRODUCT_CERTIFICATE = PC.ID_PRODUCT_CERTIFICATE   "+
                "	WHERE SHOW_ON_INIT_SALE_PAGE = TRUE                                                         "+
                "	AND PS.IS_ACTIVE = TRUE                                                                     "+
                "	AND P.IS_ACTIVE = TRUE                                                                      "+
                "	LIMIT 9                                                                                    ";

        return namedParameterJdbcTemplate.query(sql, productSupplierRowMapper);
    }
}
