package com.example.task_manager.analytics;

import com.example.task_manager.analytics.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final AnalyticsService service;

    public AnalyticsController(AnalyticsService service) {
        this.service = service;
    }

    @GetMapping("/tasks-by-status")
    public List<TaskStatusCountDto> tasksByStatus() {
        return service.tasksByStatus();
    }

    @GetMapping("/daily-task-count")
    public List<DailyTaskCountDto> dailyTaskCount() {
        return service.dailyTaskCount();
    }

}
