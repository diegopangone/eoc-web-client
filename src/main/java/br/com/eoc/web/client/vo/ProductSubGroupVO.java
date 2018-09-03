/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eoc.web.client.vo;

public class ProductSubGroupVO extends AbstractVO {
    private static final long serialVersionUID = 1L;

    private Integer idProductSubGroup;
    private String description;
    private boolean isActive;

    @Override
    public Integer getId() {
        return this.idProductSubGroup;
    }

    public Integer getIdProductSubGroup() {
        return idProductSubGroup;
    }

    public void setIdProductSubGroup(Integer idProductSubGroup) {
        this.idProductSubGroup = idProductSubGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
