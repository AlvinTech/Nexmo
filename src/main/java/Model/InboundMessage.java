package Model;

import lombok.Data;
import org.junit.validator.ValidateWith;

/**
 * Created by Alvin on 16/12/28.
 */
@Data
public class InboundMessage {

    private String msisdn;

    private String to;

    private String messageId;

    private String text;

    private String type;
    /*
    text - standard text.
    unicode - URLencoded unicode. This is valid for standard GSM, Arabic, Chinese, double-encoded characters and so on.
    binary - a binary message.
    * */

    private String keyword;

    private String timestamp;


    // If type is binary
    private String data;

    // If type is binary
    private String uhd;

    //For concatenated inbound messages
    private boolean concat;

    private String concatRef;

    private  String concatTotal;

    private String concatPart;



}

/*
{
  "msisdn": "441632960960",
  "to": "441632960961",
  "messageId": "02000000E68951D8",
  "text": "Hello7",
  "type": "text",
  "keyword": "HELLO7",
  "message-timestamp": "2016-07-05 21:46:15"
}
* */