package logintest.merkmod.com.myapplication.application;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import logintest.merkmod.com.myapplication.dependency.*;

/**
 * Created by rkodekar on 10/4/16.
 */
public class MyLoginApp extends Application {

    private LoginComponent loginComponent;

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    public void resolveDependency() {
        loginComponent  = DaggerLoginComponent.builder()
                .loginModel(new LoginModel(this))
                .apiComponent(getApiComponent())
                .sharedPreferenceModule(new SharedPreferenceModule())
                .build();
    }

    public ApiComponent getApiComponent() {
        return DaggerApiComponent.builder().networkComponent(networkComponent()).build();
    }

    public NetworkComponent networkComponent() {
        return DaggerNetworkComponent.builder().networkModule(new NetworkModule(ApplicationConfig.URL)).build();
    }

    public static LoginComponent getMyApplicationComponent(Context context) {
        return ((MyLoginApp)context.getApplicationContext()).loginComponent;
    }
}
