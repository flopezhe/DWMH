DWMH NEW READ ME FILE
Plan Outline
## MySql
### DATA LAYER
- Repository Interface
  - UserRepo
  - LocationRepo
  - ReservationRepo
- Reservation Mapper joing location and user
  - For reading
    - .query
  - For adding
    - .insert
  - For updating
    - .update
  - For Deleting
    - .update
- Location Mapper joins user
- User Mapper 
# Models
- Reservation
  - Reservation Class
    - private int reservationId
    - private BigDecimal totalAmount
    - private User user
    - private Location location
    - private LocalDate startDate
    - private LocalDate endDate
      - getLocation(){}
      - getReservationId(){}
      - getUser(){}
      - getStartDate(){}
      - getEndDate(){}
      - getTotalAmount(){}
- User
  - private String firstName
  - private String lastName
  - private int phoneNum
  - private String email;
    - getFirstName(){}
    - getLastName(){}
    - getPhone(){}
    - getEmail(){}
- Location
  - private BigDecimal standardRate(){}
  - private BigDecimal weekendRate(){}
  - private String address
  - private String state
  - private String city
  - private String zipCode 
    - getAddress(){}
    - getCity(){}
    - getState(){}
    - getZipCode(){}
    - getStandardRate(){}
    - getWeekendRate(){}
# Domain
- ReservationService
  - addReservation(){}
  - updateReservation(){}
  - cancelReservation(){}
  - calculateTotal(){}
- Result Class
  - Result.success(message)
  - Result.error(message)
# UI
### Display Reservations
  - Select host from unique value
    - viewHostsByEmail() 
  - Or Search host from options available
    - viewAllHosts()
### Make a Reservation
  - addReservation(){}
  - viewFutureReservations(){}
    - LocalDate
  - calculateTotal(){}
    - BigDecimal
    - Local Date
### Edit a Reservation
  - updateReservation(){}
  - ONLY FUTURE LOCALDATE
    - if reservation > date.now {success}
### Cancel a Reservation
  - cancelReservation(){}
  - ONLY FUTURE LOCALDATE
### Testing
- test schema 
- delimiter //
- setknowngoodstate()
- end //
- Test all methods above


# Tasks and Time
## Project SetUp 
- Set Up MySql **Done**
  - execute databases 
  - set known good state
- Set Up Java Maven **20 min**
  - Add dependencies
  - Add junit
  - Create Packages and Classes based on outline 
## Data Layer 
  - Create outlined mappers **30 MIN**
    - Location
    - Reservation
    - User
  - table repos interface **30 MIN**
  - jdbcrepo classes **1 HR**
    - CRUD
  - JUNIT TEST
    - Test to make sure queries and mysql code works
## Domain Layer
- ReservationService **1 HR**
  - getReservations
  - getAllReservations
  - makeReservation
  - updateReservation
  - cancelReservation
  - calculateTotal
- LocationService **1 HR**
  - Used for fetching/display purposes
  - getAllLocationsById(){}
  - getLocationById(){}
- UserService **1 HR**
  - getUserByEmail
  - getAllUsers
- Result **1 HR**
  - Error Handling Messages
- Validation **1 HR**
  - Error Handling Code   
- JUNIT TESTING
  - Test to make sure messages work

## Models
- Create Reservation class  **1 HR**
- Create User Class **1 HR**
- Create Location Class **1 HR**

## UI
- Create View **3 HR**
  - Implement display methods
  - Gather data to take to controller
- Create Controller **3 HR**
  - Make sure they pass before sending to domain to update data
  - addReservation
  - cancelReservation
  - UpdateReservation
  - viewReservation
