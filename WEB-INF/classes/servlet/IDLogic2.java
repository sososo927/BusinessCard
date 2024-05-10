package servlet;
import java.util.List;

import dao.ScheduleDAO;
import model.ScheduleBean;

public class IDLogic2 {
    private static int IDplus2 = 1024000000;
	public IDLogic2() {

	}


    public static int getIDplus2() {
    	ScheduleDAO bcDAO=new ScheduleDAO();
    	List<ScheduleBean> cusList=bcDAO.findAll();
    	for(ScheduleBean cusBean:cusList) {
    		IDplus2=cusBean.getId();
    	}
    	return IDplus2;
    }
}

