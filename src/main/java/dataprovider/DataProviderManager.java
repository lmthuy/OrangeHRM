package dataprovider;

import helpers.ExcelHelpers;
import helpers.Helpers;
import org.testng.annotations.DataProvider;

public class DataProviderManager {


    @DataProvider(name = "data_provider_login_from_excel", parallel = true)
    public Object[][] dataLoginHRMFromExcel() {

        ExcelHelpers excelHelpers = new ExcelHelpers();

        Object[][] data = excelHelpers.getExcelDataHashTable(Helpers.getCurrentDir() + "data/Login.xlsx", "Sheet1",1,3);

        return data;
    }


}
