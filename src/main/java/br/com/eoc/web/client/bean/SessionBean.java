package br.com.eoc.web.client.bean;


import br.com.eoc.web.client.service.CustomerService;
import br.com.eoc.web.client.service.ProductGroupService;
import br.com.eoc.web.client.vo.CustomerVO;
import br.com.eoc.web.client.vo.ProductGroupVO;
import br.com.eoc.web.client.vo.RouteVO;
import org.apache.commons.collections4.CollectionUtils;
import org.jboss.logging.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.model.menu.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import java.util.Collections;
import java.util.List;

@Controller
@ManagedBean(name = "sessionBean")
@SessionScope
public class SessionBean extends AbstractBean {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductGroupService productGroupService;

    private CustomerVO loggedCustomer;
    private RouteVO selectedRoute;
    private Float saleCost;
    private Integer productsAmount;
    private List<ProductGroupVO> listProductGroups;

    private MenuModel modelMenuGroups;

    private static final Logger log = Logger.getLogger(SessionBean.class);

    @Override
    protected void initBean() {
        this.saleCost = 0F;
        this.productsAmount = 0;
        buildProductGroupsMenu();
    }

    public CustomerVO getLoggedCustomer() {
        return loggedCustomer;
    }

    public void setLoggedCustomer(CustomerVO loggedCustomer) {
        this.loggedCustomer = loggedCustomer;

        //Atualiza os dados de acesso do usário
        customerService.updateDataAccess(loggedCustomer);

        //Obtém a data de entrega mais próxima como defualt
        if(CollectionUtils.isNotEmpty(loggedCustomer.getListRoutes())){
            this.selectedRoute = loggedCustomer.getListRoutes().get(0);
        }

        //Zera o valor da venda
        this.saleCost = 9999.99F;
        this.productsAmount = 73;


    }

    public RouteVO getSelectedRoute() {
        return selectedRoute;
    }

    public void setSelectedRoute(RouteVO selectedRoute) {
        this.selectedRoute = selectedRoute;
    }

    public void setSaleValueOfCookie(){
        this.saleCost = 0F;
        String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("saleCost");
        System.out.println(this.saleCost);
    }

    public Float getSaleCost() {
        return saleCost;
    }

    public void setSaleCost(Float saleCost) {
        this.saleCost = saleCost;
    }

    public Integer getProductsAmount() {
        return productsAmount;
    }

    public void setProductsAmount(Integer productsAmount) {
        this.productsAmount = productsAmount;
    }

    public List<ProductGroupVO> getListProductGroups() {

        //Obtém a lista de grupos de produtos caso ainda não tenha carregado na sessão
        if( CollectionUtils.isEmpty(this.listProductGroups) ){
            this.listProductGroups = productGroupService.getAtivesGroupsAndSubGroups();
            buildProductGroupsMenu();
        }

        return listProductGroups;
    }

    public void setListProductGroups(List<ProductGroupVO> listProductGroups) {
        this.listProductGroups = listProductGroups;
    }

    private void buildProductGroupsMenu(){

        //Constrói o menu uma única vez para a sessão do usuário
        if( CollectionUtils.isEmpty(this.listProductGroups) ) {
            this.listProductGroups = productGroupService.getAtivesGroupsAndSubGroups();

            modelMenuGroups = new DefaultMenuModel();

            this.listProductGroups.forEach(productGroupVO -> {

                DefaultSubMenu menuGroup = new DefaultSubMenu(productGroupVO.getDescription());
                modelMenuGroups.addElement(menuGroup);
               /* addMenu("File", "New", "Open", "Close", "Exit");
                addMenu("Edit", "Undo", "Redo", "Cut", "Copy");
                addMenu("View", "Summary", "Settings", "Layout");
                addMenu("Help", "Help topics", "Support");*/
            });

        }
    }

    private void addMenu(String label, String... items) {

        DefaultMenuColumn column = new DefaultMenuColumn();

        //a submenu inside column
        DefaultSubMenu theColumnMenu = new DefaultSubMenu(label);
        column.addElement(theColumnMenu);

        for (Object item : items) {
            DefaultMenuItem mi = new DefaultMenuItem(item);
            mi.setUrl("#");
            theColumnMenu.addElement(mi);
        }
        //the main menu has columns instead of items
        //rootMenuGroups.addElement(column);
    }

    public MenuModel getModelMenuGroups() {
        buildProductGroupsMenu();
        return modelMenuGroups;
    }
}
