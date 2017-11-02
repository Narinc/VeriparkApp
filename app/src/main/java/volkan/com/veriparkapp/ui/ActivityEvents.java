package volkan.com.veriparkapp.ui;

import java.util.List;

import volkan.com.veriparkapp.data.model.stock_indexes_info.response.StockandIndex;

/**
 * Created by volkan on 01.11.2017 23:19.
 */

public interface ActivityEvents {
    void showStockesList(List<StockandIndex> stockandIndexes);
}
