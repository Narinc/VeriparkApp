package volkan.com.veriparkapp.data.model.encryptedKey.response;

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
public class EncryptResponseEnv {

    @Element(required = false, name = "Body")
    private EncryptResponseBody body;

    public EncryptResponseBody getBody() {
        return body;
    }

    public void setBody(EncryptResponseBody body) {
        this.body = body;
    }
}
