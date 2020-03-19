package ru.mikhniuk.sitestatistic.visit;

import java.util.Objects;

public class PeriodStatistic extends DayStatistic {
    public Integer countOfRegularUsers;

    public PeriodStatistic(Integer countOfVisiting, Integer countUniqUsers, Integer countOfRegularUsers) {
        super(countOfVisiting, countUniqUsers);
        this.countOfRegularUsers = countOfRegularUsers;
    }

    public Integer getCountOfRegularUsers() {
        return countOfRegularUsers;
    }

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
