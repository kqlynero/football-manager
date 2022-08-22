package codeseek.test.manager.repository;

import codeseek.test.manager.model.Player;
import codeseek.test.manager.model.Team;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query(value = "FROM Team p JOIN FETCH p.players")
    List<Player> findAllByTeam(Team team);
}
