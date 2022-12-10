package example.crud.controller;

import example.crud.entity.BoardDto;
import example.crud.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board/write")
    public String boardWrite(@RequestBody BoardDto boardDto) {
        boardService.write(boardDto);
        return "test";
    }

    @DeleteMapping("/board/delete/{id}")
    public String boardDelete(@PathVariable Long id) {
        boardService.delete(id);
        return "test";
    }

    @PutMapping("/board/edit")
    public String boardEdit(@RequestBody BoardDto boardDto) {
        boardService.edit(boardDto);
        return "test";
    }

    @ResponseBody
    @GetMapping("/board/list")
    public List boardList() {
        return boardService.showAllBoardList();
    }
}
