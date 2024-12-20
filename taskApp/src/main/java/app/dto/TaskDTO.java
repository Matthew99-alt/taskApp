package app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO { // TODO: to record (P.S: как я понял сеттеры несовместимы с record'ом, так как данные record'а неизменяемые)

    private Long id;

    private String title;

    private String description;

    private Long userId;

}
