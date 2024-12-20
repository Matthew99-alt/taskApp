package app.mapper;

import app.dto.TaskDTO;
import app.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task makeATask(TaskDTO taskDTO) {
        if (taskDTO == null) {
            throw new IllegalArgumentException("taskDTO cannot be null");
        }

        Task task = new Task();
        task.setTitle(taskDTO.title());
        task.setDescription(taskDTO.description());
        task.setUserId(taskDTO.userId());

        return task;
    }

    public TaskDTO makeATaskDTO(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }

        return new TaskDTO(task.getId(), task.getTitle(), task.getDescription(), task.getUserId());

    }
}
