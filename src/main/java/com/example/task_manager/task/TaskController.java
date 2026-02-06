package com.example.task_manager.task;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    
    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public Task create(@RequestBody Task task, Authentication auth) {
        return service.createTask(task, auth.getName());
    }

   
    @GetMapping
    public List<Task> getTasks(Authentication auth) {
        return service.getTasks(auth.getName());
    }

    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/approve")
    public Task approve(@PathVariable Long id) {
        return service.approve(id);
    }

    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/reject")
    public Task reject(@PathVariable Long id) {
        return service.reject(id);
    }
}
