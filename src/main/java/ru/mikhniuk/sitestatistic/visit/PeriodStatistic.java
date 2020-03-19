package ru.mikhniuk.sitestatistic.visit;

import java.util.Objects;

/**
 * The Period statistic.
 */
public class PeriodStatistic extends DayStatistic {
    /**
     * The Count of regular users.
     */
    public Integer countOfRegularUsers;

    /**
     * Instantiates a new Period statistic.
     *
     * @param countOfVisiting     the count of visiting
     * @param countUniqUsers      the count uniq users
     * @param countOfRegularUsers the count of regular users
     */
    public PeriodStatistic(Integer countOfVisiting, Integer countUniqUsers, Integer countOfRegularUsers) {
        super(countOfVisiting, countUniqUsers);
        this.countOfRegularUsers = countOfRegularUsers;
    }

    /**
     * Gets count of regular users.
     *
     * @return the count of regular users
     */
    public Integer getCountOfRegularUsers() {
        return countOfRegularUsers;
    }

    /**
     * Sets count of regular users.
     *
     * @param countOfRegularUsers the count of regular users
     */
    public void setCountOfRegularUsers(Integer countOfRegularUsers) {
        this.countOfRegularUsers = countOfRegularUsers;
    }

    @Override
    public boolean equals(Object o) {
        if(!super.equals(o)) return false;
        PeriodStatistic that = (PeriodStatistic) o;
        return Objects.equals(getCountOfRegularUsers(), that.getCountOfRegularUsers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCountOfRegularUsers());
    }

    @Override
    public String toString() {
        return "PeriodStatistic{" +
                "countOfRegularUsers=" + countOfRegularUsers +
                '}';
    }
}
