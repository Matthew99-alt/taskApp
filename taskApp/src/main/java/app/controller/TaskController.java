package app.controller;

import app.dto.TaskDTO;
import app.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/all")
    public List<TaskDTO> getAllUsers() {
        return taskService.findAllTasks();
    }

    @GetMapping("/one")
    public TaskDTO getATask(@RequestParam("id") Long id){
        return taskService.findTaskById(id);
    }

    @PostMapping("/save")
    public TaskDTO saveUser(@RequestBody TaskDTO taskDTO) {
        return taskService.saveTask(taskDTO);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam("id") Long id) {
        taskService.deleteTask(id);
    }

    @PutMapping("/edit")
    public TaskDTO editUser(@RequestBody TaskDTO taskDTO) {
        return taskService.editTask(taskDTO);
    }
}
