package volkan.com.veriparkapp.data.model.stock_index_detail.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by volkan on 02.11.2017 21:04.
 */
@Root(name = "StockandIndexGraphic", strict = false)
public class StockandIndexGraphic {

    @Element(name = "Price",required = false)
    private double price;

    @Element(name = "Date",required = false)
    private String date;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
