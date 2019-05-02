package dn.codegym.crm.repository;

import dn.codegym.crm.entity.ClassRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomRepository extends JpaRepository<ClassRoom,String> {
    Page<ClassRoom> findAllByDeletedIsFalse( Pageable pageable);
    Page<ClassRoom>findAllByNameContaining(String name, Pageable pageable);
}
