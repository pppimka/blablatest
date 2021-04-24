package com.blablacar.palii.repo;

import com.blablacar.palii.entity.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, String> {
}
