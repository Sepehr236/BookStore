package com.example.Library.api;

import com.example.Library.dto.CommentRequest;
import com.example.Library.model.Comment;
import com.example.Library.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/Comment")
@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> addComment(CommentRequest commentRequest){
        return ResponseEntity.ok(commentService.addComment(commentRequest));
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable("commentId") Long commentId, @RequestBody Long bookId){
        commentService.deleteComment(commentId, bookId);
    }
}
