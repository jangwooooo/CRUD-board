package example.crud.entity;

import lombok.Data;

@Data
public class BoardDto {

    private Long id;
    private String title;
    private String content;
}
