package com.food.ordering.system.cdsbackend.repository;

import com.food.ordering.system.cdsbackend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
