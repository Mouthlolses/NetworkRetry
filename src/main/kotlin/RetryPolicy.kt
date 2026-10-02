package org.matheusbentodev


fun interface RetryPolicy {

    fun shouldRetry(
        error: Throwable,
        attempt: Int
    ): Boolean

    companion object {
        val Always = RetryPolicy { _, _ ->
            true
        }

        val Never = RetryPolicy { _, _ ->
            false
        }
    }
}