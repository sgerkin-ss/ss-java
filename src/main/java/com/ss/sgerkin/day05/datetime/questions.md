# DateTime API

## 1. Which class would you use to store your birthday in years, months, days, seconds, and nanoseconds?

Instant. See [`./Birthday.java`](./Birthday.java)

## 2. Given a random date, how would you find the date of the previous Thursday?

See [`./PreviousThursdayFinder.java`](./PreviousThursdayFinder.java)

## 3. What is the difference between a ZoneId and a ZoneOffset?

A ZoneId is used to designate a specific timezone, ie UTC or EST. This includes historical and
future changes to an offset. A ZoneOffset is a temporal value between two different zones, ie the
offset between UTC and EST is `-5:00` or, to put it another way, EST is 5 hours behind UTC.

## 4. How would you convert an Instant to a ZonedDateTime? How would you convert a ZonedDateTime to an Instant?

See [`./InstantConverter.java`](./InstantConverter.java)

## 5. Write an example that, for a given year, reports the length of each month within that year.

See [`./MonthLengths.java`](./MonthLengths.java)

## 6. Write an example that, for a given month of the current year, lists all of the Mondays in that month.

See [`./MondayLister.java`](./MondayLister.java)

## 7. Write an example that tests whether a given date occurs on Friday the 13th.

See [`./SpookyFridayChecker.java`](./SpookyFridayChecker.java)