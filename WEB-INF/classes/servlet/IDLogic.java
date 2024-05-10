package servlet;
import java.util.List;

import dao.BCDAO;
import model.CustomerBean;

public class IDLogic {
    private static int IDplus = 2024000000;
	public IDLogic() {

	}


    public static int getIDplus() {
    	BCDAO bcDAO=new BCDAO();
    	List<CustomerBean> cusList=bcDAO.findAll();
    	for(CustomerBean cusBean:cusList) {
    		IDplus=cusBean.getAID();
    	}
    	return IDplus;
    }
}

