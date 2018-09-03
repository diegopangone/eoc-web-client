package br.com.eoc.web.client.dao.productgroup;

import br.com.eoc.web.client.dao.AbstractDAO;
import br.com.eoc.web.client.dao.product.ProductRowMapper;
import br.com.eoc.web.client.vo.ProductGroupVO;
import br.com.eoc.web.client.vo.ProductSubGroupVO;
import br.com.eoc.web.client.vo.ProductVO;
import org.apache.commons.collections.MapUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductGroupDAO extends AbstractDAO {

    private static final ProductGroupRowMapper productGroupRowMapper = new ProductGroupRowMapper();
    private static final ProductSubGroupRowMapper productSubGroupRowMapper = new ProductSubGroupRowMapper();

    public List<ProductGroupVO> selectActiveGroups(){

        String sql = "" +
                "SELECT PG.ID_PRODUCT_GROUP,    " +
                "       PG.DESCRIPTION,         " +
                "       PG.IS_ACTIVE            " +
                "FROM TB_PRODUCT_GROUP PG       " +
                "WHERE PG.IS_ACTIVE = TRUE      ";

       return namedParameterJdbcTemplate.query(sql, MapUtils.EMPTY_MAP, productGroupRowMapper );
    }

    public List<ProductSubGroupVO> selectActiveSubGroupsByGroup(ProductGroupVO productGroupVO){

        String sql = "" +
                "SELECT PSG.ID_PRODUCT_GROUP,                       " +
                "       PSG.DESCRIPTION,                            " +
                "       PSG.IS_ACTIVE                               " +
                "FROM TB_PRODUCT_SUB_GROUP PSG                      " +
                "WHERE PSG.ID_PRODUCT_GROUP = :idProductGroup       ";


        return namedParameterJdbcTemplate.query(sql, new MapSqlParameterSource("idProductGroup",
                productGroupVO.getIdProductGroup()), productSubGroupRowMapper );
    }

}
