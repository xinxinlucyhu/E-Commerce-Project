package com.tts.ecommerce;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.StripeException;
import com.stripe.exception.oauth.InvalidRequestException;
import com.stripe.model.Charge;

@Service
public class StripeService
{
    @Value("${STRIPE_SECRET_KEY}")
    private String secretKey;

    @PostConstruct
    public void init()
    {
        Stripe.apiKey = secretKey;
    }

    public Charge charge(ChargeRequest chargeRequest) throws StripeException
    {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());
        System.out.println(chargeParams.get("amount"));
        System.out.println(chargeParams.get("currency"));
        System.out.println(chargeParams.get("description"));
        System.out.println(chargeParams.get("source"));


        return Charge.create(chargeParams);
    }
}
