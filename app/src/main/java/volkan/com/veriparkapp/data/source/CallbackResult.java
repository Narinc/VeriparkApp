package volkan.com.veriparkapp.data.source;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import volkan.com.veriparkapp.R;
import volkan.com.veriparkapp.VeriparkApp;

/**
 * Created by volkannarinc on 03/10/17 15:06.
 */

public class CallbackResult<T> implements Callback<T> {

    private final ICallbackData iCallbackData;

    public CallbackResult(ICallbackData iCallbackData) {
        this.iCallbackData = iCallbackData;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            if (response.body() != null) {
                iCallbackData.onLoaded(response.body());
            }
        } else {
            iCallbackData.onFailure(new Throwable(VeriparkApp.getInstance().getString(R.string.error)));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        iCallbackData.onFailure(t);
    }
}