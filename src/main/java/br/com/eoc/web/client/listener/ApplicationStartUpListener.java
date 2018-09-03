package br.com.eoc.web.client.listener;

import org.jboss.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationStartUpListener implements ServletContextListener{

    private static StringBuilder projectInfo = new StringBuilder();
    private static Logger log = Logger.getLogger(ApplicationStartUpListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        /*String appVersion = AppInfoBean.getInstance().getVersion();

        projectInfo.append("\n  _____            ___                                   _                   ____                                                             \n");
        projectInfo.append(" | ____|          / _ \\   _ __    __ _    __ _   _ __   (_)   ___   ___     / ___|   ___    _ __ ___    _ __ ___     ___   _ __    ___    ___ \n");
        projectInfo.append(" |  _|    _____  | | | | | '__|  / _` |  / _` | | '_ \\  | |  / __| / __|   | |      / _ \\  | '_ ` _ \\  | '_ ` _ \\   / _ \\ | '__|  / __|  / _ \\\n");
        projectInfo.append(" | |___  |_____| | |_| | | |    | (_| | | (_| | | | | | | | | (__  \\__ \\   | |___  | (_) | | | | | | | | | | | | | |  __/ | |    | (__  |  __/\n");
        projectInfo.append(" |_____|          \\___/  |_|     \\__, |  \\__,_| |_| |_| |_|  \\___| |___/    \\____|  \\___/  |_| |_| |_| |_| |_| |_|  \\___| |_|     \\___|  \\___|\n");
        projectInfo.append("                                 |___/                                                                                                         v " + appVersion);


        log.warn(projectInfo + " Iniciado \n");*/

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.warn(projectInfo + " Finalizado \n");
    }
}
