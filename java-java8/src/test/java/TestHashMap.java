import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class TestHashMap {

	public static void main(String[] args) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        System.err.println(map.size());

        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));

        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : " + size.get(map));
    }
  
}