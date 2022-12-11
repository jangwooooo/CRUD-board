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
    public String boardWrite(@RequestBody RequestBoardDto boardDto) {
        boardService.write(boardDto);
        return null;
    }

    @ResponseBody
    @DeleteMapping("/board/delete/{id}")
    public String boardDelete(@PathVariable Long id) {
        boardService.delete(id);
        return null;
    }

    @ResponseBody
    @PutMapping("/board/edit")
    public String boardEdit(@RequestBody RequestBoardDto boardDto) {
        boardService.edit(boardDto);
        return null;
    }

    @ResponseBody
    @GetMapping("/board/list")
    public List<ResponseBoardDto> boardList() {
        return boardService.showAllBoardList();
    }

    @ResponseBody
    @PostMapping("/board/list/{id}")
    public ResponseEntity<ResponseBoardDto> boardListID(@PathVariable Long id) {
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return new ResponseEntity<>(boardService.showBoardById(id),headers, HttpStatus.OK);
    }
}
