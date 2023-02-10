package com.dpycb.protrackerkmm.utils

import com.badoo.reaktive.completable.completable
import com.badoo.reaktive.completable.subscribe
import com.badoo.reaktive.completable.subscribeOn
import com.badoo.reaktive.scheduler.ioScheduler

fun runOnIo(block: () -> Unit) = completable { block() }
        .subscribeOn(ioScheduler)
        .subscribe()