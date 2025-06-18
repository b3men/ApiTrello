package com.example.Trello.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    private String name;
    @ManyToOne(optional = false)
    private Task task;


    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Task> tasksList;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
