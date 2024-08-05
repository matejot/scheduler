package ironhack.com.scheduler.repository;

import ironhack.com.scheduler.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepository extends JpaRepository <Site, Integer> {
}
