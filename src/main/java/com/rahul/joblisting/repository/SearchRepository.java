package com.rahul.joblisting.repository;

import com.rahul.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
