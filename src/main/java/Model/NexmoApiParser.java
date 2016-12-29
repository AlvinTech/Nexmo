package Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by alvin on 1/26/16.
 */
public class NexmoApiParser {

    private final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(NexmoApiParser.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    private static final XmlMapper xmlMapper = new XmlMapper();


    public static NexmoResponse jsonParse(String content) {
        logger.info("log");
        if (StringUtils.isNotBlank(content)) {
            try {
                NexmoResponse nexmoResponse = mapper.readValue(content, NexmoResponse.class);
                if (null != nexmoResponse && !ArrayUtils.isEmpty(nexmoResponse.getMessage())) {
                    return nexmoResponse;
                } else {
                    logger.warn("API response invalid,{}", content);
                    return null;
                }
            } catch (IOException e) {
                logger.warn("can not parse API response ,{},Exception:{}", content, e);
                e.printStackTrace();
                return null;
            }
        }
        logger.warn("API response is blank,content:{}", content);
        return null;
    }

    public static NexmoResponse xmlParse(String xml){
        logger.info("log");
        try {
            JAXBContext context = JAXBContext.newInstance(XmlEntity.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            XmlEntity response = (XmlEntity)unmarshaller.unmarshal(new StringReader(xml));
            return response.getMessages();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
