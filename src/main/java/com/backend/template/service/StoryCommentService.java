package com.backend.template.service;

import com.backend.template.exception.RecordNotFoundException;
import com.backend.template.model.StoryComment;
import com.backend.template.repositories.StoryCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StoryCommentService {
    @Autowired
    StoryCommentRepository storyCommentRepository;

    public List<StoryComment> getAllStoryComments() {
        return storyCommentRepository.findAll();
    }

    public Object getStoryComment(String id) {
        return storyCommentRepository.findById(id).orElseThrow(()
                -> new RecordNotFoundException("Không tồn tại!"));
    }

    public Object createStoryComment(StoryComment storyComment){
//        return storyCommentRepository.save(storyComment);
        return "Success";
    }

    public Object updateStoryComment(StoryComment storyComment){
//        return storyCommentRepository.save(storyComment);
        return "Success";
    }
}
