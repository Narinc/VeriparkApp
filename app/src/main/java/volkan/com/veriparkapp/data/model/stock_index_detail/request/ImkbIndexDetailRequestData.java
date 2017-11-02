package volkan.com.veriparkapp.data.model.stock_index_detail.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by volkan on 01.11.2017 21:03.
 */

@Root(name = "tem:GetForexStocksandIndexesInfo" , strict = false)
public class ImkbIndexDetailRequestData {

    @Element(name = "tem:request",required = false)
    private ImkbIndexDetailRequestInfo request;

    public ImkbIndexDetailRequestData(ImkbIndexDetailRequestInfo request) {
        this.request = request;
    }

    public ImkbIndexDetailRequestInfo getRequest() {
        return request;
    }

    public void setRequest(ImkbIndexDetailRequestInfo request) {
        this.request = request;
    }
}
