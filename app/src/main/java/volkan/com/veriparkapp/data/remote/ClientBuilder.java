package volkan.com.veriparkapp.data.remote;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by volkannarinc on 29/06/17 16:09.
 */

public class ClientBuilder {
    HttpLoggingInterceptor httpLoggingInterceptor;//TODO kaldırılacak
    Interceptor interceptor;
    OkHttpClient.Builder builder;

    public ClientBuilder() {
        httpLoggingInterceptor = new HttpLoggingInterceptor();//TODO kaldırılacak
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//TODO kaldırılacak

        create();
        add();
    }

    private void create() {
        interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
           /*     if (token != null && token != "") {
                    Request request = chain.request().newBuilder().addHeader("x-cekpara-token", token).build();
                    return chain.proceed(request);
                } else {*/
                    return chain.proceed(chain.request());
                //}
            }
        };
    }

    private void add() {
        builder = new OkHttpClient.Builder();
        builder.addInterceptor(httpLoggingInterceptor);//TODO kaldırılacak

        if (!builder.interceptors().contains(interceptor)) {
            builder.addInterceptor(interceptor);
        }
    }

    public OkHttpClient build() {
        return builder.build();
    }
}
