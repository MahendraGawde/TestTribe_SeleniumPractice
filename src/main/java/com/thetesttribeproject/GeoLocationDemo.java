package com.thetesttribeproject;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class GeoLocationDemo {
    ChromeDriver driver;
    @Test
    public void mockGeoLocation(){

        driver = new ChromeDriver();
        Map coordinates = new HashMap(){{
            put("latitude",37.7739);
            put("longitude",-122.4312);
            put("accuracy",1);
        }};
        driver.manage().window().maximize();
        driver.executeCdpCommand("Emulation.setGeolocationOverride",coordinates);
        driver.get("https://where-am-i.org");

    }
}
