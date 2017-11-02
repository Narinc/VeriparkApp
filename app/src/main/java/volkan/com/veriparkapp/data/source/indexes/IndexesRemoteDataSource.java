package volkan.com.veriparkapp.data.source.indexes;

import retrofit2.Call;
import volkan.com.veriparkapp.base.BaseRemoteDataSource;
import volkan.com.veriparkapp.data.model.encryptedKey.request.EncryptRequestEnv;
import volkan.com.veriparkapp.data.model.encryptedKey.response.EncryptResponseEnv;
import volkan.com.veriparkapp.data.model.stock_indexes_info.request.ImkbIndexesRequestEnv;
import volkan.com.veriparkapp.data.model.stock_indexes_info.response.ImkbIndexesResponseEnv;
import volkan.com.veriparkapp.data.source.CallbackResult;
import volkan.com.veriparkapp.data.source.ICallbackData;

/**
 * Created by volkan on 01.11.2017 20:04.
 */

public class IndexesRemoteDataSource extends BaseRemoteDataSource implements IndexsDataSource{
    private static IndexsDataSource INSTANCE;

    private IndexesRemoteDataSource() {
        super();
    }

    public static IndexsDataSource getInstance() {
        return new IndexesRemoteDataSource();
    }

    @Override
    public void getEncryptedKey(EncryptRequestEnv env, ICallbackData<EncryptResponseEnv> iCallbackData) {
        Call<EncryptResponseEnv> call = apiRequest.requestEncryptedData(env);
        call.enqueue(new CallbackResult<EncryptResponseEnv>(iCallbackData));
    }

    @Override
    public void getStockList(ImkbIndexesRequestEnv requestEnv, ICallbackData<ImkbIndexesResponseEnv> iCallbackData) {
        Call<ImkbIndexesResponseEnv> call = apiRequest.requestStockList(requestEnv);
        call.enqueue(new CallbackResult<ImkbIndexesResponseEnv>(iCallbackData));
    }

}
