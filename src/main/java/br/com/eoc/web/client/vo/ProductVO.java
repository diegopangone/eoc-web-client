/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eoc.web.client.vo;

import java.util.Date;
import java.util.Objects;


public class ProductVO extends AbstractVO {

    private static final long serialVersionUID = 1L;

    private Integer idProduct;
    private String description;
    //private PackagePosition packagePosition;
    private boolean perishable;
    private Date dtRegister;
    //private PackType packType;
    //private UnitOfMeasure unitOfMeasure;
    private String imageName;
    //private ProductSubGroupVO productSubGroupVO;
    //private ProductDeliveryTypeVO productDeliveryTypeVO;
    //private List<ProductSupplierVO> listProductSuppliers;


    @Override
    public Integer getId() {
        return this.idProduct;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPerishable() {
        return perishable;
    }

    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }

    public Date getDtRegister() {
        return dtRegister;
    }

    public void setDtRegister(Date dtRegister) {
        this.dtRegister = dtRegister;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductVO)) return false;
        ProductVO productVO = (ProductVO) o;
        return Objects.equals(idProduct, productVO.idProduct);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idProduct);
    }
}
