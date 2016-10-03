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
public abstract class _0 {
    @SerializedName("Login_Id")
    public abstract String loginId();
    @SerializedName("Login_Name")
    public abstract String loginName();
    @SerializedName("First_Name")
    public abstract String firstName();
    @SerializedName("Middle_Name")
    public abstract String middleName();
    @SerializedName("Last_Name")
    public abstract String lastName();
    @SerializedName("Password")
    public abstract String password();
    @SerializedName("Email_Id")
    public abstract String emailId();
    @SerializedName("Mobile_No")
    public abstract String mobileNo();
    @SerializedName("IMEINO")
    public abstract String iMEINO();
    @SerializedName("IMEINO2")
    public abstract String iMEINO2();
    @SerializedName("DATEOFBIRTH")
    @Nullable
    public abstract Object dATEOFBIRTH();
    @SerializedName("Effective_From")
    @Nullable
    public abstract Object effectiveFrom();
    @SerializedName("ACTIVE")
    public abstract String aCTIVE();
    @SerializedName("Address")
    public abstract String address();
    @SerializedName("City")
    public abstract String city();
    @SerializedName("Pincode")
    public abstract String pincode();
    @SerializedName("Stat")
    public abstract String stat();
    @SerializedName("Category_Name")
    @Nullable
    public abstract Object categoryName();
    @SerializedName("Created_By")
    @Nullable
    public abstract Object createdBy();
    @SerializedName("Created_Date")
    @Nullable
    public abstract Object createdDate();
    @SerializedName("Modify_By")
    @Nullable
    public abstract Object modifyBy();
    @SerializedName("Modify_Date")
    @Nullable
    public abstract Object modifyDate();
    @SerializedName("Latitude")
    @Nullable
    public abstract Object latitude();
    @SerializedName("Longtitude")
    @Nullable
    public abstract Object longtitude();
    @SerializedName("CLIENT_NAME")
    @Nullable
    public abstract String cLIENTNAME();

    public static TypeAdapter<_0> typeAdapter(Gson gson) {
        return new AutoValue__0.GsonTypeAdapter(gson);
    }
}
