
package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class DropdownMenu extends TestBase {
    @Test
    public void dropdownTest() {
        // -Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        // -Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);

        List<WebElement> menuler = select.getOptions();
        menuler.forEach(t-> System.out.println(t.getText()));

        // -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        // başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
        for(int i = 0; i <5;i++) {
            WebElement ddm1 = driver.findElement(By.xpath("//select"));
            Select select1 = new Select(ddm1);
            select1.selectByIndex(i);
            List<WebElement> menuler1 = select1.getOptions();
            System.out.println("ilk "+ i +" tanesi :" + menuler1.get(i).getText());
        }


    }
}
