package lk.ijse.ecommerce.dao;

public interface CrudDAO<T> extends SuperDAO{
    boolean save(T dto);
}
