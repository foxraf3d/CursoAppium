package br.ce.rafaelsilva.appium.Page;

import br.ce.rafaelsilva.appium.core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static br.ce.rafaelsilva.appium.core.DriverFactory.getDriver;

public class SwipeListPage extends BasePage {

    public void swipeLeft(String path, double inicio, double fim){

        Dimension sizeElement = getDriver().findElement(By.xpath(path)).getSize();

        int y = sizeElement.height/2;

        int start_x = (int) (sizeElement.width*inicio);
        int end_x = (int) (sizeElement.width*fim);

        PointOption point = new PointOption();
        WaitOptions espera = new WaitOptions();

        new TouchAction(getDriver()).press(point.withCoordinates(start_x, y))
                .waitAction( espera.withDuration(Duration.ofMillis(500)))
                .moveTo(point.withCoordinates(end_x, y))
                .release()
                .perform();


    }

    public void clicarBotaoMais(){

        String path = "//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='2']/android.view.ViewGroup[@index='1']";
        Dimension size = getDriver().findElement(By.xpath(path)).getSize();


        int y = size.height/2;
        int x = size.width*2;


        PointOption point = new PointOption();
        WaitOptions espera = new WaitOptions();

        new TouchAction(getDriver()).press(point.withCoordinates(x, y))
                .waitAction( espera.withDuration(Duration.ofMillis(500)))
                .release()
                .perform();
    }

    public void clicarBotaoMenos(){
        String path = "//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='2']/android.view.ViewGroup[@index='1']/android.widget.TextView[@text='(-)']";
        getDriver().findElement(By.xpath(path)).click();
    }

}
