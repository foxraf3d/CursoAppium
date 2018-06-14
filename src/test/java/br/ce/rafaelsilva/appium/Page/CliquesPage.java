package br.ce.rafaelsilva.appium.Page;
import static br.ce.rafaelsilva.appium.core.DriverFactory.getDriver;
import br.ce.rafaelsilva.appium.core.BasePage;
import br.ce.rafaelsilva.appium.core.BaseTest;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CliquesPage extends BasePage {

    public void cliqueLongo(){
    	WebElement elemento = getDriver().findElement(By.xpath("//*[@text='Clique Longo']"));
    	ElementOption ele = new ElementOption();
        ele.withElement(elemento);

        new TouchAction(getDriver()).longPress(new LongPressOptions().withElement(ele)).release().perform();

        
    }
    
    public String obterTextoCampo(){
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
}
