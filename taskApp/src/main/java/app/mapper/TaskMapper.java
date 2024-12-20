package app.mapper;

import app.dto.TaskDTO;
import app.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task makeATask(TaskDTO taskDTO) {
        if(taskDTO == null){
            return new Task();
        }

        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setUserId(taskDTO.getUserId());

        return task;
    }

    public TaskDTO makeATaskDTO(Task task) {
        if(task == null){
            return new TaskDTO();
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId(task.getId());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setUserId(task.getUserId());

        return taskDTO;
    }
}
