package volkan.com.veriparkapp.data.model.stock_indexes_info.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by volkan on 01.11.2017 21:03.
 */

@Root(name = "soapenv:Body", strict = false)
public class ImkbIndexesRequestBody {

    @Element(name = "tem:GetForexStocksandIndexesInfo", required = false)
    private ImkbIndexesRequestData ımkbIndexesRequestData;

    public ImkbIndexesRequestBody(ImkbIndexesRequestData ımkbIndexesRequestData) {
        this.ımkbIndexesRequestData = ımkbIndexesRequestData;
    }

    public ImkbIndexesRequestData getImkbIndexesRequestData() {
        return ımkbIndexesRequestData;
    }

    public void setImkbIndexesRequestData(ImkbIndexesRequestData ımkbIndexesRequestData) {
        this.ımkbIndexesRequestData = ımkbIndexesRequestData;
    }
}
