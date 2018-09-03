package br.com.eoc.web.client.service;

import br.com.eoc.web.client.dao.productgroup.ProductGroupDAO;
import br.com.eoc.web.client.vo.ProductGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductGroupService extends AbstractService {

    @Autowired
    private ProductGroupDAO productGroupDAO;

    public List<ProductGroupVO> getAtivesGroupsAndSubGroups(){

        List<ProductGroupVO> listGroup = productGroupDAO.selectActiveGroups();

        listGroup.forEach( group -> {
            group.setListSubGroups(productGroupDAO.selectActiveSubGroupsByGroup(group));
        });

        return listGroup;
    }
}
