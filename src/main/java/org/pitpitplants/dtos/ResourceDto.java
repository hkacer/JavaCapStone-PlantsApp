package org.pitpitplants.dtos;

import lombok.Data;

// Resource DTO class
@Data
public class ResourceDto {
    private Long id;
    private String title;
    private String link;
    private Long userId;

    public ResourceDto() {}

    public ResourceDto(Long id, String title, String link, Long userId) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getUser(){
    return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}