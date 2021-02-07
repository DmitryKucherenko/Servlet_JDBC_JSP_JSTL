package dao;

import java.util.List;

public interface DAO<Entity> {
    List<Entity> getAll();
    void insert(Entity e);
    void delete(String id);
    void update(Entity e);
    void getById(Entity e);
}
