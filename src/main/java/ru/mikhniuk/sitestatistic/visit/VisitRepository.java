package ru.mikhniuk.sitestatistic.visit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface VisitRepository extends JpaRepository<VisitInfo, Long> {
    @Query(value = "SELECT COUNT(DISTINCT v.userId) FROM VisitInfo v " +
            "WHERE v.createdAt  >= :start AND v.createdAt <= :end")
    Integer getUniqUsers(@Param("start") Date start,
                         @Param("end") Date end);

    @Query(value = "SELECT COUNT(v) FROM VisitInfo v " +
            "WHERE v.createdAt  >= :start AND v.createdAt <= :end")
    Integer getCount(@Param("start") Date start,
                         @Param("end") Date end);

    @Query(value = "SELECT COUNT(DISTINCT v.userId) FROM VisitInfo v " +
            "WHERE v.createdAt  >= :start AND v.createdAt <= :end " +
            "GROUP BY v.userId " +
            "HAVING COUNT(distinct v.siteUrl) >= 10")
    Integer getUniqSuperUsers(@Param("start") Date start,
                         @Param("end") Date end);

}
