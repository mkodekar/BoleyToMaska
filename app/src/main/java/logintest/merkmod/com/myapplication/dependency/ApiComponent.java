package logintest.merkmod.com.myapplication.dependency;

import dagger.Component;
import logintest.merkmod.com.myapplication.services.Api;

/**
 * Created by rkodekar on 10/4/16.
 */

@ApiScope
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ApiComponent {
    Api api();
}
