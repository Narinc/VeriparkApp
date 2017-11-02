package volkan.com.veriparkapp.data.model.encryptedKey.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by volkan on 01.11.2017 21:26.
 */

@Root(name = "EncryptResponse", strict = false)
@Namespace(reference = "http://tempuri.org/")
public class EncryptResponseData {

    @Element(name = "EncryptResult",required = false)
    private String EncryptResult;

    public String getEncryptResult() {
        return EncryptResult;
    }

    public void setEncryptResult(String encryptResult) {
        EncryptResult = encryptResult;
    }
}
