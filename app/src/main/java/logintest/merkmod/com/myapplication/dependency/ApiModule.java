package logintest.merkmod.com.myapplication.dependency;

import dagger.Module;
import dagger.Provides;
import logintest.merkmod.com.myapplication.services.Api;
import retrofit2.Retrofit;

/**
 * Created by rkodekar on 10/4/16.
 */

@Module
public class ApiModule {

    @Provides @ApiScope
    Api provideApi(Retrofit retrofit){
        return retrofit.create(Api.class);
    }
}
