package sp.kx.reactive.subject

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

internal class BehaviorSubjectTest {
    @Test
    fun flowTest() {
        val subject: BehaviorSubject<String> = BehaviorSubject()
        val consumer: SubjectConsumer<String> = subject
        var value: String? = null
        val subscription = consumer.subscribe(subjectAction { value = it })
        val producer: SubjectProducer<String> = subject
        val s1 = "foo"
        assertNotEquals(s1, value)
        assertNotEquals(s1, subject.getValueOrNull())
        producer.next(s1)
        assertEquals(s1, value)
        assertEquals(s1, subject.getValueOrNull())
        subscription.unsubscribe()
        val s2 = "bar"
        assertNotEquals(s1, s2)
        producer.next(s2)
        assertEquals(s1, value)
        assertEquals(s2, subject.getValueOrNull())
    }
}
