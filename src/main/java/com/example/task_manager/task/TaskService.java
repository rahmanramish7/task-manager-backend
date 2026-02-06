package com.example.task_manager.task;

import com.example.task_manager.exception.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

  
    @Transactional
    public Task createTask(Task task, String username) {

        if (isAdmin()) {
            throw new BusinessException("ADMIN cannot create tasks");
        }

        task.setTaskNumber(generateTaskNumber());
        task.setStatus(TaskStatus.CREATED);
        task.setCreatedBy(username);
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(null);

        return repo.save(task);
    }

   
    @Transactional(readOnly = true)
    public List<Task> getTasks(String username) {
        return isAdmin()
                ? repo.findAll()
                : repo.findByCreatedBy(username);
    }

   
    @Transactional
    public Task approve(Long id) {

        Task task = getTaskOrThrow(id);

        if (task.getStatus() != TaskStatus.CREATED) {
            throw new BusinessException("Task already finalized");
        }

        task.setStatus(TaskStatus.APPROVED);
        task.setUpdatedAt(LocalDateTime.now());

        return repo.save(task);
    }

   
    @Transactional
    public Task reject(Long id) {

        Task task = getTaskOrThrow(id);

        if (task.getStatus() != TaskStatus.CREATED) {
            throw new BusinessException("Task already finalized");
        }

        task.setStatus(TaskStatus.REJECTED);
        task.setUpdatedAt(LocalDateTime.now());

        return repo.save(task);
    }

   

    private Task getTaskOrThrow(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found with id: " + id));
    }

    private boolean isAdmin() {
        Authentication auth = SecurityContextHolder
                .getContext()
                .getAuthentication();

        return auth.getAuthorities()
                .stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
    }

    private String generateTaskNumber() {
        long count = repo.count() + 1;
        return "TASK-" + String.format("%04d", count);
    }
}
