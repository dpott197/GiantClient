package com.dpott.giantclient.data;

import com.dpott.giantclient.C;
import com.dpott.giantclient.data.model.game.GameResponse;
import com.dpott.giantclient.data.source.RemoteDataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.fail;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GiantHttpGiantBombApiTest {

    @Before
    public void before() {
        RemoteDataSource.init(true);
    }

    @After
    public void after() {

    }

    @Test
    public void getGameById() throws Exception {
        RemoteDataSource.getInstance().getGameResponse(C.GAME_ID_HALO_COMBAT_EVOLVED)
                .observeOn(Schedulers.trampoline())
                .subscribeOn(Schedulers.trampoline())
                .subscribe(new Observer<GameResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GameResponse gameResponse) {
                        gameResponse.getResults().toString();
                    }

                    @Override
                    public void onError(Throwable e) {
                        fail();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
