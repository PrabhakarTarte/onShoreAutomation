package RegisteredCheckoutScenarios;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Locale_Kuwait {
	
	
{
		
		
		System.out.println("STATIC  Registered user"+System.getProperty("user.dir")+"\\atu.properties");
		System.setProperty("atu.reporter.config",
   			System.getProperty("user.dir")+"\\atu.properties");
		
		
		
	}
	
	
	RunnerScripts rsc= new RunnerScripts();
	@Test
	@Parameters({ "DataSheetRow"}) // String dataRow
	public void reg_Promo_CreditCard(String dataRow) throws Exception {
		
	 int row= Integer.parseInt(dataRow);
	 System.out.println(row);
		rsc.suiteRunner("Kuwait", row);
		//rsc.suiteRunner("Kuwait",2);
	}	
}
