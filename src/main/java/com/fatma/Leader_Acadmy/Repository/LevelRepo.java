package com.fatma.Leader_Acadmy.Repository;

import com.fatma.Leader_Acadmy.model.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepo extends JpaRepository<Level,Long> {
}
