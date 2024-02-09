package tests.day14_ScreenShot_jsExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_TumSayfaScreenShot extends TestBase {

    @Test
    public void aramaTesti(){

        // testotomasyon anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // doğru sayfaya gittiğinizi test edin
        String expectedUrl = "https://www.testotomasyonu.com/" ;
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

        // screenshot alin
        ReusableMethods.tumSayfaScreenShot(driver);

        // phone için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildiğini test edin
        WebElement products = driver.findElement(By.xpath("//*[@*='product-count-text']"));

        String unExpectedSonucYazisi = "0 Products Found";
        String actulaSonucYazisi = products.getText();

        Assert.assertNotEquals(unExpectedSonucYazisi,actulaSonucYazisi);

        // screenshot alın
        ReusableMethods.tumSayfaScreenShot(driver,"Arama sonucu screenshot");

        ReusableMethods.bekle(2);
    }
}
