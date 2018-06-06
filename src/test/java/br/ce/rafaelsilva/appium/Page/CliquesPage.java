package br.ce.rafaelsilva.appium.Page;
import static br.ce.rafaelsilva.appium.core.DriverFactory.getDriver;
import br.ce.rafaelsilva.appium.core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.By;

public class CliquesPage extends BasePage {

    public void cliqueLongo(){
        TouchAction action = new TouchAction(getDriver());
        //action.longPress(getDriver().findElement(By.xpath("//*[@text='Clique Longo']")));
        action.perform();
    }

    public String obterTextoCampo(){
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
}
