package com.ptteng.sca.college.home.client;

import java.util.List;
import java.util.Map;

import com.ptteng.college.home.model.Internship;
import com.ptteng.college.home.service.InternshipService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class InternshipSCAClient implements InternshipService {

    private InternshipService internshipService;

	public InternshipService getInternshipService() {
		return internshipService;
	}
	
	
	public void setInternshipService(InternshipService internshipService) {
		this.internshipService =internshipService;
	}
	
	
			   
		@Override
		public Long insert(Internship internship)throws ServiceException, ServiceDaoException{
		
		return internshipService.insert(internship);
		          
		
		}	
		  
    	   
		@Override
		public List<Internship> insertList(List<Internship> internshipList)throws ServiceException, ServiceDaoException{
		
		return internshipService.insertList(internshipList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return internshipService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Internship internship)throws ServiceException, ServiceDaoException{
		
		return internshipService.update(internship);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Internship> internshipList)throws ServiceException, ServiceDaoException{
		
		return internshipService.updateList(internshipList);
		          
		
		}	
		  
    	   
		@Override
		public Internship getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return internshipService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Internship> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return internshipService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getInternshipIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return internshipService.getInternshipIds(start, limit);
	}

	@Override
	public Integer countInternshipIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return internshipService.countInternshipIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return internshipService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return internshipService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   internshipService.deleteList(clz, ids);
		
	}
	
	//@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		return null;
		//return this.internshipService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

