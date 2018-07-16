package br.ce.rafaelsilva.appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.List;

import static br.ce.rafaelsilva.appium.core.DriverFactory.getDriver;

public class BasePage {

    public void escrever(By by, String texto){
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by){
        return getDriver().findElement(by).getText();
    }

    public void clicar(By by){
        getDriver().findElement(by).click();
    }

    public void clicarPorTexto(String valor) {
        clicar(By.xpath("//*[@text='"+valor+"']"));
    }

    public void selecionarCombo(By by, String valor){
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    public boolean isCheckMArcado(By by){
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean isSwitchMArcado(By by){
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean existeElementoPorTexto(String texto){
        List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
        return elementos.size() > 0;
    }

    public void toque(int x, int y){
        new TouchAction(getDriver()).tap(PointOption.point(x,y)).perform();
    }

    public void scroll(double inicio, double fim){
        Dimension size = getDriver().manage().window().getSize();
        int x = size.width/2;

        int start_y = (int) (size.height*inicio);
        int end_y = (int) (size.height*fim);

        PointOption point = new PointOption();
        WaitOptions espera = new WaitOptions();

        new BaseTest().esperarCarregar(2000);

        new TouchAction(getDriver()).press(point.withCoordinates(x, start_y))
                .waitAction( espera.withDuration(Duration.ofMillis(500)))
                .moveTo(point.withCoordinates(x, end_y))
                .release()
                .perform();
    }

    public void swipe(double inicio, double fim){
        Dimension size = getDriver().manage().window().getSize();
        int y = size.height/2;

        int start_x = (int) (size.width * inicio);
        int end_x = (int) (size.width * fim);

        PointOption point = new PointOption();
        WaitOptions espera = new WaitOptions();

        new TouchAction(getDriver()).press(point.withCoordinates(start_x, y))
                .waitAction( espera.withDuration(Duration.ofMillis(500)))
                .moveTo(point.withCoordinates(end_x, y))
                .release()
                .perform();
    }

    public void swipeElement(MobileElement elemento, double inicio, double fim){

        int y = elemento.getLocation().y + (elemento.getSize().height / 2);

        int start_x = (int) (elemento.getSize().width* inicio);
        int end_x = (int) (elemento.getSize().width*fim);

        PointOption point = new PointOption();
        WaitOptions espera = new WaitOptions();

        new TouchAction(getDriver()).press(point.withCoordinates(start_x, y))
                .waitAction( espera.withDuration(Duration.ofMillis(500)))
                .moveTo(point.withCoordinates(end_x, y))
                .release()
                .perform();

    }
}
