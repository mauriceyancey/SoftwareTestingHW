import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CFGTests {
    @Test
    public void t0()
    {
        CFG cfg = new CFG();
        assertEquals(true, cfg.isReachable("main", "homework.D", "foo", "homework.D"));
    }

    @Test
    public void t1()
    {
        CFG cfg = new CFG();
        assertEquals(true, cfg.isReachable("main", "homework.D", "bar", "homework.D"));
    }

    @Test
    public void t2()
    {
        CFG cfg = new CFG();
        assertEquals(false, cfg.isReachable("main", "faker", "bar", "homework.D"));
    }

    @Test
    public void t3()
    {
        CFG cfg = new CFG();
        assertEquals(false, cfg.isReachable("main", "homework.D", "faker", "homework.D"));
    }

    @Test
    public void t4()
    {
        CFG cfg = new CFG();
        assertEquals(false, cfg.isReachable("main", "homework.D", "bar", "faker"));
    }

    @Test
    public void t5()
    {
        CFG cfg = new CFG();
        assertEquals(true, cfg.isReachable("foo", "homework.D", "bar", "homework.D"));
    }

    @Test
    public void t6()
    {
        CFG cfg = new CFG();
        assertEquals(false, cfg.isReachable("foo", "homework.D", "main", "homework.D"));
    }

    @Test
    public void t7()
    {
        CFG cfg = new CFG();
        assertEquals(false, cfg.isReachable("bar", "homework.D", "foo", "homework.D"));
    }
    @Test
    public void t8()
    {
        CFG cfg = new CFG();
        assertEquals(false, cfg.isReachable("bar", "homework.D", "main", "homework.D"));
    }

}
