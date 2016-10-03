package logintest.merkmod.com.myapplication.dependency;

import android.app.Application;
import android.content.SharedPreferences;
import dagger.Component;
import logintest.merkmod.com.myapplication.MainActivity;

/**
 * Created by rkodekar on 10/4/16.
 */

@MyLoginScope
@Component(modules = {LoginModel.class, SharedPreferenceModule.class}, dependencies = ApiComponent.class)
public interface LoginComponent {
    void inject(MainActivity mainActivity);
    Application application();
    SharedPreferences sharedPreferences();
}
