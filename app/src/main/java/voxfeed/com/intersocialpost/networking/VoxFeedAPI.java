package voxfeed.com.intersocialpost.networking;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import voxfeed.com.intersocialpost.model.PostFull;

/**
 * Created by rjasso on 02/02/2017.
 */

public interface VoxFeedAPI {
    String BASE_URL = "https://api.voxfeed.com";

    @GET("/public/promoted_messages")
    Call<List<PostFull>> getPosts();
}
