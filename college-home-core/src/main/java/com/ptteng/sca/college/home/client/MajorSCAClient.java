package com.ptteng.sca.college.home.client;

import java.util.List;
import java.util.Map;

import com.ptteng.college.home.model.Major;
import com.ptteng.college.home.service.MajorService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class MajorSCAClient implements MajorService {

    private MajorService majorService;

	public MajorService getMajorService() {
		return majorService;
	}
	
	
	public void setMajorService(MajorService majorService) {
		this.majorService =majorService;
	}
	
	
			   
		@Override
		public Long insert(Major major)throws ServiceException, ServiceDaoException{
		
		return majorService.insert(major);
		          
		
		}	
		  
    	   
		@Override
		public List<Major> insertList(List<Major> majorList)throws ServiceException, ServiceDaoException{
		
		return majorService.insertList(majorList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return majorService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Major major)throws ServiceException, ServiceDaoException{
		
		return majorService.update(major);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Major> majorList)throws ServiceException, ServiceDaoException{
		
		return majorService.updateList(majorList);
		          
		
		}	
		  
    	   
		@Override
		public Major getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return majorService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Major> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return majorService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getMajorIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return majorService.getMajorIds(start, limit);
	}

	@Override
	public Integer countMajorIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return majorService.countMajorIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return majorService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return majorService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   majorService.deleteList(clz, ids);
		
	}
	
	//@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		return null;
		//return this.majorService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

