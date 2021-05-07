package DataAccessLayer.abstracts;

public interface BaseCrudDal<T> {

    void add(T t);
    void delete(T t);
    void update(T t);
    T get(T t);

}
