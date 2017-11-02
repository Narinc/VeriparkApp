package volkan.com.veriparkapp.data.source;

/**
 * Created by volkannarinc on 03/10/17 15:17.
 */

public class ICalbackDataImpl<T> implements ICallbackData<T> {

    private final ICallbackData ICallbackData;

    public ICalbackDataImpl(ICallbackData ICallbackData) {
        this.ICallbackData = ICallbackData;
    }

    @Override
    public void onLoaded(T result) {
        ICallbackData.onLoaded(result);
    }

    @Override
    public void onFailure(Throwable throwable) {
        ICallbackData.onFailure(throwable);
    }
}
