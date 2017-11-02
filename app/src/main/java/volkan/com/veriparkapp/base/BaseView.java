package volkan.com.veriparkapp.base;

import android.content.Context;
import android.support.v4.app.FragmentManager;

/**
 * Created by volkan on 31.10.2017 22:38.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);

    Context getContext();

    void showErrorSnackbar(Throwable t, int resId);

    void showErrorSnackbar(String problem, int resId);

    void showErrorSnackbar(int resId, String problem);

    android.view.View getSnackbarAnchorView();

    FragmentManager getFragmentManager();
}
