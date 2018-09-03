package br.com.eoc.web.client.service;

import br.com.eoc.web.client.dao.product.ProductDAO;
import br.com.eoc.web.client.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends AbstractService {

    @Autowired
    private ProductDAO productDAO;

    public List<ProductVO> getAllProducts(){
        return productDAO.getAllProducts();
    }
}
