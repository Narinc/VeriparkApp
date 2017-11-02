package volkan.com.veriparkapp.data.source.indexes;

import android.support.annotation.NonNull;

import volkan.com.veriparkapp.data.model.encryptedKey.request.EncryptRequestEnv;
import volkan.com.veriparkapp.data.model.encryptedKey.response.EncryptResponseEnv;
import volkan.com.veriparkapp.data.model.stock_indexes_info.request.ImkbIndexesRequestEnv;
import volkan.com.veriparkapp.data.model.stock_indexes_info.response.ImkbIndexesResponseEnv;
import volkan.com.veriparkapp.data.source.ICalbackDataImpl;
import volkan.com.veriparkapp.data.source.ICallbackData;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by volkan on 01.11.2017 20:01.
 */

public class IndexesRepository implements IndexsDataSource {
    private static IndexesRepository INSTANCE;

    private final IndexsDataSource indexsDataSource;

    // Prevent direct instantiation.
    private IndexesRepository(@NonNull IndexsDataSource indexsDataSource) {
        this.indexsDataSource = checkNotNull(indexsDataSource);
    }

    /**
     * Returns the single instance of this class, creating it if necessary.
     *
     * @param queryDataSource the backend data source
     * @return the {@link IndexesRepository} instance
     */
    public static IndexesRepository getInstance(IndexsDataSource queryDataSource) {
        return new IndexesRepository(queryDataSource);
    }

    /**
     * Used to force {@link #getInstance(IndexsDataSource)} to create a new instance
     * next time it's called.
     */
    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public void getEncryptedKey(EncryptRequestEnv requestEnv, ICallbackData<EncryptResponseEnv> iCallbackData) {
        indexsDataSource.getEncryptedKey(requestEnv,new ICalbackDataImpl<EncryptResponseEnv>(iCallbackData));
    }

    @Override
    public void getStockList(ImkbIndexesRequestEnv requestEnv, ICallbackData<ImkbIndexesResponseEnv> iCallbackData) {
        indexsDataSource.getStockList(requestEnv,new ICalbackDataImpl<ImkbIndexesResponseEnv>(iCallbackData));
    }
}
