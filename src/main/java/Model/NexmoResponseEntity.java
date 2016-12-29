package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by alvin on 1/26/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class NexmoResponseEntity {

    @JsonProperty("message-id")
    private String messageId;

    @JsonProperty("status")
    private int status;

    @JsonProperty("to")
    private String to;

    @JsonProperty("client-ref")
    private String clientRef;

    @JsonProperty("remaining-balance")
    private String remainingBalance;

    @JsonProperty("message-price")
    private String messagePrice;

    @JsonProperty("network")
    private String network;

    @JsonProperty("error-text")
    private String errorText;


    @Override
    public String toString(){
        String slipt  = ": ";
        String result = "messageId" +slipt + messageId + '\n' +
                "status" + slipt + status + '\n' +
                "clientRef" + slipt + clientRef + '\n' +
                "to" + slipt + to + '\n' +
                "remainingBalance" + slipt + remainingBalance + '\n' +
                "messagePrice" + slipt + messagePrice + '\n' +
                "network" + slipt + network + '\n' +
                "errorText" + slipt + errorText+ '\n';
        return result;
    }
}
