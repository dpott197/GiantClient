package com.dpott.giantclient.data.source;

import com.dpott.giantclient.data.model.game.GameResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import io.reactivex.Observable;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by dpott on 8/14/2017.
 */

public class RemoteDataSource implements DataSource {

    private final DataSource dataSource;

    //region Constructors
    public RemoteDataSource(boolean shouldLog) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(createQueryInterceptor())
                .addInterceptor(createHttpLoggingInterceptor(shouldLog))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.giantbomb.com/api/")
                .client(okHttpClient)
                .addConverterFactory(createJacksonConverterFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        DataSource dataSource = retrofit.create(DataSource.class);
        this.dataSource = dataSource;
    }
    //endregion

    //region Dependency Creation
    private static HttpLoggingInterceptor createHttpLoggingInterceptor(boolean shouldLog) {
        HttpLoggingInterceptor.Level level = shouldLog ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE;
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(level);
        return loggingInterceptor;
    }

    // TODO: Make these parameters dynamic
    private static Interceptor createQueryInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url().newBuilder()
                        .addQueryParameter("api_key", "b6b0857eb0c182188ee8d5abaccf6156783897cc")
                        .addQueryParameter("format", "json")
                        .build();
                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }
        };
    }

    private static JacksonConverterFactory createJacksonConverterFactory() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return JacksonConverterFactory.create(mapper);
    }
    //endregion Dependency Creation

    //region Responses
    public Observable<GameResponse> getGameResponse(String id) {
        return dataSource.getGameResponse(id);
    }
    //

}
