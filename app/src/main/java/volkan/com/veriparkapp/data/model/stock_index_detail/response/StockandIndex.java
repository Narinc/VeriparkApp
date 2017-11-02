package volkan.com.veriparkapp.data.model.stock_index_detail.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by volkan on 02.11.2017 00:43.
 */
@Root(name = "StockandIndex", strict = false)
public class StockandIndex implements Serializable{
    @Element(name = "Symbol",required = false)
    private String symbol;
    @Element(name = "Price",required = false)
    private double price;
    @Element(name = "Difference",required = false)
    private double difference;
    @Element(name = "Volume",required = false)
    private double volume;
    @Element(name = "Buying",required = false)
    private double buying;
    @Element(name = "Selling",required = false)
    private double selling;
    @Element(name = "Hour",required = false)
    private int hour;
    @Element(name = "DayPeakPrice",required = false)
    private double dayPeakPrice;
    @Element(name = "DayLowestPrice",required = false)
    private double dayLowestPrice;
    @Element(name = "Total",required = false)
    private int total;
    @Element(name = "IsIndex",required = false)
    private boolean isIndex;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getBuying() {
        return buying;
    }

    public void setBuying(double buying) {
        this.buying = buying;
    }

    public double getSelling() {
        return selling;
    }

    public void setSelling(double selling) {
        this.selling = selling;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public double getDayPeakPrice() {
        return dayPeakPrice;
    }

    public void setDayPeakPrice(double dayPeakPrice) {
        this.dayPeakPrice = dayPeakPrice;
    }

    public double getDayLowestPrice() {
        return dayLowestPrice;
    }

    public void setDayLowestPrice(double dayLowestPrice) {
        this.dayLowestPrice = dayLowestPrice;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isIndex() {
        return isIndex;
    }

    public void setIndex(boolean index) {
        isIndex = index;
    }
}
