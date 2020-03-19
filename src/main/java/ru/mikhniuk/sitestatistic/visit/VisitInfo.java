package ru.mikhniuk.sitestatistic.visit;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Entity

public class VisitInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String userId;

    private String siteUrl;

    @CreationTimestamp
    private Date createdAt;

    public VisitInfo() {
    }

    public VisitInfo(String userId, String siteUrl) {
        this();
        this.userId = userId;
        this.siteUrl = siteUrl;
        this.createdAt = Calendar.getInstance().getTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof VisitInfo)) return false;
        VisitInfo visitInfo = (VisitInfo) o;
        return Objects.equals(getId(), visitInfo.getId()) &&
                Objects.equals(getSiteUrl(), visitInfo.getSiteUrl()) &&
                Objects.equals(getCreatedAt(), visitInfo.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSiteUrl(), getCreatedAt());
    }

    @Override
    public String toString() {
        return "VisitInfo{" +
                "id='" + id + '\'' +
                ", siteUrl='" + siteUrl + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
