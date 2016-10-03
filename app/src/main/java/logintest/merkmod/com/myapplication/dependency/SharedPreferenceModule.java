package logintest.merkmod.com.myapplication.dependency;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.Module;
import dagger.Provides;
import logintest.merkmod.com.myapplication.application.ApplicationConfig;
import logintest.merkmod.com.myapplication.application.MyLoginApp;

/**
 * Created by rkodekar on 10/4/16.
 */

@Module
public class SharedPreferenceModule {

    @Provides @MyLoginScope
    SharedPreferences provideSharedPreferences(MyLoginApp myLoginApp) {
        return myLoginApp.getSharedPreferences(ApplicationConfig.APP_NAME, Context.MODE_PRIVATE);
    }
}
