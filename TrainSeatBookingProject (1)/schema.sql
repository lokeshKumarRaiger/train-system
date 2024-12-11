CREATE TABLE Seats (
    seat_id INT PRIMARY KEY,
    row_num INT,
    status BOOLEAN DEFAULT FALSE
);

-- Insert seats with some pre-booked
INSERT INTO Seats (seat_id, row_num, status)
VALUES
(1, 1, FALSE), (2, 1, FALSE), (3, 1, TRUE), -- Continue for all 80 seats
-- Example pre-booked seats
(10, 2, TRUE), (25, 4, TRUE), (50, 7, TRUE);