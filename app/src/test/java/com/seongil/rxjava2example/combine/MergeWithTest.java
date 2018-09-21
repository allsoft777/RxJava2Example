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
public class MergeWithTest {

    @Test
    public void observableMergeWithTest() throws Exception {
        final List<String> items1 = Lists.newArrayList("one", "two", "three", "four");
        final List<String> items2 = Lists.newArrayList("five", "six", "seven");
        Observable<String> observableRet = Observable.fromIterable(items1);
        observableRet.mergeWith(Observable.fromIterable(items2))
              .subscribe(ret -> TestLog.log(ret));
    }
}
