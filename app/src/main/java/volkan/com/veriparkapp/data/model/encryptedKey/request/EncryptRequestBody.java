package volkan.com.veriparkapp.data.model.encryptedKey.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by volkan on 01.11.2017 21:03.
 */

@Root(name = "soap:Body", strict = false)
public class EncryptRequestBody {

    @Element(name = "Encrypt", required = false)
    private EncryptRequestData encryptRequestData;

    public EncryptRequestBody(EncryptRequestData encryptRequestData) {
        this.encryptRequestData = encryptRequestData;
    }

    public EncryptRequestData getImkbIndexesRequestData() {
        return encryptRequestData;
    }

    public void setImkbIndexesRequestData(EncryptRequestData encryptRequestData) {
        this.encryptRequestData = encryptRequestData;
    }
}
