package com.SQA.QATestForShop.payment;

import com.SQA.QATestForShop.User.UserRepository;
import com.SQA.QATestForShop.manageProduct.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/save/{userID}/{productID}")
    public ResponseEntity<String> savePayment(
            @PathVariable String productID,
            @PathVariable String userID,
            @RequestBody PaymentRequest paymentRequest) {
        try {
            paymentService.savePayment(productID, userID, paymentRequest);
            return ResponseEntity.ok("Payment saved successfully.");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<Payment>> getAllPayments(@PathVariable String userId) {
        List<Payment> payments = paymentService.getAllProducts(userId);
        try {
            if (payments != null && !payments.isEmpty()) {
                return ResponseEntity.ok(payments);
            } else {
                return ResponseEntity.noContent().build();
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPayment(@PathVariable String paymentId) {
        Payment payment = paymentService.getPayment(paymentId);
        try {
            if (payment != null) {
                return ResponseEntity.ok(payment);
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
