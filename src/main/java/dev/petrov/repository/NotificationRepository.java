package dev.petrov.repository;

import dev.petrov.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
    Optional<List<NotificationEntity>> findByIsReadFalse();
    List<NotificationEntity> findByCreatedAtBefore(LocalDateTime dateTime);
    void deleteByCreatedAtBefore(LocalDateTime dateTime);
}
