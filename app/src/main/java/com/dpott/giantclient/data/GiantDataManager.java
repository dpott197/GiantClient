package com.dpott.giantclient.data;

import com.dpott.giantclient.data.model.game.GameResponse;
import com.dpott.giantclient.data.source.DataSource;
import com.dpott.giantclient.data.source.RemoteDataSource;

import io.reactivex.Observable;

public class GiantDataManager implements DataSource {

    protected static GiantDataManager INSTANCE;

    private DataSource remoteDataSource;

    public GiantDataManager(DataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public static void init(boolean shouldLog) {
        INSTANCE = new GiantDataManager(
                new RemoteDataSource(shouldLog)
        );
    }

    public static GiantDataManager getInstance() {
        return INSTANCE;
    }

    @Override
    public Observable<GameResponse> getGameResponse(String id) {
        return remoteDataSource.getGameResponse(id);
    }

}
