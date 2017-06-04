package com.ptteng.sca.college.home.client;

import java.util.List;
import java.util.Map;

import com.ptteng.college.home.model.AdmissionEmployment;
import com.ptteng.college.home.service.AdmissionEmploymentService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class AdmissionEmploymentSCAClient implements AdmissionEmploymentService {

    private AdmissionEmploymentService admissionEmploymentService;

	public AdmissionEmploymentService getAdmissionEmploymentService() {
		return admissionEmploymentService;
	}
	
	
	public void setAdmissionEmploymentService(AdmissionEmploymentService admissionEmploymentService) {
		this.admissionEmploymentService =admissionEmploymentService;
	}
	
	
			   
		@Override
		public Long insert(AdmissionEmployment admissionEmployment)throws ServiceException, ServiceDaoException{
		
		return admissionEmploymentService.insert(admissionEmployment);
		          
		
		}	
		  
    	   
		@Override
		public List<AdmissionEmployment> insertList(List<AdmissionEmployment> admissionEmploymentList)throws ServiceException, ServiceDaoException{
		
		return admissionEmploymentService.insertList(admissionEmploymentList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return admissionEmploymentService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(AdmissionEmployment admissionEmployment)throws ServiceException, ServiceDaoException{
		
		return admissionEmploymentService.update(admissionEmployment);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<AdmissionEmployment> admissionEmploymentList)throws ServiceException, ServiceDaoException{
		
		return admissionEmploymentService.updateList(admissionEmploymentList);
		          
		
		}	
		  
    	   
		@Override
		public AdmissionEmployment getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return admissionEmploymentService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<AdmissionEmployment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return admissionEmploymentService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getAdmissionEmploymentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return admissionEmploymentService.getAdmissionEmploymentIds(start, limit);
	}

	@Override
	public Integer countAdmissionEmploymentIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return admissionEmploymentService.countAdmissionEmploymentIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return admissionEmploymentService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return admissionEmploymentService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   admissionEmploymentService.deleteList(clz, ids);
		
	}
	
	//@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	return null;
		//return this.admissionEmploymentService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}

}

