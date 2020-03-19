package ru.mikhniuk.sitestatistic.visit;

import java.util.Objects;

/**
 * The Day statistic.
 */
public class DayStatistic {
    /**
     * The Count of visiting.
     */
    public Integer countOfVisiting;
    /**
     * The Count uniq users.
     */
    public Integer countUniqUsers;

    /**
     * Instantiates a new Day statistic.
     *
     * @param countOfVisiting the count of visiting
     * @param countUniqUsers  the count uniq users
     */
    public DayStatistic(Integer countOfVisiting, Integer countUniqUsers) {
        this.countOfVisiting = countOfVisiting;
        this.countUniqUsers = countUniqUsers;
    }

    /**
     * Gets count of visiting.
     *
     * @return the count of visiting
     */
    public Integer getCountOfVisiting() {
        return countOfVisiting;
    }

    /**
     * Sets count of visiting.
     *
     * @param countOfVisiting the count of visiting
     */
    public void setCountOfVisiting(Integer countOfVisiting) {
        this.countOfVisiting = countOfVisiting;
    }

    /**
     * Gets count uniq users.
     *
     * @return the count uniq users
     */
    public Integer getCountUniqUsers() {
        return countUniqUsers;
    }

    /**
     * Sets count uniq users.
     *
     * @param countUniqUsers the count uniq users
     */
    public void setCountUniqUsers(Integer countUniqUsers) {
        this.countUniqUsers = countUniqUsers;
    }

    @Override
    public String toString() {
        return "DayStatistic{" +
                "countOfVisiting=" + countOfVisiting +
                ", countUniqUsers=" + countUniqUsers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof DayStatistic)) return false;
        DayStatistic that = (DayStatistic) o;
        return Objects.equals(getCountOfVisiting(), that.getCountOfVisiting()) &&
                Objects.equals(getCountUniqUsers(), that.getCountUniqUsers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountOfVisiting(), getCountUniqUsers());
    }
}
