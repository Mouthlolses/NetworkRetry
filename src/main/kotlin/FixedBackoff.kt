package org.matheusbentodev

class FixedBackoff(
    private val delayMillis: Long
) : BackoffStrategy {

    init {
        require(delayMillis >= 0) {
            "delayMillis must be greater than or equal to 0"
        }
    }

    override fun delayMillis(attempt: Int): Long {
        return delayMillis
    }
}