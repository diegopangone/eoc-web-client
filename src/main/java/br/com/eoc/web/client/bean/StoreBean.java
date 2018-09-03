package br.com.eoc.web.client.bean;

import br.com.eoc.web.client.scope.BeanViewScope;
import br.com.eoc.web.client.service.ProductSupplierService;
import br.com.eoc.web.client.vo.ProductSupplierVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "storeBean")
@Controller
@BeanViewScope
public class StoreBean extends AbstractBean {

    @Autowired
    private ProductSupplierService productSupplierService;

    private List<ProductSupplierVO> listProductSuppliers;
    private ProductSupplierVO selectedProduct;

    @Override
    protected void initBean() {
        this.listProductSuppliers = productSupplierService.getAllPromotionProducts();
    }

    public List<ProductSupplierVO> getListProductSuppliers() {
        return listProductSuppliers;
    }

    public void setListProductSuppliers(List<ProductSupplierVO> listProductSuppliers) {
        this.listProductSuppliers = listProductSuppliers;
    }

    public ProductSupplierVO getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(ProductSupplierVO selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
}
