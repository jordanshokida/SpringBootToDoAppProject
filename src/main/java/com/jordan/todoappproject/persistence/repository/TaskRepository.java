package com.jordan.todoappproject.persistence.repository;

import com.jordan.todoappproject.persistence.entity.Task;
import com.jordan.todoappproject.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findAllByTaskStatus(TaskStatus status);


    @Modifying
    @Query(value = "UPDATE TASK SET IS_FINISHED=TRUE WHERE ID=:id", nativeQuery = true)
    public void markTaskAsFinished(@Param("id") Long id);

}
