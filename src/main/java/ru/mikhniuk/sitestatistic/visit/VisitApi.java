package ru.mikhniuk.sitestatistic.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * The Visit api.
 */
@RestController
@RequestMapping("/api/visit")
public class VisitApi {
    private final VisitService visitService;

    /**
     * Instantiates a new Visit api.
     *
     * @param visitService the visit service
     */
    @Autowired
    public VisitApi(VisitService visitService) {
        this.visitService = visitService;
    }

    /**
     * Create response entity. And return day statistic
     * countOfVisiting countUniqUsers
     * @param userId  the user id
     * @param siteUrl the site url
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestParam("userId") String userId,
                                    @RequestParam("siteUrl") String siteUrl) {
        VisitInfo visitInfo = new VisitInfo(userId, siteUrl);
        visitService.save(visitInfo);

        return ResponseEntity.ok(visitService.getDayStatistic());
    }

    /**
     * Gets period statistic.
     * countOfVisiting countUniqUsers countOfRegularUsers
     *
     * @param start the start
     * @param end   the end
     * @return the period statistic
     */
    @GetMapping
    public ResponseEntity<?> getPeriodStatistic(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date start,
            @RequestParam("end")   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date end) {
        return ResponseEntity.ok(visitService.getPeriodStatistic(start, end));
    }
}
