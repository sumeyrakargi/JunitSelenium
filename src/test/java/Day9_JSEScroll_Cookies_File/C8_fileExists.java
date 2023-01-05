package Day9_JSEScroll_Cookies_File;

import org.junit.Assert;

import java.io.File;

public class C8_fileExists {
    public static void main(String[] args) {

        System.out.println(System.getProperty("user.home"));//home yolunu yazdırdık
        String homePath=System.getProperty("user.home");//home yolunu atadık
        String filePath="\\src/test/java/resources/fileExist.png";//dosyanın kalan yolunu atadık
        String fullPath=homePath+filePath;//home ve dosya yollarımızı birleştirdik full path i elde ettik
        File image=new File(fullPath);//Pathimizi file e çevirdik
        Assert.assertTrue(image.exists());//exists methodu ile var olup olmadığını kontrol ettik
    }
}
