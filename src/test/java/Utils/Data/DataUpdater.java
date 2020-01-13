package Utils.Data;

import Utils.FileHandler;
import Utils.e2eConstants;

import java.io.IOException;

public class DataUpdater {

    private static FileHandler fileHandler = new FileHandler();

    public void updateData(String sheetName, String dataToWrite,String id,int cellNum){
        try {
            fileHandler.updateExcel(e2eConstants.FILE_PATH, e2eConstants.FILE_NAME, sheetName, dataToWrite, id, cellNum);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
