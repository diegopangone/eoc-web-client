package br.com.eoc.web.client.vo;

import java.util.Objects;

public class SupplierVO extends AbstractVO{

    private Integer idSupplier;
    private String comporateName;
    private String financyName;

    @Override
    public Integer getId() {
        return this.idSupplier;
    }

    public Integer getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Integer idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getComporateName() {
        return comporateName;
    }

    public void setComporateName(String comporateName) {
        this.comporateName = comporateName;
    }

    public String getFinancyName() {
        return financyName;
    }

    public void setFinancyName(String financyName) {
        this.financyName = financyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierVO)) return false;
        SupplierVO that = (SupplierVO) o;
        return Objects.equals(idSupplier, that.idSupplier);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idSupplier);
    }
}
