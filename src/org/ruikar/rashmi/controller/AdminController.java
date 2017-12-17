package org.ruikar.rashmi.controller;

import java.util.ArrayList;
import java.util.List;

import org.ruikar.rashmi.doa.AdminDOA;
import org.ruikar.rashmi.model.RegisterBean;

public class AdminController {
	
	public List getInfo()
	{
		List<RegisterBean> list1 = new ArrayList<RegisterBean>();
		AdminDOA ad = new AdminDOA();
		list1 = ad.getinfo();
		return list1;
		
	}

}
