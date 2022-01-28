package com.checkout.samples.abc.customersidentifier;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.common.Phone;
import com.checkout.customers.CustomerRequest;

import java.util.concurrent.ExecutionException;

public class patch {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        final CustomerRequest request = CustomerRequest.builder()
                .email("email@checkout.com")
                .name("user")
                .phone(Phone.builder().build())
                .build();

        api.customersClient().update("customer_id", request).get();

    }

}


