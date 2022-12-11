package example.crud.controller;

import example.crud.dto.RequestBoardDto;
import example.crud.dto.ResponseBoardDto;
import example.crud.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @ResponseBody
    @PostMapping("/board/write")
    public ResponseEntity<Void> boardWrite(@RequestBody RequestBoardDto boardDto) {
        boardService.write(boardDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ResponseBody
    @DeleteMapping("/board/delete/{id}")
    public ResponseEntity<Void> boardDelete(@PathVariable Long id) {
        boardService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ResponseBody
    @PutMapping("/board/edit")
    public ResponseEntity<Void> boardEdit(@RequestBody RequestBoardDto boardDto) {
        boardService.edit(boardDto);
        return ResponseEntity.ok().build();
    }

    @ResponseBody
    @GetMapping("/board/list")
    public List<ResponseBoardDto> boardList() {
        return boardService.showAllBoardList();
    }

    @ResponseBody
    @PostMapping("/board/list/{id}")
    public ResponseEntity<ResponseBoardDto> boardListID(@PathVariable Long id) {
        ResponseBoardDto board = boardService.showBoardById(id);
        return ResponseEntity.ok().body(board);
    }
}
