package com.seongil.rxjava2example.combine;

import com.google.common.collect.Lists;
import com.seongil.rxjava2example.log.TestLog;

import org.junit.Test;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author seong-il, kim
 * @since 18. 9. 20
 */
public class StartWithTest {

    @Test
    public void observableStartWithTest() throws Exception {
        final List<String> items = Lists.newArrayList("one", "two", "three", "four");
        Observable<String> observableRet = Observable.fromIterable(items);
        observableRet.startWith("First Item.")
              .subscribe(ret -> TestLog.log(ret));
    }
}
