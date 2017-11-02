package volkan.com.veriparkapp.data.model.stock_index_detail.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by volkan on 01.11.2017 21:24.
 */

@Root(name = "soap:Envelope")
@NamespaceList({
        @Namespace( prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace( prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace( prefix = "soap", reference = "http://schemas.xmlsoap.org/soap/envelope/")
})
public class ImkbIndexDetailResponseEnv {

    @Element(required = false, name = "Body")
    private ImkbIndexesResponseBody body;

    public ImkbIndexesResponseBody getBody() {
        return body;
    }

    public void setBody(ImkbIndexesResponseBody body) {
        this.body = body;
    }
}
