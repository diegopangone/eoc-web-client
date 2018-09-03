package br.com.eoc.web.client.session;

import org.jboss.logging.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener("ApplicationSessionListener")
public class ApplicationSessionListener implements HttpSessionListener {

    private static Logger log = Logger.getLogger(ApplicationSessionListener.class);

    private int sessionCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        synchronized (this) {
            sessionCount++;
        }

        log.debug("########## Sessão Criada " + se.getSession().getId() + " ##########");
        log.debug("########## Sessões Ativas " + sessionCount + " ##########");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        synchronized (this) {
            sessionCount--;
        }

        log.debug("########## Sessão Desconectada " + se.getSession().getId()+" ##########");
        log.debug("########## Sessões Ativas " + sessionCount + " ##########");
    }
}
