package br.com.eoc.web.client.vo;

import br.com.eoc.web.client.enums.DayOfWeek;

import java.util.Date;

public class RouteVO extends AbstractVO{

    private Integer idRoute;
    private String description;
    private Float rateDelivery;
    private boolean isActive;
    private DayOfWeek deliveryDay;
    private Date dateDelivery;

    @Override
    public Integer getId() {
        return this.idRoute;
    }

    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public Integer getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Integer idRoute) {
        this.idRoute = idRoute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getRateDelivery() {
        return rateDelivery;
    }

    public void setRateDelivery(Float rateDelivery) {
        this.rateDelivery = rateDelivery;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public DayOfWeek getDeliveryDay() {
        return deliveryDay;
    }

    public void setDeliveryDay(DayOfWeek deliveryDay) {
        this.deliveryDay = deliveryDay;
    }
}
