package tests.day04_MavenIlkGun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_JUnitIlkTest {

    public static void main(String[] args) throws InterruptedException {

        // ilk ayarları yapın
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // chair için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("chair" + Keys.ENTER);

        // arama sonucunda urun bulunamadığını test edin
        List<WebElement> bulunanUrunlerListesi = driver.findElements(By.xpath("//*[@*=‘product-box my-2  py-1’]"));

        int actualUrunSayisi = bulunanUrunlerListesi.size();

        if (actualUrunSayisi>0){
            System.out.println("Chair testi PASSED");
        }else {
            System.out.println("Chair testi FAILED");
        }

        // Java için arama yapın
        Thread.sleep(2000);
        aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        // arama sonucunda urun bulunamadığını test edin

        actualUrunSayisi = bulunanUrunlerListesi.size();

        if (actualUrunSayisi ==0){
            System.out.println("Java testi PASSED");
        }else {
            System.out.println("Java testi FAILED");
        }
        // sayfayi kapatın

        Thread.sleep(3000);
        driver.quit();
    }
}
