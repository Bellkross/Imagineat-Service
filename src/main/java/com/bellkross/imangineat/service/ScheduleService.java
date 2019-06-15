package com.bellkross.imangineat.service;

import com.bellkross.imangineat.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService extends CrudServiceImpl<Schedule, Long> {

    @Autowired
    ScheduleService(JpaRepository<Schedule, Long> repository) {
        super(repository);
    }

}
