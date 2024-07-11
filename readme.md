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
  - private String email
  - private Location location
    - getFirstName(){}
    - getLastName(){}
    - getPhone(){}
    - getEmail(){}
    - getLocation(){}
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
- Validation
  - Validate results
  - if null {} else {}
  - if date>date.now {} etc.
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

1. [x] ## Project SetUp 
2. [x] - Set Up MySql **Done**
3. [x]   - execute databases 
4. [x]   - set known good state
5. [x] - Set Up Java Maven **20 min**
6. [x]   - Add dependencies
7. [x]   - Add junit
8. [x]   - Create Packages and Classes based on outline 
9. [x] ## Data Layer 
10. [x]   - Create outlined mappers **30 MIN**
11. [x]   - Location
12. [x]   - Reservation
13. [x]   - User
14. [x]   - table repos interface **30 MIN**
15. [x]   - jdbcrepo classes **1 HR**
16. [x]   - CRUD
17. [ ]   - JUNIT TEST
18. []   - Test to make sure queries and mysql code works
19. [ ] ## Domain Layer
20. [x] - ReservationService **1 HR**
21. [ ]   - reservationById
22. [x]   - getAllReservations
23. [x]   - createReservation
24. [x]   - updateReservation
25. [x]   - deleteReserve
26. [x]   - calculateTotal
27. [x]   - getUserByEmail
28. [x]   - getAllUsers(moved to Reservation)
29. [x] - Result **1 HR**
30. [x]   - Error Handling Messages
31. [x] - Validation **1 HR**
32. [x]   - Error Handling Code   
33. [ ] - JUNIT TESTING
34. [ ]   - Test to make sure messages work
35. [x] ## Models
36. [x] - Create Reservation class  **1 HR**
37. [x] - Create User Class **1 HR**
38. [x] - Create Location Class **1 HR**
39. [ ] ## UI
40. [ ] - Create View **3 HR**
41. [ ]   - Implement display methods
42. [ ]   - Gather data to take to controller
43. [ ] - Create Controller **3 HR**
44. [ ]   - Make sure they pass before sending to domain to update data
45. [ ]   - addReservation
46. [ ]   - cancelReservation
47. [ ]   - UpdateReservation
48. [ ]   - viewReservation
49. [ ] - JUNIT Testing
50. [ ]   - testing to make sure view and controller actually do something
51. [ ]   - same methods as above tests
52. [ ] ## App
53. [ ] - Implement controller
