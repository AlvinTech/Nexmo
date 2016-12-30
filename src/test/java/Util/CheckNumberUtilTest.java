package Util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alvin on 16/12/30.
 */
public class CheckNumberUtilTest {

    private CheckNumberUtil numberUtil = new CheckNumberUtil();

    private String tel = "86 158 5817 8699";
    private String[] phones = {
            "86 158 5817 8699",
            "55 48 9187 8951",
            "55 11 8444 8383",
            "55 48 3333 1551",
            "55 11 98444 8383",
            "55 48 99187 8951"
    };

    boolean[] result = {true,true,false,true,true,true};

    private String[] formatPhones = {
            "+86 158 5817 8699",
            "+55 48 9187-8951",
            "+55 11 8444-8383",
            "+55 48 3333-1551",
            "+55 11 98444-8383",
            "+55 48 99187-8951"
    };

    private int[] countryCodes= {86,55,55,55,55,55};
    @Test public void isValid() throws Exception {
        for (int i =0; i <phones.length; i++){
            Assert.assertEquals(phones[i],result[i],numberUtil.isValid(phones[i]));
        }
    }

    @Test
    public void testFormate(){
        for (int i =0; i <phones.length; i++){
            Assert.assertEquals(phones[i],formatPhones[i],numberUtil.formatPhoneNumber(phones[i]));
        }
    }

    @Test
    public void testCountryCode(){
        for (int i =0; i <phones.length; i++){
            Assert.assertEquals(phones[i],countryCodes[i],numberUtil.getCountryCode(phones[i]));
        }
    }


    @Test
    public void testException(){
        numberUtil.isValid("098dnxndf123123#%^&*)");
    }

}