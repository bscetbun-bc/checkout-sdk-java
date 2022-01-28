package com.checkout.samples.abc.hostedpayments;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.payments.hosted.HostedPaymentRequest;
import com.checkout.payments.hosted.HostedPaymentResponse;

import java.util.concurrent.ExecutionException;

public class post {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        final HostedPaymentRequest request = HostedPaymentRequest.builder().build();
        final HostedPaymentResponse response = api.hostedPaymentsClient().createAsync(request).get();

    }

}


