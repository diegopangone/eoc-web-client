package br.com.eoc.web.client.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean(name = "appInfoBean")
@Controller
@ApplicationScope
public class AppInfoBean implements Serializable {

    private String version;
    private String name;
    private String buildDate;
    private String description;
    private String ppackage;
    private String deployedServer;
    private String deployedNode;

    private static AppInfoBean instance;

    public static AppInfoBean getInstance(){
        return instance;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
        instance = this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPpackage() {
        return ppackage;
    }

    public void setPpackage(String ppackage) {
        this.ppackage = ppackage;
    }

    public String getDeployedServer() {
        return deployedServer;
    }

    public void setDeployedServer(String deployedServer) {
        this.deployedServer = deployedServer;
    }

    public String getDeployedNode() {
        return deployedNode;
    }

    public void setDeployedNode(String deployedNode) {
        this.deployedNode = deployedNode;
    }
}
