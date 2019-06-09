package com.bellkross.imangineat.respository;

import com.bellkross.imangineat.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
