package com.example.Trello.Repository;

import com.example.Trello.Model.Board;
import com.example.Trello.Model.TaskGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskGroupRepository extends JpaRepository<TaskGroup, Long> {}
