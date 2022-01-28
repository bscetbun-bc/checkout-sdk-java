package com.checkout.samples.abc.payments;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.payments.request.PaymentRequest;
import com.checkout.payments.request.PayoutRequest;
import com.checkout.payments.request.destination.PaymentRequestCardDestination;
import com.checkout.payments.request.source.RequestCardSource;
import com.checkout.payments.response.PaymentResponse;

import java.util.concurrent.ExecutionException;

public class post {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

// payment
        final RequestCardSource source = RequestCardSource.builder().build(); // other sources are also supported
        final PaymentRequest paymentRequest = PaymentRequest.builder().source(source).build();
        final PaymentResponse paymentResponse = api.paymentsClient().requestPayment(paymentRequest).get();

// payout
        final PayoutRequest payoutRequest = PayoutRequest.builder().destination(PaymentRequestCardDestination.builder().build()).build();
        final PaymentResponse payoutResponse = api.paymentsClient().requestPayout(payoutRequest).get();

    }

}


