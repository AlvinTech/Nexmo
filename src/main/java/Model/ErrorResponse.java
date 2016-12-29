package Model;

import lombok.Data;

/**
 * Created by Alvin on 16/12/28.
 */

@Data
public class ErrorResponse {
    private int count;

    private ErrorResponseEntity[] messages;

}

/*
{
  "message-count":"1",
  "messages":[
    {
    "status":"2",
    "error-text":"Missing from param"
    }
  ]
}
* */
