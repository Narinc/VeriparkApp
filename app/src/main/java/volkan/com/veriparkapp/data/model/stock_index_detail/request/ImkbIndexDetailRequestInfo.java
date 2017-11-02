package volkan.com.veriparkapp.data.model.stock_index_detail.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by volkan on 02.11.2017 00:12.
 */

@Root(name = "tem:request", strict = false)
public class ImkbIndexDetailRequestInfo {
    @Element(name = "tem:IsIPAD", required = false)
    private boolean isIPAD;

    @Element(name = "tem:DeviceID", required = false)
    private String deviceID;

    @Element(name = "tem:DeviceType", required = false)
    private String deviceType;

    @Element(name = "tem:RequestKey", required = false)
    private String requestKey;

    @Element(name = "tem:RequestedSymbol", required = false)
    private String requestedSymbol;

    @Element(name = "tem:Period", required = false)
    private String period;

    public ImkbIndexDetailRequestInfo(boolean isIPAD, String deviceID, String deviceType, String requestKey, String requestedSymbol, String period) {
        this.isIPAD = isIPAD;
        this.deviceID = deviceID;
        this.deviceType = deviceType;
        this.requestKey = requestKey;
        this.requestedSymbol = requestedSymbol;
        this.period = period;
    }

    public boolean isIPAD() {
        return isIPAD;
    }

    public void setIPAD(boolean IPAD) {
        isIPAD = IPAD;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getRequestKey() {
        return requestKey;
    }

    public void setRequestKey(String requestKey) {
        this.requestKey = requestKey;
    }

    public String getRequestedSymbol() {
        return requestedSymbol;
    }

    public void setRequestedSymbol(String requestedSymbol) {
        this.requestedSymbol = requestedSymbol;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
