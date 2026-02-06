package com.example.task_manager.analytics;

import com.example.task_manager.analytics.dto.*;
import com.example.task_manager.task.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsService {

    private final TaskRepository repo;

    public AnalyticsService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<TaskStatusCountDto> tasksByStatus() {
        return repo.countByStatus();
    }

    public List<DailyTaskCountDto> dailyTaskCount() {
        return repo.dailyTaskCount();
    }

}
