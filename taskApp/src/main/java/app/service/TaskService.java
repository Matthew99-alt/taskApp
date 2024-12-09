package app.service;

import app.dto.TaskDTO;
import app.entity.Task;
import app.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<TaskDTO> findAllTasks() { // todo: to Stream Api
        List<Task> taskEntities = taskRepository.findAll();
        ArrayList<TaskDTO> taskDTOs = new ArrayList<>();
        for (Task task : taskEntities) {
            taskDTOs.add(makeATaskDTO(new TaskDTO(), task));
        }
        return taskDTOs;
    }

    public TaskDTO findTaskById(Long id){
        Task task = taskRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return makeATaskDTO(new TaskDTO(), task);
    }

    public TaskDTO saveTask(TaskDTO taskDTO) {
        Task task = new Task(); // todo: перенести создание пустого объекта в сам маппер(mapToDto, mapToEntity) - makeATask
        taskRepository.save(makeATask(taskDTO, task));

        taskDTO.setId(task.getId());
        return taskDTO;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public TaskDTO editTask(TaskDTO taskDTO) {
        Task task = taskRepository.findById(taskDTO.getId()).orElseThrow(EntityNotFoundException::new);

        taskRepository.save(makeATask(taskDTO, task));
        return taskDTO;
    }

    //TODO: очень по желанию посмотреть mapStruct
    private TaskDTO makeATaskDTO(TaskDTO taskDTO, Task task) {
        taskDTO.setId(task.getId());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setUserId(task.getUserId());

        return taskDTO;
    }

    private Task makeATask(TaskDTO taskDTO, Task task) {
        taskDTO.setId(task.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setUserId(taskDTO.getUserId());

        return task;
    }
}
