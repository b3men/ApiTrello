package com.example.Trello.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Board {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "O campo 'name' não pode estar em branco")
    @Size(min = 3)
    private String name;
    private String description;
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    public List<TaskGroup> boardList;
}
