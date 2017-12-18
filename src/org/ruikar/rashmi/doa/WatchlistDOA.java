package org.ruikar.rashmi.doa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.ruikar.rashmi.connection.dbconnection;
import org.ruikar.rashmi.model.RegisterBean;
import org.ruikar.rashmi.stockapi.StockBean;

public class WatchlistDOA {
	
	
	public List getmywatchlist(int userid)
	{
	List<StockBean> list2 = new ArrayList<StockBean>();
	
	try
	{
		String sql = "SELECT stockname from watchlist where uid=" +userid;
		PreparedStatement st = dbconnection.a.getconnection().prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next())
		{
			StockBean sb = new StockBean();
			sb.setSymbol(rs.getString("stockname"));
			list2.add(sb);
							
		}
	}
	catch (Exception e)
	{
		
	}

	return list2;
}
	public List getmywatchlist1(int userid)
	{
	List<StockBean> list1 = new ArrayList<StockBean>();
	
	try
	{
		String sql = "SELECT stockname from watchlist where uid=" +userid;
		PreparedStatement st = dbconnection.a.getconnection().prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next())
		{
			StockBean sb = new StockBean();
			sb.setSymbol(rs.getString("stockname"));
			list1.add(sb);
							
		}
	}
	catch (Exception e)
	{
		
	}

	return list1;
}
}
