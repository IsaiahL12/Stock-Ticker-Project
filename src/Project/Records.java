package Project;
import java.util.Dictionary;

public class Records {
	int stocknumber;
	public double [][] records = new double [151][2];
	Dictionary<String, Integer> stocknames;
	public String [] names = new String [151];

	public Records()
	{
		stocknumber = 0;
		for (int i=0; i<150; i++){
			for (int j = 0; j<2; j++){
				records [i][j] = 0;
			}
			
			names [i] = "";
		}
	
	}
	int getStockNumber(){
		return stocknumber;
	}
	
	void changeStockNumber(int change){
		if (change < 0){
			if (stocknumber > 1)
			{
				stocknumber = stocknumber + change;
			}
		}
		
		else{
			stocknumber = stocknumber + change;
		}
	}
	
	void buyStock(String purchaseName, int purchaseNumber, double purchasePrice){
		
		if(stocknames.get(purchaseName) != null){
			records[(Integer) stocknames.get(purchaseName)][0] = records[(Integer) stocknames.get(purchaseName)][0] + purchaseNumber;
			records[(Integer) stocknames.get(purchaseName)][1] = records[(Integer) stocknames.get(purchaseName)][1] + purchasePrice;
			}
		else
		{
			if(getStockNumber()<150)
			{
				records[getStockNumber()][0] = purchaseNumber;
				records[getStockNumber()][1] = purchasePrice;
				names[getStockNumber()] = purchaseName;
				stocknames.put(purchaseName, getStockNumber());
				changeStockNumber(1);
			}
		}
	}	
	
	void sellStock(String sellName, int sellNumber, double sellPrice){
			
		if (stocknames.get(sellName) != null){
			if(records[(Integer) stocknames.get(sellName)][0] >= sellNumber)
			{				
				if(records[(Integer) stocknames.get(sellName)][0] - sellNumber == 0){
					
					int holdnumber = (Integer) stocknames.get(sellName);
					for(int i=holdnumber; i<getStockNumber(); i++){
						stocknames.remove(names[i]);
						stocknames.put(names[i+1], i);
						records[i][0] = records[i+1][0];
						records[i][1] = records[i+1][0];
						names[i] = names[i+1];
					}
				}
				
				else{
						records[(Integer) stocknames.get(sellName)][0] = records[(Integer) stocknames.get(sellName)][0] - sellNumber;
						records[(Integer) stocknames.get(sellName)][1] = records[(Integer) stocknames.get(sellName)][1] + sellPrice;
					}
			}
			
			else 
			{
				// attempting to sell number of stock one doesn't have
			}
		}
		
		else 
		{
			// attempting to sell stock one doesn't own. 
		}
	}
}


