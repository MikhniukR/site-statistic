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

@RestController
@RequestMapping("/api/visit")
public class VisitApi {
    private final VisitService visitService;

    @Autowired
    public VisitApi(VisitService visitService) {
        this.visitService = visitService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestParam("userId") String userId,
                                    @RequestParam("siteUrl") String siteUrl) {
        VisitInfo visitInfo = new VisitInfo(userId, siteUrl);
        visitService.save(visitInfo);

        return ResponseEntity.ok(visitService.getDayStatistic());
    }

    @GetMapping
    public ResponseEntity<?> getPeriodStatistic(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date start,
            @RequestParam("end")   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date end) {
        return ResponseEntity.ok(visitService.getPeriodStatistic(start, end));
    }
}
