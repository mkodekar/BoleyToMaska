package logintest.merkmod.com.myapplication.dependency;

import dagger.Component;
import retrofit2.Retrofit;

import javax.inject.Singleton;

/**
 * Created by mkodekar on 26/09/2016.
 */

@Singleton
@Component(modules = NetworkModule.class)
public interface NetworkComponent {
    Retrofit retrofit();
}
