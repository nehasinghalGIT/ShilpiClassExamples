package come.walmart.utilities;

import org.testng.annotations.DataProvider;

public class WTGDataProvider {

	@DataProvider(name="invalidlogin")
	public static Object[][] mydata(){
		
		return new Object[][] {
				{"test@test.com","wbqa"},
				{"shilpi@innova-path.com","wbqa"},
				{"shilpi@innova-path.com","WHITEBOXQA"}
		};
	}
}
