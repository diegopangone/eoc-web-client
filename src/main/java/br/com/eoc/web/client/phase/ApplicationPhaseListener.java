package br.com.eoc.web.client.phase;

import br.com.eoc.web.client.bean.SessionBean;
import br.com.eoc.web.client.enums.Constantes;
import br.com.eoc.web.client.service.CustomerService;
import br.com.eoc.web.client.vo.CustomerVO;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.management.RuntimeMBeanException;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ApplicationPhaseListener implements PhaseListener {
    private static final long serialVersionUID = -1216620620302322995L;

    private static final Logger log = Logger.getLogger(ApplicationPhaseListener.class);

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        UIViewRoot currentUI = facesContext.getViewRoot();
        String currentPage = currentUI.getViewId();

        /*// Limpa a mensagem do header, toda vez que uma nova requisição for feita
        if (event.getPhaseId() == PhaseId.RESTORE_VIEW) {
            facesContext.getExternalContext().getSessionMap().put(Enum.HAS_INTERNAL_ERROR, Boolean.FALSE);
            facesContext.getExternalContext().getSessionMap().put(Enum.HAS_PAGE_ERROR, Boolean.FALSE);
            facesContext.getExternalContext().getSessionMap().put(Enum.MAP_ERRORS, null);
        }*/
    }

    @Override
    public void beforePhase(PhaseEvent event) {

        FacesContext facesContext = event.getFacesContext();

        //Se estiver iniciando uma nova requisição
        if (event.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            //Verifica se o usuário tem sessão ativa
            checkAndCreateUserSession(facesContext);
        }

        // Se for o evento de renderização da tela
        /*if (event.getPhaseId() == PhaseId.RENDER_RESPONSE) {

            // Se algum erro foi gerado, então exibir a mensagem de erro no header da tela, senão, limpa a mensagem da sessão, caso tenha alguma
            if (((Boolean) facesContext.getExternalContext().getSessionMap().get(Enum.HAS_PAGE_ERROR)).booleanValue()) {

                // Verifica se ja não foi setado a mensagem de erro para ser exibida no header da tela, caso não, seta a mensagem default
                if (!((Boolean) facesContext.getExternalContext().getSessionMap().get(Enum.HAS_INTERNAL_ERROR)).booleanValue()) {
                    ApplicationContext.showMessageInfo(FacesMessage.SEVERITY_ERROR, Messages.SYSTEM_ERRORS_FOUND, Messages.SYSTEM_ERRORS_ON_PAGE);
                }

                //Cria uma mapa de erros que será utilizado para a exibição dos ícones de erros na tela
                Map<String, String> errorMessages = new HashMap<String, String>();
                Iterator<String> compIds = facesContext.getClientIdsWithMessages();
                while (compIds.hasNext()) {
                    String id = compIds.next();
                    if (id != null && facesContext.getMessageList(id) != null && !facesContext.getMessageList(id).isEmpty()) {
                        String errorMessage = getErrorMessage(facesContext, id);

                        //Se for um erro gerado automaticamente pelo primefaces, então tem que obter só o final do id após o ":"
                        id = id.substring(id.lastIndexOf(":") + 1, id.length());
                        errorMessages.put(id, errorMessage);
                        log.info("Erro na validação de regra de negócio do componente: \"" + id + "\" Erro gerado: (" + errorMessage + ")");
                    }
                }

                facesContext.getExternalContext().getSessionMap().put(Enum.MAP_ERRORS, errorMessages);
            }
        }*/
    }

    /**
     * Método para obter todas as mensagem de erro que foram geradas para o devido componente
     *
     * @param context
     *            Contexto da aplicação
     * @param compID
     *            Componente exibido na tela
     * @return
     */
    private String getErrorMessage(FacesContext context, String compID) {
        String msgReturn = "";
        List<FacesMessage> listMessages = context.getMessageList(compID);
        for (FacesMessage errorMessage : listMessages) {
            msgReturn = msgReturn + "* " + errorMessage.getSummary() + "\n";
        }
        return msgReturn;
    }

    private void checkAndCreateUserSession(FacesContext facesContext) {
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

        // Controle de acesso de usuários, conforme perfil do mesmo
        CustomerVO loggedUser = (CustomerVO) session.getAttribute(Constantes.LOGGED_CUSTOMER);

        //Se não existir uma sessão ativa
        if (loggedUser == null) {

            //Verifica se o usuário fez o Login com sucesso
            SecurityContext context = SecurityContextHolder.getContext();
            if (context instanceof SecurityContext) {
                Authentication authentication = context.getAuthentication();
                if (authentication instanceof AnonymousAuthenticationToken) {
                    log.debug("Usuário não Logado");
                } else if (authentication instanceof Authentication) {
                    String email = ((User) authentication.getPrincipal()).getUsername();
                    this.putUserOnSession(email, session);
                }
            }
        }

    }

    private void putUserOnSession(String email, HttpSession session) {

        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());

        CustomerService customerService = ctx.getBean(CustomerService.class);

        CustomerVO loggedUser = customerService.getDataOnLogin(email);

        log.info("Registrando sessão para o usuário: " + loggedUser.getEmail());

        //Coloca o usuário em um parâmetro na sessão
        session.setAttribute(Constantes.LOGGED_CUSTOMER, loggedUser);

        //Coloca o usuário no ManagedBean de sessão
        SessionBean sessionBean = ctx.getBean(SessionBean.class);
        sessionBean.setLoggedCustomer(loggedUser);
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}