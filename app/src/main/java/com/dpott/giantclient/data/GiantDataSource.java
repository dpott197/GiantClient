package com.dpott.giantclient.data;

import com.dpott.giantclient.data.model.game.GameResponse;
import com.dpott.giantclient.data.source.DataSource;
import com.dpott.giantclient.data.source.RemoteDataSource;

import io.reactivex.Observable;

public class GiantDataSource implements DataSource {

    protected static GiantDataSource INSTANCE;

    private DataSource remoteDataSource;

    public GiantDataSource(DataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public static void init(boolean shouldLog) {
        INSTANCE = new GiantDataSource(
                new RemoteDataSource(shouldLog)
        );
    }

    public static GiantDataSource getInstance() {
        return INSTANCE;
    }

    @Override
    public Observable<GameResponse> getGameResponse(String id) {
        return remoteDataSource.getGameResponse(id);
    }

}
