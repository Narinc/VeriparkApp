package volkan.com.veriparkapp.ui.indexlist;

import android.util.Log;

import volkan.com.veriparkapp.data.model.encryptedKey.request.EncryptRequestBody;
import volkan.com.veriparkapp.data.model.encryptedKey.request.EncryptRequestData;
import volkan.com.veriparkapp.data.model.encryptedKey.request.EncryptRequestEnv;
import volkan.com.veriparkapp.data.model.encryptedKey.response.EncryptResponseEnv;
import volkan.com.veriparkapp.data.source.ICallbackData;
import volkan.com.veriparkapp.data.source.indexes.IndexesRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by volkan on 01.11.2017 01:02.
 */

public class IndexListPresenter implements IndexListScreen.Presenter {
    private static final String TAG = "IndexesPresenter";
    private final IndexesRepository indexesRepository;
    private final IndexListScreen.View view;

    public IndexListPresenter(IndexesRepository indexesRepository, IndexListScreen.View view) {
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

            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }
}
