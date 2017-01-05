package Util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Alvin on 16/12/30.
 */
public class CheckNumberUtil {

    private static final Logger logger = LoggerFactory.getLogger(CheckNumberUtil.class);

    private static final String PREFIX = "+";

    private static final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

    public boolean isValid(String phone) {
        PhoneNumber phoneNumber = format(phone);
        if (phoneNumber == null)
            return false;
        return phoneUtil.isValidNumber(phoneNumber);
    }

    public int getCountryCode(String phone) {
        PhoneNumber phoneNumber = format(phone);
        if (phoneNumber == null)
            return -1;
        int countryCode = phoneUtil.getCountryCodeForRegion(phoneUtil.getRegionCodeForNumber(phoneNumber));
        return countryCode;
    }

    public String formatPhoneNumber(String phone) {
        PhoneNumber phoneNumber = format(phone);
        if (phoneNumber == null)
            return "";
        return phoneUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
    }

    private PhoneNumber format(String phone) {
        if (!phone.startsWith(PREFIX)) {
            phone = PREFIX + phone;
        }
        try {
            PhoneNumber phoneNumber = phoneUtil.parse(phone, "");
            return phoneNumber;
        }
        catch (NumberParseException e) {
            logger.warn("Cannot parse phone number: {}  \n ", phone, e);
            return null;
        }
    }

}
