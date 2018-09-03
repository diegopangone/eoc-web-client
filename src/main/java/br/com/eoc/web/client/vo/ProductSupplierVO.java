package br.com.eoc.web.client.vo;

public class ProductSupplierVO extends AbstractVO {

    private Integer idProductSupplier;
    private SupplierVO supplierVO;
    private ProductCertificateVO productCertificateVO;
    private ProductVO productVO;
    private Float cost;
    private Float percGain;
    private String detail;
    private boolean showOnInitSalePage;

    @Override
    public Integer getId() {
        return this.idProductSupplier;
    }

    public Integer getIdProductSupplier() {
        return idProductSupplier;
    }

    public void setIdProductSupplier(Integer idProductSupplier) {
        this.idProductSupplier = idProductSupplier;
    }

    public SupplierVO getSupplierVO() {
        return supplierVO;
    }

    public void setSupplierVO(SupplierVO supplierVO) {
        this.supplierVO = supplierVO;
    }

    public ProductCertificateVO getProductCertificateVO() {
        return productCertificateVO;
    }

    public void setProductCertificateVO(ProductCertificateVO productCertificateVO) {
        this.productCertificateVO = productCertificateVO;
    }

    public ProductVO getProductVO() {
        return productVO;
    }

    public void setProductVO(ProductVO productVO) {
        this.productVO = productVO;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Float getPercGain() {
        return percGain;
    }

    public void setPercGain(Float percGain) {
        this.percGain = percGain;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public boolean isShowOnInitSalePage() {
        return showOnInitSalePage;
    }

    public void setShowOnInitSalePage(boolean showOnInitSalePage) {
        this.showOnInitSalePage = showOnInitSalePage;
    }


}

