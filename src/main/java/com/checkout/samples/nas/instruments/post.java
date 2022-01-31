

import com.checkout.CheckoutApiException;
import com.checkout.CheckoutArgumentException;
import com.checkout.CheckoutAuthorizationException;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.common.Address;
import com.checkout.common.CountryCode;
import com.checkout.common.Phone;
import com.checkout.common.four.AccountHolder;
import com.checkout.four.CheckoutApi;
import com.checkout.instruments.four.create.CreateCustomerInstrumentRequest;
import com.checkout.instruments.four.create.CreateInstrumentResponse;
import com.checkout.instruments.four.create.CreateInstrumentTokenRequest;








        CheckoutApi api = CheckoutSdk.fourSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX) // or Environment.PRODUCTION
                .build();

        CreateInstrumentTokenRequest request = CreateInstrumentTokenRequest.builder()
                .token("token")
                .accountHolder(AccountHolder.builder()
                        .firstName("FirstName")
                        .lastName("LastName")
                        .phone(Phone.builder().countryCode("+1").number("415 555 2671").build())
                        .billingAddress(Address.builder()
                                .addressLine1("CheckoutSdk.com")
                                .addressLine2("90 Tottenham Court Road")
                                .city("London")
                                .state("London")
                                .zip("W1T 4TJ")
                                .country(CountryCode.GB)
                                .build())
                        .build())
                .customer(CreateCustomerInstrumentRequest.builder()
                        .id("customer_id")
                        .build())
                .build();

        try {
            CreateInstrumentResponse response = api.instrumentsClient().create(request).get();
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

