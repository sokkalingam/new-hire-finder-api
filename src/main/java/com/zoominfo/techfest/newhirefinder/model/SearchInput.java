package com.zoominfo.techfest.newhirefinder.model;

public class SearchInput {

    private String companyName;
    private String jobTitle;
    private Double score;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SearchInput{");
        sb.append("companyName='").append(companyName).append('\'');
        sb.append(", jobTitle='").append(jobTitle).append('\'');
        sb.append(", confidenceScore=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
