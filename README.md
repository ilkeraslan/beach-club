# Beach Club

A beach club management system.

The system contains 4 functionalities:
- Base
- Booking
- Bar
- Administration

## Base

**Ticket office**: A staff member can book a sunbed for the first customer in the queue and can make one available as a customer leaves the beach club.

**Current map**: a customer can see the current occupation situation in the beach club.


## Booking

**Signup&Login**: A user should signup and login in order to book a sunbed and use the bar.

**Book/Cancel**: After logging in, a user can book a sunbed and cancel current bookings.

**Entrance**: A user with an effective booking token can enter the beach club whereas without a booking should book a ticket.
The token is distributed when the user makes a booking.

## Bar

**Order**: A booked user can order a meal/beverage.

**Distribution**: A staff member marks an order as distributed based on a FIFO concept.

## Administration

**Payment**: A booked user can see and pay the bill.

**Charge**: A staff member can charge a booked user and accept the payment. 