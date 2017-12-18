package org.ruikar.rashmi.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.ruikar.rashmi.controller.WatchlistController;
import org.ruikar.rashmi.stockapi.StockBean;

@ManagedBean(name="watchlistBean")
@SessionScoped

public class watchlistBean {

	List<StockBean> list1 = new ArrayList<StockBean>();
	WatchlistController wc = new WatchlistController();
	List<StockBean> list;
	
	public List<StockBean> getList() {
		return list;
	}

	public void setList(List<StockBean> list) {
		this.list = list;
	}
	
	public String vwatchlist()
	{
		int userid = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session1");
		list1 = wc.getmymgrInfo(userid);
		this.list = list1;
		return "mywatchlistuser";
	}
}
