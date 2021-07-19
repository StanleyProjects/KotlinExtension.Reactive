package sp.service.sample

import sp.kx.reactive.subject.BehaviorSubject
import sp.kx.reactive.subject.Subject
import sp.kx.reactive.subject.SubjectConsumer
import sp.kx.reactive.subject.SubjectProducer
import sp.kx.reactive.subject.subjectAction

fun main() {
    val subject: BehaviorSubject<String> = BehaviorSubject()
    val consumer: SubjectConsumer<String> = subject
    val subscription = consumer.subscribe(subjectAction { println(it) })
    println("subscribe")
    val producer: SubjectProducer<String> = subject
    producer.next("foo")
    println("value: " + subject.getValueOrNull())
    subscription.unsubscribe()
    println("unsubscribe")
    producer.next("bar")
    println("value: " + subject.getValueOrNull())
}
