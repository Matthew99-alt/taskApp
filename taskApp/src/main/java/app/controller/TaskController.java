package app.controller;

import app.dto.TaskDTO;
import app.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/all")
    public List<TaskDTO> getAllTasks() {
        return taskService.findAllTasks();
    }

    @GetMapping("/one")
    public TaskDTO getATask(@RequestParam("id") Long id) {
        return taskService.findTaskById(id);
    }

    @PostMapping("/save")
    public TaskDTO saveATask(@RequestBody TaskDTO taskDTO) {
        return taskService.saveTask(taskDTO);
    }

    @DeleteMapping("/delete")
    public void deleteATask(@RequestParam("id") Long id) {
        taskService.deleteTask(id);
    }

    @PutMapping("/edit")
    public TaskDTO editATask(@RequestBody TaskDTO taskDTO) {
        return taskService.editTask(taskDTO);
    }

    @GetMapping("/restricted")
    public String restrictedAccess() throws BadRequestException {
        boolean hasAccess = false;

        if (!hasAccess) {
            throw new BadRequestException();
        }

        return "Welcome to the restricted area!";
    }
}
