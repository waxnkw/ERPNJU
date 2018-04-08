package blImpl.adminBl;

import java.util.ArrayList;

import assistant.type.UserPositionEnum;
import blInteract.userInteract.GetUserService;
import vo.UserVO;

public class GetUserBl implements GetUserService{

	@Override
	public ArrayList<UserVO> getManager() {
		ArrayList<UserVO> vos = new ArrayList<>();
		filterByPosition(vos, UserPositionEnum.MANAGER);
		return vos;
	}

	@Override
	public ArrayList<UserVO> getWarekeeper() {
		ArrayList<UserVO> vos = new ArrayList<>();
		filterByPosition(vos, UserPositionEnum.WAREKEPPER);
		return vos;
	}

	@Override
	public ArrayList<UserVO> getFianceStaff() {
		ArrayList<UserVO> vos = new ArrayList<>();
		filterByPosition(vos, UserPositionEnum.FINANCE);
		return vos;
	}

	@Override
	public ArrayList<UserVO> getAdmin() {
		ArrayList<UserVO> vos = new ArrayList<>();
		filterByPosition(vos, UserPositionEnum.ADMIN);
		return vos;
	}

	@Override
	public ArrayList<UserVO> getSalesman() {
		ArrayList<UserVO> vos = new ArrayList<>();
		filterByPosition(vos, UserPositionEnum.SALESMAN);
		return vos;
	}

	private ArrayList<UserVO> filterByPosition(ArrayList<UserVO> vos,UserPositionEnum position){
		ArrayList<UserVO> filteredVos = new ArrayList<>();
		for(UserVO vo: vos){
			if(vo.getPosition()==position){
				filteredVos.add(vo);
			}
		}
		return filteredVos;
	}

}
