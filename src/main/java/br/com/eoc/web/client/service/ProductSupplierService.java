package br.com.eoc.web.client.service;

import br.com.eoc.web.client.dao.productsupplier.ProductSupplierDAO;
import br.com.eoc.web.client.vo.ProductSupplierVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSupplierService extends AbstractService {

    @Autowired
    private ProductSupplierDAO productSupplierDAO;

    public List<ProductSupplierVO> getAllPromotionProducts(){
        return productSupplierDAO.getAllPromotionProducts();
    }
}
