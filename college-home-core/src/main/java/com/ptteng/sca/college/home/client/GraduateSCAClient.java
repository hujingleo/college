package com.ptteng.sca.college.home.client;

import java.util.List;
import java.util.Map;

import com.ptteng.college.home.model.Graduate;
import com.ptteng.college.home.service.GraduateService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class GraduateSCAClient implements GraduateService {

    private GraduateService graduateService;

	public GraduateService getGraduateService() {
		return graduateService;
	}
	
	
	public void setGraduateService(GraduateService graduateService) {
		this.graduateService =graduateService;
	}
	
	
			   
		@Override
		public Long insert(Graduate graduate)throws ServiceException, ServiceDaoException{
		
		return graduateService.insert(graduate);
		          
		
		}	
		  
    	   
		@Override
		public List<Graduate> insertList(List<Graduate> graduateList)throws ServiceException, ServiceDaoException{
		
		return graduateService.insertList(graduateList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return graduateService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Graduate graduate)throws ServiceException, ServiceDaoException{
		
		return graduateService.update(graduate);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Graduate> graduateList)throws ServiceException, ServiceDaoException{
		
		return graduateService.updateList(graduateList);
		          
		
		}	
		  
    	   
		@Override
		public Graduate getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return graduateService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Graduate> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return graduateService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getGraduateIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return graduateService.getGraduateIds(start, limit);
	}

	@Override
	public Integer countGraduateIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return graduateService.countGraduateIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return graduateService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return graduateService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   graduateService.deleteList(clz, ids);
		
	}
	
	//@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		return null;
		//return this.graduateService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

