package com.backend.template.service;

import com.backend.template.dto.input.UpdateStoryComment;
import com.backend.template.dto.response.PageResponseBuilder;
import com.backend.template.exception.RecordNotFoundException;
import com.backend.template.locale.Translator;
import com.backend.template.model.StoryComment;
import com.backend.template.paging.PagingInfo;
import com.backend.template.repositories.StoryCommentRepository;
import com.backend.template.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;


@Component
public class StoryCommentService {
    @Autowired
    StoryCommentRepository storyCommentRepository;

    public PagingInfo<StoryComment> getAllStoryComments(Integer page, Integer size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<StoryComment> storyComments = storyCommentRepository.findAll(pageable);
        return PageResponseBuilder.buildPagingData(storyComments, storyComments.getPageable());
    }

    public StoryComment getStoryComment(String id) {
        return storyCommentRepository.findById(id).orElseThrow(()
                -> new RecordNotFoundException(Translator.toLocale("error.msg.record.not_found")));
    }

    public StoryComment createStoryComment(StoryComment storyComment) {
        storyComment.setCommentedTime(Utils.getUnixTimeInSecond());
        return storyCommentRepository.save(storyComment);
    }

    public StoryComment updateStoryComment(UpdateStoryComment updateStoryComment, String id) {
        StoryComment storyComment = storyCommentRepository.findById(id).orElseThrow(()
                -> new RecordNotFoundException(Translator.toLocale("error.msg.record.not_found")));

        storyComment.setContent(updateStoryComment.getContent());
        storyComment.setStatus(updateStoryComment.getStatus());

        return storyCommentRepository.save(storyComment);
    }
}
