import Model.NexmoApiParser;
import Model.NexmoResponse;
import Model.NexmoResponseEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * Created by Alvin on 16/12/29.
 */

public class NexmoApiParserTest {

    private NexmoApiParser apiParser;


    private String xml;
    private String json;

    @Before
    public void init() throws Exception {
        String path = this.getClass().getResource("/").getPath();
        String xmlFile= path + "file/response.xml";
        String jsonFile =path +  "file/response.json";
        json = readFile(jsonFile);
        xml = readFile(xmlFile);
    }

    private String readFile(String filename) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuffer buffer = new StringBuffer();
        String line ;
        while ((line = reader.readLine()) != null){
            buffer.append(line);
        }
        return buffer.toString();
    }

    @Test
    public void testJsonToObject(){
        NexmoResponse response = new NexmoApiParser().jsonParse(json);
        Assert.assertEquals(3, response.getCount());
        for (int i =0 ;i < response.getCount(); i++){
            NexmoResponseEntity entity = response.getMessage()[i];
            System.out.println(entity);
        }
    }


    @Test
    public void testXmlToObject(){
        NexmoResponse response = NexmoApiParser.xmlParse(xml);
        Assert.assertEquals(3, response.getCount());
        for (int i =0 ;i < response.getCount(); i++){
            NexmoResponseEntity entity = response.getMessage()[i];
            System.out.println(entity);
        }
    }
}
