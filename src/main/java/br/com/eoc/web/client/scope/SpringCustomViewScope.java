package br.com.eoc.web.client.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Diego
 * Date: 27/05/13
 * Time: 00:15
 * To change this template use File | Settings | File Templates.
 */
public class SpringCustomViewScope implements Scope {

    @SuppressWarnings("unchecked")
    public Object get(String name, ObjectFactory objectFactory) {
        Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();
        //FacesContext.getCurrentInstance().getViewRoot()


        if (viewMap.containsKey(name)) {
            return viewMap.get(name);
        } else {
            Object object = objectFactory.getObject();
            viewMap.put(name, object);

            return object;
        }
    }

    public Object remove(String name) {
        return FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(name);
    }

    public String getConversationId() {
        return null;
    }

    public void registerDestructionCallback(String name, Runnable callback) {
        //Not supported
    }

    public Object resolveContextualObject(String key) {
        return null;
    }
}
