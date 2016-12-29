package Model;

import lombok.Data;

/**
 * Created by Alvin on 16/12/28.
 */
@Data
public class DeliveryReceipt {

    private String messageId;

    private String msisdn;

    private String to;

    private String networkCode;

    private float price;

    private String status;

    private String scts;

    private int errCode;

    private String timestamp;

    private String clientRef;
}

/**
 "msisdn": "441632960960",
 "to": "441632960961",
 "network-code": "52099",
 "messageId": "02000000E68951D8",
 "price": "0.02000000",
 "status": "delivered",
 "scts": "1208121359",
 "err-code": "0",
 "message-timestamp": "2016-07-05 21:46:15"
 */