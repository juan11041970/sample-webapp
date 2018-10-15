package com.jda.application;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "LoginResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoginResult", propOrder = {"errorMessage", "status"})
public class WebLoginResult {

    List<WebLoginResult> results = new ArrayList<>();

    @XmlElement
    private String errorMessage;

    @XmlElement
    private String status;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlElement(name="LoginResult")
    public List<WebLoginResult> getResults() {
        return this.results;
    }
}
