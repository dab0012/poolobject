/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.DuplicatedInstanceException;
import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.Reusable;
import ubu.gii.dass.c01.ReusablePool;

/**
 * @author Daniel Alonso
 * @author Victor Pascual
 *
 */
public class ReusablePoolTest {
	

	public ReusablePool rp;
	public Reusable r;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		rp = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		
		//Intentamos obtener una instancia del objeto
		rp = ReusablePool.getInstance();
		
		if(rp == null) 
			fail();
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() {
		
		try {
			r = rp.acquireReusable();
		} catch (NotFreeInstanceException e) {
			fail();
		}

	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		
		try {
			rp.releaseReusable(r);
		} catch (DuplicatedInstanceException e) {
			fail();
		}
		
	}

}
