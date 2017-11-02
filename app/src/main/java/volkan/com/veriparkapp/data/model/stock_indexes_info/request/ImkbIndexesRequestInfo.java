package volkan.com.veriparkapp.data.model.stock_indexes_info.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by volkan on 02.11.2017 00:12.
 */

@Root(name = "tem:request", strict = false)
public class ImkbIndexesRequestInfo {
    @Element(name = "tem:IsIPAD", required = false)
    private boolean isIPAD;

    @Element(name = "tem:DeviceID", required = false)
    private String DeviceID;

    @Element(name = "tem:DeviceType", required = false)
    private String DeviceType;

    @Element(name = "tem:RequestKey", required = false)
    private String requestKey;

    public ImkbIndexesRequestInfo(boolean isIPAD, String deviceID, String deviceType, String requestKey) {
        this.isIPAD = isIPAD;
        DeviceID = deviceID;
        DeviceType = deviceType;
        this.requestKey = requestKey;
    }

    public boolean isIPAD() {
        return isIPAD;
    }

    public void setIPAD(boolean IPAD) {
        isIPAD = IPAD;
    }

    public String getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(String deviceID) {
        DeviceID = deviceID;
    }

    public String getDeviceType() {
        return DeviceType;
    }

    public void setDeviceType(String deviceType) {
        DeviceType = deviceType;
    }

    public String getRequestKey() {
        return requestKey;
    }

    public void setRequestKey(String requestKey) {
        this.requestKey = requestKey;
    }
}
