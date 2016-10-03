package logintest.merkmod.com.myapplication.dependency;

import com.google.gson.GsonBuilder;
import com.ryanharter.auto.value.gson.AutoValueGsonTypeAdapterFactory;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;

/**
 * Created by mkodekar on 26/09/2016.
 */

@Module
public class NetworkModule {

    private String mBaseUrl;

    public NetworkModule(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
    }

    @Provides
    @Singleton
    RxJavaCallAdapterFactory providesRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    GsonConverterFactory gsonConverterFactory() {
        return GsonConverterFactory.create(new GsonBuilder().registerTypeAdapterFactory(new AutoValueGsonTypeAdapterFactory()).create());
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(GsonConverterFactory gsonConverterFactory, RxJavaCallAdapterFactory rxJavaCallAdapter ) {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapter)
                .build();
    }

}
