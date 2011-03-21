package gov.nih.nci.ncia.dao;

import gov.nih.nci.ncia.internaldomain.LoginHistory;

import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class LoginHistoryDAOImpl extends AbstractDAO 
                                 implements LoginHistoryDAO {
    /**
     * Records a user login in the database
     */
	@Transactional(propagation=Propagation.REQUIRED)	
    public void recordUserLogin(String ipAddress) throws DataAccessException {

		LoginHistory loginHistory = new LoginHistory();
		loginHistory.setLoginTimestamp(new Date());
		// Pull the IP address off of the HTTP request
		loginHistory.setIPAddress(ipAddress);
		

		getHibernateTemplate().save(loginHistory);
    }
}