package app.repository;

import app.entity.DraftTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<DraftTask, Long> {

    List<DraftTask> findAll();

    @Override
    DraftTask getById(Long aLong);
}