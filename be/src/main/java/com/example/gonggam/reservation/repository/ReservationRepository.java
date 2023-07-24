package com.example.gonggam.reservation.repository;

import com.example.gonggam.reservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByCustomerId(Long customerId);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END " +
            "FROM Reservation as a " +
            "WHERE a.customerId = :customerId " +
            "  AND a.sharedSpace.spaceId = :spaceId ")
    boolean existsByCustomerIdAndSpaceId(@Param(value = "customerId") Long customerId
            , @Param(value = "spaceId") Long spaceId);
}
