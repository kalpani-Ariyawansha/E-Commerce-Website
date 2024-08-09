package com.SQA.QATestForShop.payment;

import com.SQA.QATestForShop.User.User;
import com.SQA.QATestForShop.User.UserRepository;
import com.SQA.QATestForShop.manageProduct.Product;
import com.SQA.QATestForShop.manageProduct.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final PaymentRepository paymentRepository;

    public void savePayment(String productID, String userID,PaymentRequest paymentRequest){
        Optional<User> user = userRepository.findById(userID);
        Optional<Product> product = productRepository.findById(productID);
        if(user.isPresent() && product.isPresent() && paymentRequest != null){

                Double totalPrice = calTotalPrice(product.get().getPrice(), paymentRequest.getQuantity(), product.get().getDeliveryCharge());
                Payment payment = Payment.builder()
                        .quantity(paymentRequest.getQuantity())
                        .totalPrice(totalPrice)
                        .product(product.get())
                        .build();
                List<Payment> paymentList = new ArrayList<>();
                paymentList.add(payment);
                user.get().setPayments(paymentList);
                paymentRepository.save(payment);
                userRepository.save(user.get());
        }
    }

    public Double calTotalPrice(BigDecimal price, int quantity, Double deliveryCharge) {
            double onePrice = price.doubleValue();
            return  (onePrice * quantity) + deliveryCharge;
    }

    public List<Payment> getAllProducts(String id){
        Optional<User> user = userRepository.findById(id);
        return user.map(User::getPayments).orElse(null);
    }

    public Payment getPayment(String id){
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.orElse(null);
    }
}
