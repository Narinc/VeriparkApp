package volkan.com.veriparkapp.data.model.stock_indexes_info.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by volkan on 01.11.2017 21:03.
 */

@Root(name = "tem:GetForexStocksandIndexesInfo" , strict = false)
public class ImkbIndexesRequestData {

    @Element(name = "tem:request",required = false)
    private ImkbIndexesRequestInfo request;

    public ImkbIndexesRequestData(ImkbIndexesRequestInfo request) {
        this.request = request;
    }

    public ImkbIndexesRequestInfo getRequest() {
        return request;
    }

    public void setRequest(ImkbIndexesRequestInfo request) {
        this.request = request;
    }
}
