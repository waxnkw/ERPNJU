package ui.uiAssistants;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageFactory {
	private static Stage financeStage;
	
	
	public static Stage getFinanceStage(){
		if(financeStage==null){
			financeStage=new Stage();
		//	financeStage.initStyle(StageStyle.UTILITY);
		}
		
		return financeStage;
	}
	
	
}
