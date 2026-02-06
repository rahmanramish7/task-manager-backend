package com.example.task_manager.task;

import com.example.task_manager.analytics.dto.*;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByCreatedBy(String username);

    @Query(value = """
        SELECT status AS status, COUNT(*) AS count
        FROM tasks
        GROUP BY status
    """, nativeQuery = true)
    List<TaskStatusCountDto> countByStatus();

    @Query(value = """
    	    SELECT DATE(created_at) AS date, COUNT(*) AS count
    	    FROM tasks
    	    GROUP BY DATE(created_at)
    	""", nativeQuery = true)
    	List<DailyTaskCountDto> dailyTaskCount();
}
