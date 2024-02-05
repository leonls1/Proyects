package Task.service;

import Task.model.TaskType;
import jakarta.persistence.EntityManager;
import java.util.List;

public interface TaskTypeDao {

    public List<TaskType> getAll();

    public TaskType getById(Long id);

    public void create(TaskType type);

    public void update(TaskType type);

    public void delete(TaskType type);

    public void setEntityManager(EntityManager em);
}
