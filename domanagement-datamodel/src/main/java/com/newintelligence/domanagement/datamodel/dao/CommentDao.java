package com.newintelligence.domanagement.datamodel.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.newintelligence.domanagement.datamodel.Comment;

@Repository
public interface CommentDao extends PagingAndSortingRepository<Comment, Long> {
}
