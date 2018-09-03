package br.com.eoc.web.client.dao.supplier;

import br.com.eoc.web.client.vo.SupplierVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierRowMapper implements RowMapper<SupplierVO> {

    @Override
    public SupplierVO mapRow(ResultSet rs, int i) throws SQLException {

        SupplierVO supplierVO = new SupplierVO();
        supplierVO.setIdSupplier(rs.getInt("ID_SUPPLIER"));
        supplierVO.setComporateName(rs.getString("CORPORATE_NAME"));
        supplierVO.setFinancyName(rs.getString("FINANCY_NAME"));

        return supplierVO;
    }
}
