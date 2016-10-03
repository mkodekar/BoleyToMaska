package logintest.merkmod.com.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import logintest.merkmod.com.myapplication.application.MyLoginApp;
import logintest.merkmod.com.myapplication.base.LoginPresenter;
import logintest.merkmod.com.myapplication.base.LoginViewInterface;
import logintest.merkmod.com.myapplication.model.Login;
import logintest.merkmod.com.myapplication.services.Api;
import rx.Observable;
import rx.Subscription;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements LoginViewInterface {

    @Inject
    Api api;

    @BindView(R.id.usernameEd)
    AppCompatEditText userEditText;

    @BindView(R.id.passwordEd)
    AppCompatEditText passwordEditext;

    @BindView(R.id.button)
    AppCompatButton button;

    private LoginPresenter loginPresenter;

    private ProgressDialog progressDialog;

    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Observable<CharSequence> emailSub = RxTextView.textChanges(userEditText);
        Observable<CharSequence> passwordSub = RxTextView.textChanges(passwordEditext);
        subscription = Observable.combineLatest(emailSub, passwordSub, (t1, t2) -> validate())
                .subscribe(aBoolean -> button.setEnabled(aBoolean));
        progressDialog = new ProgressDialog(this);
        MyLoginApp.getMyApplicationComponent(this).inject(this);
        loginPresenter = new LoginPresenter(this);
        RxView.clicks(button).subscribe(aVoid -> checkLogin());
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(String message) {
        progressDialog.dismiss();
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFetched(Login login) {
        progressDialog.dismiss();
        if (login.successInteger().equals(1)) {
            Toast.makeText(MainActivity.this, login.message(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, login.message(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public Observable<Login> getLoginStatus(String emailId, String Password) {
        return api.getLoginModel(userEditText.getText().toString(), passwordEditext.getText().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
        subscription.unsubscribe();
    }

    private boolean validate() {
        if (userEditText.getText().toString().isEmpty() || android.util.Patterns.EMAIL_ADDRESS.matcher(userEditText.getText().toString()).matches()) {
            button.setEnabled(false);
            userEditText.setError("Invalid username");
            return false;
        } else if (passwordEditext.getText().toString().trim().isEmpty()) {
            button.setEnabled(false);
            passwordEditext.setError("Password is empty");
            return false;
        } else if (!userEditText.getText().toString().isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(userEditText.getText().toString()).matches() && !passwordEditext.getText().toString().trim().isEmpty()) {
            return true;
        }
        return false;
    }

    private void checkLogin() {
        progressDialog.setMessage("Signing in please wait");
        progressDialog.show();
        loginPresenter.checkLoginStatus(userEditText.getText().toString(), passwordEditext.getText().toString());
    }
}
