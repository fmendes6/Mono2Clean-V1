package com.clean.sharednode.solution1.presenters;

import com.clean.sharednode.solution1.model.Comment;
import com.clean.sharednode.solution1.model.Post;
import com.clean.sharednode.solution1.presenters.rest.ApiProvider;
import com.clean.sharednode.solution1.presenters.rest.PostApi;
import com.clean.sharednode.solution1.view.IHomeView;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class HomePresenter {

    private PostApi mApi;
    private IHomeView mView;

    public HomePresenter(IHomeView view) {
        mApi = ApiProvider.getApi().create(PostApi.class);
        mView = view;
    }

    public void loadPost(final int postId){
        mApi.getPostById(postId, new Callback<Post>() {
            public void success(Post post, Response response) {
                mView.onPostLoaded(post);
            }

            @Override
            public void failure(RetrofitError error) {
                mView.onError(error.getMessage());
            }
        });
    }


    public void loadComments(int postId){
        mApi.getPostComments(postId, new Callback<List<Comment>>() {
            @Override
            public void success(List<Comment> commentList, Response response) {
                mView.onCommentsLoaded(commentList);
            }

            @Override
            public void failure(RetrofitError error) {
                mView.onError(error.getMessage());
            }
        });
    }
}
