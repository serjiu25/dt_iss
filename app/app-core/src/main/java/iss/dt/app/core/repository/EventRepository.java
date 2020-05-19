package iss.dt.app.core.repository;

import iss.dt.app.core.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
