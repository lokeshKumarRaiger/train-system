# Train Seat Booking System

This project is a Java-based console application for booking train seats in a single coach with 80 seats. It uses a hashmap for tracking seat availability and an SQL schema for initializing a database structure.

## Features
- Book up to 7 seats at a time.
- Priority for booking seats in the same row.
- Displays seat layout after each booking.
- Handles edge cases such as insufficient seat availability.

## Setup Instructions
1. Compile and run the `TrainSeatBooking.java` file in any Java IDE or using the terminal.
2. Use the `schema.sql` file to create and initialize the database structure.

## Requirements
- Java 8 or higher.
- SQL database (e.g., MySQL).

## Usage
1. Enter the number of seats to book (1-7).
2. View the seat layout after booking.
3. Exit the application by entering `-1`.

## Assumptions
- Only one coach with 80 seats is considered.
- Pre-booked seats are hardcoded for simplicity.

## Future Enhancements
- Add a frontend for visualizing the seat layout.
- Integrate with a live database for real-time booking.
