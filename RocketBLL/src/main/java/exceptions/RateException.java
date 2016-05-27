
package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
	private RateDomainModel ratedomainmodel = null;

	public RateDomainModel getRatedomainmodel() {
		return ratedomainmodel;
	}

	public RateException(RateDomainModel ratedomainmodel){
		this.ratedomainmodel = ratedomainmodel;
	}
}