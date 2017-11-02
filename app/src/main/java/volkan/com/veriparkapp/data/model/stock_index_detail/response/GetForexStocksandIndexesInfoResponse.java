package volkan.com.veriparkapp.data.model.stock_index_detail.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by volkan on 01.11.2017 21:26.
 */

@Root(name = "GetForexStocksandIndexesInfoResponse", strict = false)
@Namespace(reference = "http://tempuri.org/")
public class GetForexStocksandIndexesInfoResponse {

    @Element(name = "GetForexStocksandIndexesInfoResult",required = false)
    private GetForexStocksandIndexesInfoResult ınfoResult;

    public GetForexStocksandIndexesInfoResult getInfoResult() {
        return ınfoResult;
    }

    public void setInfoResult(GetForexStocksandIndexesInfoResult ınfoResult) {
        this.ınfoResult = ınfoResult;
    }
}
