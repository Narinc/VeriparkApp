package volkan.com.veriparkapp.data.model.encryptedKey.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by volkan on 01.11.2017 21:03.
 */

@Root(name = "Encrypt" , strict = false)
@Namespace(reference = "http://tempuri.org/")
public class EncryptRequestData {

    @Element(name = "request",required = false)
    private String request;

    public EncryptRequestData(String request) {
        this.request = request;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
