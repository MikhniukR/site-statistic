package ru.mikhniuk.sitestatistic.visit;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class VisitService {
    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public VisitInfo save(VisitInfo visitInfo) {
        return visitRepository.save(visitInfo);
    }

    public List<VisitInfo> findByTime(Date start, Date end) {
        return visitRepository.findAll().stream().filter(
                v -> v.getCreatedAt().after(start) && v.getCreatedAt().before(end)
                ).collect(Collectors.toList());
    }
}
