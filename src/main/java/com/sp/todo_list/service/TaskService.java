package com.sp.todo_list.service;

import com.sp.todo_list.models.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskService {

    public Task createNewTask(Task task);
    public List<Task> getAllTask();
    public Optional<Task> findTaskById(Long id);

    public List<Task> findAllCompletedTask();
    public List<Task> findAllInCompleteTask();
    public void deleteTask(Task task);
    public Task updateTask(Task task);

}
