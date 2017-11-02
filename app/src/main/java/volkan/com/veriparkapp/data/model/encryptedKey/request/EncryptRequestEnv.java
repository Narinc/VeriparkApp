package volkan.com.veriparkapp.data.model.encryptedKey.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by volkan on 01.11.2017 21:03.
 */

@Root(name = "soap:Envelope")
@NamespaceList({
        @Namespace( prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace( prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace( prefix = "soap", reference = "http://schemas.xmlsoap.org/soap/envelope/")
})
public class EncryptRequestEnv {

    @Element(name = "soap:Body",required = false)
    private EncryptRequestBody body;

    public EncryptRequestBody getBody() {
        return body;
    }

    public void setBody(EncryptRequestBody body) {
        this.body = body;
    }
}
