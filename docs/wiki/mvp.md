# MVP scope and open questions

Draft. Nothing here is built yet.

## Words we use

* **Listing:** food a donor offers: what it is, how much, where, and a pickup window.
* **Reservation:** a receiver's claim on a number of portions of a listing.
* **Portion:** one unit of the listing's quantity.
* **Pickup window:** the start and end time during which the food can be collected.

## Donor side

1. Post a listing.
2. See my own listings.
3. Cancel a listing.

## Receiver side

1. Browse open listings.
2. Reserve some portions.
3. Confirm collection.

## Rules

* A listing is open while it has portions left and its pickup window has not closed.
* A reservation can never ask for more portions than are left.
* Nobody can reserve after the window closes.
* If two people reserve the last portions at the same moment, only one succeeds.

## Open questions to decide before building

These are product decisions, so they need an answer from both of us before we code the slice they affect.

1. Are there user accounts in the MVP, or does a donor or receiver just type a name and phone number?
2. How is a location stored: free text, or coordinates for a map later?
3. Which time zone do pickup windows use? South Africa Standard Time is UTC+2 with no daylight saving.
4. Can one person reserve the same listing more than once?
5. What happens to an uncollected reservation when the window closes: do the portions go back, or is the listing simply closed?
6. How do we stop fake or abusive listings?
