package br.ce.rafaelsilva.appium.Page;
import static br.ce.rafaelsilva.appium.core.DriverFactory.getDriver;
import br.ce.rafaelsilva.appium.core.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CliquesPage extends BasePage {

    public void cliqueLongo(){
    	WebElement elemento = getDriver().findElement(By.xpath("//*[@text='Clique Longo']"));
    	Actions action = new Actions(getDriver());
    	action.clickAndHold(elemento); 
        
    }
    
    public String obterTextoCampo(){
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
}
