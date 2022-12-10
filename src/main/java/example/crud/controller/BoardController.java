package example.crud.controller;

import example.crud.entity.BoardDto;
import example.crud.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board/write")
    public String boardWrite(@RequestBody BoardDto boardDto) {
        boardService.write(boardDto);
        return "test";
    }
}
