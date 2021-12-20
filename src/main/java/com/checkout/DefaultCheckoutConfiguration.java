package com.checkout;

import org.apache.http.impl.client.HttpClientBuilder;

import java.net.URI;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;

import static com.checkout.common.CheckoutUtils.validateParams;

class DefaultCheckoutConfiguration implements CheckoutConfiguration {

    private static final Executor DEFAULT_EXECUTOR = ForkJoinPool.commonPool();

    private final SdkCredentials sdkCredentials;
    private final URI baseUri;
    private final HttpClientBuilder httpClientBuilder;
    private final Executor executor;
    private final FilesApiConfiguration filesApiConfiguration;

    DefaultCheckoutConfiguration(final SdkCredentials sdkCredentials,
                                 final Environment environment,
                                 final HttpClientBuilder httpClientBuilder,
                                 final Executor executor,
                                 final FilesApiConfiguration filesApiConfiguration) {
        validateParams("sdkCredentials", sdkCredentials, "environment", environment, "httpClientBuilder", httpClientBuilder);
        this.sdkCredentials = sdkCredentials;
        this.baseUri = environment.getUri();
        this.httpClientBuilder = httpClientBuilder;
        this.executor = executor != null ? executor : DEFAULT_EXECUTOR;
        this.filesApiConfiguration = filesApiConfiguration;
    }

    DefaultCheckoutConfiguration(final SdkCredentials sdkCredentials,
                                 final URI uri,
                                 final HttpClientBuilder httpClientBuilder,
                                 final Executor executor,
                                 final FilesApiConfiguration filesApiConfiguration) {
        validateParams("sdkCredentials", sdkCredentials, "uri", uri, "httpClientBuilder", httpClientBuilder);
        this.sdkCredentials = sdkCredentials;
        this.baseUri = uri;
        this.httpClientBuilder = httpClientBuilder;
        this.executor = executor != null ? executor : DEFAULT_EXECUTOR;
        this.filesApiConfiguration = filesApiConfiguration;
    }

    @Override
    public URI getBaseUri() {
        return baseUri;
    }

    @Override
    public SdkCredentials getSdkCredentials() {
        return sdkCredentials;
    }

    @Override
    public HttpClientBuilder getHttpClientBuilder() {
        return httpClientBuilder;
    }

    @Override
    public Executor getExecutor() {
        return executor;
    }

    @Override
    public FilesApiConfiguration getFilesApiConfiguration() {
        return filesApiConfiguration;
    }

}
