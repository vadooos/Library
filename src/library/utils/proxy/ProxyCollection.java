package library.utils.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by vadim on 11.04.2017.
 */
public class ProxyCollection implements InvocationHandler{


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        switch (method.getName()){
            case ("add"):
                return Boolean.TRUE;

            case ("remove"):
                return Boolean.TRUE;
            case ("contains"):
                boolean[] mas = {true, false, true, true};
                int index = (Integer)args[0];
                if (index >= mas.length){
                    return false;
                }
                return mas[index];
        }

        return null;
    }
}
