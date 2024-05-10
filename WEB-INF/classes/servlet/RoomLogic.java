package servlet;
import java.util.List;

import dao.Notification_DAO;
import model.Roomidinsert_Bean;

public class RoomLogic {
    private static int IDplus = 0;
    private static int i = 0;
	public RoomLogic() {}


    public static int getRoomplus() {
    	Notification_DAO noDAO=new Notification_DAO();
    	List<Roomidinsert_Bean> noList=noDAO.findAll();
    	for(Roomidinsert_Bean rmBean:noList) {
    		i=rmBean.getRoom_id();
    		if (i>IDplus) {
    			IDplus=i;
    		}
    	}
    	return IDplus;
    }
}
