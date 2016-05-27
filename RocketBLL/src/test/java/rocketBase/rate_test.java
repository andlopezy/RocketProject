package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;
import exceptions.RateException;

public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void test() {
		assert(1==1);
	}
	@Test
	public void ratetest1() throws RateException {
		assertEquals(RateBLL.getRate(720),3.0,0.001);
	}
	@Test
	public void ratetest2() throws RateException {
		assertEquals(RateBLL.getRate(0),0,0.001);
	}
	
}
