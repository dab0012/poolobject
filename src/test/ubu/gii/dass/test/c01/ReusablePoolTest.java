package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.Client;
import ubu.gii.dass.c01.DuplicatedInstanceException;
import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.Reusable;
import ubu.gii.dass.c01.ReusablePool;

/**
 * @author Daniel Alonso
 * @email dab0012@alu.ubu.es
 * 
 * @author Victor Pascual
 * 
 *         Test para la clase ReusablePool v.1
 *
 */
public class ReusablePoolTest {

    private ReusablePool rPool1, rPool2;
    private Reusable reusable1, reusable2;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

	// Inicializamos las variables del test
	rPool1 = rPool2 = ReusablePool.getInstance();
	reusable1 = reusable2 = null;
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	rPool1 = rPool2 = null;
	reusable1 = reusable2 = null;
    }

    /**
     * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
     */
    @Test
    public void testGetInstance() {

	// Comprobar si son el mismo objeto
	assertEquals(rPool1, rPool2);

	// no nulo
	assertNotNull(rPool1);

    }

    /**
     * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
     * 
     * @throws NotFreeInstanceException
     */
    @Test
    public void testAcquireReusable() throws NotFreeInstanceException {
	reusable1 = rPool1.acquireReusable();
	reusable2 = rPool1.acquireReusable();
    }

    /**
     * Test method for releaseReusable
     * {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
     * 
     * @throws DuplicatedInstanceException
     * @throws NotFreeInstanceException
     */
    @Test
    public void testReleaseReusable() throws DuplicatedInstanceException, NotFreeInstanceException {

	// Obtener los 2 reusables
	reusable1 = rPool1.acquireReusable();
	reusable2 = rPool1.acquireReusable();

	// Liberar reusables
	rPool1.releaseReusable(reusable1);
	rPool1.releaseReusable(reusable2);
    }

    /**
     * Test method for .util() {@link ubu.gii.dass.c01.Reusable#util()}.
     * 
     * @throws NotFreeInstanceException
     * @throws DuplicatedInstanceException
     */
    @Test
    public void testUtil() throws NotFreeInstanceException, DuplicatedInstanceException {
	reusable1 = rPool1.acquireReusable();
	reusable2 = rPool1.acquireReusable();
	assertEquals(reusable1.hashCode() + "  :Uso del objeto Reutilizable", reusable1.util());
	assertNotEquals(reusable1.util(), reusable2.util());
	rPool1.releaseReusable(reusable1);
	rPool1.releaseReusable(reusable2);
    }

    /**
     * Test method for notFreeInstanceException
     * {@link ubu.gii.dass.c01.NotFreeInstanceException}.
     * 
     * @throws DuplicatedInstanceException
     */
    @Test
    public void notFreeInstanceException() throws DuplicatedInstanceException {
	try {
	    reusable1 = rPool1.acquireReusable();
	    reusable2 = rPool1.acquireReusable();
	    // Producir la excepcion
	    rPool1.acquireReusable();
	} catch (NotFreeInstanceException e) {
	    rPool1.releaseReusable(reusable1);
	    rPool1.releaseReusable(reusable2);
	    assertTrue(true);
	}
    }

    /**
     * Test method for DuplicatedInstanceException
     * {@link ubu.gii.dass.c01.DuplicatedInstanceException}.
     * 
     * @throws NotFreeInstanceException
     */
    @Test
    public void duplicatedInstanceException() throws NotFreeInstanceException {
	try {
	    reusable1 = rPool1.acquireReusable();
	    rPool1.releaseReusable(reusable1);
	    rPool1.releaseReusable(reusable1);
	} catch (DuplicatedInstanceException e) {
	    assertTrue(true);
	}
    }
    

    
}
