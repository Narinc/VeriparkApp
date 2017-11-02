package volkan.com.veriparkapp.ui.detail;

import android.util.Log;

import volkan.com.veriparkapp.R;
import volkan.com.veriparkapp.data.model.encryptedKey.request.EncryptRequestBody;
import volkan.com.veriparkapp.data.model.encryptedKey.request.EncryptRequestData;
import volkan.com.veriparkapp.data.model.encryptedKey.request.EncryptRequestEnv;
import volkan.com.veriparkapp.data.model.encryptedKey.response.EncryptResponseEnv;
import volkan.com.veriparkapp.data.model.stock_index_detail.request.ImkbIndexDetailRequestBody;
import volkan.com.veriparkapp.data.model.stock_index_detail.request.ImkbIndexDetailRequestData;
import volkan.com.veriparkapp.data.model.stock_index_detail.request.ImkbIndexDetailRequestEnv;
import volkan.com.veriparkapp.data.model.stock_index_detail.request.ImkbIndexDetailRequestInfo;
import volkan.com.veriparkapp.data.model.stock_index_detail.response.ImkbIndexDetailResponseEnv;
import volkan.com.veriparkapp.data.source.ICallbackData;
import volkan.com.veriparkapp.data.source.indexes.IndexesRepository;
import volkan.com.veriparkapp.ui.ProgressDialogFragment;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by volkan on 01.11.2017 01:02.
 */

public class DetailPresenter implements IndexDetailScreen.Presenter {
    private static final String TAG = "DetailPresenter";
    private final IndexesRepository indexesRepository;
    private final IndexDetailScreen.View view;

    public DetailPresenter(IndexesRepository indexesRepository, IndexDetailScreen.View view) {
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
                Log.i(TAG, "onLoaded: encryptedKey: " + result.getBody().getData().getEncryptResult());
                String key = result.getBody().getData().getEncryptResult();
                getIndexDetail(new ImkbIndexDetailRequestInfo(true, "test", "ipad", key, view.getSymbol(), "Month"));
            }

            @Override
            public void onFailure(Throwable throwable) {
                ProgressDialogFragment.hide(view.getFragmentManager());
                view.showErrorSnackbar(throwable, R.string.error);
            }
        });
    }

    @Override
    public void getIndexDetail(ImkbIndexDetailRequestInfo requestInfo) {
        ImkbIndexDetailRequestEnv requestEnv = new ImkbIndexDetailRequestEnv();
        requestEnv.setBody(new ImkbIndexDetailRequestBody(new ImkbIndexDetailRequestData(requestInfo)));

        ProgressDialogFragment.show(view.getFragmentManager());
        indexesRepository.getDetail(requestEnv, new ICallbackData<ImkbIndexDetailResponseEnv>() {
            @Override
            public void onLoaded(ImkbIndexDetailResponseEnv result) {
                ProgressDialogFragment.hide(view.getFragmentManager());
                Log.i(TAG, "onLoaded: " + result.getBody().getData().getInfoResult().getRequestResult().getMessage());
            }

            @Override
            public void onFailure(Throwable throwable) {
                ProgressDialogFragment.hide(view.getFragmentManager());
                view.showErrorSnackbar(throwable, R.string.error);
            }
        });
    }
}
