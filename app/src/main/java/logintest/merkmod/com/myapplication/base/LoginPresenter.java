package logintest.merkmod.com.myapplication.base;

import logintest.merkmod.com.myapplication.model.Login;
import rx.Observer;

/**
 * Created by mkodekar on 26/09/2016.
 */

public class LoginPresenter extends BasePresenter implements Observer<Login> {

    private  LoginViewInterface loginViewInterface;

    public LoginPresenter(LoginViewInterface loginViewInterface) {
        this.loginViewInterface = loginViewInterface;
    }

    @Override
    public void onCompleted() {
        loginViewInterface.onCompleted();
    }

    @Override
    public void onError(Throwable e) {

        loginViewInterface.onError(e.getMessage());
    }

    @Override
    public void onNext(Login login) {
        loginViewInterface.onFetched(login);
    }

    public void checkLoginStatus(String emailId, String passWord) {
        unSubscribeAll();
        subscribe(loginViewInterface.getLoginStatus(emailId, passWord), LoginPresenter.this);
    }
}
