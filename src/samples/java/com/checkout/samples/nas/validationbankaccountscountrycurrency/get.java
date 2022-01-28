package com.checkout.samples.nas.validationbankaccountscountrycurrency;// For more information please refer to https://github.com/checkout/checkout-sdk-javaç

import com.checkout.CheckoutApiException;
import com.checkout.CheckoutArgumentException;
import com.checkout.CheckoutAuthorizationException;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.common.CountryCode;
import com.checkout.common.Currency;
import com.checkout.common.four.AccountHolderType;
import com.checkout.four.CheckoutApi;
import com.checkout.instruments.four.get.BankAccountFieldQuery;
import com.checkout.instruments.four.get.BankAccountFieldResponse;
import com.checkout.instruments.four.get.PaymentNetwork;

import java.util.Map;
import java.util.concurrent.ExecutionException;

public class get {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.fourSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        try {
            final BankAccountFieldQuery query = BankAccountFieldQuery.builder()
                    .accountHolderType(AccountHolderType.INDIVIDUAL)
                    .paymentNetwork(PaymentNetwork.LOCAL)
                    .build();

            final BankAccountFieldResponse response = api.instrumentsClient().getBankAccountFieldFormatting(CountryCode.GB, Currency.GBP, query).get();
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

