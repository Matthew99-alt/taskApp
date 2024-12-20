package app.service;

import app.dto.TaskDTO;
import app.entity.Task;
import app.mapper.TaskMapper;
import app.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    public List<TaskDTO> findAllTasks() {
        List<Task> taskEntities = taskRepository.findAll();
        return taskEntities.stream().map(taskMapper::makeATaskDTO).collect(Collectors.toList());
    }

    public TaskDTO findTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return taskMapper.makeATaskDTO(task);
    }

    public TaskDTO saveTask(TaskDTO taskDTO) {
        Task savedTask = taskRepository.save(taskMapper.makeATask(taskDTO));
        return taskMapper.makeATaskDTO(savedTask);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public TaskDTO editTask(TaskDTO taskDTO) {
        Task task = taskMapper.makeATask(taskDTO);
        task.setId(taskDTO.id());
        taskRepository.save(task);
        return taskDTO;
    }
}
