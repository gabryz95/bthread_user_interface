package gui.model;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BthreadTest {
    int pid = 5226;
    Bthread bthread = new Bthread(pid);

    @Test
    public void getPidTest(){
        assertEquals(pid,bthread.getPid());
        bthread.setPid(3558);
        assertEquals(3558,bthread.getPid());
    }

    @Test
    public void getMemoryTest(){
        assertNull(bthread.getMemory());
        String mem = "0x558693d34040";
        bthread.setMemory(mem);
        assertEquals(mem,bthread.getMemory());
    }

    @Test
    public void getStatusTest(){
        assertNull(bthread.getStatus());
        String status = "READY";
        bthread.setStatus(status);
        assertEquals(status,bthread.getStatus());
    }
}
