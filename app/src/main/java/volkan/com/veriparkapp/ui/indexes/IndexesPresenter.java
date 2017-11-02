package volkan.com.veriparkapp.ui.indexes;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import volkan.com.veriparkapp.R;
import volkan.com.veriparkapp.data.model.encryptedKey.request.EncryptRequestBody;
import volkan.com.veriparkapp.data.model.encryptedKey.request.EncryptRequestData;
import volkan.com.veriparkapp.data.model.encryptedKey.request.EncryptRequestEnv;
import volkan.com.veriparkapp.data.model.encryptedKey.response.EncryptResponseEnv;
import volkan.com.veriparkapp.data.model.stock_indexes_info.request.ImkbIndexesRequestBody;
import volkan.com.veriparkapp.data.model.stock_indexes_info.request.ImkbIndexesRequestData;
import volkan.com.veriparkapp.data.model.stock_indexes_info.request.ImkbIndexesRequestEnv;
import volkan.com.veriparkapp.data.model.stock_indexes_info.request.ImkbIndexesRequestInfo;
import volkan.com.veriparkapp.data.model.stock_indexes_info.response.ImkbIndexesResponseEnv;
import volkan.com.veriparkapp.data.model.stock_indexes_info.response.StockandIndex;
import volkan.com.veriparkapp.data.source.ICallbackData;
import volkan.com.veriparkapp.data.source.indexes.IndexesRepository;
import volkan.com.veriparkapp.ui.ProgressDialogFragment;
import volkan.com.veriparkapp.util.Constants;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by volkan on 01.11.2017 01:02.
 */

public class IndexesPresenter implements IndexesScreen.Presenter {
    private static final String TAG = "IndexesPresenter";
    private final IndexesRepository indexesRepository;
    private final IndexesScreen.View view;

    public IndexesPresenter(IndexesRepository indexesRepository, IndexesScreen.View view) {
        this.indexesRepository = checkNotNull(indexesRepository, "indexesRepository cannot be null");
        this.view = checkNotNull(view, "view cannot be null!");
        view.setPresenter(this);
    }

    @Override
    public void getEncryptedKey(String format) {
        EncryptRequestEnv requestEnv = new EncryptRequestEnv();
        requestEnv.setBody(new EncryptRequestBody(new EncryptRequestData(format)));

        ProgressDialogFragment.show(view.getFragmentManager());
        indexesRepository.getEncryptedKey(requestEnv, new ICallbackData<EncryptResponseEnv>() {
            @Override
            public void onLoaded(EncryptResponseEnv result) {
                ProgressDialogFragment.hide(view.getFragmentManager());

                String key = result.getBody().getData().getEncryptResult();
                getStoksList(new ImkbIndexesRequestInfo(true, "test", "ipad", key), null);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }

    @Override
    public void getEncryptedKey(String format, final String filter) {
        EncryptRequestEnv requestEnv = new EncryptRequestEnv();
        requestEnv.setBody(new EncryptRequestBody(new EncryptRequestData(format)));

        ProgressDialogFragment.show(view.getFragmentManager());
        indexesRepository.getEncryptedKey(requestEnv, new ICallbackData<EncryptResponseEnv>() {
            @Override
            public void onLoaded(EncryptResponseEnv result) {
                ProgressDialogFragment.hide(view.getFragmentManager());

                String key = result.getBody().getData().getEncryptResult();
                getStoksList(new ImkbIndexesRequestInfo(true, "test", "ipad", key), filter);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }

    @Override
    public void getStoksList(ImkbIndexesRequestInfo requestInfo, final String filter) {
        ImkbIndexesRequestEnv requestEnv = new ImkbIndexesRequestEnv();
        requestEnv.setBody(new ImkbIndexesRequestBody(new ImkbIndexesRequestData(requestInfo)));

        ProgressDialogFragment.show(view.getFragmentManager());
        indexesRepository.getStockList(requestEnv, new ICallbackData<ImkbIndexesResponseEnv>() {
            @Override
            public void onLoaded(ImkbIndexesResponseEnv result) {
                ProgressDialogFragment.hide(view.getFragmentManager());

                filterIt(filter, result);
            }

            @Override
            public void onFailure(Throwable throwable) {
                ProgressDialogFragment.hide(view.getFragmentManager());
                view.showErrorSnackbar(throwable, R.string.error);
            }
        });
    }

    private void filterIt(String filter, ImkbIndexesResponseEnv result) {
        Log.i(TAG, "filterIt: ".concat(filter));
        List<StockandIndex> list = result.getBody().getData().getInfoResult().getStockandIndexes();
        List<StockandIndex> fildeterdList = new ArrayList<>();

        if (filter.equals(Constants.ALL)) {
            view.showStockList(list);
        } else if (filter.equals(Constants.RISINGS)) {
            for (StockandIndex index : list) {
                if (index.getDifference() > 0) {
                    fildeterdList.add(index);
                }
            }
            view.showStockList(fildeterdList);
        } else if (filter.equals(Constants.DROPPINGS)) {
            for (StockandIndex index : list) {
                if (index.getDifference() <= 0) {
                    fildeterdList.add(index);
                }
            }
            view.showStockList(fildeterdList);
        } else if (filter.equals(Constants.BY_VOLUME_30)) {
            for (StockandIndex index : list) {
                if (index.getVolume() <= 30) {
                    fildeterdList.add(index);
                }
            }
            view.showStockList(fildeterdList);
        } else if (filter.equals(Constants.BY_VOLUME_50)) {
            for (StockandIndex index : list) {
                if (30 < index.getVolume() && index.getVolume() <= 50) {
                    fildeterdList.add(index);
                }
            }
            view.showStockList(fildeterdList);
        } else if (filter.equals(Constants.BY_VOLUME_100)) {
            for (StockandIndex index : list) {
                if (index.getVolume() >= 100) {
                    fildeterdList.add(index);
                }
            }
            view.showStockList(fildeterdList);
        } else Log.i(TAG, "filterIt: nothing");
    }
}
