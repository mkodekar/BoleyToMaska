package logintest.merkmod.com.myapplication.model;

import android.support.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rkodekar on 10/3/16.
 */

@AutoValue
public abstract class Login {

    @SerializedName("success")
    public abstract Integer successInteger();
    @SerializedName("message")
    public abstract String message();
    @SerializedName("0")
    @Nullable
    public abstract  _0 _0();

    public static TypeAdapter<Login> typeAdapter(Gson gson) {
        return new AutoValue_Login.GsonTypeAdapter(gson);
    }

}
