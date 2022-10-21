package com.mediTrash.app.Tools.ExcelCreator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import com.mediTrash.app.Data.Trash;
import com.mediTrash.app.Tools.Methods.getTrash;
import com.mediTrash.app.Tools.Methods.getAPName;
import com.mediTrash.app.Tools.Methods.getAPid;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Data {

    public void Data() throws SQLException, FileNotFoundException {
        List<Trash> trashList;
        getTrash getTrash = new getTrash();
        trashList = getTrash.getTrash(2);
        getAPid getAPid = new getAPid();
        getAPName getAPName = new getAPName();
        String apName, date;
        int apID;
        try {
            HSSFWorkbook wb = new HSSFWorkbook();
            OutputStream output = new FileOutputStream("Odpad.xls");
            HSSFSheet sheet = wb.createSheet("Odpad");
            HSSFRow rowhead = sheet.createRow(0);
            rowhead.createCell(0).setCellValue("Nazev");
            rowhead.createCell(1).setCellValue("Množství");
            rowhead.createCell(2).setCellValue("id odpadu");
            rowhead.createCell(3).setCellValue("id zodpovědný osoby");
            rowhead.createCell(4).setCellValue("jmeno zodpovědný osoby ");
            rowhead.createCell(5).setCellValue("datum");
            for (int i = 0; i < trashList.size(); i++) {
                apID = getAPid.getAPid(trashList.get(i).getTrashId());
                apName = getAPName.getAPName(apID);
                date = getAPName.getDate(apID);
                HSSFRow row = sheet.createRow(i+1);
                row.createCell(0).setCellValue(trashList.get(i).getNameOfTrash());
                row.createCell(1).setCellValue(trashList.get(i).getCountOfTrash());
                row.createCell(2).setCellValue(trashList.get(i).getTrashId());
                row.createCell(3).setCellValue(apID);
                row.createCell(4).setCellValue(apName);
                row.createCell(5).setCellValue(date);
            }
            wb.write(output);
            output.close();
            wb.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
