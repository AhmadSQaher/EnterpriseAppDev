package com.asq.spring.finalex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.asq.spring.finalex.model.Customer;
import com.asq.spring.finalex.model.Payment;
import com.asq.spring.finalex.model.Reservation;
import com.asq.spring.finalex.service.CustomerService;
import com.asq.spring.finalex.service.PaymentService;
import com.asq.spring.finalex.service.ReservationService;
//import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class FormController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/submit")
    public String submitForm(@RequestParam String firstName, @RequestParam String lastName,
                             @RequestParam int numberOfPassengers, @RequestParam String classType,
                             @RequestParam String phoneNumber, @RequestParam String time,
                             @RequestParam String dateOfDeparting, Model model) {

        Customer customer = new Customer(firstName, lastName, phoneNumber);
        /*
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = new Customer("firstName", "lastName", "phoneNumber");
        objectMapper.writeValue(new File("target/customer.json"), customer);
        
         * ObjectMapper objectMapper = new ObjectMapper();
			Car car = new Car("yellow", "renault");
			objectMapper.writeValue(new File("target/car.json"), car);

         */
        
        
        customerService.addCustomer(customer);

        Reservation reservation = new Reservation(firstName, lastName, numberOfPassengers, classType, phoneNumber, time, dateOfDeparting);
        reservationService.addReservation(reservation);

        Payment payment = new Payment(0, classType);
        int price = payment.calculatePrice(numberOfPassengers);
        payment.setAmount(price);
        paymentService.addPayment(payment);

        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("numberOfPassengers", numberOfPassengers);
        model.addAttribute("classType", classType);
        model.addAttribute("price", price);
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("time", time);
        model.addAttribute("dateOfDeparting", dateOfDeparting);

        return "result";
    }
}