package main.Repository;

import main.Entity.OdsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OdsRepository extends JpaRepository<OdsEntity, Long> {
    public OdsEntity findByObjectiveName(String objectiveName);
}
