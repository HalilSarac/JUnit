package tests.day05_annotations_assertion;

import org.junit.Ignore;
import org.junit.Test;

public class C01_TestNotasyonu {
    /*
        @Test Notasyonu sıradan bir methodu
        bağımsız olarak çalıştırılabilen bir test methoduna dönüştürür

        bir classta birden fazla test metodu varsa
        istersek her bir method'u tek başına,
        isterse de class level'dan çalıştırıp toplu olarak çalıştırabiliriz

        JUnit'de test method'lari toplu çalıştırıldığında
        hangi sıralama ile çalışacağını BİLEMEYİZ ve KONTROL EDEMEYIZ

        Eğer çalışmasını istemediğimiz bir test methodu varsa
        @Ignore notasyonu kullanabiliriz
     */

    @Test
    public void testOtomasyonu(){
        System.out.println("testOtomasyonu testi çalıştı");
    }

    @Test @Ignore
    public void wisequarterTest(){
        System.out.println("wisequarter testi çalıştı");
    }

    @Test
    public void youtubeTest(){
        System.out.println("youtube testi çalıştı");
    }
}
