

import com.checkout.CheckoutApiException;
import com.checkout.CheckoutArgumentException;
import com.checkout.CheckoutAuthorizationException;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.common.Address;
import com.checkout.common.CountryCode;
import com.checkout.common.Currency;
import com.checkout.common.four.AccountType;
import com.checkout.common.four.BankDetails;
import com.checkout.four.CheckoutApi;
import com.checkout.marketplace.InstrumentDocument;
import com.checkout.marketplace.MarketplacePaymentInstrument;








        CheckoutApi api = CheckoutSdk.fourSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX) // or Environment.PRODUCTION
                .build();

        MarketplacePaymentInstrument marketplacePaymentInstrument = MarketplacePaymentInstrument.builder()
                .accountNumber("123456789")
                .accountType(AccountType.CASH)
                .bank(BankDetails.builder().name("bank_name").address(Address.builder().build()).build())
                .bankCode("bank_code")
                .bban("bban")
                .branchCode("123")
                .country(CountryCode.GB)
                .currency(Currency.GBP)
                .document(new InstrumentDocument("document", "file"))
                .iban("iban")
                .label("mkt-1")
                .swiftBic("BIC")
                .build();

        try {

            api.marketplaceClient().createPaymentInstrument(marketplacePaymentInstrument, "entity_id").get();
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

