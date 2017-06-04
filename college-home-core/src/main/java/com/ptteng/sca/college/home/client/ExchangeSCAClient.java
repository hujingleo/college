package com.ptteng.sca.college.home.client;

import java.util.List;
import java.util.Map;

import com.ptteng.college.home.model.Exchange;
import com.ptteng.college.home.service.ExchangeService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class ExchangeSCAClient implements ExchangeService {

    private ExchangeService exchangeService;

	public ExchangeService getExchangeService() {
		return exchangeService;
	}
	
	
	public void setExchangeService(ExchangeService exchangeService) {
		this.exchangeService =exchangeService;
	}
	
	
			   
		@Override
		public Long insert(Exchange exchange)throws ServiceException, ServiceDaoException{
		
		return exchangeService.insert(exchange);
		          
		
		}	
		  
    	   
		@Override
		public List<Exchange> insertList(List<Exchange> exchangeList)throws ServiceException, ServiceDaoException{
		
		return exchangeService.insertList(exchangeList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return exchangeService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Exchange exchange)throws ServiceException, ServiceDaoException{
		
		return exchangeService.update(exchange);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Exchange> exchangeList)throws ServiceException, ServiceDaoException{
		
		return exchangeService.updateList(exchangeList);
		          
		
		}	
		  
    	   
		@Override
		public Exchange getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return exchangeService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Exchange> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return exchangeService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getExchangeIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return exchangeService.getExchangeIds(start, limit);
	}

	@Override
	public Integer countExchangeIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return exchangeService.countExchangeIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return exchangeService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return exchangeService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   exchangeService.deleteList(clz, ids);
		
	}
	
	//@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		return null;
		//return this.exchangeService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

