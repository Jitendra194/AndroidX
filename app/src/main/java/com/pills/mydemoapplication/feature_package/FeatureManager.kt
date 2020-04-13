package com.pills.mydemoapplication.feature_package

import java.util.*

class FeatureManager {
    inline fun <reified T : Feature<D>, D> getFeature(
        dependencies: D
    ): T? {
        val serviceIterator = ServiceLoader.load(
            T::class.java,
            T::class.java.classLoader
        ).iterator()

        return if (serviceIterator.hasNext()) {
            (serviceIterator.next()).apply { inject(dependencies) }
        } else {
            null
        }
    }
}