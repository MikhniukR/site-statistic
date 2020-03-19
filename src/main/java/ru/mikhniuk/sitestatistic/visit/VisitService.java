package ru.mikhniuk.sitestatistic.visit;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service

public class VisitService {
    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public VisitInfo save(VisitInfo visitInfo) {
        return visitRepository.save(visitInfo);
    }

    public DayStatistic getDayStatistic() {
        Date now = new Date();
        Date dayStart = new Date();
        dayStart.setHours(0);
        dayStart.setMinutes(0);
        dayStart.setSeconds(0);

        return new DayStatistic(
                visitRepository.getCount(dayStart, now),
                visitRepository.getUniqUsers(dayStart, now)
        );
    }

    public PeriodStatistic getPeriodStatistic(Date start, Date end) {
        return new PeriodStatistic(
                visitRepository.getCount(start, end),
                visitRepository.getUniqUsers(start, end),
                visitRepository.getUniqSuperUsers(start, end)
        );
    }
}
