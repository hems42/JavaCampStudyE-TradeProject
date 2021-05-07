package Bussines.abstracts;

import java.util.List;

public interface BaseCrudService<T> {

    void add(T t);
    void delete(T t);
    void update(T t);
    T get(T t);
    List<T> getAll();
}
