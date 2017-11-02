package volkan.com.veriparkapp.data.model.stock_index_detail.request;

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
public class ImkbIndexDetailRequestEnv {

    @Element(name = "soapenv:Body",required = false)
    private ImkbIndexDetailRequestBody body;

    public ImkbIndexDetailRequestBody getBody() {
        return body;
    }

    public void setBody(ImkbIndexDetailRequestBody body) {
        this.body = body;
    }
}
