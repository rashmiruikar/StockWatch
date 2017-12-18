package org.ruikar.rashmi.controller;

import java.util.ArrayList;
import java.util.List;

import org.ruikar.rashmi.doa.WatchlistDOA;
import org.ruikar.rashmi.model.RegisterBean;
import org.ruikar.rashmi.stockapi.StockBean;

public class WatchlistController {
	
	public List getmymgrInfo(int userid)
	{
		List<StockBean> list1 = new ArrayList<StockBean>();
		WatchlistDOA wl = new WatchlistDOA();
		list1 = wl.getmywatchlist(userid);
		return list1;
		
	}

}
