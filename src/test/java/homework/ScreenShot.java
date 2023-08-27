package homework;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class ScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {

       driver.get("https://amazon.com");

       String dosyaYolu = "src/test/java/utilities/ekranGoruntuleri/amazonScreenShot.jpeg";
        TakesScreenshot ts= (TakesScreenshot) driver; //
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }

    @Test
    public void test02() throws IOException {
        driver.get("https://www.amazon.com");
        String dosyayolu = "target/screenShot/amazonresim.png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyayolu));

    }
}
