package com.checkout.samples.nas.sessions;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApiException;
import com.checkout.CheckoutArgumentException;
import com.checkout.CheckoutAuthorizationException;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.common.ChallengeIndicator;
import com.checkout.common.Currency;
import com.checkout.common.MarketplaceData;
import com.checkout.four.CheckoutApi;
import com.checkout.sessions.AuthenticationType;
import com.checkout.sessions.Category;
import com.checkout.sessions.SessionAddress;
import com.checkout.sessions.SessionRequest;
import com.checkout.sessions.SessionResponse;
import com.checkout.sessions.SessionsBillingDescriptor;
import com.checkout.sessions.TransactionType;
import com.checkout.sessions.channel.BrowserSession;
import com.checkout.sessions.channel.ChannelData;
import com.checkout.sessions.completion.NonHostedCompletionInfo;
import com.checkout.sessions.source.SessionCardSource;

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
            final ChannelData channelData = BrowserSession.builder() // other channel data types available
                    .acceptHeader("Accept:  *.*, q=0.1")
                    .build();

            final SessionRequest sessionRequest = SessionRequest.builder()
                    .source(SessionCardSource.builder().build()) // more sources available
                    .amount(12L)
                    .currency(Currency.GBP)
                    .processingChannelId("")
                    .marketplace(MarketplaceData.builder().subEntityId("").build())
                    .authenticationType(AuthenticationType.REGULAR)
                    .authenticationCategory(Category.PAYMENT)
                    .challengeIndicator(ChallengeIndicator.CHALLENGE_REQUESTED)
                    .billingDescriptor(SessionsBillingDescriptor.builder().build())
                    .reference("")
                    .transactionType(TransactionType.GOODS_SERVICE)
                    .shippingAddress(SessionAddress.builderSessionAddress().build())
                    .completion(NonHostedCompletionInfo.builder().build())
                    .channelData(channelData)
                    .build();

            final SessionResponse response = api.sessionsClient().requestSession(sessionRequest).get();
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


