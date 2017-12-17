package org.ruikar.rashmi.controller;

import java.util.ArrayList;
import java.util.List;

import org.ruikar.rashmi.doa.AdminDOA;
import org.ruikar.rashmi.doa.ViewmanagerprofileDOA;
import org.ruikar.rashmi.model.RegisterBean;

public class ManagerprofileController {
	
	public List getInfo()
	{
		List<RegisterBean> list1 = new ArrayList<RegisterBean>();
		ViewmanagerprofileDOA vm = new ViewmanagerprofileDOA();
		list1 = vm.getmgrinfo();
		return list1;
		
	}
	
	public List getmymgrInfo(int userid)
	{
		List<RegisterBean> list1 = new ArrayList<RegisterBean>();
		ViewmanagerprofileDOA vm = new ViewmanagerprofileDOA();
		list1 = vm.getmymgrinfo(userid);
		return list1;
		
	}

}
