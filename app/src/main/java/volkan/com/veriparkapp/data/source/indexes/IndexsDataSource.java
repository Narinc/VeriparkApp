package volkan.com.veriparkapp.data.source.indexes;

import volkan.com.veriparkapp.data.model.encryptedKey.request.EncryptRequestEnv;
import volkan.com.veriparkapp.data.model.encryptedKey.response.EncryptResponseEnv;
import volkan.com.veriparkapp.data.model.stock_indexes_info.request.ImkbIndexesRequestEnv;
import volkan.com.veriparkapp.data.model.stock_indexes_info.response.ImkbIndexesResponseEnv;
import volkan.com.veriparkapp.data.source.ICallbackData;

/**
 * Created by volkan on 01.11.2017 20:00.
 */

public interface IndexsDataSource {
    void getEncryptedKey(EncryptRequestEnv env, ICallbackData<EncryptResponseEnv> iCallbackData);

    void getStockList(ImkbIndexesRequestEnv requestEnv, ICallbackData<ImkbIndexesResponseEnv> iCallbackData);
}
