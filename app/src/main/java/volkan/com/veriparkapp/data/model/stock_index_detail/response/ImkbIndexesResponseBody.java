package volkan.com.veriparkapp.data.model.stock_index_detail.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by volkan on 01.11.2017 21:25.
 */

@Root(name = "Body", strict = false)
public class ImkbIndexesResponseBody {
    @Element(name = "GetForexStocksandIndexesInfoResponse", required = false)
    private GetForexStocksandIndexesInfoResponse data;

    public GetForexStocksandIndexesInfoResponse getData() {
        return data;
    }

    public void setData(GetForexStocksandIndexesInfoResponse data) {
        this.data = data;
    }
}
