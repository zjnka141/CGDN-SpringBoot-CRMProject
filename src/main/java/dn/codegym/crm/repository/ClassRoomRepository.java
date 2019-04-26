package dn.codegym.crm.repository;

import dn.codegym.crm.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomRepository extends JpaRepository<ClassRoom,String> {
    Iterable<ClassRoom> findAllByDeletedIsFalse();
}
