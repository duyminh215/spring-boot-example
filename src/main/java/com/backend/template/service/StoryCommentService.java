package com.backend.template.service;

import com.backend.template.controller.BaseController;
import com.backend.template.dto.input.CreateStoryComment;
import com.backend.template.dto.input.UpdateStoryComment;
import com.backend.template.dto.response.PageResponseBuilder;
import com.backend.template.exception.RecordNotFoundException;
import com.backend.template.exception.RequestInvalidException;
import com.backend.template.locale.Translator;
import com.backend.template.model.StoryComment;
import com.backend.template.paging.PagingInfo;
import com.backend.template.repositories.StoryCommentRepository;
import com.backend.template.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class StoryCommentService {

    @Autowired
    StoryCommentRepository storyCommentRepository;

    ModelMapper mapper = new ModelMapper();

    public PagingInfo<StoryComment> getAllStoryComments(Pageable pageable) {
        Page<StoryComment> storyComments = storyCommentRepository.findAll(pageable);
        return PageResponseBuilder.buildPagingData(storyComments, storyComments.getPageable());
    }

    public StoryComment getStoryComment(String id) {
        return storyCommentRepository.findById(id).orElseThrow(()
                -> new RecordNotFoundException(Translator.toLocale("error.msg.record.not_found")));
    }

    public StoryComment createStoryComment(CreateStoryComment createStoryComment, Long userId) {
        StoryComment storyComment = mapper.map(createStoryComment, StoryComment.class);
        storyComment.setCommentedTime(Utils.getUnixTimeInSecond());
        storyComment.setUserId(userId);
        return storyCommentRepository.save(storyComment);
    }

    public StoryComment updateStoryComment(UpdateStoryComment updateStoryComment, Long userId) {
        StoryComment storyComment = storyCommentRepository.findById(updateStoryComment.getId()).orElseThrow(()
                -> new RecordNotFoundException(Translator.toLocale("error.msg.record.not_found")));
        if(storyComment.getUserId() != userId){
            throw new RequestInvalidException(Translator.toLocale("error.msg.request.invalid"));
        }
        storyComment.setContent(updateStoryComment.getContent());
        storyComment.setStatus(updateStoryComment.getStatus());

        return storyCommentRepository.save(storyComment);
    }
}
