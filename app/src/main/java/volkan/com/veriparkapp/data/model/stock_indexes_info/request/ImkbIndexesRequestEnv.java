package volkan.com.veriparkapp.data.model.stock_indexes_info.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by volkan on 01.11.2017 21:03.
 */

@Root(name = "soapenv:Envelope")
@NamespaceList({
        @Namespace( prefix = "soapenv", reference = "http://schemas.xmlsoap.org/soap/envelope/"),
        @Namespace( prefix = "tem", reference = "http://tempuri.org/")
})
public class ImkbIndexesRequestEnv {

    @Element(name = "soapenv:Body",required = false)
    private ImkbIndexesRequestBody body;

    public ImkbIndexesRequestBody getBody() {
        return body;
    }

    public void setBody(ImkbIndexesRequestBody body) {
        this.body = body;
    }
}
