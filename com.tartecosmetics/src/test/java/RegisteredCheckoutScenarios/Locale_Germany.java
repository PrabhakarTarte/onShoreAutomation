package RegisteredCheckoutScenarios;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Locale_Germany {
	
	
{
		
		
		/*System.out.println("STATIC  Registered user"+System.getProperty("user.dir")+"\\atu.properties");
		System.setProperty("atu.reporter.config",
   			System.getProperty("user.dir")+"\\atu.properties");*/
		
		
		
	}
	
	
	RunnerScripts rsc= new RunnerScripts();;
	@Test
	@Parameters({ "DataSheetRow"})
	public void reg_Promo_CreditCard(String dataRow) throws Exception {
		 int row= Integer.parseInt(dataRow);
		rsc.suiteRunner("Germany",row);
	}	

}
