package br.com.eoc.web.client.service;

import br.com.eoc.web.client.dao.param.ParamDAO;
import br.com.eoc.web.client.dao.product.ProductDAO;
import br.com.eoc.web.client.enums.Parameters;
import br.com.eoc.web.client.vo.ParamVO;
import br.com.eoc.web.client.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParamService extends AbstractService {

    @Autowired
    private ParamDAO paramDAO;

    public ParamVO getByName(Parameters param) {
        return paramDAO.selectByName(param);
    }
}
