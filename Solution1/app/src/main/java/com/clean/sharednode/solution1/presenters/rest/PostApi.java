package com.clean.sharednode.solution1.presenters.rest;

import com.clean.sharednode.solution1.model.Comment;
import com.clean.sharednode.solution1.model.Post;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;


public interface PostApi {

    @GET("/posts/{postId}")
    void getPostById(@Path("postId") int postId, Callback<Post> callback);

    @GET("/posts/{postId}/comments")
    void getPostComments(@Path("postId") int postId, Callback<List<Comment>> callback);
}
