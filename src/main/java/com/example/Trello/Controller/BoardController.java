package com.example.Trello.Controller;

import com.example.Trello.Model.Board;
import com.example.Trello.Service.BoardService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardService service;

    public BoardController(BoardService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Board> create(@RequestBody @Valid Board board) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(board));
    }

    @GetMapping
    public List<Board> list() {
        return service.findAll();
    }

    // Implementar buscar por ID, atualizar, deletar
}

