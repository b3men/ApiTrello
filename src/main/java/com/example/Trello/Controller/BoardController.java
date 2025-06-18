package com.example.Trello.Controller;

import com.example.Trello.Model.Board;
import com.example.Trello.Service.BoardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping //Lista todos os boards
    public ResponseEntity<List<Board>> getAllBoards() {
        return new ResponseEntity<>(boardService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") //Busca pelo ID
    public ResponseEntity<Board> getBoardById(@PathVariable Long id) {
        return new ResponseEntity<>(boardService.findById(id), HttpStatus.OK);
    }

    @PostMapping //Cria um novo board
    public ResponseEntity<Board> createBoard(@RequestBody @Valid Board board) {
        return ResponseEntity.status(HttpStatus.CREATED).body(boardService.create(board));
    }

    @PostMapping("/save-all") //Salva
    public ResponseEntity<List<Board>> saveAllBoards(@RequestBody @Valid List<Board> boards) {
        return ResponseEntity.status(HttpStatus.CREATED).body(boardService.saveAll(boards));
    }

    @PutMapping("/{id}") //Atualiza o board existente
    public ResponseEntity<Board> updateBoard(@PathVariable Long id, @RequestBody @Valid Board board) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.update(id, board));
    }
}

