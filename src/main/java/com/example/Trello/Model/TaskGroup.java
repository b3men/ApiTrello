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
public class TaskGroup {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "O campo 'name' não pode estar em branco")
    @Size(min = 3)
    private String name;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Task> tasksList;


}
