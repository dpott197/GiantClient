package com.dpott.giantclient.data.source;

import com.dpott.giantclient.data.model.game.GameResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by dpott on 8/14/2017.
 */

public interface DataSource {

    @GET("game/{id}")
    Observable<GameResponse> getGameResponse(@Path("id") String id);

}
