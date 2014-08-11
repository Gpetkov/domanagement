package com.newintelligence.domanagement.datamodel.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.newintelligence.domanagement.datamodel.Comment;

public interface CommentDao extends PagingAndSortingRepository<Comment, Long> {
}
