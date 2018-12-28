package gui.view.menubar;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class MenuItemViewTest {

    @Test
    public void getMenuItem() {
        MenuItemView menuItemView = Mockito.mock(MenuItemView.class);
        assertEquals(menuItemView.menuItem, menuItemView.getMenuItem());
    }
}