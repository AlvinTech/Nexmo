package Model;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Alvin on 16/12/29.
 */
@Data
@XmlRootElement(name = "mt-submission-response")
public class XmlEntity {
    private NexmoResponse messages;
}
