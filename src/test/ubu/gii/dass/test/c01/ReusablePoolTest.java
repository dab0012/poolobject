
package ubu.gii.dass.test.c01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
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
 *         Test para la clase ReusablePool v.1
 *
 */
public class ReusablePoolTest {

	private ReusablePool rp1, rp2;
	private Reusable r1, r2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		// Inicializamos las variables del test
		rp1 = ReusablePool.getInstance();
		rp2 = null;
		r1 = r2 = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		rp1 = rp2 = null;
		r1 = r2 = null;
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {

		// Comprobar si son el mismo objeto
		rp2 = ReusablePool.getInstance();
		assertEquals(rp1, rp2);

		// no nulo
		assertNotNull(rp1);

	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() {

		// Comprobar numero de instancias de reusables = 2
		try {
			rp1.acquireReusable();
			rp1.acquireReusable();
		} catch (NotFreeInstanceException e) {
			fail("El pool deberia de tener 2 reusables y no los tiene");
			e.printStackTrace();
		}

		// Forzar obtener una instancia de donde no hay
		try {
			rp1.acquireReusable();
		} catch (NotFreeInstanceException e) {
			return;
		}
		fail();

	}

	/**
	 * Test method for
	 * {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {

		// Liberar los 2 reusables
		try {
			r1 = rp1.acquireReusable();
			r2 = rp1.acquireReusable();

		} catch (NotFreeInstanceException e) {
		}

		try {
			rp1.releaseReusable(r1);
			rp1.releaseReusable(r2);
		} catch (DuplicatedInstanceException e) {
			fail();
			e.printStackTrace();
		}

		// Forzar liberar un reusaable ya liberado
		try {
			rp1.releaseReusable(r1);
		} catch (DuplicatedInstanceException e) {
			return;
		}
		fail();
	}

}
