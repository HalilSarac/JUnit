package tests.day07_jsAlerts_iFrame;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C04_IFrame extends TestBase {

    @Test
    public void iFrameTesti(){

        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur olduğunu test edin
            //kullanacağımız elementin locate'inden %100 emin olmamıza rağmen
            //NoSuchElementException verdi
            //Kontrol Ettiğimizde kullanacağımız elementin bir iFrame içerisinde olduğunu gördük

                //1. adım : geçiş yapacağımız iFrame'i locate etmek
                WebElement electronicsIframe = driver.findElement(By.xpath("(//iframe[@frameborder='1'])[1]"));

                //2. adım : locate ettiğimiz iFrame'e geçiş yapalım
                driver.switchTo().frame(electronicsIframe);

                //3. adım : iFrame içindeki elementleri kullan
        WebElement electronicProductsElementi = driver.findElement(By.xpath("//h2[text()='Electronics Products']"));

        Assert.assertTrue(electronicProductsElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement bilgisayarElementi = driver.findElement(By.xpath("//span[text()='DELL Core I3 11th Gen ']"));

        String expectedIsimElementi ="DELL Core I3 11th Gen";
        String actualIsimElementi = bilgisayarElementi.getText();

        Assert.assertEquals(expectedIsimElementi,actualIsimElementi);

    driver.switchTo().defaultContent();

        //4- Sagdaki bolumde gorunen urunler arasinda ‘Men Slim Fit’
        //   içeren en az 1 urun olduğunu test edin
                WebElement menSlimFitIframe = driver.findElement(By.xpath("(//iframe[@frameborder='1'])[2]"));

                driver.switchTo().frame(menSlimFitIframe);

        List<WebElement> fashionProdWEList = driver.findElements(By.xpath("//*[@class='image-gallery']"));

        List<String> fashionProdSTRList = ReusableMethods.stringListeCevir(fashionProdWEList);

        for (int i = 0; i < fashionProdSTRList.size(); i++) {

            Assert.assertTrue(fashionProdSTRList.get(i).contains("Men Slim Fit"));
        }

        //5- Fashion yazisinin gorunur olduğunu test edin
        WebElement fashion = driver.findElement(By.xpath("//h2[text()='Fashion']"));

        Assert.assertTrue(fashion.isDisplayed());

        // 6- Here are some products. yazısının görünür olduğunu test edin
        //    yazi ana sayfada olduğundan

        driver.switchTo().defaultContent();

        WebElement hereAreSomeProductsElementi = driver.findElement(By.xpath("//*[text()=‘Here are some products.’]"));

        Assert.assertTrue(hereAreSomeProductsElementi.isDisplayed());

        ReusableMethods.bekle(5);
    }
}
