package volkan.com.veriparkapp.ui.detail;

import android.app.Activity;

import volkan.com.veriparkapp.base.BasePresenter;
import volkan.com.veriparkapp.base.BaseView;
import volkan.com.veriparkapp.data.model.stock_index_detail.request.ImkbIndexDetailRequestInfo;

/**
 * Created by volkan on 01.11.2017 00:52.
 */

public interface IndexDetailScreen {
    interface View extends BaseView<Presenter> {
        String getSymbol();

        Activity getActivity();
    }

    interface Presenter extends BasePresenter {
        void getIndexDetail(ImkbIndexDetailRequestInfo requestInfo);
    }
}
