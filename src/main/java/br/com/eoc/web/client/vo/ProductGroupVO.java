/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eoc.web.client.vo;

import java.util.List;

public class ProductGroupVO extends AbstractVO {
    private static final long serialVersionUID = 1L;

    private Integer idProductGroup;
    private String description;
    private boolean isActive;
    private List<ProductSubGroupVO> listSubGroups;

    @Override
    public Integer getId() {
        return this.idProductGroup;
    }

    public Integer getIdProductGroup() {
        return idProductGroup;
    }

    public void setIdProductGroup(Integer idProductGroup) {
        this.idProductGroup = idProductGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductSubGroupVO> getListSubGroups() {
        return listSubGroups;
    }

    public void setListSubGroups(List<ProductSubGroupVO> listSubGroups) {
        this.listSubGroups = listSubGroups;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
