package org.matheusbentodev

interface BackoffStrategy {

    fun delayMillis(attempt: Int): Long
}


class ExponentialBackoff(
    private val initialDelayMillis: Long = 500,
    private val maxDelayMillis: Long = 30_000
) : BackoffStrategy {

    init {
        require(initialDelayMillis >= 0) {
            "initialDelayMillis must be greater than or equal to 0"
        }

        require(maxDelayMillis >= initialDelayMillis) {
            "maxDelayMillis must be greater than or equal to initialDelayMillis"
        }
    }

    override fun delayMillis(attempt: Int): Long {
        require(attempt >= 1) {
            "attempt must be greater than or equal to 1"
        }

        val multiplier = 1L shl (attempt - 1)

        return (initialDelayMillis * multiplier)
            .coerceAtMost(maxDelayMillis)
    }
}