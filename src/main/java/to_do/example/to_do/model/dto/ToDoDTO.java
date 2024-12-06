package to_do.example.to_do.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ToDoDTO {

    private Long code;
    private String title;
    private String description;
    private boolean completed;
    private String date;


}
