package ru.mikhniuk.sitestatistic.visit;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * The Visit info.
 */
@Entity

public class VisitInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String userId;

    private String siteUrl;

    @CreationTimestamp
    private Date createdAt;

    /**
     * Instantiates a new Visit info.
     */
    public VisitInfo() {
    }

    /**
     * Instantiates a new Visit info.
     *
     * @param userId  the user id
     * @param siteUrl the site url
     */
    public VisitInfo(String userId, String siteUrl) {
        this();
        this.userId = userId;
        this.siteUrl = siteUrl;
        this.createdAt = Calendar.getInstance().getTime();
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets site url.
     *
     * @return the site url
     */
    public String getSiteUrl() {
        return siteUrl;
    }

    /**
     * Sets site url.
     *
     * @param siteUrl the site url
     */
    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
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
