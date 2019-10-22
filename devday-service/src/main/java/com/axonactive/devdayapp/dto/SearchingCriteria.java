package com.axonactive.devdayapp.dto;

public class SearchingCriteria {
    
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SearchingCriteria [");
        sb.append("keyword=");
        sb.append(keyword);
        sb.append("]");
        return sb.toString();
    }
}

