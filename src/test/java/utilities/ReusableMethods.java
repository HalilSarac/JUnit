package utilities;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.StringList;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> stringListeCevir(List<WebElement> webElementList){

        List<String> stringList = new ArrayList<>();

        for (WebElement eachElement : webElementList
            ){

            stringList.add(eachElement.getText());
        }
        return stringList;
    }

    static public void titleWindowDegistir(String hedefTitle, WebDriver driver){

        Set<String> whdSeti = driver.getWindowHandles();

        for (String eachWhd : whdSeti
        ){
            driver.switchTo().window(eachWhd);
            String oldugumuzWindowTitle = driver.getTitle();
            if (oldugumuzWindowTitle.equals(hedefTitle)){
                break;
            }
        }
    }
    public static void tumSayfaScreenShot(WebDriver driver){

        // 1- bir TakesScrenShoot objesi oluşturun ve değer alarak driver'i atayin

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- screenShot'ı kaydedeceğimiz bir dosya oluşturalım
        // screenshot ismini unique yapabilmek için, timestamp ekleyelim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter zamanFormati = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String timeStamp = ldt.format(zamanFormati);

        File kursScreenShot = new File("target/kursScreenShots/TumSayfa"+timeStamp+".jpeg");

        // 3- tss objesini kullanarak screenShot alın ve bir file olarak kaydedin

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4- geçiçi dosyayı değer olarak asıl kaydedilecek File'a kopyalayın

        try {
            FileUtils.copyFile(geciciDosya,kursScreenShot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tumSayfaScreenShot(WebDriver driver,String resimAdi){

        // 1- bir TakesScrenShoot objesi oluşturun ve değer alarak driver'i atayin

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- screenShot'ı kaydedeceğimiz bir dosya oluşturalım

        File kursScreenShot = new File("target/kursScreenShots/"+resimAdi+".jpeg");

        // 3- tss objesini kullanarak screenShot alın ve bir file olarak kaydedin

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4- geçiçi dosyayı değer olarak asıl kaydedilecek File'a kopyalayın

        try {
            FileUtils.copyFile(geciciDosya,kursScreenShot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void webelementScreenshot(WebElement webElement){

        // 1- screenshot alacaginiz webelementi locate edip kaydedin
        // 2- screenshot'i kaydedecegimiz dosyayi olusturun
        //    screenshot ismini unique yapabilmek icin, timestamp ekleyelim
        LocalDateTime ldt = LocalDateTime.now(); // 2024-01-24T19:01:05.777116
        DateTimeFormatter zamanFormati = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String timeStamp = ldt.format(zamanFormati); // 240124190341

        File webelementSS = new File("target/webelementScreenshots/webElement"+timeStamp+".jpg");

        // 3- webelementi kullanarak screeshot alin ve gecici dosyaya kaydedin
        File geciciScreenshot = webElement.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi asil dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciScreenshot,webelementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void webelementScreenshot(WebElement webElement,String screenshotIsim){
        // 1- screenshot alacaginiz webelementi locate edip kaydedin
        // 2- screenshot'i kaydedecegimiz dosyayi olusturun
        //    screenshot ismini unique yapabilmek icin, timestamp ekleyelim
        LocalDateTime ldt = LocalDateTime.now(); // 2024-01-24T19:01:05.777116
        DateTimeFormatter zamanFormati = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String timeStamp = ldt.format(zamanFormati); // 240124190341

        File webelementSS = new File("target/webelementScreenshots/"+screenshotIsim+timeStamp+".jpg");

        // 3- webelementi kullanarak screeshot alin ve gecici dosyaya kaydedin
        File geciciScreenshot = webElement.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi asil dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciScreenshot,webelementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
