package ru.mikhniuk.sitestatistic.visit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VisitRepositoryTest {

    @Autowired
    private VisitRepository visitRepository;

    @Test
    void addVisit() {
        VisitInfo visitInfo = new VisitInfo("userId", "siteUrl");
        VisitInfo visitInfoSaved = visitRepository.save(visitInfo);

        assertNotNull(visitInfoSaved);
    }

    @Test
    void getUniqUsers() {
        VisitInfo user1 = new VisitInfo("user1", "siteUrl");
        VisitInfo user2 = new VisitInfo("user2", "siteUrl");
        visitRepository.save(user1);
        visitRepository.save(user2);

        assertEquals(2, visitRepository.getCountUniqUsers(user1.getCreatedAt(), user2.getCreatedAt()));
    }

    @Test
    void getCount() {
        VisitInfo user1 = new VisitInfo("user1", "siteUrl");
        VisitInfo user2 = new VisitInfo("user1", "siteUrl");
        VisitInfo user1ComeBack = new VisitInfo("user1", "siteUrlElse");
        visitRepository.save(user1);
        visitRepository.save(user2);
        visitRepository.save(user1ComeBack);

        assertEquals(3, visitRepository
                .getCountOfVisiting(user1.getCreatedAt(), user1ComeBack.getCreatedAt()));
    }

    @Test
    void getUniqSuperUsers() {
        VisitInfo user1 = new VisitInfo("user1", "siteUrl");
        Date start = user1.getCreatedAt();
        for(int i = 0; i < 10; i++) {
            visitRepository.save(user1);
            user1 = new VisitInfo("user1", Integer.valueOf(i).toString());
        }
        VisitInfo user2 = new VisitInfo("user1", "siteUrl");
        for(int i = 0; i < 9; i++) {
            visitRepository.save(user2);
            user2 = new VisitInfo("user2", Integer.valueOf(i).toString());
        }
        Date end = user2.getCreatedAt();

        assertEquals(1, visitRepository.getCountOfUniqRegularUsers(start, end));
    }
}