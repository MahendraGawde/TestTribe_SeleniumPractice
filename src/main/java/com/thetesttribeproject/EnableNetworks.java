package com.thetesttribeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Optional;

import static org.openqa.selenium.devtools.v129.network.Network.loadingFailed;
import static org.testng.Assert.assertEquals;

public class EnableNetworks {
    EdgeDriver driver;
    DevTools devTools;

    @BeforeMethod
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        devTools = driver.getDevTools();
    }

    @Test(priority = 0)
    public void loadApplicationRegular(){
        driver.get("https://www.linkedin.com");
        System.out.println("Normal speed " +driver.getTitle());
    }
    @Test(priority = 2)
    public void enableSlowNetwork(){
        devTools.createSession();
        devTools.send(Network.enable(
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));

        devTools.send(Network.emulateNetworkConditions(
                false,
                100,
                1100,
                900,
                Optional.of(ConnectionType.CELLULAR3G)));
        driver.get("https://www.linkedin.com");

        System.out.println("Slow Network 3G " +driver.getTitle());
    }

    @Test(priority = 1)
    public void enableOfflineNetwork(){
        devTools.createSession();
        devTools.send(Network.enable(
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));

        devTools.send(Network.emulateNetworkConditions(
                true,
                10,
                100,
                50,
                Optional.of(ConnectionType.WIFI)));
        devTools.addListener(loadingFailed(),loadingFailed -> assertEquals(loadingFailed.getErrorText(),
                "net::ERR_INTERNET_DISCONNECTED"));

        try{
            driver.get("https://www.google.com");
        }catch(WebDriverException exc){
            driver.findElement(By.id("game-button")).click();
            System.out.println("Offline " +driver.getTitle()+ " Page did not load");
        }
    }

}
