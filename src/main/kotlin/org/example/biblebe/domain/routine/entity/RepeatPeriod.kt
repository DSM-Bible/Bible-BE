package org.example.biblebe.domain.routine.entity

import java.time.Period

enum class RepeatPeriod(
    val days: Int
) {
    EVERY_DAY(Period.ofDays(1).days),
    EVERY_WEEKS(Period.ofWeeks(1).days),
    EVERY_OTHER_WEEKS(Period.ofWeeks(2).days),
    EVERY_THREE_WEEKS(Period.ofWeeks(3).days),
    EVERY_MONTH(Period.ofMonths(1).days);
}