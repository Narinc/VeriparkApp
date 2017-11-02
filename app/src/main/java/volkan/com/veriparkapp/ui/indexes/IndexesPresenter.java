package volkan.com.veriparkapp.ui.indexes;

import android.util.Log;

import volkan.com.veriparkapp.data.model.encryptedKey.request.EncryptRequestBody;
import volkan.com.veriparkapp.data.model.encryptedKey.request.EncryptRequestData;
import volkan.com.veriparkapp.data.model.encryptedKey.request.EncryptRequestEnv;
import volkan.com.veriparkapp.data.model.encryptedKey.response.EncryptResponseEnv;
import volkan.com.veriparkapp.data.model.stock_indexes_info.request.ImkbIndexesRequestBody;
import volkan.com.veriparkapp.data.model.stock_indexes_info.request.ImkbIndexesRequestData;
import volkan.com.veriparkapp.data.model.stock_indexes_info.request.ImkbIndexesRequestEnv;
import volkan.com.veriparkapp.data.model.stock_indexes_info.request.ImkbIndexesRequestInfo;
import volkan.com.veriparkapp.data.model.stock_indexes_info.response.ImkbIndexesResponseEnv;
import volkan.com.veriparkapp.data.source.ICallbackData;
import volkan.com.veriparkapp.data.source.indexes.IndexesRepository;

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
        indexesRepository.getEncryptedKey(requestEnv, new ICallbackData<EncryptResponseEnv>() {
            @Override
            public void onLoaded(EncryptResponseEnv result) {
                Log.i(TAG, "onLoaded: encryptedKey: " + result.getBody().getData().getEncryptResult());
                String key = result.getBody().getData().getEncryptResult();
                getStoksList(new ImkbIndexesRequestInfo(true, "test", "ipad", key));
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }

    @Override
    public void getStoksList(ImkbIndexesRequestInfo requestInfo) {
        ImkbIndexesRequestEnv requestEnv = new ImkbIndexesRequestEnv();
        requestEnv.setBody(new ImkbIndexesRequestBody(new ImkbIndexesRequestData(requestInfo)));
        indexesRepository.getStockList(requestEnv, new ICallbackData<ImkbIndexesResponseEnv>() {
            @Override
            public void onLoaded(ImkbIndexesResponseEnv result) {
                view.showStockList(result.getBody().getData().getInfoResult().getStockandIndexes());
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }
}
