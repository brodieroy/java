public class LoadClassEnumTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
/**
 *         public class A  {
 *            public enum B { FIRST, SECOND, THIRD }
 *              public void setB( B b ) {
 *            }
 *         }
 */
        Class clz = Class.forName("test.A$B");
        
        Object[] consts = clz.getEnumConstants();
        Class<?> sub = consts[0].getClass();
        
        for(int i = 0; i< consts.length ; i++){
            if(consts[i].getClass().equals(sub)){
                System.out.println("consts["+i+"]:"+ consts[i].toString());
            }
        }
    }
}
