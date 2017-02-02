package voxfeed.com.intersocialpost.interactors;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import voxfeed.com.intersocialpost.model.Post;
import voxfeed.com.intersocialpost.networking.VoxFeedAPI;
import voxfeed.com.intersocialpost.presenters.PostPresenterImpl;

/**
 * Created by rjasso on 02/02/2017.
 */

public class ServerRequestImpl implements ServerRequest {
    @Override
    public void getPosts(final PostPresenterImpl presenter) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(VoxFeedAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VoxFeedAPI voxFeedAPI = retrofit.create(VoxFeedAPI.class);

        voxFeedAPI.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                presenter.updatePost(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                presenter.showFailureMessage();
            }
        });
    }
}