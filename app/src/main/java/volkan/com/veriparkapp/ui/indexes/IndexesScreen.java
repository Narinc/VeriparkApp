package volkan.com.veriparkapp.ui.indexes;

import java.util.List;

import volkan.com.veriparkapp.base.BasePresenter;
import volkan.com.veriparkapp.base.BaseView;
import volkan.com.veriparkapp.data.model.stock_indexes_info.request.ImkbIndexesRequestInfo;
import volkan.com.veriparkapp.data.model.stock_indexes_info.response.StockandIndex;

/**
 * Created by volkan on 01.11.2017 00:52.
 */

public interface IndexesScreen {
    interface View extends BaseView<Presenter> {

        void showStockList(List<StockandIndex> stockandIndexes);
    }

    interface Presenter extends BasePresenter {

        void getEncryptedKey(String format);

        void getStoksList(ImkbIndexesRequestInfo requestInfo);
    }
}
