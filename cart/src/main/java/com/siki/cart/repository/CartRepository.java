package com.siki.cart.repository;

import com.siki.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("""
            select c
            from Cart c
            where c.productId = :productId AND c.userId = :userId
            """)
    Optional<Cart> findByProductAndUser(@Param("productId") Long productId,
                                        @Param("userId") String userId);


    @Query("""
            update Cart c
            set c.quantity = :quantity
            where c.id = :cartId
            """)
    @Modifying
    void updateQuantity(@Param("cartId") Long cartId,
                        @Param("quantity") int quantity);

    @Query("""
            UPDATE Cart c
            SET c.selected = :selected
            WHERE c.id = :cartId
            """)
    @Modifying
    void updateSelected(@Param("cartId") Long cartId,
                        @Param("selected") boolean selected);


    @Query("""
            UPDATE Cart c
            SET c.selected = :selected
            WHERE c.userId = :userId
            """)
    @Modifying
    void updateSelected(@Param("userId") String customerId,
                        @Param("selected") boolean selected);

    @Query("""
            delete from Cart c
            where c.id = :cartId
            """)
    @Modifying
    void deleteCart(@Param("cartId") Long cartId);

    @Query("""
            delete from Cart c
            where c.userId = :userId
            """)
    @Modifying
    void deleteCartByUser(@Param("userId") String userId);


    @Query("""
            select c
            from Cart c
            where c.userId = :userId
            """)
    List<Cart> findByUserId(@Param("userId") String userId);


}
