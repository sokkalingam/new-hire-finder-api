package com.zoominfo.techfest.newhirefinder.model;

import java.util.Objects;

public class Contact {

    private String name;
    private String companyName;
    private String phone;
    private String email;
    private Double absScore;
    private Double score;
    private String jobTitle;
    private String lat;
    private String lng;
    private String avgTimeInPosition;
    private String changedAJobLastYear;
    private String numJobChangesLast10Years;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getAvgTimeInPosition() {
        return avgTimeInPosition;
    }

    public void setAvgTimeInPosition(String avgTimeInPosition) {
        this.avgTimeInPosition = avgTimeInPosition;
    }

    public String getChangedAJobLastYear() {
        return changedAJobLastYear;
    }

    public void setChangedAJobLastYear(String changedAJobLastYear) {
        this.changedAJobLastYear = changedAJobLastYear;
    }

    public String getNumJobChangesLast10Years() {
        return numJobChangesLast10Years;
    }

    public void setNumJobChangesLast10Years(String numJobChangesLast10Years) {
        this.numJobChangesLast10Years = numJobChangesLast10Years;
    }

    public Double getAbsScore() {
        return absScore;
    }

    public void setAbsScore(Double absScore) {
        this.absScore = absScore;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Contact{");
        sb.append("name='").append(name).append('\'');
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", score=").append(score);
        sb.append(", jobTitle='").append(jobTitle).append('\'');
        sb.append(", lat='").append(lat).append('\'');
        sb.append(", lng='").append(lng).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return name.equals(contact.name) &&
                companyName.equals(contact.companyName) &&
                phone.equals(contact.phone) &&
                email.equals(contact.email) &&
                absScore.equals(contact.absScore) &&
                score.equals(contact.score) &&
                jobTitle.equals(contact.jobTitle) &&
                lat.equals(contact.lat) &&
                lng.equals(contact.lng) &&
                avgTimeInPosition.equals(contact.avgTimeInPosition) &&
                changedAJobLastYear.equals(contact.changedAJobLastYear) &&
                numJobChangesLast10Years.equals(contact.numJobChangesLast10Years);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, companyName, phone, email, absScore, score, jobTitle, lat, lng, avgTimeInPosition, changedAJobLastYear, numJobChangesLast10Years);
    }
}
