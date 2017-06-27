package hitwh.fanghh.manage.service.impl;

import hitwh.fanghh.manage.dao.PermissionDao;
import hitwh.fanghh.manage.dao.impl.SystemSetting;
import hitwh.fanghh.manage.service.SystemSettingService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemSettingServiceImpl implements SystemSettingService {

	/*@Autowired
	private ModifyInfoMarksService modifyInfoMarksService;
	
	@Autowired
	private PermissionDao permissionDao;
	
	@Autowired
	private BaseInfoDao baseInfoDao;
	
	@Autowired
	private UnsubmitClassService unsubmitClassService;*/
	
	public void openSelfModify() {
		//如果有数据  则不清空
		/*List<ModifyInfoMarks> list = this.modifyInfoMarksService.getAll();
		if(list.size() == 0){
			//如果没有  每人新建数据
			this.modifyInfoMarksService.initAll();
		}
		
		synchronized(SystemSetting.class){
			SystemSetting.setOpenToModify(true);
		}*/
	}
	
	public void closeSelfModigy(){
		//清空ModifyInfoMarks
		/*this.modifyInfoMarksService.deleteAll();
	
		//TODO: 清空 各个临时表
		this.baseInfoDao.deleteAll();
		this.unsubmitClassService.deleteAll(Contact_T.class);
		this.unsubmitClassService.deleteAll(EducationBackground_T.class);
		this.unsubmitClassService.deleteAll(WorkingExperience_T.class);
		this.unsubmitClassService.deleteAll(ProfessionalAndTechnical_T.class);
		this.unsubmitClassService.deleteAll(ManagePost_T.class);
		this.unsubmitClassService.deleteAll(ServicePost_T.class);
		this.unsubmitClassService.deleteAll(Tutor_T.class);
		this.unsubmitClassService.deleteAll(Contact_T.class);
		this.unsubmitClassService.deleteAll(AbroadExperience_T.class);
		this.unsubmitClassService.deleteAll(Awards_T.class);
		this.unsubmitClassService.deleteAll(FamilyMembers_T.class);
		this.unsubmitClassService.deleteAll(BaseInfo.class);
		this.unsubmitClassService.deleteAll(Talents_T.class);
		this.unsubmitClassService.deleteAll(PersonPhoto_T.class);*/
		
		synchronized(SystemSetting.class){
			SystemSetting.setOpenToModify(false);
		}
	}

	@Override
	public boolean isOpenSelfModigy() {
		return SystemSetting.isOpenToModify();
	}

	
	

}
