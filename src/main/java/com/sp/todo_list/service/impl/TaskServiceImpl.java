package com.sp.todo_list.service.impl;

import com.sp.todo_list.models.Task;
import com.sp.todo_list.repositories.TaskRepository;
import com.sp.todo_list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("TaskService")
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createNewTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> findAllCompletedTask() {
        return taskRepository.findByCompletedTrue();
    }

    @Override
    public List<Task> findAllInCompleteTask() {
        return taskRepository.findByCompletedFalse();
    }

    @Override
    public void deleteTask(Task task) {
         taskRepository.delete(task);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }


}
