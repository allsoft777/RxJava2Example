package com.seongil.rxjava2example.combine;

import com.seongil.rxjava2example.log.TestLog;

import org.junit.Test;

import io.reactivex.Observable;

/**
 * @author seong-il, kim
 * @since 18. 9. 20
 */
public class CombineLatestTest {

    private String mUserInputName = "OwlLife";
    private String mUserInputPassword = "password!!!";

    @Test
    public void observableCombineLatestTest() throws Exception {
        Observable.combineLatest(checkMandatoryInputOfName(), checkMandatoryInputOfPassword(),
              checkOptionalInputOfAddress(),
              (name, password, address) -> name && password || address)
              .subscribe(ret -> TestLog.log(String.valueOf(ret)));
    }

    private Observable<Boolean> checkMandatoryInputOfName() throws Exception {
        return Observable.just(!isEmptyString(mUserInputName));
    }

    private Observable<Boolean> checkMandatoryInputOfPassword() throws Exception {
        return Observable.just(!isEmptyString(mUserInputPassword));
    }

    private Observable<Boolean> checkOptionalInputOfAddress() throws Exception {
        return Observable.just(true);
    }

    private boolean isEmptyString(String str) {
        return str == null || str.length() == 0;
    }
}
