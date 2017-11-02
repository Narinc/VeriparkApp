package volkan.com.veriparkapp.data.model.stock_indexes_info.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by volkan on 02.11.2017 00:42.
 */

@Root(name = "RequestResult", strict = false)
class RequestResult {
    @Element(name = "Success",required = false)
    private boolean Success;
    @Element(name = "Message",required = false)
    private String Message;

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
