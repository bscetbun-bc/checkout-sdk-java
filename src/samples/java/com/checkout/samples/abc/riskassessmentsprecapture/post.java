package com.checkout.samples.abc.riskassessmentsprecapture;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.risk.precapture.PreCaptureAssessmentRequest;
import com.checkout.risk.precapture.PreCaptureAssessmentResponse;

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

        final PreCaptureAssessmentRequest request = PreCaptureAssessmentRequest.builder()
                .date(Instant.now())
                .source(null)
                .build();

        final PreCaptureAssessmentResponse response = api.riskClient().requestPreCaptureRiskScan(request).get();

    }

}

