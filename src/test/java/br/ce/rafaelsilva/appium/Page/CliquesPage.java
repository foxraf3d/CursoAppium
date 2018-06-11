package br.ce.rafaelsilva.appium.Page;
import static br.ce.rafaelsilva.appium.core.DriverFactory.getDriver;
import br.ce.rafaelsilva.appium.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

public class CliquesPage extends BasePage {

    public void cliqueLongo(){
    	WebElement elemento = getDriver().findElement(By.xpath("//*[@text='Clique Longo']"));
    	//Actions action = new Actions(getDriver());
    	//action.clickAndHold(elemento);

        /*TouchAction action = new TouchAction(getDriver());
        action.longPress((LongPressOptions) elemento).perform();*/

        TouchActions action = new TouchActions(getDriver());
        action.longPress(elemento);
        action.perform();

        
    }
    
    public String obterTextoCampo(){
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
}
