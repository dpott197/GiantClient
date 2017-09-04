package com.dpott.giantclient.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.dpott.giantclient.C
import com.dpott.giantclient.R
import com.dpott.giantclient.data.GiantBombClient
import com.dpott.giantclient.data.model.game.GameResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by dpott on 8/13/2017.
 */

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GiantBombClient.getInstance().getGameResponse(C.GAME_ID_HALO_COMBAT_EVOLVED)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object : Observer<GameResponse> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(gameResponse: GameResponse) {
                        Toast.makeText(this@GameActivity, gameResponse.results.toString(), Toast.LENGTH_SHORT).show()
                    }

                    override fun onError(e: Throwable) {
                        Log.e("GameActivity", "", e)
                    }

                    override fun onComplete() {

                    }
                })
    }

}
