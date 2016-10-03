package logintest.merkmod.com.myapplication.dependency;

import javax.inject.Scope;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by rkodekar on 10/4/16.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiScope {
}
