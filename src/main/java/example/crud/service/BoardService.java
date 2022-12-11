package example.crud.service;

import example.crud.entity.Board;
import example.crud.dto.RequestBoardDto;
import example.crud.dto.ResponseBoardDto;
import example.crud.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void write(RequestBoardDto boardDto) {
        Board board = Board.builder()
                        .title(boardDto.getTitle())
                        .content(boardDto.getContent())
                        .build();
        boardRepository.save(board);
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    public void edit( RequestBoardDto boardDto) {
        Board board = boardRepository.findById(boardDto.getId()).get();
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());

        boardRepository.save(board);
    }

    public List<ResponseBoardDto> showAllBoardList() {
        return boardRepository.findAll().stream()
                .map(ResponseBoardDto::new)
                .collect(Collectors.toList());
    }

    public ResponseBoardDto showBoardById(Long id) {
        Board board = boardRepository.findById(id).get();
        return ResponseBoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }

}
