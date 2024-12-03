package timebasedcache;

import timebasedcache.TimeBasedCache;

public class TimeBasedCacheTest {
    public static void main(String[]args)
    {
        TimeBasedCache timeBasedCache = new TimeBasedCache();
        timeBasedCache.put("1234","1234");
        timeBasedCache.put("1234","12345");
        timeBasedCache.put("12345","12340000");
        timeBasedCache.getExpirer().startExpiring();
        timeBasedCache.getExpirer().startExpiringIfNotStarted();
        System.out.println("Time "+System.currentTimeMillis()+  ":"+ timeBasedCache.get("1234"));
        try {
            Thread.sleep(90*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Time to check expiry "+System.currentTimeMillis()+  ":"+ timeBasedCache.get("12345"));
        System.out.println("Putting again "+System.currentTimeMillis()+  ":"+  timeBasedCache.put("12345","lkadsda"));
        System.out.println("Checking "+System.currentTimeMillis()+  ":"+  timeBasedCache.get("12345"));
        try {
            Thread.sleep(30*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Checking1 "+System.currentTimeMillis()+  ":"+  timeBasedCache.get("12345"));
        try {
            Thread.sleep(31*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        timeBasedCache.put("123456","partha");
        System.out.println("Time to check expiry1 "+System.currentTimeMillis()+  ":"+ timeBasedCache.get("1234"));
        System.out.println("Time to check expiry1 "+System.currentTimeMillis()+  ":"+ timeBasedCache.get("12345"));
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Time to check expiry2 "+System.currentTimeMillis()+  ":"+ timeBasedCache.get("123456"));
    }

}
