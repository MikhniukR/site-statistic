package ru.mikhniuk.sitestatistic.visit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<VisitInfo, String> {
}
