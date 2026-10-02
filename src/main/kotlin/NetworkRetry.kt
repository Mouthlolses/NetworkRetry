package org.matheusbentodev

import kotlinx.coroutines.delay

class NetworkRetry(
    private val config: RetryConfig = RetryConfig()
) {

    suspend fun <T> execute(
        block: suspend () -> T
    ): T {

        var attempt = 0

        while (true) {
            try {
                return block()
            } catch (exception: Throwable) {
                attempt++

                if (attempt >= config.maxAttempts) {
                    throw exception
                }

                if (!config.policy.shouldRetry(exception, attempt)) {
                    throw exception
                }

                val delayMillis = config.backoff.delayMillis(attempt)

                delay(delayMillis)
            }
        }
    }
}