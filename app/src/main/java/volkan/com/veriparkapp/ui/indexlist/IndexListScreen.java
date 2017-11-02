package volkan.com.veriparkapp.ui.indexlist;

import android.app.Activity;

import volkan.com.veriparkapp.base.BasePresenter;
import volkan.com.veriparkapp.base.BaseView;

/**
 * Created by volkan on 01.11.2017 00:52.
 */

public interface IndexListScreen {
    interface View extends BaseView<Presenter> {

        Activity getActivity();
    }

    interface Presenter extends BasePresenter {

    }
}
