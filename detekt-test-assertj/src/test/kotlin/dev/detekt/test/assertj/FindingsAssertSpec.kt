package dev.detekt.test.assertj

import dev.detekt.api.Finding
import dev.detekt.api.testfixtures.createFinding
import org.junit.jupiter.api.Test

class FindingsAssertSpec {
    @Test
    fun `filters an empty list`() {
        assertThat(emptyList<Finding>()).filteredOn { true }.isEmpty()
    }

    @Test
    fun `keeps finding assertions after filtering`() {
        val first = createFinding(message = "first")
        val second = createFinding(message = "second")

        assertThat(listOf(first, second))
            .filteredOn { it.message == "second" }
            .singleElement()
            .hasMessage("second")
    }
}
