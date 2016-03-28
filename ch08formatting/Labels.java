import java.util.ListResourceBundle;

public class Labels extends ListResourceBundle{
    
    public Object[][] getContents(){
        return objects;
    }
    
    private Object[][] objects = {
        {"hello","Generic Hello"},
        {"bye","Generic Bye"},
        {"12", "king"}
    };
}