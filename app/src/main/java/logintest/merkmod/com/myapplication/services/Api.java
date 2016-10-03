package logintest.merkmod.com.myapplication.services;

import logintest.merkmod.com.myapplication.model.Login;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by rkodekar on 10/3/16.
 */

public interface Api {

    @FormUrlEncoded
    @POST("/elogin.php")
    Observable<Login> getLoginModel (@Field("Email_Id") String emaiAddress, @Field("Password") String password);
}
