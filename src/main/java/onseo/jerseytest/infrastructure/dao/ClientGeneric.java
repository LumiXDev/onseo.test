package onseo.jerseytest.infrastructure.dao;

public interface ClientGeneric<T> {
    T getEntity(int id);
}
