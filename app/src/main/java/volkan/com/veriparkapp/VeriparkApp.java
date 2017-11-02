package volkan.com.veriparkapp;

import android.app.Application;

import volkan.com.veriparkapp.data.remote.ApiService;

/**
 * Created by volkan on 01.11.2017 00:57.
 */

public class VeriparkApp extends Application {
    private static VeriparkApp instance;

    public static synchronized VeriparkApp getInstance() {
        if (instance == null) {
            instance = new VeriparkApp();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }


    public ApiService getApiService() {
        return new ApiService(getString(R.string.base_url));
    }
}
