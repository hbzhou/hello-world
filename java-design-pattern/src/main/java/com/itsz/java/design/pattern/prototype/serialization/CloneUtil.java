package com.itsz.java.design.pattern.prototype.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author jeremy
 */
public class CloneUtil {

    public static Object getObject(Object object){
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream =null;

        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);

            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                byteArrayOutputStream.close();
                objectOutputStream.close();
                byteArrayInputStream.close();
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  null;
    }
}
