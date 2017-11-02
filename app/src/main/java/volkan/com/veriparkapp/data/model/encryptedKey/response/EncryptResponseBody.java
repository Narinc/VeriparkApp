package volkan.com.veriparkapp.data.model.encryptedKey.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by volkan on 01.11.2017 21:25.
 */

@Root(name = "Body", strict = false)
public class EncryptResponseBody {
    @Element(name = "EncryptResponse", required = false)
    private EncryptResponseData data;

    public EncryptResponseData getData() {
        return data;
    }

    public void setData(EncryptResponseData data) {
        this.data = data;
    }
}
