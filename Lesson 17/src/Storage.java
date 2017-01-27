import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vig on 11/28/16.
 */
public class Storage {
    private static final Object lock = new Object();
    private static final Object lock1 = new Object();
    private Map<String, Number> map = Collections.synchronizedMap(new HashMap<>());

    //public synchronized void store(String key, Number value) {
    public void store(String key, Number value) {
        new java.util.concurrent.ConcurrentHashMap<>();  // разница между этим и synchronizedMap: блокировка происходит не сразу, а после вычислений(когда уже надо класть значение в key)
       // Collections.synchronizedMap()  //wraper потокобезопасная карта
                    boolean isPresent = false;
            for (String k : map.keySet()) {
                if (k.equals(key)) {
                    isPresent = true;
                    break;
                }
            }
            if (!isPresent) {

                    this.map.putIfAbsent(key, value);
                }
            }


    public void store2(String key, Number value) {
        synchronized (lock) {
            boolean isPresent = false;
            for (String k : map.keySet()) {
                if (k.equals(key)) {
                    isPresent = true;
                    break;
                }
            }
            if (!isPresent) {
                synchronized (lock1) {
                    this.map.putIfAbsent(key, value);
                }
            }
        }
    }
}
// оба метода могут работать, если они кладут значения в разные карты.
//deadlock - когда методы приводят к взаимной блокировке потоков (ожиданию)
//пути решения 1) вырезается второй метод 2) java.util.concurrent.ConcurrentHashMap или Collections.synchronizedMap
//определить deadlock можно с помощью jvisualvm
//livelock - зацикливание выполнения задач, в случае livelock jvisualvm НЕ поможет. Только анализ кода.