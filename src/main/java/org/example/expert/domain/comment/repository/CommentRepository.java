package org.example.expert.domain.comment.repository;

import org.example.expert.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c JOIN c.user WHERE c.todo.id = :todoId")
    List<Comment> findByTodoIdWithUser(@Param("todoId") Long todoId);

    //comment를 가져올 때, user도 가져오게 하는
    @Query("SELECT c FROM Comment c"+
    "JOIN FETCH c.user"+ //user를 fetch join으로 즉시로딩시킴
    "WHERE c.todo.id =:todoId")
    List<Comment> findByTodoIdWithUser(@Param("todoId") long todoId);
}
