package volkan.com.veriparkapp.base;


import volkan.com.veriparkapp.VeriparkApp;
import volkan.com.veriparkapp.data.remote.ApiRequest;

/**
 * Created by volkannarinc on 03/07/17 15:06.
 */

public abstract class BaseRemoteDataSource {
    protected ApiRequest apiRequest;


    public BaseRemoteDataSource() {
        apiRequest = VeriparkApp.getInstance().getApiService().getAPI();
    }
}

