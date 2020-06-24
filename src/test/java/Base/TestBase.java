package Base;

import org.testng.annotations.DataProvider;

public class TestBase {
	
	@DataProvider(name="getCredentialsAsDP")
	public Object[][] getCredentials(){
		String[][] credArray= new String [2][2]; 
		/*try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File("./Data/Credentials.xlsx")));
			
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			Iterator<Row> itSheet = sheet.rowIterator();
			
			int iRow = 0;
			
			while (itSheet.hasNext()){
				Row row = itSheet.next();
				
					int iCol = 0;
					
					Iterator<Cell> itRow = row.cellIterator(); 
					
					while (itRow.hasNext()){
						Cell cell = itRow.next();
						String cellVal = cell.getStringCellValue();
						credArray[iRow][iCol] = cellVal;
						iCol++;
					}
					
				
				iRow++;
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		return credArray;
		
	}
}
