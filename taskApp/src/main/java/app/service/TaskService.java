package app.service;

import app.dto.TaskDTO;
import app.entity.DraftTask;
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

    public List<TaskDTO> findAllTasks() {
        List<DraftTask> draftTaskEntities = taskRepository.findAll();
        ArrayList<TaskDTO> taskDTOs = new ArrayList<>();
        for (DraftTask task : draftTaskEntities) {
            taskDTOs.add(makeATaskDTO(new TaskDTO(), task));
        }
        return taskDTOs;
    }

    public TaskDTO findTaskById(Long id){
        return makeATaskDTO(new TaskDTO(), taskRepository.getById(id));
    }

    private TaskDTO makeATaskDTO(TaskDTO taskDTO, DraftTask task) {
        taskDTO.setId(task.getId());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setUserId(task.getUserId());

        return taskDTO;
    }

    private DraftTask makeATask(TaskDTO taskDTO, DraftTask task) {
        taskDTO.setId(task.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setUserId(taskDTO.getUserId());

        return task;
    }

    public TaskDTO saveTask(TaskDTO taskDTO) {
        DraftTask task = new DraftTask();

        taskRepository.save(makeATask(taskDTO, task));
        taskDTO.setId(task.getId());
        return taskDTO;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public TaskDTO editTask(TaskDTO taskDTO) {
        DraftTask task = taskRepository.findById(taskDTO.getId()).orElseThrow(EntityNotFoundException::new);
        task.setId(taskDTO.getId());

        taskRepository.save(makeATask(taskDTO, task));
        return taskDTO;
    }

    public TaskDTO findById(Long userId) {
        DraftTask task = taskRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        return makeATaskDTO(new TaskDTO(), task);
    }
}
