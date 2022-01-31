

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








        CheckoutApi api = CheckoutSdk.fourSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX) // or Environment.PRODUCTION
                .build();

        BankAccountFieldQuery query = BankAccountFieldQuery.builder()
                .accountHolderType(AccountHolderType.INDIVIDUAL)
                .paymentNetwork(PaymentNetwork.LOCAL)
                .build();

        try {
            BankAccountFieldResponse response = api.instrumentsClient().getBankAccountFieldFormatting(CountryCode.GB, Currency.GBP, query).get();
        } catch (CheckoutApiException e) {
            // API error
            String requestId = e.getRequestId();
            int statusCode = e.getHttpStatusCode();
            Map<String, Object> errorDetails = e.getErrorDetails();
        } catch (CheckoutArgumentException e) {
            // Bad arguments
        } catch (CheckoutAuthorizationException e) {
            // Invalid authorization
        }

    }

}

