package Day9_JSEScroll_Cookies_File;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C7_FileExist {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));//projemizin root yolunu verir

        String projectRoot = System.getProperty("user.dir");// // Bulmak istedigimiz file proje
        // icerisinde oldugundan proje yolunu aldik

        String filePath ="\\src/test/java/resources/1668971312966.jpg";//// Bulmak istedigimiz dosyanin proje klasorunden sonraki yolunu aldik
        // (Copy path from content root)

        filePath=projectRoot+filePath;//Almis oldugumuz 2 yolu birlestirip absolute path imizi elde ettik

        Files.exists(Paths.get(filePath));//// Bu path de bir dosya olup olmadigini dogruladik

        if (Files.exists(Paths.get(filePath))){
            System.out.println("Dosya bulundu");
        }else{
            System.out.println("Dosya bulunamadı");
        }
    }

}
