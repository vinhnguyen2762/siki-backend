package com.siki.cart.controller;

import com.siki.cart.dto.CartDto;
import com.siki.cart.service.CartService;
import jakarta.ws.rs.Path;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/storefront/add-to-cart/{productId}")
    public ResponseEntity<Void> addToCart(@PathVariable("productId") Long productId) {
        cartService.addToCart(productId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/storefront/{cartId}")
    public ResponseEntity<Void> removeCart(@PathVariable("cartId") Long cartId) {
        cartService.removeCartByCartId(cartId);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/storefront")
    public ResponseEntity<Void> removeCart() {
        cartService.removeCartOfLoggedUser();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/storefront/selection/{selection}")
    public ResponseEntity<Void> updateSlectionCart(@PathVariable("selection") boolean selection) {
        cartService.updateSelectedOfUser(selection);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/storefront/products/{productId}")
    public ResponseEntity<CartDto> listCarts(
            @PathVariable("productId") Long productId
    ) {
        return ResponseEntity.ok().body(cartService.findByProductAndUser(productId));
    }

    @GetMapping("/storefront/{customerId}")
    public ResponseEntity<List<CartDto>> listCarts(@PathVariable("customerId") String customerId) {
        return ResponseEntity.ok().body(cartService.getCartsForCustomer(customerId));
    }

    @PutMapping("/storefront/{cartId}/quantity/{quantity}")
    public ResponseEntity<Void> updateQuantity(@PathVariable("cartId") Long cartId,
                                               @PathVariable("quantity") int quantity) {
        cartService.updateQuantity(cartId, quantity);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/storefront/{cartId}/selection/{selection}")
    public ResponseEntity<Void> updateSelection(@PathVariable("cartId") Long cartId,
                                                @PathVariable("selection") boolean selection) {
        cartService.updateSelected(cartId, selection);
        return ResponseEntity.noContent().build();
    }

}
