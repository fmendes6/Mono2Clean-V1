package com.clean.sharednode.solution1.view;

import com.clean.sharednode.solution1.model.Comment;
import com.clean.sharednode.solution1.model.Post;

import java.util.List;


public interface IHomeView {

    void onPostLoaded(Post post);

    void onCommentsLoaded(List<Comment> comments);

    void onError(String error);
}
