package com.checkout.samples.abc.riskassessmentspreauthentication;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.risk.preauthentication.PreAuthenticationAssessmentRequest;
import com.checkout.risk.preauthentication.PreAuthenticationAssessmentResponse;

import java.time.Instant;
import java.util.concurrent.ExecutionException;

public class post {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        final PreAuthenticationAssessmentRequest request = PreAuthenticationAssessmentRequest.builder()
                .date(Instant.EPOCH)
                .source(null)
                .build();

        final PreAuthenticationAssessmentResponse response = api.riskClient().requestPreAuthenticationRiskScan(request).get();

    }

}

