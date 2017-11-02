package volkan.com.veriparkapp.data.remote;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by volkannarinc on 29/06/17 15:24.
 */

public class ApiService {
    private ApiRequest apiRequest;
    private OkHttpClient okHttpClient;

    public ApiService(String baseUrl) {

        okHttpClient = new ClientBuilder().build();

        Retrofit retrofit;
        if (okHttpClient != null) {

            Strategy strategy = new AnnotationStrategy();
            Serializer serializer = new Persister(strategy);


            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                    .client(okHttpClient)
                    .build();
            apiRequest = retrofit.create(ApiRequest.class);
        }
    }

    public ApiRequest getAPI() {
        return apiRequest;
    }

}
