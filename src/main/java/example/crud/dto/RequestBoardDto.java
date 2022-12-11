package example.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestBoardDto {

    private Long id;

    @NotBlank(message = "공백 노노")
    private String title;

    @NotBlank
    private String content;
}
