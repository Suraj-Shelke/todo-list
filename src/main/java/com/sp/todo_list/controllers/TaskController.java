package com.sp.todo_list.controllers;

import com.sp.todo_list.models.Task;
import com.sp.todo_list.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    @Autowired
    private TaskServiceImpl taskService;
    @GetMapping("/")
    public List<Task> getAllTasks(){
        return taskService.getAllTask();
    }
    @GetMapping("/completed")
    public List<Task> getAllCompletedTasks(){
        return taskService.findAllCompletedTask();
    }
    @GetMapping("/incomplete")
    public List<Task> getAllIncompleteTasks(){
        return taskService.findAllInCompleteTask();
    }
    @PostMapping("/")
    public Task createTask(@RequestBody Task task){
        return taskService.createNewTask(task);
    }

    @GetMapping("/{id}")
    public Optional<Task> getTask(@PathVariable Long id){
        return taskService.findTaskById(id);
    }
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task){
        task.setId(id);
        return taskService.updateTask(task);
    }
    @DeleteMapping("/{id}")
    public boolean deleteTask(@PathVariable Long id){

        Optional<Task> task =taskService.findTaskById(id);
        System.out.println("task="+task);
        if(task.isPresent()) {
            taskService.deleteTask(task.get());
            return true;
        }
        else
            return false;
    }
}
