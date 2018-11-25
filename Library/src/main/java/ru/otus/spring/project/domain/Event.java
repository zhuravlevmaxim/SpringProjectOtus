package ru.otus.spring.project.domain;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
public class Event {

    @Id
    @Indexed
    private String id;
    private String clientX;
    private String clientY;
    private String pageX;
    private String pageY;
    private String type;
    private String innerHTML;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientX() {
        return clientX;
    }

    public void setClientX(String clientX) {
        this.clientX = clientX;
    }

    public String getClientY() {
        return clientY;
    }

    public void setClientY(String clientY) {
        this.clientY = clientY;
    }

    public String getPageX() {
        return pageX;
    }

    public void setPageX(String pageX) {
        this.pageX = pageX;
    }

    public String getPageY() {
        return pageY;
    }

    public void setPageY(String pageY) {
        this.pageY = pageY;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInnerHTML() {
        return innerHTML;
    }

    public void setInnerHTML(String innerHTML) {
        this.innerHTML = innerHTML;
    }
}
