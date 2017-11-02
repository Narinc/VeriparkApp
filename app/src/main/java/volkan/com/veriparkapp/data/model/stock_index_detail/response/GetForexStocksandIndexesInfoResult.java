package volkan.com.veriparkapp.data.model.stock_index_detail.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by volkan on 02.11.2017 00:38.
 */
@Root(name = "GetForexStocksandIndexesInfoResult", strict = false)
public class GetForexStocksandIndexesInfoResult {

    @Element(name = "RequestResult",required = false)
    private RequestResult requestResult;

    @ElementList(name = "StocknIndexesResponseList",required = false)
    private List<StockandIndex> stockandIndexes;

    @ElementList(name = "StocknIndexesGraphicInfos",required = false)
    private List<StockandIndexGraphic> ındexGraphicList;

    public RequestResult getRequestResult() {
        return requestResult;
    }

    public void setRequestResult(RequestResult requestResult) {
        this.requestResult = requestResult;
    }

    public List<StockandIndex> getStockandIndexes() {
        return stockandIndexes;
    }

    public void setStockandIndexes(List<StockandIndex> stockandIndexes) {
        this.stockandIndexes = stockandIndexes;
    }

    public List<StockandIndexGraphic> getIndexGraphicList() {
        return ındexGraphicList;
    }

    public void setIndexGraphicList(List<StockandIndexGraphic> ındexGraphicList) {
        this.ındexGraphicList = ındexGraphicList;
    }
}
