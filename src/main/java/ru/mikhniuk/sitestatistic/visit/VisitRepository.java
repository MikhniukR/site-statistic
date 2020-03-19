package ru.mikhniuk.sitestatistic.visit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * The interface Visit repository extends JPARepository.
 */
public interface VisitRepository extends JpaRepository<VisitInfo, Long> {
    /**
     * Gets count uniq users.
     *
     * @param start the start
     * @param end   the end
     * @return the uniq users
     */
    @Query(value = "SELECT COUNT(DISTINCT v.userId) FROM VisitInfo v " +
            "WHERE v.createdAt  >= :start AND v.createdAt <= :end")
    Integer getCountUniqUsers(@Param("start") Date start,
                              @Param("end") Date end);

    /**
     * Gets count of visiting.
     *
     * @param start the start
     * @param end   the end
     * @return the count of visiting
     */
    @Query(value = "SELECT COUNT(v) FROM VisitInfo v " +
            "WHERE v.createdAt  >= :start AND v.createdAt <= :end")
    Integer getCountOfVisiting(@Param("start") Date start,
                               @Param("end") Date end);

    /**
     * Gets count of uniq regular users.
     * Regular user - visit not less than 10 page.
     *
     * @param start the start
     * @param end   the end
     * @return the count of uniq regular users
     */
    @Query(value = "SELECT COUNT(DISTINCT v.userId) FROM VisitInfo v " +
            "WHERE v.createdAt  >= :start AND v.createdAt <= :end " +
            "GROUP BY v.userId " +
            "HAVING COUNT(distinct v.siteUrl) >= 10")
    Integer getCountOfUniqRegularUsers(@Param("start") Date start,
                                       @Param("end") Date end);

}
