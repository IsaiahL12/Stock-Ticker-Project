package Project;

public class Budget {
	private double capitalvalue;
	private double endofdayvalue;
	private double totalvalue_end;
	private double totalvalue_current;
	public Records record;
	
	
	
	public Budget(Records inputrecord){
		capitalvalue = 25000;
		endofdayvalue = 0;
		Records record = inputrecord;
		totalvalue_end = endofdayvalue + capitalvalue;
		
	}
	
	char BuyStocks(int price){
		if(capitalvalue >= price)
		{
			capitalvalue = capitalvalue - price;
			return 'y';
		}
		
		else
		{
			return 'n';
		}
	}
	
	void SellStocks(int price){
		capitalvalue = capitalvalue + price;
	}
	
	void updateTotalValue_End()
	{
		double counter = 0;
		record.updateClosingPrice();
		for(int i = 0; i < record.getStockNumber(); i++)
		{
			counter = record.getClosingPrice(i)*record.getNumberofStocks(i);
		}
		
		totalvalue_end = counter;
	}
	
	void updateTotalValue_Current()
	{
		double counter = 0;
		for(int i=0; i < record.getStockNumber(); i++)
		{
			counter = record.getNumberofStocks(i)*record.getCurrentPriceofStocks(i);
		}
		
		totalvalue_current = counter;
	}
}
