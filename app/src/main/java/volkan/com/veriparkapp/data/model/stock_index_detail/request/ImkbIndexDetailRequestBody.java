package volkan.com.veriparkapp.data.model.stock_index_detail.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by volkan on 01.11.2017 21:03.
 */

@Root(name = "soapenv:Body", strict = false)
public class ImkbIndexDetailRequestBody {

    @Element(name = "tem:GetForexStocksandIndexesInfo", required = false)
    private ImkbIndexDetailRequestData ımkbIndexDetailRequestData;

    public ImkbIndexDetailRequestBody(ImkbIndexDetailRequestData ımkbIndexDetailRequestData) {
        this.ımkbIndexDetailRequestData = ımkbIndexDetailRequestData;
    }

    public ImkbIndexDetailRequestData getImkbIndexesRequestData() {
        return ımkbIndexDetailRequestData;
    }

    public void setImkbIndexesRequestData(ImkbIndexDetailRequestData ımkbIndexDetailRequestData) {
        this.ımkbIndexDetailRequestData = ımkbIndexDetailRequestData;
    }
}
