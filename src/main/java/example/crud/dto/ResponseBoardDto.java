package example.crud.dto;

import example.crud.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBoardDto {

    private Long id;
    private String title;
    private String content;

    public ResponseBoardDto(Board board) {
    }
}
