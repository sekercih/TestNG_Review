package test.day21;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C03_ReusableMethodsExcel01 {
    // bir method olusturalim
    // dosya yolu, sayfa ismi ve satir, hucre index'ini verince hucre bilgisini yazdirsin

    public static Cell hucreGetir(String path, String sayfaIsmi, int satirIndex, int hucreIndex){

        Cell cell=null;

        try {
            FileInputStream fileInputStream=new FileInputStream(path);

            Workbook workbook= WorkbookFactory.create(fileInputStream);
            cell=workbook.getSheet(sayfaIsmi).getRow(satirIndex).getCell(hucreIndex);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cell;
    }
//! **************** Aşağı kısmı Excel Mape yükleme kılasında yazacağız.*******************

    public static Map<String,String> mapOlustur(String path, String sayfaAdi) {

        Map<String,String> excelMap = new TreeMap<>();
        Workbook workbook=null;
        // ilk adim excel'de istenen sayfaya ulasmak
        try {
            FileInputStream fis = new FileInputStream(path);

            workbook = WorkbookFactory.create(fis);


        } catch (IOException e) {
            e.printStackTrace();
        }

        int satirSayisi=workbook.getSheet(sayfaAdi).getLastRowNum();
        String key="";
        String value="";

        for(int i=0; i<=satirSayisi; i++){
            // ikinci adim tablodaki hucreleri Map'e uygun hale donusturmek
            key=workbook.getSheet(sayfaAdi).getRow(i).getCell(0).toString();
            value=workbook.getSheet(sayfaAdi).getRow(i).getCell(1).toString()+
                    ", " + workbook.getSheet(sayfaAdi).getRow(i).getCell(2).toString()+
                    ", " + workbook.getSheet(sayfaAdi).getRow(i).getCell(3).toString();

            // ucuncu adim key-value haline getirdigimiz satirlari Map'e eklemek
            excelMap.put(key,value);



        }

        return excelMap;






    }

}
