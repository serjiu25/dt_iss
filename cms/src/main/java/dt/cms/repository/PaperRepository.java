package dt.cms.repository;

import dt.cms.domain.Paper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperRepository extends JpaRepository<Paper, Integer> {
}
