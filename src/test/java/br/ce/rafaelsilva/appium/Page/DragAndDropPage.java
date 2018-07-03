package br.ce.rafaelsilva.appium.Page;
import br.ce.rafaelsilva.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import static br.ce.rafaelsilva.appium.core.DriverFactory.getDriver;

public class DragAndDropPage extends BasePage {

    public void arrastar(String origem, String destino){
        WebElement inicio = getDriver().findElement(By.xpath("//*[@text='"+ origem +"']"));
        WebElement fim = getDriver().findElement(By.xpath("//*[@text='"+ destino +"']"));

        ElementOption eleInicio = new ElementOption().withElement(inicio);
        ElementOption eleFim =  new ElementOption().withElement(fim);

        new TouchAction(getDriver())
                .longPress(new LongPressOptions().withElement(eleInicio))
                .moveTo(eleFim)
                .release()
                .perform();
    }

    public String[] obterLista(){
        List<MobileElement> elements = getDriver().findElements(By.className("android.widget.TextView"));
        String[] retorno = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++){
            retorno[i] = elements.get(i).getText();
            System.out.print("\"" + retorno[i] + "\", ");
        }
        return retorno;
    }

}
