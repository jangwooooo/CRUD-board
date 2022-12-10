package example.crud.service;

import example.crud.entity.Board;
import example.crud.entity.BoardDto;
import example.crud.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void write(BoardDto boardDto) {
        Board board = Board.builder()
                        .title(boardDto.getTitle())
                        .content(boardDto.getContent())
                        .build();
        boardRepository.save(board);
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    public void edit(BoardDto boardDto) {
        Board board = boardRepository.findById(boardDto.getId()).get();
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());

        boardRepository.save(board);
    }

    public List showAllBoardList() {
        return boardRepository.findAll();
    }

}
