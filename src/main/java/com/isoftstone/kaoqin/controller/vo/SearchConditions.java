package com.isoftstone.kaoqin.controller.vo;

/**
 * Created by wb-chenchaobin on 2015/10/8.
 */
public class SearchConditions {
    private String from;
    private System to;
    private Integer projectId;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public System getTo() {
        return to;
    }

    public void setTo(System to) {
        this.to = to;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "SearchConditions{" +
                "from='" + from + '\'' +
                ", to=" + to +
                ", projectId=" + projectId +
                '}';
    }
}
