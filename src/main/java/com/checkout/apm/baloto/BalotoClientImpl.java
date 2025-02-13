package com.checkout.apm.baloto;

import com.checkout.AbstractClient;
import com.checkout.ApiClient;
import com.checkout.CheckoutConfiguration;
import com.checkout.SdkAuthorizationType;

import java.util.concurrent.CompletableFuture;

public class BalotoClientImpl extends AbstractClient implements BalotoClient {

    private static final String BALOTO_PATH = "/apms/baloto/payments";

    public BalotoClientImpl(final ApiClient apiClient, final CheckoutConfiguration configuration) {
        super(apiClient, configuration, SdkAuthorizationType.SECRET_KEY);
    }

    @Override
    public CompletableFuture<Void> succeed(final String paymentId) {
        return apiClient.postAsync(buildPath(BALOTO_PATH, paymentId, "succeed"), sdkAuthorization(), Void.class, null, null);
    }

    @Override
    public CompletableFuture<Void> expire(final String paymentId) {
        return apiClient.postAsync(buildPath(BALOTO_PATH, paymentId, "expire"), sdkAuthorization(), Void.class, null, null);
    }

}
