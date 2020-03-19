package ru.mikhniuk.sitestatistic.visit;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class DayStatistic {
    public Integer countOfVisiting;
    public Integer countUniqUsers;

    public DayStatistic(Integer countOfVisiting, Integer countUniqUsers) {

    }

    public DayStatistic(List<VisitInfo> statistic) {
        this.countOfVisiting = statistic.size();
        Set<String> users = new HashSet<>();
        statistic.stream().forEach(v -> users.add(v.getUserId()));
        this.countUniqUsers = users.size();
    }

    public Integer getCountOfVisiting() {
        return countOfVisiting;
    }

    public void setCountOfVisiting(Integer countOfVisiting) {
        this.countOfVisiting = countOfVisiting;
    }

    public Integer getCountUniqUsers() {
        return countUniqUsers;
    }

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
