package ru.mikhniuk.sitestatistic.visit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PeriodStatistic extends DayStatistic {
    public Integer countOfRegularUsers;

    public PeriodStatistic(Integer countOfVisiting, Integer countUniqUsers, Integer countOfRegularUsers) {
        super(countOfVisiting, countUniqUsers);
        this.countOfRegularUsers = countOfRegularUsers;
    }

    public PeriodStatistic(List<VisitInfo> statistic) {
        super(statistic);
        Map<String, Integer> visitCount = new HashMap<>();
        statistic.forEach(v -> {
            if(visitCount.containsKey(v.getUserId())) {
                visitCount.put(v.getUserId(), visitCount.get(v.getUserId()) + 1);
            }
            else {
                visitCount.put(v.getUserId(), 1);
            }
        });
        this.countOfRegularUsers = 0;
        visitCount.forEach((k, v) -> {
            if(v >= 10) {
                countOfRegularUsers++;
            }
        });
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
