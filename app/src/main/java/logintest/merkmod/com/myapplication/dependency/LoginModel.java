package logintest.merkmod.com.myapplication.dependency;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import logintest.merkmod.com.myapplication.application.MyLoginApp;

/**
 * Created by rkodekar on 10/4/16.
 */
@Module
public class LoginModel {

    private MyLoginApp myLoginApp;

    public LoginModel(MyLoginApp myLoginApp) {
        this.myLoginApp = myLoginApp;
    }

    @Provides @MyLoginScope
    MyLoginApp provideLoginApp() {
        return myLoginApp;
    }

    @Provides @MyLoginScope
    Application provideApplication(MyLoginApp myLoginApp) {
        return myLoginApp;
    }
}
