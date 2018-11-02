package com.dpott.giantclient.ui.game.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.dpott.giantclient.Constants
import com.dpott.giantclient.R
import com.dpott.giantclient.data.GiantDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_game_detail.*

/**
 * Created by dpott on 8/13/2017.
 */

class GameDetailActivity : AppCompatActivity(), GameDetailContract.View {

    private val TAG = "GameDetailActivity"
    private var compositeDisposable : CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateView()
    }

    private fun onCreateView() {
        setContentView(R.layout.activity_game_detail)
    }

    override fun onStart() {
        super.onStart()
        subscribe()
    }

    override fun onStop() {
        super.onStop()
        unsubscribe()
    }

    override fun subscribe() {
       compositeDisposable.add(GiantDataSource.getInstance().getGameResponse(Constants.GAME_ID_MARIO_KART_64)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(Consumer { gameResponse ->
                        Toast.makeText(this@GameDetailActivity, gameResponse.results.toString(), Toast.LENGTH_SHORT).show()
                        gameTitle.setText(gameResponse.results.name)
                        Glide.with(this@GameDetailActivity)
                                .load(gameResponse.results?.images?.get(0)?.superUrl)
                                .into(gameImage)
                        },
                        Consumer { e -> Log.e(TAG, "getGameResponse failed", e) }
                )
       )
    }

    override fun unsubscribe() {
        compositeDisposable.dispose()
    }

}
