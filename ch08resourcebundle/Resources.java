import java.util.ListResourceBundle;

public class Resources extends ListResourceBundle {
    
    public Object[][] getContents (){
        return new Object[][] {
            {"man", new String("Chavelier")},
        };
    }
}