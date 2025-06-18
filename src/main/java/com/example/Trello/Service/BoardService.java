package com.example.Trello.Service;

import com.example.Trello.Model.Board;
import com.example.Trello.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private final BoardRepository boardRepo;

    public BoardService(BoardRepository boardRepo) {
        this.boardRepo = boardRepo;
    }

    public Board create(Board board) {
        return boardRepo.save(board);
    }

    public List<Board> findAll() {
        return List.of();
    }
}
