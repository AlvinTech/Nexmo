package Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by alvin on 1/26/16.
 */

public class NexmoResponse {

    @JsonProperty("message-count")
    private int count;

    @JsonProperty("messages")
    private NexmoResponseEntity[] message;

    @XmlAttribute(name = "count")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public NexmoResponseEntity[] getMessage() {
        return message;
    }

    public void setMessage(NexmoResponseEntity[] message) {
        this.message = message;
    }
}
/**
 * https://docs.nexmo.com/api-ref/sms-api/response
 * you can find detail message in this URL
 * <p/>
 * <p/>
 * nexmo message body:
 * <p/>
 * { "message-count":"1", "messages":[ { "status":"returnCode",
 * "message-id":"messageId", "to":"to", "client-ref":"client-ref",
 * "remaining-balance":"remaining-balance", "message-price":"message-price",
 * "network":"network", "error-text":"error-message" } ] }
 * <p/>
 * only returnCode = 0 is succes.
 * only returnCode = 1 need try.
 */

