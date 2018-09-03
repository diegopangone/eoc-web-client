package br.com.eoc.web.client.vo;

import java.util.Objects;

public class ProductCertificateVO extends AbstractVO {

    private Integer idProductCertificate;
    private String acronym;
    private String description;

    @Override
    public Integer getId() {
        return this.idProductCertificate;
    }

    public Integer getIdProductCertificate() {
        return idProductCertificate;
    }

    public void setIdProductCertificate(Integer idProductCertificate) {
        this.idProductCertificate = idProductCertificate;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductCertificateVO)) return false;
        ProductCertificateVO that = (ProductCertificateVO) o;
        return Objects.equals(idProductCertificate, that.idProductCertificate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idProductCertificate);
    }
}
