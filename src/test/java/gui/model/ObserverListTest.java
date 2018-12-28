package gui.model;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import java.util.Observer;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;

public class ObserverListTest {

    @Mock
    Observer obs;

    @Before
    public void setUp(){
        obs = mock(Observer.class);
    }

    @Test
    public void addTest(){
        ObserverList list = new ObserverList();
        list.add(obs);
        assertEquals(1,list.size());
    }

    @Test
    public void getObserverTest(){
        ObserverList list = new ObserverList();
        list.add(obs);
        ObserverList list2 = new ObserverList();
        list2.add(obs);
        assertEquals(list2.getObservers(),list.getObservers());
    }

    @Test
    public void getObserver(){
        ObserverList list = new ObserverList();
        list.add(obs);
        assertEquals(obs, list.getObserver(0));
    }
}