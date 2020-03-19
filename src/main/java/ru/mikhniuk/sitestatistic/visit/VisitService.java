package ru.mikhniuk.sitestatistic.visit;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * The Visit service.
 */
@Service

public class VisitService {
    private final VisitRepository visitRepository;

    /**
     * Instantiates a new Visit service.
     *
     * @param visitRepository the visit repository
     */
    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    /**
     * Save visit info.
     *
     * @param visitInfo the visit info
     * @return the visit info
     */
    public VisitInfo save(VisitInfo visitInfo) {
        return visitRepository.save(visitInfo);
    }

    /**
     * Gets day statistic.
     *
     * @return the day statistic
     */
    public DayStatistic getDayStatistic() {
        Date now = new Date();
        Date dayStart = new Date();
        dayStart.setHours(0);
        dayStart.setMinutes(0);
        dayStart.setSeconds(0);

        return new DayStatistic(
                visitRepository.getCountOfVisiting(dayStart, now),
                visitRepository.getCountUniqUsers(dayStart, now)
        );
    }

    /**
     * Gets period statistic.
     *
     * @param start the start
     * @param end   the end
     * @return the period statistic
     */
    public PeriodStatistic getPeriodStatistic(Date start, Date end) {
        return new PeriodStatistic(
                visitRepository.getCountOfVisiting(start, end),
                visitRepository.getCountUniqUsers(start, end),
                visitRepository.getCountOfUniqRegularUsers(start, end)
        );
    }
}
