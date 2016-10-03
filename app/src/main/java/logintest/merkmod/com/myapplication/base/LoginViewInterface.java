package logintest.merkmod.com.myapplication.base;

import logintest.merkmod.com.myapplication.model.Login;
import rx.Observable;

/**
 * Created by mkodekar on 26/09/2016.
 */
public interface LoginViewInterface {

    void onCompleted();
    void onError(String message);
    void onFetched(Login login);
    Observable<Login> getLoginStatus(String emailId, String Password);
}
