package com.checkout.samples.nas.riskassessmentsprecapture;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApiException;
import com.checkout.CheckoutArgumentException;
import com.checkout.CheckoutAuthorizationException;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.common.Currency;
import com.checkout.common.CustomerRequest;
import com.checkout.four.CheckoutApi;
import com.checkout.risk.Device;
import com.checkout.risk.RiskPayment;
import com.checkout.risk.RiskShippingDetails;
import com.checkout.risk.precapture.AuthenticationResult;
import com.checkout.risk.precapture.AuthorizationResult;
import com.checkout.risk.precapture.PreCaptureAssessmentRequest;
import com.checkout.risk.precapture.PreCaptureAssessmentResponse;
import com.checkout.risk.source.CustomerSourcePrism;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class post {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.fourSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        try {
            final PreCaptureAssessmentRequest request = PreCaptureAssessmentRequest.builder()
                    .date(Instant.MAX)
                    .source(CustomerSourcePrism.builder().build())
                    .customer(new CustomerRequest())
                    .payment(RiskPayment.builder().build())
                    .shipping(RiskShippingDetails.builder().build())
                    .amount(12L)
                    .currency(Currency.GBP)
                    .device(Device.builder().build())
                    .metadata(new HashMap<>())
                    .authenticationResult(AuthenticationResult.builder().build())
                    .authorizationResult(AuthorizationResult.builder().build())
                    .build();
            final PreCaptureAssessmentResponse response = api.riskClient().requestPreCaptureRiskScan(request).get();
        } catch (final CheckoutApiException e) {
            // API error
            final String requestId = e.getRequestId();
            final int statusCode = e.getHttpStatusCode();
            final Map<String, Object> errorDetails = e.getErrorDetails();
        } catch (final CheckoutArgumentException e) {
            // bad input
        } catch (final CheckoutAuthorizationException e) {
            // invalid authorization
        }

    }

}


