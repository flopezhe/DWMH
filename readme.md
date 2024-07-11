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

1. [x ] ## Project SetUp 
2. [ x] - Set Up MySql **Done**
3. [ x]   - execute databases 
4. [ x]   - set known good state
5. [x ] - Set Up Java Maven **20 min**
6. [x ]   - Add dependencies
7. [x ]   - Add junit
8. [x ]   - Create Packages and Classes based on outline 
9. [ ] ## Data Layer 
10. [x ]   - Create outlined mappers **30 MIN**
11. [ x]     - Location
12. [x ]     - Reservation
13. [x ]     - User
14. [ x]   - table repos interface **30 MIN**
15. [ ]   - jdbcrepo classes **1 HR**
16. [ ]     - CRUD
17. [ ]   - JUNIT TEST
18. [ ]     - Test to make sure queries and mysql code works
19. [ ] ## Domain Layer
20. [ ] - ReservationService **1 HR**
21. [ ]   - getReservations
22. [ ]   - getAllReservations
23. [ ]   - makeReservation
24. [ ]   - updateReservation
25. [ ]   - cancelReservation
26. [ ]   - calculateTotal
27. [ ] - LocationService **1 HR**
28. [ ]   - Used for fetching/display purposes
29. [ ]   - getAllLocationsById(){}
30. [ ]   - getLocationById(){}
31. [ ] - UserService **1 HR**
32. [ ]   - getUserByEmail
33. [ ]   - getAllUsers
34. [ ] - Result **1 HR**
35. [ ]   - Error Handling Messages
36. [ ] - Validation **1 HR**
37. [ ]   - Error Handling Code   
38. [ ] - JUNIT TESTING
39. [ ]   - Test to make sure messages work
40. [ ] 
41. [ ] ## Models
42. [ ] - Create Reservation class  **1 HR**
43. [ ] - Create User Class **1 HR**
44. [ ] - Create Location Class **1 HR**
45. [ ] 
46. [ ] ## UI
47. [ ] - Create View **3 HR**
48. [ ]   - Implement display methods
49. [ ]   - Gather data to take to controller
50. [ ] - Create Controller **3 HR**
51. [ ]   - Make sure they pass before sending to domain to update data
52. [ ]   - addReservation
53. [ ]   - cancelReservation
54. [ ]   - UpdateReservation
55. [ ]   - viewReservation
56. [ ] - JUNIT Testing
57. [ ]   - testing to make sure view and controller actually do something
58. [ ]   - same methods as above tests
59. [ ] ## App
60. [ ] - Implement controller
