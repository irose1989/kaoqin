package com.isoftstone.kaoqin.controller.vo;

/**
 * Created by wb-chenchaobin on 2015/10/8.
 */
public class SearchConditions {
    private String from;
    private String to;
    private Integer projectId;
    private Integer month;
    private Integer year;
    private Integer currentPage;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "SearchConditions{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", projectId=" + projectId +
                ", month=" + month +
                ", year=" + year +
                ", currentPage=" + currentPage +
                '}';
    }
}
