package timebasedcache;

public interface ExpirationListener<E> {
    void expired(E expiredObject);
}