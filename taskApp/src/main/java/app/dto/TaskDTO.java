package app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO { // TODO: to record

    private Long id;

    private String title;

    private String description;

    private Long userId;

}
