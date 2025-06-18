package com.example.Trello.Service;

import com.example.Trello.Model.Board;
import com.example.Trello.Repository.BoardRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepo;

    public Board create(Board board) {
        return boardRepo.save(board);
    }

    public List<Board> saveAll(List<Board> boards) {
        return boardRepo.saveAll(boards);
    }

    public Board findById(Long id) {
        return boardRepo.findById(id).orElseThrow(() -> new RuntimeException("Board não encontrado"));
    }

    public List<Board> getAllBoard() {
        return List.of();
    }

    public List<Board> listAll() {
        return boardRepo.findAll();
    }

    public BoardService(BoardRepository boardRepo) {
        this.boardRepo = boardRepo;
    }

    public Board update(Long id, @Valid Board board) {
        Board existing = boardRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Board não encontrado"));
        existing.setName(board.getName());
        existing.setDescription(board.getDescription());
        return boardRepo.save(existing);
    }


}
