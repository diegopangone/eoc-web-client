package br.com.eoc.web.client.service;

import br.com.eoc.web.client.dao.route.RouteDAO;
import br.com.eoc.web.client.enums.Parameters;
import br.com.eoc.web.client.vo.CustomerVO;
import br.com.eoc.web.client.vo.ParamVO;
import br.com.eoc.web.client.vo.RouteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class RouteService extends AbstractService {

    @Autowired
    private RouteDAO routeDAO;

    @Autowired
    private ParamService paramService;

    public List<RouteVO> getRoutesByCustomer(CustomerVO customerVO){
        List<RouteVO> listRoutes = routeDAO.selectRoutesByCustomer(customerVO);

        listRoutes.forEach( routeVO -> {
            setNextDateOfDelivery(routeVO);
        });

        //Ordena pela data de entrega mais próxima
        Collections.sort(listRoutes, new Comparator<RouteVO>() {
            @Override
            public int compare(RouteVO o1, RouteVO o2) {
                return o1.getDateDelivery().compareTo(o2.getDateDelivery());
            }
        });

        return listRoutes;
    }

    private void setNextDateOfDelivery(RouteVO route)  {
        if (route != null) {
            //Obtém a data configurada no parâmetro
            ParamVO param = paramService.getByName(Parameters.QTDE_HORAS_CORTE_DISPONIBILIDADE_VENDA_DA_ROTA);
            Integer qtdeHoursToRemove = Integer.parseInt(param.getValue());

            //Obtém a data atual, e adiciona o dia da entrega da rota, e desconta a quantidade de horas configurada no parâmetro
            Calendar dayOfDelivery = Calendar.getInstance();
            dayOfDelivery.set(Calendar.DAY_OF_WEEK, route.getDeliveryDay().getValue());
            dayOfDelivery.set(Calendar.HOUR_OF_DAY, 0);
            dayOfDelivery.set(Calendar.MINUTE, 0);
            dayOfDelivery.set(Calendar.SECOND, 0);
            dayOfDelivery.add(Calendar.HOUR_OF_DAY, -qtdeHoursToRemove);

            //Verifica se a data de entrega da rota, subtraída da quantidade de horas do parâmetro, já expirou em relação a data atual
            //Se sim, então calcula a próxima data da entrega, senão, utiliza a data gerada acima
            if (Calendar.getInstance().getTime().after(dayOfDelivery.getTime())) {
                dayOfDelivery = Calendar.getInstance();
                dayOfDelivery.set(Calendar.DAY_OF_WEEK, route.getDeliveryDay().getValue());
                dayOfDelivery.set(Calendar.HOUR_OF_DAY, 0);
                dayOfDelivery.set(Calendar.MINUTE, 0);
                dayOfDelivery.set(Calendar.SECOND, 0);
                dayOfDelivery.add(Calendar.DAY_OF_MONTH, 7);
                route.setDateDelivery(dayOfDelivery.getTime());
            } else {
                dayOfDelivery = Calendar.getInstance();
                dayOfDelivery.set(Calendar.DAY_OF_WEEK, route.getDeliveryDay().getValue());
                dayOfDelivery.set(Calendar.HOUR_OF_DAY, 0);
                dayOfDelivery.set(Calendar.MINUTE, 0);
                dayOfDelivery.set(Calendar.SECOND, 0);
                route.setDateDelivery(dayOfDelivery.getTime());
            }
        }
    }
}
