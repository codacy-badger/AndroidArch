package com.noisyninja.androidlistpoc.layers

import com.squareup.leakcanary.RefWatcher
import javax.inject.Inject

/**
 * Wrapper RefWatcher class to help mock and test final classes using mockito
 * Created by sudiptadutta on 21/05/18.
 */

open class RefWatcherModule @Inject
constructor(val refWatcher: RefWatcher)
