package volkan.com.veriparkapp.data.remote;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import volkan.com.veriparkapp.data.model.encryptedKey.request.EncryptRequestEnv;
import volkan.com.veriparkapp.data.model.encryptedKey.response.EncryptResponseEnv;
import volkan.com.veriparkapp.data.model.stock_index_detail.request.ImkbIndexDetailRequestEnv;
import volkan.com.veriparkapp.data.model.stock_index_detail.response.ImkbIndexDetailResponseEnv;
import volkan.com.veriparkapp.data.model.stock_indexes_info.request.ImkbIndexesRequestEnv;
import volkan.com.veriparkapp.data.model.stock_indexes_info.response.ImkbIndexesResponseEnv;

/**
 * Created by volkan on 01.11.2017 20:05.
 */

public interface ApiRequest {
    @Headers({
            "Content-Type: text/xml",
            "Accept-Charset: utf-8"
    })
    @POST("/service.asmx")
    Call<EncryptResponseEnv> requestEncryptedData(@Body EncryptRequestEnv body);

    @Headers({
            "Content-Type: text/xml",
            "Accept-Charset: utf-8"
    })
    @POST("/service.asmx")
    Call<ImkbIndexesResponseEnv> requestStockList(@Body ImkbIndexesRequestEnv body);

    @Headers({
            "Content-Type: text/xml",
            "Accept-Charset: utf-8"
    })
    @POST("/service.asmx")
    Call<ImkbIndexDetailResponseEnv> requestStockDetail(@Body ImkbIndexDetailRequestEnv body);


}
