package br.com.eoc.web.client.service;

import br.com.eoc.web.client.dao.customer.CustomerDAO;
import br.com.eoc.web.client.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends AbstractService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private RouteService routeService;

    public CustomerVO getCustomerByEmail(String email){
        return customerDAO.selectCustomerByEmail(email);
    }

    public void updateDataAccess(CustomerVO customerVO){
        customerDAO.updateDataAccess(customerVO);
    }

    public CustomerVO getDataOnLogin(String email){

        CustomerVO customerVO = getCustomerByEmail(email);

        customerVO.setListRoutes(routeService.getRoutesByCustomer(customerVO));

        return customerVO;
    }
}
