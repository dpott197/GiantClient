package com.dpott.giantclient.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.dpott.giantclient.C
import com.dpott.giantclient.R
import com.dpott.giantclient.data.GiantBombClient
import com.dpott.giantclient.data.model.game.GameResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_game_detail.*

/**
 * Created by dpott on 8/13/2017.
 */

class GameDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_detail)
        GiantBombClient.getInstance().getGameResponse(C.GAME_ID_HALO_COMBAT_EVOLVED)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object : Observer<GameResponse> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(gameResponse: GameResponse) {
                        Toast.makeText(this@GameDetailActivity, gameResponse.results.toString(), Toast.LENGTH_SHORT).show()
                        gameTitle.setText(gameResponse.results.name)
                        Glide.with(this@GameDetailActivity)
                                .load(gameResponse?.results?.images?.get(0)?.screenUrl)
                                .into(gameImage)
                    }

                    override fun onError(e: Throwable) {
                        Log.e("GameDetailActivity", "", e)
                    }

                    override fun onComplete() {

                    }
                })
    }

}
