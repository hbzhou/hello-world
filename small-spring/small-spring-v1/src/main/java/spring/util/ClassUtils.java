package spring.util;

public class ClassUtils {

    public static ClassLoader getClassLoader() {
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {

        }
        if (classLoader == null) {
            try {
                classLoader = ClassUtils.class.getClassLoader();
            } catch (Exception e) {

            }
        }
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return classLoader;
    }
}
