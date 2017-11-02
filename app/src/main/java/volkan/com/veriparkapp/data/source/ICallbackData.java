package volkan.com.veriparkapp.data.source;

/**
 * Created by volkannarinc on 28/09/17 10:44.
 */

public interface ICallbackData<T> {

    void onLoaded(T result);

    void onFailure(Throwable throwable);

}
