package org.matheusbentodev

data class RetryConfig(
    val maxAttempts: Int = 3,
    val policy: RetryPolicy = RetryPolicy.Always,
    val backoff: BackoffStrategy = ExponentialBackoff()
) {

    init {
        require(maxAttempts >= 1) {
            "maxAttempts must be greater than or equal to 1"
        }
    }
}